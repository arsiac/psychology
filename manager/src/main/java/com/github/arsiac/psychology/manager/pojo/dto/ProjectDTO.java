package com.github.arsiac.psychology.manager.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.ProjectSourceEntity;
import com.github.arsiac.psychology.base.pojo.entity.SubjectTypeEntity;
import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.manager.pojo.entity.ProjectEntity;

/**
 * <p>科研立项数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO extends ProjectEntity {
    /**
     * 项目来源
     * */
    private ProjectSourceEntity projectSourceEntity;

    /**
     * 课题类型
     * */
    private SubjectTypeEntity subjectTypeEntity;

    /**
     * 负责人
     * */
    private TeacherEntity teacherEntity;

    public ProjectSourceEntity getProjectSourceEntity() {
        return projectSourceEntity;
    }

    public void setProjectSourceEntity(ProjectSourceEntity projectSourceEntity) {
        this.projectSourceEntity = projectSourceEntity;
    }

    public SubjectTypeEntity getSubjectTypeEntity() {
        return subjectTypeEntity;
    }

    public void setSubjectTypeEntity(SubjectTypeEntity subjectTypeEntity) {
        this.subjectTypeEntity = subjectTypeEntity;
    }

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectSourceEntity=" + projectSourceEntity +
                ", subjectTypeEntity=" + subjectTypeEntity +
                ", teacherEntity=" + teacherEntity +
                "} " + super.toString();
    }
}
