package com.github.arsiac.psychology.base.pojo.dto;

import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.base.pojo.entity.TitleEntity;

/**
 * <p>教师dto</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/7
 */
public class TeacherDTO extends TeacherEntity {
    /**
     * 职称
     * */
    private TitleEntity titleEntity;

    /**
     * 系别
     * */
    private DepartmentEntity departmentEntity;

    public TitleEntity getTitleEntity() {
        return titleEntity;
    }

    public void setTitleEntity(TitleEntity titleEntity) {
        this.titleEntity = titleEntity;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "titleEntity=" + titleEntity +
                ", departmentEntity=" + departmentEntity +
                "} " + super.toString();
    }
}
