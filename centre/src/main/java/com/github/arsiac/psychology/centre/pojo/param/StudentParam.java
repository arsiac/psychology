package com.github.arsiac.psychology.centre.pojo.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

import java.util.Date;

/**
 * <p>学生查询参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/27
 */
public class StudentParam extends PageParam {
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

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getSchoolDepartmentId() {
        return schoolDepartmentId;
    }

    public void setSchoolDepartmentId(Long schoolDepartmentId) {
        this.schoolDepartmentId = schoolDepartmentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    @Override
    public String toString() {
        return "StudentParam{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", majorId=" + majorId +
                ", schoolDepartmentId=" + schoolDepartmentId +
                ", grade=" + grade +
                ", identity='" + identity + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", source='" + source + '\'' +
                ", address='" + address + '\'' +
                ", politic='" + politic + '\'' +
                "} " + super.toString();
    }
}
