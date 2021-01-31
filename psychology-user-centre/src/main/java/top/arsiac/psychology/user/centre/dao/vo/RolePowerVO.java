package top.arsiac.psychology.user.centre.dao.vo;

import top.arsiac.psychology.user.centre.dao.entity.RolePowerEntity;

/**
 * <p>角色权限视图对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class RolePowerVO extends RolePowerEntity {
    /**
     * 角色名称
     * */
    private String roleName;

    /**
     * 权力名称
     * */
    private String powerName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    @Override
    public String toString() {
        return "RolePowerVO{" +
                "roleName='" + roleName + '\'' +
                ", powerName='" + powerName + '\'' +
                "} " + super.toString();
    }
}
