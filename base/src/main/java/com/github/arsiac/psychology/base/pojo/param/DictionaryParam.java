package com.github.arsiac.psychology.base.pojo.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

/**
 * <p>字典分页参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
public class DictionaryParam extends PageParam {
    /**
     * 名称
     * */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DictionaryParam{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
