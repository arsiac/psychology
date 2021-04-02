package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.MajorEntity;
import com.github.arsiac.psychology.centre.pojo.entity.SchoolDepartmentEntity;
import com.github.arsiac.psychology.centre.pojo.entity.StudentEntity;

/**
 * <p>学生数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO extends StudentEntity {
    /**
     * 专业
     * */
    private MajorEntity majorEntity;

    /**
     * 学院
     * */
    private SchoolDepartmentEntity schoolDepartmentEntity;

    public MajorEntity getMajorEntity() {
        return majorEntity;
    }

    public void setMajorEntity(MajorEntity majorEntity) {
        this.majorEntity = majorEntity;
    }

    public SchoolDepartmentEntity getSchoolDepartmentEntity() {
        return schoolDepartmentEntity;
    }

    public void setSchoolDepartmentEntity(SchoolDepartmentEntity schoolDepartmentEntity) {
        this.schoolDepartmentEntity = schoolDepartmentEntity;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "majorEntity=" + majorEntity +
                ", schoolDepartmentEntity=" + schoolDepartmentEntity +
                "} " + super.toString();
    }
}
