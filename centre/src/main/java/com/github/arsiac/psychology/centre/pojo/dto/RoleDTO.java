package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.RoleEntity;

/**
 * <p>角色数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDTO extends RoleEntity {
    @Override
    public String toString() {
        return "RoleDTO{} " + super.toString();
    }
}
