package com.github.arsiac.psychology.centre.service;

import com.github.arsiac.psychology.centre.pojo.entity.TokenEntity;
import com.github.arsiac.psychology.centre.pojo.entity.UserEntity;

/**
 * <p>token 服务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
public interface TokenService {
    /**
     * access token 过期时间 7day 604800L
     *      1hour 3600L
     * */
    long ACCESS_EXPIRE_SECOND = 3600L;


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
    void invalidateToken(Long id);

    /**
     * <p>获取用户的token</p>
     *
     * @param userId 用户id
     * @return 用户token，不存在则返回空字符串
     * */
    String getToken(Long userId);
}
