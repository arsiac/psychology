package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.DictionaryTypeEntity;

/**
 * <p>字典类型</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryTypeDTO extends DictionaryTypeEntity {
    @Override
    public String toString() {
        return "DictionaryTypeDTO{} " + super.toString();
    }
}
