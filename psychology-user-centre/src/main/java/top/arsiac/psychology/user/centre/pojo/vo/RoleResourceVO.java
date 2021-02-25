package top.arsiac.psychology.user.centre.pojo.vo;

import top.arsiac.psychology.user.centre.pojo.entity.RoleResourceEntity;

/**
 * <p>角色-资源VO</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
public class RoleResourceVO extends RoleResourceEntity {
    /**
     * 角色名称
     * */
    private String roleName;

    /**
     * 资源名称
     * */
    private String resourceName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "RoleResourceVO{" +
                "roleName='" + roleName + '\'' +
                ", resourceName='" + resourceName + '\'' +
                "} " + super.toString();
    }
}
