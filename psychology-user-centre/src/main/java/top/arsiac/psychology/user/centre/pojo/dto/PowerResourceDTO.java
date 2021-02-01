package top.arsiac.psychology.user.centre.pojo.dto;

import top.arsiac.psychology.user.centre.pojo.entity.PowerResourceEntity;

/**
 * <p>权力对应资源数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class PowerResourceDTO extends PowerResourceEntity {
    /**
     * 权力dto
     * */
    private PowerDTO powerDTO;

    /**
     * 资源dto
     * */
    private ResourceDTO resourceDTO;

    public PowerDTO getPowerDTO() {
        return powerDTO;
    }

    public void setPowerDTO(PowerDTO powerDTO) {
        this.powerDTO = powerDTO;
    }

    public ResourceDTO getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(ResourceDTO resourceDTO) {
        this.resourceDTO = resourceDTO;
    }

    @Override
    public String toString() {
        return "PowerResourceDTO{" +
                "powerDTO=" + powerDTO +
                ", resourceDTO=" + resourceDTO +
                "} " + super.toString();
    }
}
