package com.github.arsiac.psychology.centre.pojo.form.param;

import com.github.arsiac.psychology.utils.entity.PageParam;

/**
 * <p>角色参数</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/4
 */
public class RoleParam extends PageParam {
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
        return "RoleParam{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
