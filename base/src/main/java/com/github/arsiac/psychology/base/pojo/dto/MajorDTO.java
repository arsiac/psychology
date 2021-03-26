package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.MajorEntity;

/**
 * <p>专业数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:56
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MajorDTO extends MajorEntity {
    @Override
    public String toString() {
        return "MajorDTO{} " + super.toString();
    }
}
