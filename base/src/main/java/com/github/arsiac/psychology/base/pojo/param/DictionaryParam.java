package com.github.arsiac.psychology.base.pojo.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

/**
 * <p>字典表查询参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/4/23
 */
public class DictionaryParam extends PageParam {
    /**
     * 字典名称
     * */
    private String name;

    /**
     * 字典类型
     * */
    private Long dictionaryTypeId;

    /**
     * 状态
     * */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDictionaryTypeId() {
        return dictionaryTypeId;
    }

    public void setDictionaryTypeId(Long dictionaryTypeId) {
        this.dictionaryTypeId = dictionaryTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DictionaryParam{" +
                "name='" + name + '\'' +
                ", dictionaryTypeId=" + dictionaryTypeId +
                ", status=" + status +
                "} " + super.toString();
    }
}
