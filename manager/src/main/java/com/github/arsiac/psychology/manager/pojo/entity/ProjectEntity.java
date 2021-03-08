package com.github.arsiac.psychology.manager.pojo.entity;


import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>科研立项</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
public class ProjectEntity {

	/**
	 * 项目id
	 */
	private Long id;

	/**
	 * 项目名称
	 */
	private String name;

	/**
	 * 项目编码
	 */
	private String code;

	/**
	 * 校内编码
	 */
	private String schoolCode;

	/**
	 * 项目来源id
	 */
	private Long projectSourceId;

	/**
	 * 课题类型id
	 */
	private Long subjectTypeId;

	/**
	 * 立项时间
	 */
	private Date projectStartDate;

	/**
	 * 结束时间
	 */
	private Date projectEndDate;

	/**
	 * 经费(万元)
	 */
	private BigDecimal money;

	/**
	 * 项目负责人
	 */
	private Long managerId;

	/**
	 * 是否结题(0未结题, 1已结题)
	 */
	private Integer projectIsEnd;

	/**
	 * 状态(0未提交, 1已提交, 2审核通过, 3退回修改)
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

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setProjectSourceId(Long projectSourceId) {
		this.projectSourceId = projectSourceId;
	}

	public Long getProjectSourceId() {
		return projectSourceId;
	}

	public void setSubjectTypeId(Long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	public Long getSubjectTypeId() {
		return subjectTypeId;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setProjectIsEnd(Integer projectIsEnd) {
		this.projectIsEnd = projectIsEnd;
	}

	public Integer getProjectIsEnd() {
		return projectIsEnd;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public String getReturnMessage() {
		return returnMessage;
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
