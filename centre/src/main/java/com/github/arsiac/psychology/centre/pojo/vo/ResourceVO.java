package com.github.arsiac.psychology.centre.pojo.vo;

import com.github.arsiac.psychology.centre.pojo.entity.ResourceEntity;

/**
 * <p>资源视图对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class ResourceVO extends ResourceEntity {
    /**
     * 父节点名称
     * */
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "ResourceVO{} " + super.toString();
    }
}
