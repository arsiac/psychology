package com.github.arsiac.psychology.centre.pojo.vo;

import com.github.arsiac.psychology.centre.pojo.entity.TeacherEntity;

/**
 * <p>教师视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
public class TeacherVO extends TeacherEntity {
    /**
     * 系别
     * */
    private String departmentName;

    /**
     * 职称
     * */
    private String titleName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Override
    public String toString() {
        return "TeacherVO{" +
                "departmentName='" + departmentName + '\'' +
                ", titleName='" + titleName + '\'' +
                "} " + super.toString();
    }
}
