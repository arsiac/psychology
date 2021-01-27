package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.UserApi;

/**
 * <p>用户管理接口实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@CrossOrigin
@RestController
public class UserController implements UserApi {
    @Override
    public String getUserName() {
        return "ZhangSan";
    }
}
