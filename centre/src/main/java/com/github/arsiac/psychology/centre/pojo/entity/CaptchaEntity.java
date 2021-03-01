package com.github.arsiac.psychology.centre.pojo.entity;

/**
 * <p>验证码</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/10
 */
public class CaptchaEntity {
    /**
     * 验证码
     * */
    private String code;

    /**
     * 过期时间
     * */
    private Long expireTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "CaptchaEntity{" +
                "code='" + code + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
