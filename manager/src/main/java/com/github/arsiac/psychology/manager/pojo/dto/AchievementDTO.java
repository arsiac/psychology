package com.github.arsiac.psychology.manager.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.AchievementTypeEntity;
import com.github.arsiac.psychology.base.pojo.entity.RewordLevelEntity;
import com.github.arsiac.psychology.manager.pojo.entity.AchievementEntity;

/**
 * <p>成果数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AchievementDTO extends AchievementEntity {
    /**
     * 成果类型
     * */
    private AchievementTypeEntity achievementType;

    /**
     * 获奖等级
     * */
    private RewordLevelEntity rewordLevel;

    public AchievementTypeEntity getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(AchievementTypeEntity achievementType) {
        this.achievementType = achievementType;
    }

    public RewordLevelEntity getRewordLevel() {
        return rewordLevel;
    }

    public void setRewordLevel(RewordLevelEntity rewordLevel) {
        this.rewordLevel = rewordLevel;
    }

    @Override
    public String toString() {
        return "AchievementDTO{" +
                "achievementType=" + achievementType +
                ", rewordLevel=" + rewordLevel +
                "} " + super.toString();
    }
}
