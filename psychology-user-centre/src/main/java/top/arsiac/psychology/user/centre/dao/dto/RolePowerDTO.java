package top.arsiac.psychology.user.centre.dao.dto;

import top.arsiac.psychology.user.centre.dao.entity.RolePowerEntity;

/**
 * <p>角色权限数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class RolePowerDTO extends RolePowerEntity {
    /**
     * 角色dto
     * */
    private RoleDTO roleDTO;

    /**
     * 权限dto
     * */
    private PowerDTO powerDTO;

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public PowerDTO getPowerDTO() {
        return powerDTO;
    }

    public void setPowerDTO(PowerDTO powerDTO) {
        this.powerDTO = powerDTO;
    }

    @Override
    public String toString() {
        return "RolePowerDTO{" +
                "roleDTO=" + roleDTO +
                ", powerDTO=" + powerDTO +
                "} " + super.toString();
    }
}
