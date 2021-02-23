package top.arsiac.psychology.user.centre.pojo.form;

/**
 * <p>注册表单</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/22
 */
public class RegisterForm {
    /**
     * 用户名
     * */
    private String username;

    /**
     * 教师编号
     * */
    private Long code;

    /**
     * 密码
     * */
    private String password;

    /**
     * 盐
     * */
    private String salt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "username='" + username + '\'' +
                ", code=" + code +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
