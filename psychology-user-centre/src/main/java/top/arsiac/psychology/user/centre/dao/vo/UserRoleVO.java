package top.arsiac.psychology.user.centre.dao.vo;

import top.arsiac.psychology.user.centre.dao.entity.UserRoleEntity;

/**
 * <p>用户角色视图对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class UserRoleVO extends UserRoleEntity {
    /**
     * 用户名
     * */
    private String username;

    /**
     * 角色名
     * */
    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRoleVO{" +
                "username='" + username + '\'' +
                ", roleName='" + roleName + '\'' +
                "} " + super.toString();
    }
}
