package top.arsiac.psychology.utils.common;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>Redis 工具类</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/24
 */
@Component
public class RedisUtils {
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 一分钟
     * */
    public static final long EXPIRE_ONE_MINUTE = 60L;

    /**
     * 一小时
     * */
    public static final long EXPIRE_ONE_HOUR = 3600L;

    /**
     * 一天
     * */
    public static final long EXPIRE_ONE_DAY = 86400L;

    /**
     * 永久，不过期
     * */
    public static final long EXPIRE_FOREVER = -1L;

    /**
     * 非法参数异常: key is null
     * */
    public static final NullPointerException ARGUMENT_KEY_NULL =
            new NullPointerException("key is null.");

    /**
     * <p>存储key value到redis</p>
     *
     * @param key key
     * @param value value
     * @param expire 过期时间
     */
    public void set(String key, Object value, long expire) {
        if (key == null) {
            throw ARGUMENT_KEY_NULL;
        }
        redisTemplate.opsForValue().set(key, toJsonString(value), expire);
    }

    /**
     * <p>存储key value到redis</p>
     *
     * @param key key
     * @param value value
     */
    public void set(String key, Object value) {
        if (key == null) {
            throw ARGUMENT_KEY_NULL;
        }
        redisTemplate.opsForValue().set(key, toJsonString(value));
    }

    /**
     * <p>获取key对应的value</p>
     *
     * @param key key
     * @return value
     */
    public String get(String key) {
        if (key == null) {
            throw ARGUMENT_KEY_NULL;
        }
        return toJsonString(redisTemplate.opsForValue().get(key));
    }

    /**
     * <p>获取key对应的value</p>
     *
     * @param key key
     * @return value
     */
    public <T> T get(String key, Class<T> target) {
        if (key == null) {
            throw ARGUMENT_KEY_NULL;
        }
        return JSON.parseObject(toJsonString(redisTemplate.opsForValue().get(key)), target);
    }

    /**
     * <p>获取key对应的value</p>
     *
     * @param key key
     * @return value
     */
    public Boolean delete(String key) {
        if (key == null) {
            throw ARGUMENT_KEY_NULL;
        }
        return redisTemplate.delete(key);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * <p>转换为json</p>
     * <p>如果是字符串，直接返回</p>
     *
     * @param o 对象
     * @return 字符串
     */
    private String toJsonString(Object o) {
        // 如果是字符串，直接返回
        if (o instanceof String) {
            return (String) o;
        }

        // 如果是内置类型， 使用String.valueOf()
        if (o instanceof Integer ||
        o instanceof Long ||
        o instanceof Float ||
        o instanceof Double ||
        o instanceof Boolean) {
            return String.valueOf(o);
        }

        // 如果是其他对象，转换为JSON字符串
        return JSON.toJSONString(o);
    }
}
