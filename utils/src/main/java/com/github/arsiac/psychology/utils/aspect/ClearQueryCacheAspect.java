package com.github.arsiac.psychology.utils.aspect;

import com.github.arsiac.psychology.utils.annotation.ClearQueryCache;
import com.github.arsiac.psychology.utils.common.QueryCacheNameSpace;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * <p>清空某个命名空间的数据</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/4/23
 */
@Aspect
@Component
public class ClearQueryCacheAspect {
    /**
     * 日志记录
     * */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClearQueryCacheAspect.class);

    /**
     * redis
     * */
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.github.arsiac.psychology.utils.annotation.ClearQueryCache)")
    public void pointcut() {
        // Point Cut
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturn(JoinPoint point, Object result) throws Throwable {
        // 获取注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        ClearQueryCache clearQueryCache = method.getAnnotation(ClearQueryCache.class);
        QueryCacheNameSpace namespace = clearQueryCache.value();

        // 获取所有namespace开头的key
        String keyStart = namespace.name();
        Set<String> keySet = redisTemplate.keys(keyStart + "*");

        if (keySet == null || keySet.isEmpty()) {
            LOGGER.info("{}开头的key不存在({})", keyStart, keySet == null ? "null" : "0");
            return;
        }

        LOGGER.info("清除redis缓存：命名空间 -> {}, keys -> {}", keyStart, keySet);
        for (String key : keySet) {
            redisTemplate.delete(key);
        }
    }

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
