package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.AchievementTypeEntity;

/**
 * <p>成果形式数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AchievementTypeDTO extends AchievementTypeEntity {
    @Override
    public String toString() {
        return "AchievementTypeDTO{} " + super.toString();
    }
}
