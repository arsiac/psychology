package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.DictionaryEntity;
import com.github.arsiac.psychology.base.pojo.entity.DictionaryTypeEntity;

/**
 * <p>字典</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryDTO extends DictionaryEntity {
    /**
     * 字典类型
     * */
    private DictionaryTypeEntity dictionaryTypeEntity;

    public DictionaryTypeEntity getDictionaryTypeEntity() {
        return dictionaryTypeEntity;
    }

    public void setDictionaryTypeEntity(DictionaryTypeEntity dictionaryTypeEntity) {
        this.dictionaryTypeEntity = dictionaryTypeEntity;
    }

    @Override
    public String toString() {
        return "DictionaryDTO{} " + super.toString();
    }
}
