package com.github.arsiac.psychology.manager.pojo.entity;


import java.util.Date;

/**
 * <p>成果</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
public class AchievementEntity {

	/**
	 * 成果id
	 */
	private Long id;

	/**
	 * 成果名称
	 */
	private String name;

	/**
	 * 成果类型id
	 */
	private Long achievementTypeId;

	/**
	 * 奖励名称
	 */
	private String awardName;

	/**
	 * 获奖等级id
	 */
	private Long rewordLevelId;

	/**
	 * 颁奖单位
	 */
	private String unit;

	/**
	 * 获奖时间
	 */
	private Date date;

	/**
	 * 证书编号
	 */
	private String code;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 退回修改建议
	 */
	private String returnMessage;

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

	public void setAchievementTypeId(Long achievementTypeId) {
		this.achievementTypeId = achievementTypeId;
	}

	public Long getAchievementTypeId() {
		return achievementTypeId;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setRewordLevelId(Long rewordLevelId) {
		this.rewordLevelId = rewordLevelId;
	}

	public Long getRewordLevelId() {
		return rewordLevelId;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
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
}
