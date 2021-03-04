package com.github.arsiac.psychology.centre.pojo.form.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

/**
 * <p>资源查询参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/4
 */
public class ResourceParam extends PageParam {
    /**
     * 资源名称
     * */
    private String name;

    /**
     * 资源uri
     * */
    private String uri;

    /**
     * 类型
     * */
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResourceParam{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", type=" + type +
                "} " + super.toString();
    }
}
