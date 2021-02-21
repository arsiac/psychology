package top.arsiac.psychology.user.centre.pojo.form;

/**
 * <p>登录表单</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
public class LoginForm {
    /**
     * 用户名
     * */
    private String username;

    /**
     * 密码
     * */
    private String password;

    /**
     * 验证码
     * */
    private String code;

    /**
     * 验证码 id
     * */
    private Long uuid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
