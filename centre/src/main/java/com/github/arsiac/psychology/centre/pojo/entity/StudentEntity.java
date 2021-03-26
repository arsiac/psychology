package com.github.arsiac.psychology.centre.pojo.entity;


import java.util.Date;

/**
 * <p>学生</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
public class StudentEntity {

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
	 * 专业id
	 */
	private Long majorId;

	/**
	 * 学院id
	 */
	private Long schoolDepartmentId;

	/**
	 * 年级
	 */
	private Integer grade;

	/**
	 * 身份证
	 */
	private String identity;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 来源地(省)
	 */
	private String source;

	/**
	 * 家庭住址
	 */
	private String address;

	/**
	 * 政治面貌(1党员, 2共青团员, 3群众)
	 */
	private String politic;

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

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public Long getMajorId() {
		return majorId;
	}

	public void setSchoolDepartmentId(Long schoolDepartmentId) {
		this.schoolDepartmentId = schoolDepartmentId;
	}

	public Long getSchoolDepartmentId() {
		return schoolDepartmentId;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
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

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPolitic(String politic) {
		this.politic = politic;
	}

	public String getPolitic() {
		return politic;
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
