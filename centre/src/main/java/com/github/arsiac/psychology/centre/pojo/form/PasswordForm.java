package com.github.arsiac.psychology.centre.pojo.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <p>修改密码表单</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PasswordForm {
    /**
     * 用户id
     * */
    private Long userId;

    /**
     * 旧密码
     * */
    private String oldPassword;

    /**
     * 新密码
     * */
    private String newPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "PasswordForm{" +
                "userId=" + userId +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
