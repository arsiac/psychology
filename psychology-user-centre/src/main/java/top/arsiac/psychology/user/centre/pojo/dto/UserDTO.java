package top.arsiac.psychology.user.centre.pojo.dto;

import top.arsiac.psychology.user.centre.pojo.entity.UserEntity;

/**
 * <p>用户数据传输对象</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class UserDTO extends UserEntity {
    @Override
    public String toString() {
        return "UserDTO{} " + super.toString();
    }
}
