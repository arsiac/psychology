package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>用户管理接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@RequestMapping(value = "/user")
public interface UserApi {
    /**
     * 获取用户名
     * */
    @GetMapping
    String getUserName();
}
