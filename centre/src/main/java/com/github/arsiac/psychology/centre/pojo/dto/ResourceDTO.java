package com.github.arsiac.psychology.centre.pojo.dto;

import com.github.arsiac.psychology.centre.pojo.entity.ResourceEntity;

/**
 * <p>资源数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class ResourceDTO extends ResourceEntity {
    /**
     * 父节点
     * */
    private ResourceDTO parentDTO;

    public ResourceDTO getParentDTO() {
        return parentDTO;
    }

    public void setParentDTO(ResourceDTO parentDTO) {
        this.parentDTO = parentDTO;
    }

    @Override
    public String toString() {
        return "ResourceDTO{} " + super.toString();
    }
}
