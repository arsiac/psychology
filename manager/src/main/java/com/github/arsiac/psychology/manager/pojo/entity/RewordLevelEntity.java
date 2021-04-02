package com.github.arsiac.psychology.manager.pojo.entity;


import java.util.Date;

/**
 * <p>获奖等级</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
public class RewordLevelEntity {

    /**
     * 获奖等级id
     */
    private Long id;

    /**
     * 获奖等级
     */
    private String name;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 版本
     */
    private Integer version;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "RewordLevelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }
}
