package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.centre.pojo.entity.TitleEntity;
import com.github.arsiac.psychology.centre.pojo.entity.TeacherEntity;

/**
 * <p>教师数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherDTO extends TeacherEntity {
    /**
     * 系别
     * */
    private DepartmentEntity departmentEntity;

    /**
     * 职称
     * */
    private TitleEntity titleEntity;

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public TitleEntity getTitleEntity() {
        return titleEntity;
    }

    public void setTitleEntity(TitleEntity titleEntity) {
        this.titleEntity = titleEntity;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "departmentEntity=" + departmentEntity +
                ", titleEntity=" + titleEntity +
                "} " + super.toString();
    }
}
