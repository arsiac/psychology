package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.UserRoleEntity;

/**
 * <p>用户-角色数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRoleDTO extends UserRoleEntity {
    /**
     * 用户 dto
     * */
    private UserDTO userDTO;

    /**
     * 角色 dto
     * */
    private RoleDTO roleDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userDTO=" + userDTO +
                ", roleDTO=" + roleDTO +
                "} " + super.toString();
    }
}
