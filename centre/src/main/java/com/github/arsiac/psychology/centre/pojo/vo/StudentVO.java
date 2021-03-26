package com.github.arsiac.psychology.centre.pojo.vo;

import com.github.arsiac.psychology.centre.pojo.entity.StudentEntity;

/**
 * <p>学生视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
public class StudentVO extends StudentEntity {
    /**
     * 专业
     * */
    private String majorName;

    /**
     * 学院
     * */
    private String schoolDepartmentName;

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getSchoolDepartmentName() {
        return schoolDepartmentName;
    }

    public void setSchoolDepartmentName(String schoolDepartmentName) {
        this.schoolDepartmentName = schoolDepartmentName;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "majorName='" + majorName + '\'' +
                ", schoolDepartmentName='" + schoolDepartmentName + '\'' +
                "} " + super.toString();
    }
}
