package com.github.arsiac.psychology.manager.pojo.vo;

import com.github.arsiac.psychology.manager.pojo.entity.PaperEntity;

/**
 * <p>视图对象}</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
public class PaperVO extends PaperEntity {
    /**
     * 第一作者
     * */
    private String firstAuthorName;

    /**
     * 通讯作者
     * */
    private String correspondingAuthorName;

    /**
     * 论文等级
     * */
    private String paperLevelName;

    public String getFirstAuthorName() {
        return firstAuthorName;
    }

    public void setFirstAuthorName(String firstAuthorName) {
        this.firstAuthorName = firstAuthorName;
    }

    public String getCorrespondingAuthorName() {
        return correspondingAuthorName;
    }

    public void setCorrespondingAuthorName(String correspondingAuthorName) {
        this.correspondingAuthorName = correspondingAuthorName;
    }

    public String getPaperLevelName() {
        return paperLevelName;
    }

    public void setPaperLevelName(String paperLevelName) {
        this.paperLevelName = paperLevelName;
    }

    @Override
    public String toString() {
        return "PaperVO{" +
                "firstAuthorName='" + firstAuthorName + '\'' +
                ", correspondingAuthorName='" + correspondingAuthorName + '\'' +
                ", paperLevelName='" + paperLevelName + '\'' +
                "} " + super.toString();
    }
}
