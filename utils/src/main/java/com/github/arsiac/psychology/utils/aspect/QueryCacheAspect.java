package com.github.arsiac.psychology.utils.aspect;

import com.github.arsiac.psychology.utils.annotation.QueryCache;
import com.github.arsiac.psychology.utils.common.QueryCacheNameSpace;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * <p>查询缓存切面</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/4/23
 */
@Aspect
@Component
public class QueryCacheAspect {
    /**
     * 日志记录
     * */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryCacheAspect.class);

    /**
     * Gson
     * */
    private static final Gson GSON = new Gson();

    /**
     * redis
     * */
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.github.arsiac.psychology.utils.annotation.QueryCache)")
    public void pointcut(){
        // Point Cut
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 获取注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        QueryCache queryCache = method.getAnnotation(QueryCache.class);

        // name space
        QueryCacheNameSpace namespace = queryCache.value();

        // args
        Object[] args = point.getArgs();

        // cache key
        StringBuilder cacheKeyBuilder = new StringBuilder(namespace.name());

        // no argument
        if (args.length == 0) {
            cacheKeyBuilder.append("_NO_ARG__ALL");
        }

        for (Object arg : args) {
            if (arg == null) {
                cacheKeyBuilder.append("_null");
            } else {
                cacheKeyBuilder.append('_').append(GSON.toJson(arg));
            }
        }

        final String cacheKey = cacheKeyBuilder.toString();

        // 缓存中存在则查询缓存
        Boolean hasKey = redisTemplate.hasKey(cacheKey);
        if (hasKey != null && hasKey) {
            LOGGER.info("缓存命中: key -> {}", cacheKey);
            return redisTemplate.opsForValue().get(cacheKey);
        }

        // 数据库查询
        Object result = point.proceed();
        redisTemplate.opsForValue().set(cacheKey, result);
        LOGGER.info("缓存未命中：key -> {}, value -> {}", cacheKey, result);
        return result;
    }

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
