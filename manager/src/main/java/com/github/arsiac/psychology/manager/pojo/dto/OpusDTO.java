package com.github.arsiac.psychology.manager.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.manager.pojo.entity.AchievementTypeEntity;
import com.github.arsiac.psychology.manager.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.manager.pojo.entity.OpusEntity;

/**
 * <p>数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpusDTO extends OpusEntity {
    /**
     * 作者
     * */
    private TeacherEntity author;

    /**
     * 成果类型
     * */
    private AchievementTypeEntity achievementType;

    public TeacherEntity getAuthor() {
        return author;
    }

    public void setAuthor(TeacherEntity author) {
        this.author = author;
    }

    public AchievementTypeEntity getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(AchievementTypeEntity achievementType) {
        this.achievementType = achievementType;
    }

    @Override
    public String toString() {
        return "OpusDTO{" +
                "author=" + author +
                ", achievementType=" + achievementType +
                "} " + super.toString();
    }
}
