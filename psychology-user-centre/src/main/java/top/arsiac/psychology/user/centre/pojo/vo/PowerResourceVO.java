package top.arsiac.psychology.user.centre.pojo.vo;

import top.arsiac.psychology.user.centre.pojo.entity.PowerResourceEntity;

/**
 * <p>权力资源视图对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class PowerResourceVO extends PowerResourceEntity {
    /**
     * 权力名称
     * */
    private String powerName;

    /**
     * 资源名称
     * */
    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    @Override
    public String toString() {
        return "PowerResourceVO{" +
                "powerName='" + powerName + '\'' +
                ", resourceName='" + resourceName + '\'' +
                "} " + super.toString();
    }
}
