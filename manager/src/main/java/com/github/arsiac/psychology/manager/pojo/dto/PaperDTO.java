package com.github.arsiac.psychology.manager.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.PaperLevelEntity;
import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.manager.pojo.entity.PaperEntity;

/**
 * <p>数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaperDTO extends PaperEntity {
    /**
     * 第一作者
     * */
    private TeacherEntity firstAuthor;

    /**
     * 通讯作者
     * */
    private TeacherEntity correspondingAuthor;

    /**
     * 论文等级
     * */
    private PaperLevelEntity paperLevel;

    public TeacherEntity getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(TeacherEntity firstAuthor) {
        this.firstAuthor = firstAuthor;
    }

    public TeacherEntity getCorrespondingAuthor() {
        return correspondingAuthor;
    }

    public void setCorrespondingAuthor(TeacherEntity correspondingAuthor) {
        this.correspondingAuthor = correspondingAuthor;
    }

    public PaperLevelEntity getPaperLevel() {
        return paperLevel;
    }

    public void setPaperLevel(PaperLevelEntity paperLevel) {
        this.paperLevel = paperLevel;
    }

    @Override
    public String toString() {
        return "PaperDTO{" +
                "firstAuthor=" + firstAuthor +
                ", correspondingAuthor=" + correspondingAuthor +
                ", paperLevel=" + paperLevel +
                "} " + super.toString();
    }
}
