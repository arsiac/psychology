package top.arsiac.psychology.user.centre.api.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.LoginApi;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.form.LoginForm;
import top.arsiac.psychology.user.centre.service.TokenService;
import top.arsiac.psychology.user.centre.service.UserService;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

/**
 * <p>登录接口实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/11
 */
@RestController
public class LoginController implements LoginApi {
    /**
     * token 服务
     * */
    private TokenService tokenService;

    /**
     * 用户服务
     * */
    private UserService userService;


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

        /*
         * 查询用户, 比较密码
         * */
        UserDTO userDTO = userService.queryByName(loginForm.getUsername());
        if (userDTO == null || !userDTO.getPassword().equals(loginForm.getPassword())) {
            throw PsychologyErrorCode.USERNAME_OR_PASSWORD_ERROR.createException();
        }

        return tokenService.createToken(userDTO);
    }

    @Override
    public boolean logout(UserDTO dto) {
        return false;
    }

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
