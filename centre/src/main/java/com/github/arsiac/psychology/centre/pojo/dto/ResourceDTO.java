package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.ResourceEntity;

/**
 * <p>资源数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceDTO extends ResourceEntity {
    /**
     * 父节点
     * */
    private ResourceEntity parentDTO;

    public ResourceEntity getParentDTO() {
        return parentDTO;
    }

    public void setParentDTO(ResourceEntity parentDTO) {
        this.parentDTO = parentDTO;
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "parentDTO=" + parentDTO +
                "} " + super.toString();
    }
}
