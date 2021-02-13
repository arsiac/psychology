package top.arsiac.psychology.user.centre.service;

import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.entity.UserEntity;

/**
 * <p>token 服务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
public interface TokenService {

    /**
     * <p>创建 token</p>
     *
     * @param user 用户
     * @return 生成的token
     */
    TokenEntity createToken(UserEntity user);

    /**
     * <p>使用户 token 失效</p>
     *
     * @param id 用户 id
     */
    void invalidateToken(long id);
}
