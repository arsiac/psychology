package com.github.arsiac.psychology.centre.pojo.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

import java.util.Date;

/**
 * <p>教师查询参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/27
 */
public class TeacherParam extends PageParam {
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

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "TeacherParam{" +
                "code='" + code + '\'' +
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
                "} " + super.toString();
    }
}
