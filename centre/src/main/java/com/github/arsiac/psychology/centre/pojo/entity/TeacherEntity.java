package com.github.arsiac.psychology.centre.pojo.entity;


import java.util.Date;

/**
 * <p>教师</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
public class TeacherEntity {

	/**
	 * 教师id
	 */
	private Long id;

	/**
	 * 账号
	 */
	private Long account;

	/**
	 * 教师编号
	 */
	private String code;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 系别
	 */
	private Long departmentId;

	/**
	 * 职称
	 */
	private Long titleId;

	/**
	 * 海外经历
	 */
	private Integer oversea;

	/**
	 * 学缘关系 (本校, 外校(国内), 外校(国外))
	 */
	private String relation;

	/**
	 * 政治面貌
	 */
	private String politic;

	/**
	 * 导师类型(1博导, 2硕导)
	 */
	private String type;

	/**
	 * 学历(1本科, 2硕士研究生, 3博士研究生)
	 */
	private String education;

	/**
	 * 最高学位(1.学士, 2硕士, 3博士)
	 */
	private String degree;

	/**
	 * 最高学位获取单位
	 */
	private String degreeUnit;

	/**
	 * 研究方向
	 */
	private String researchDirection;

	/**
	 * 工作类别
	 */
	private String jobType;

	/**
	 * 任职情况
	 */
	private String position;

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

	public void setAccount(Long account) {
		this.account = account;
	}

	public Long getAccount() {
		return account;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setOversea(Integer oversea) {
		this.oversea = oversea;
	}

	public Integer getOversea() {
		return oversea;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRelation() {
		return relation;
	}

	public void setPolitic(String politic) {
		this.politic = politic;
	}

	public String getPolitic() {
		return politic;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducation() {
		return education;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegreeUnit(String degreeUnit) {
		this.degreeUnit = degreeUnit;
	}

	public String getDegreeUnit() {
		return degreeUnit;
	}

	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}

	public String getResearchDirection() {
		return researchDirection;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
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
		return "TeacherEntity{" +
				"id=" + id +
				", account=" + account +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", birthday=" + birthday +
				", departmentId=" + departmentId +
				", titleId=" + titleId +
				", oversea=" + oversea +
				", relation='" + relation + '\'' +
				", politic='" + politic + '\'' +
				", type='" + type + '\'' +
				", education='" + education + '\'' +
				", degree='" + degree + '\'' +
				", degreeUnit='" + degreeUnit + '\'' +
				", researchDirection='" + researchDirection + '\'' +
				", jobType='" + jobType + '\'' +
				", position='" + position + '\'' +
				", createBy=" + createBy +
				", createTime=" + createTime +
				", updateBy=" + updateBy +
				", updateTime=" + updateTime +
				", version=" + version +
				'}';
	}
}
