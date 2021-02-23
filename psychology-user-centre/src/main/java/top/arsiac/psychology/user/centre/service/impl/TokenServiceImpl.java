package top.arsiac.psychology.user.centre.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.entity.UserEntity;
import top.arsiac.psychology.user.centre.service.TokenService;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public TokenEntity createToken(UserEntity user) {
        final long currentMills = System.currentTimeMillis();
        Date accessExpire = new Date(currentMills + ACCESS_EXPIRE_MILLISECOND);

        // 生成 token
        String accessToken = JWT.create()
                .withClaim("user", user.getId())
                .withClaim("expire", accessExpire)
                .sign(Algorithm.HMAC512(user.getPassword()));

        TokenEntity tokenEntity = new TokenEntity(user.getId(), user.getUsername(), accessToken, accessExpire);

        // 将token保存到redis
        redisTemplate.opsForValue().set(String.valueOf(user.getId()), tokenEntity,
                ACCESS_EXPIRE_MILLISECOND, TimeUnit.MILLISECONDS);

        return tokenEntity;
    }

    @Override
    public void invalidateToken(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException("用户登出");
        }
        // 删除用户的token
        redisTemplate.delete(String.valueOf(id));
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
