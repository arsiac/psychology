package com.github.arsiac.psychology.manager.pojo.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

/**
 * <p>科研立项分页</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/8
 */
public class ProjectParam extends PageParam {
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
}
