package com.github.arsiac.psychology.centre.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.arsiac.psychology.centre.pojo.entity.UserEntity;

/**
 * <p>用户数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO extends UserEntity {
    @Override
    public String toString() {
        return "UserDTO{} " + super.toString();
    }
}
