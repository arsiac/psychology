package com.github.arsiac.psychology.base.pojo.vo;

import com.github.arsiac.psychology.base.pojo.entity.DictionaryEntity;

/**
 * <p>字典</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
public class DictionaryVO extends DictionaryEntity {
    /**
     * 字典类型
     * */
    private String dictionaryTypeName;

    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName;
    }

    @Override
    public String toString() {
        return "DictionaryVO{" +
                "dictionaryTypeName='" + dictionaryTypeName + '\'' +
                '}';
    }
}
