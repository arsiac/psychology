package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.ResourceEntity;
import com.github.arsiac.psychology.centre.pojo.entity.RoleEntity;
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
    private RoleEntity roleEntity;

    /**
     * 资源dto
     * */
    private ResourceEntity resourceEntity;

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public ResourceEntity getResourceEntity() {
        return resourceEntity;
    }

    public void setResourceEntity(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    @Override
    public String toString() {
        return "RoleResourceDTO{" +
                "roleEntity=" + roleEntity +
                ", resourceEntity=" + resourceEntity +
                "} " + super.toString();
    }
}
