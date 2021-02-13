package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.form.LoginForm;

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

    @PostMapping("/logout")
    boolean logout(@RequestBody UserDTO dto);
}
