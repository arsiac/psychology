package top.arsiac.psychology.user.centre.pojo.entity;

import java.util.Date;

/**
 * <p>token结构</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
public class TokenEntity {
    /**
     * 用户ID
     * */
    private Long userId;

    /**
     * 用户名
     * */
    private String username;

    /**
     * access token
     * */
    private String accessToken;

    /**
     * refresh token
     * */
    private String refreshToken;

    /**
     * access token 过期时间
     * */
    private Date expireTime;

    /**
     * refresh token 过期时间
     * */
    private Date updateTime;

    public TokenEntity() {}

    /**
     * @param userId 用户 id
     * @param username 用户名
     * @param accessToken access token
     * @param refreshToken refresh token
     * @param expireTime access token 过期时间
     * @param updateTime refresh token 过期时间
     * */
    public TokenEntity(Long userId, String username, String accessToken, String refreshToken, Date expireTime, Date updateTime) {
        this.userId = userId;
        this.username = username;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireTime = expireTime;
        this.updateTime = updateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
