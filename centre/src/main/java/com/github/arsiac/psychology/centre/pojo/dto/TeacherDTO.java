package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Override
    public String toString() {
        return "TeacherDTO{} " + super.toString();
    }
}
