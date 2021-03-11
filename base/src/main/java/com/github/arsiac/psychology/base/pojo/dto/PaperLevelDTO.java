package com.github.arsiac.psychology.base.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.base.pojo.entity.PaperLevelEntity;

/**
 * <p>论文级别数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 20:59:39
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaperLevelDTO extends PaperLevelEntity {
    @Override
    public String toString() {
        return "PaperLevelDTO{} " + super.toString();
    }
}
