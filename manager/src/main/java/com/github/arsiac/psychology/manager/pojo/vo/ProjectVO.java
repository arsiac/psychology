package com.github.arsiac.psychology.manager.pojo.vo;

import com.github.arsiac.psychology.manager.pojo.entity.ProjectEntity;

/**
 * <p>科研立项视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
public class ProjectVO extends ProjectEntity {
    /**
     * 项目来源名称
     * */
    private String projectSourceName;

    /**
     * 课题类型名称
     * */
    private String subjectTypeName;

    /**
     * 负责人名称
     * */
    private String teacherName;

    public String getProjectSourceName() {
        return projectSourceName;
    }

    public void setProjectSourceName(String projectSourceName) {
        this.projectSourceName = projectSourceName;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "ProjectVO{" +
                "projectSourceName='" + projectSourceName + '\'' +
                ", subjectTypeName='" + subjectTypeName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                "} " + super.toString();
    }
}
