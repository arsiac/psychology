package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.SchoolDepartmentEntity;

/**
 * <p>学院数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:55
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolDepartmentDTO extends SchoolDepartmentEntity {
    @Override
    public String toString() {
        return "SchoolDepartmentDTO{} " + super.toString();
    }
}
