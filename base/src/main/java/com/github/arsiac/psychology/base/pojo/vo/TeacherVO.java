package com.github.arsiac.psychology.base.pojo.vo;

import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;

/**
 * <p>教师视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
public class TeacherVO extends TeacherEntity {
    /**
     * 职称
     * */
    private String titleName;

    /**
     * 系别
     * */
    private String departmentName;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "TeacherVO{" +
                "titleName='" + titleName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                "} " + super.toString();
    }
}
