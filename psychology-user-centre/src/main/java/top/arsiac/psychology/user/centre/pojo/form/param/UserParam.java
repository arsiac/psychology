package top.arsiac.psychology.user.centre.pojo.form.param;

import top.arsiac.psychology.utils.entity.PageParam;

/**
 * <p>用户搜索条件</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/23
 */
public class UserParam extends PageParam {
    /**
     * 用户名
     * */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserParam{" +
                "username='" + username + '\'' +
                '}' + super.toString();
    }
}
