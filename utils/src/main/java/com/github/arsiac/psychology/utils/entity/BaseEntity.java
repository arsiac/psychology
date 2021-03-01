package com.github.arsiac.psychology.utils.entity;

import java.util.Date;
import java.util.Objects;

/**
 * <p>基础entity， 共有字段</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class BaseEntity {
    /**
     * 创建者
     * */
    private Long createBy;

    /**
     * 更新者
     * */
    private Long updateBy;

    /**
     * 创建时间
     * */
    private Date createTime;

    /**
     * 更新时间
     * */
    private Date updateTime;

    /**
     * 版本
     * */
    private Integer version;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return createBy.equals(that.createBy) &&
                updateBy.equals(that.updateBy) &&
                createTime.equals(that.createTime) &&
                updateTime.equals(that.updateTime) &&
                version.equals(that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createBy, updateBy, createTime, updateTime, version);
    }
}
