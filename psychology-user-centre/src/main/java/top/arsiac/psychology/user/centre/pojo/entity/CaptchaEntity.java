package top.arsiac.psychology.user.centre.pojo.entity;

import java.util.Date;

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
    private Date expireTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
