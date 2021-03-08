package com.github.arsiac.psychology.manager.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.manager.pojo.entity.ProjectEntity;

/**
 * <p>科研立项数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO extends ProjectEntity {
    @Override
    public String toString() {
        return "ProjectDTO{} " + super.toString();
    }
}
