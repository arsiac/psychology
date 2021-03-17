package com.github.arsiac.psychology.manager.pojo.vo;

import com.github.arsiac.psychology.manager.pojo.entity.AchievementEntity;

/**
 * <p>成果视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
public class AchievementVO extends AchievementEntity {
    /**
     * 成果类型
     * */
    private String achievementTypeName;

    /**
     * 获奖等级
     * */
    private String rewordLevelName;

    public String getAchievementTypeName() {
        return achievementTypeName;
    }

    public void setAchievementTypeName(String achievementTypeName) {
        this.achievementTypeName = achievementTypeName;
    }

    public String getRewordLevelName() {
        return rewordLevelName;
    }

    public void setRewordLevelName(String rewordLevelName) {
        this.rewordLevelName = rewordLevelName;
    }

    @Override
    public String toString() {
        return "AchievementVO{" +
                "achievementTypeName='" + achievementTypeName + '\'' +
                ", rewordLevelName='" + rewordLevelName + '\'' +
                "} " + super.toString();
    }
}
