package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.form.LoginForm;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>登录接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/11
 */
@CrossOrigin
public interface LoginApi {

    /**
     * <p>登录</p>
     *
     * @param loginForm 登录数据
     * @return token
     */
    @PostMapping("/login")
    TokenEntity login(@RequestBody LoginForm loginForm);

    /**
     * <p>登出</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    @PostMapping("/logout")
    boolean logout(@RequestBody UserDTO dto);

    /**
     * <p>获取验证码</p>
     *
     * @param response 回复
     * @throws IOException 写文件错误
     */
    @GetMapping("/captcha")
    @ResponseBody
    void captcha(HttpServletResponse response) throws IOException;
}
