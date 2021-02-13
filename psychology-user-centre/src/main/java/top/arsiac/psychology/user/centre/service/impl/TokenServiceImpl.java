package top.arsiac.psychology.user.centre.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import top.arsiac.psychology.user.centre.pojo.entity.TokenEntity;
import top.arsiac.psychology.user.centre.pojo.entity.UserEntity;
import top.arsiac.psychology.user.centre.service.TokenService;

import java.util.Date;

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
     * access token 过期时间 1h
     * */
    private static final long ACCESS_EXPIRE_MILLISECOND = 3600000L;

    /**
     * refresh token 过期时间 7d
     * */
    private static final long REFRESH_EXPIRE_MILLISECOND = 604800000L;
    @Override
    public TokenEntity createToken(UserEntity user) {
        final long currentMills = System.currentTimeMillis();
        Date accessExpire = new Date(currentMills + ACCESS_EXPIRE_MILLISECOND);
        Date refreshExpire = new Date(currentMills + REFRESH_EXPIRE_MILLISECOND);

        // 生成 token
        String accessToken = JWT.create()
                .withClaim("user", user.getId())
                .withClaim("expire", accessExpire)
                .sign(Algorithm.HMAC512(user.getPassword()));

        String refreshToken = JWT.create()
                .withClaim("user", user.getId())
                .withClaim("expire", refreshExpire)
                .sign(Algorithm.HMAC512(user.getPassword()));

        return new TokenEntity(user.getId(),
                user.getUsername(),
                accessToken,
                refreshToken,
                accessExpire,
                refreshExpire);
    }

    @Override
    public void invalidateToken(long id) {
        // 删除缓存
    }
}
