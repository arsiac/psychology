package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.SubjectTypeEntity;

/**
 * <p>课题类别数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectTypeDTO extends SubjectTypeEntity {
    @Override
    public String toString() {
        return "SubjectTypeDTO{} " + super.toString();
    }
}
