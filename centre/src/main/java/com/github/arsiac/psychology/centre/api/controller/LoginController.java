package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.LoginApi;
import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;
import com.github.arsiac.psychology.centre.pojo.entity.TokenEntity;
import com.github.arsiac.psychology.centre.pojo.form.LoginForm;
import com.github.arsiac.psychology.centre.pojo.form.RegisterForm;
import com.github.arsiac.psychology.centre.service.CaptchaService;
import com.github.arsiac.psychology.centre.service.TokenService;
import com.github.arsiac.psychology.centre.service.UserService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.CommonTool;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>登录接口实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/2/11
 */
@RestController
public class LoginController implements LoginApi {
    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * token 服务
     */
    private TokenService tokenService;

    /**
     * 用户服务
     */
    private UserService userService;

    /**
     * 验证码服务
     */
    private CaptchaService captchaService;

    /**
     * id 生成
     */
    private IdGenerator idGenerator;

    @SystemLogger("注册")
    @Override
    public boolean register(RegisterForm form) {
        return userService.add(form);
    }

    @SystemLogger("登录")
    @Override
    public TokenEntity login(LoginForm loginForm) {
        // 验证数据
        if (CommonTool.isBlank(loginForm.getCode())) {
            throw PsychologyErrorCode.CAPTURE_IS_EMPTY.createException();
        }
        if (CommonTool.isBlank(loginForm.getUsername())) {
            throw PsychologyErrorCode.USERNAME_IS_EMPTY.createException();
        }
        if (CommonTool.isBlank(loginForm.getPassword())) {
            throw PsychologyErrorCode.PASSWORD_IS_EMPTY.createException();
        }
        if (loginForm.getUuid() == null) {
            throw PsychologyErrorCode.CAPTURE_WRONG.createException("captcha uuid is null");
        }

        logger.info("用户登录: {}", loginForm);
        // 验证码错误
        if (!captchaService.validate(loginForm.getUuid(), loginForm.getCode())) {
            throw PsychologyErrorCode.CAPTURE_WRONG.createException();
        }

        /*
         * 查询用户, 比较密码
         * */
        UserDTO userDTO = userService.queryByName(loginForm.getUsername());
        if (userDTO == null) {
            throw PsychologyErrorCode.USERNAME_OR_PASSWORD_ERROR.createException("用户不存在");
        }

        // 加密后比较密码
        String encryptPassword = CommonTool.encrypt(loginForm.getPassword(), userDTO.getSalt());

        if (!userDTO.getPassword().equals(encryptPassword)) {
            throw PsychologyErrorCode.USERNAME_OR_PASSWORD_ERROR.createException(
                    String.format("密码错误: %n==> 原密码: %s%n==> 输入: %s%n==> 盐: %s%n==> 加密后: %s%n",
                            userDTO.getPassword(), loginForm.getPassword(), userDTO.getSalt(), encryptPassword)
            );
        }

        return tokenService.createToken(userDTO);
    }

    @Override
    public String getToken(Long id) {
        return tokenService.getToken(id);
    }

    @SystemLogger("登出")
    @Override
    public boolean logout(UserDTO dto) {
        tokenService.invalidateToken(dto.getId());
        return true;
    }

    @Override
    public void captcha(HttpServletResponse response) throws IOException {
        long uuid = idGenerator.generate();
        response.setHeader("Access-Control-Expose-Headers", "Captcha-Id");
        response.setHeader("Captcha-Id", String.valueOf(uuid));
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/png");

        //获取图片验证码
        BufferedImage image = captchaService.generateCaptcha(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
        out.flush();
    }

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCaptchaService(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @Autowired
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
