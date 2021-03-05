package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.RoleResourceEntity;

/**
 * <p>角色-资源DTO</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleResourceDTO extends RoleResourceEntity {
    /**
     * 角色dto
     * */
    private RoleDTO roleDTO;

    /**
     * 资源dto
     * */
    private ResourceDTO resourceDTO;

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public ResourceDTO getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(ResourceDTO resourceDTO) {
        this.resourceDTO = resourceDTO;
    }

    @Override
    public String toString() {
        return "RoleResourceDTO{" +
                "roleDTO=" + roleDTO +
                ", resourceDTO=" + resourceDTO +
                "} " + super.toString();
    }
}
