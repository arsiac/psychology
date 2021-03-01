package com.github.arsiac.psychology.centre.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.pojo.entity.TokenEntity;
import com.github.arsiac.psychology.centre.pojo.entity.UserEntity;
import com.github.arsiac.psychology.centre.service.TokenService;
import com.github.arsiac.psychology.utils.common.RedisUtils;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;


/**
 * <p>token 服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
@Service
public class TokenServiceImpl implements TokenService {
    /**
     * redis
     * */
    private RedisUtils redisUtils;

    @Override
    public TokenEntity createToken(UserEntity user) {
        Long accessExpire = System.currentTimeMillis() + ACCESS_EXPIRE_SECOND * 1000;

        // 生成 token
        String accessToken = JWT.create()
                .withClaim("user", user.getId())
                .withClaim("expire", accessExpire)
                .sign(Algorithm.HMAC512(user.getPassword()));

        TokenEntity tokenEntity = new TokenEntity(user.getId(), user.getUsername(), accessToken, accessExpire);

        // 将token保存到redis
        redisUtils.set(String.valueOf(user.getId()), tokenEntity, ACCESS_EXPIRE_SECOND);

        return tokenEntity;
    }

    @Override
    public void invalidateToken(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException("用户登出");
        }

        // 删除用户的token
        redisUtils.delete(String.valueOf(id));
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
}
