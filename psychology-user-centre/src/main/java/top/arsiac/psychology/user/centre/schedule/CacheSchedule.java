package top.arsiac.psychology.user.centre.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.arsiac.psychology.user.centre.service.CaptchaService;

/**
 * <p>缓存定时清理</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/21
 */
@Component
public class CacheSchedule {
    /**
     * 日志
     * */
    private final Logger logger = LoggerFactory.getLogger("CacheSchedule");
    /**
     * 验证码服务
     * */
    private CaptchaService captchaService;

    /**
     * <p>清理验证码缓存</p>
     * <p>五分钟清理一次</p>
     */
    @Scheduled(cron = "0 0/5 * * * *")
    public void clearCaptchaCache() {
        logger.info("清理验证码缓存");
        captchaService.removeInvalidCaptcha();
    }

    @Autowired
    public void setCaptchaService(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }
}
