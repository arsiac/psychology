package top.arsiac.psychology.user.centre.pojo.entity;

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
     * access token 过期时间
     * */
    private Long expireTime;

    public TokenEntity() {}

    /**
     * @param userId 用户 id
     * @param username 用户名
     * @param accessToken access token
     * @param expireTime access token 过期时间
     * */
    public TokenEntity(Long userId, String username, String accessToken, Long expireTime) {
        this.userId = userId;
        this.username = username;
        this.accessToken = accessToken;
        this.expireTime = expireTime;
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


    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
