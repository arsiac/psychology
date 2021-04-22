package com.github.arsiac.psychology.utils.entity;

/**
 * <p>字典分页参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
public class DictionaryParam extends PageParam {
    /**
     * 名称
     * */
    private String name;

    /**
     * 状态
     * */
    private Integer status;

    public String getName() {
        return name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DictionaryParam{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
