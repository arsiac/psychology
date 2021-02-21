package top.arsiac.psychology.user.centre.service;

import java.awt.image.BufferedImage;

/**
 * <p>验证码服务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/11
 */
public interface CaptchaService {
    /**
     * <p>获取图片验证码</p>
     *
     * @param uuid uuid
     * @return 图片
     */
    BufferedImage generateCaptcha(long uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(long uuid, String code);

    /**
     * 从缓存移除过期验证码信息
     * */
    void removeInvalidCaptcha();
}
