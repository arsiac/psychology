package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Override
    public String toString() {
        return "StudentDTO{} " + super.toString();
    }
}
