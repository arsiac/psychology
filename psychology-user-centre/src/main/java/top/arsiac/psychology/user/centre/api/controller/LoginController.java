package top.arsiac.psychology.user.centre.api.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.LoginApi;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.form.LoginForm;
import top.arsiac.psychology.user.centre.pojo.form.RegisterForm;
import top.arsiac.psychology.user.centre.service.CaptchaService;
import top.arsiac.psychology.user.centre.service.TokenService;
import top.arsiac.psychology.user.centre.service.UserService;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.common.CommonTool;
import top.arsiac.psychology.utils.common.IdGenerator;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

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
        if (StringUtils.isBlank(form.getUsername())) {
            throw PsychologyErrorCode.USERNAME_IS_EMPTY.createException();
        }
        UserDTO userDTO = userService.queryByName(form.getUsername());
        if (userDTO != null) {
            throw PsychologyErrorCode.USERNAME_ALREADY_EXIST.createException(userDTO.getUsername());
        }

        final String password = form.getPassword();

        // 生成随机字符串作为盐
        form.setSalt(CommonTool.randomString(32));

        // 加密密码
        form.setPassword(CommonTool.encrypt(password, form.getSalt()));

        logger.info("用户注册: {}", form);

        // 注册用户
        return userService.add(form);
    }

    @SystemLogger("登录")
    @Override
    public TokenEntity login(LoginForm loginForm) {
        // 验证数据
        if (StringUtils.isBlank(loginForm.getCode())) {
            throw PsychologyErrorCode.CAPTURE_IS_EMPTY.createException();
        }
        if (StringUtils.isBlank(loginForm.getUsername())) {
            throw PsychologyErrorCode.USERNAME_IS_EMPTY.createException();
        }
        if (StringUtils.isBlank(loginForm.getPassword())) {
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
        final String encryptPassword = CommonTool.encrypt(loginForm.getPassword(), userDTO.getSalt());

        if (!userDTO.getPassword().equals(encryptPassword)) {
            throw PsychologyErrorCode.USERNAME_OR_PASSWORD_ERROR.createException(
                    String.format("密码错误: %n==> 原密码: %s%n==> 输入: %s%n==> 盐: %s%n==> 加密后: %s%n",
                            userDTO.getPassword(), loginForm.getPassword(), userDTO.getSalt(), encryptPassword)
            );
        }

        return tokenService.createToken(userDTO);
    }

    @SystemLogger("登出")
    @Override
    public boolean logout(UserDTO dto) {
        return false;
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

    @Override
    public String app() {
        return "Psychology User Centre";
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
