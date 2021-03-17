package com.github.arsiac.psychology.manager.pojo.vo;

import com.github.arsiac.psychology.manager.pojo.entity.OpusEntity;

/**
 * <p>视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
public class OpusVO extends OpusEntity {
    /**
     * 作者
     * */
    private String authorName;


    /**
     * 成果类型
     * */
    private String achievementTypeName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAchievementTypeName() {
        return achievementTypeName;
    }

    public void setAchievementTypeName(String achievementTypeName) {
        this.achievementTypeName = achievementTypeName;
    }

    @Override
    public String toString() {
        return "OpusVO{" +
                "authorName='" + authorName + '\'' +
                ", achievementTypeName='" + achievementTypeName + '\'' +
                "} " + super.toString();
    }
}
