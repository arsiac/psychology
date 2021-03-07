package com.github.arsiac.psychology.base.pojo.entity;

import java.util.Date;

/**
 * <p>教师</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/5
 */
public class TeacherEntity {
	/**
	 * 教师id
	 */
	private Long id;
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
	private Integer sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 年龄
	 */
	private Integer age;
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
	 * 学缘关系 (1本校, 2外校(国内), 3外校(国外))
	 */
	private String relation;
	/**
	 * 政治面貌(1党员, 2共青团员, 3群众)
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
	private Integer jobType;
	/**
	 * 任职情况
	 */
	private String position;
	/**
	 * 账号
	 */
	private Long account;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}

	public Integer getOversea() {
		return oversea;
	}

	public void setOversea(Integer oversea) {
		this.oversea = oversea;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPolitic() {
		return politic;
	}

	public void setPolitic(String politic) {
		this.politic = politic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegreeUnit() {
		return degreeUnit;
	}

	public void setDegreeUnit(String degreeUnit) {
		this.degreeUnit = degreeUnit;
	}

	public String getResearchDirection() {
		return researchDirection;
	}

	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
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
	public String toString() {
		return "TeacherEntity{" +
				"id=" + id +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", sex=" + sex +
				", birthday=" + birthday +
				", age=" + age +
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
				", jobType=" + jobType +
				", position='" + position + '\'' +
				", account=" + account +
				", createBy=" + createBy +
				", createTime=" + createTime +
				", updateBy=" + updateBy +
				", updateTime=" + updateTime +
				", version=" + version +
				'}';
	}
}
