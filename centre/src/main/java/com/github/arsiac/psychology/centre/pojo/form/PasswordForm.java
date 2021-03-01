package com.github.arsiac.psychology.centre.pojo.form;

/**
 * <p>修改密码表单</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
public class PasswordForm {
    /**
     * 旧密码
     * */
    private String oldPassword;

    /**
     * 新密码
     * */
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
