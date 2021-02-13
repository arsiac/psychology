package top.arsiac.psychology.utils.common;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>回复</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/11
 */
public class Reply {
    /**
     * 成功状态码
     * */
    public static final int SUCCESS_CODE = 200;

    /**
     * 默认错误状态码
     * */
    public static final int ERROR_CODE = 500;

    /**
     * 头部
     * */
    private final Head head = new Head();

    /**
     * 具体信息
     * */
    private Map<String, Object> body;

    /**
     * <p>head部分</p>
     *
     * @author arsiac
     * @version 1.0
     * @since  2021/2/11
     */
    static class Head {
        int code;
        String message;
    }

    /**
     * <p>自定义头部</p>
     *
     * @param code 状态码
     * @param message 消息
     * @return reply
     */
    public Reply head(int code, String message) {
        head.code = code;
        head.message = message;
        return this;
    }

    /**
     * <p>成功</p>
     *
     * @param message 消息
     * @return reply
     */
    public Reply success(String message) {
        return head(SUCCESS_CODE, message);
    }

    /**
     * <p>成功</p>
     *
     * @return reply
     */
    public Reply success() {
        return head(SUCCESS_CODE, "success");
    }

    /**
     * <p>错误</p>
     *
     * @param message 消息
     * @return reply
     */
    public Reply error(String message) {
        return head(ERROR_CODE, message);
    }

    /**
     * <p>失败</p>
     *
     * @return reply
     */
    public Reply error() {
        return head(ERROR_CODE, "success");
    }

    /**
     * <p>向body添加新数据</p>
     *
     * @param key key
     * @param value value
     * @return reply
     */
    public Reply with(String key, Object value) {
        // 跳过无效 key
        if (key == null || "".equals(key)) {
            return this;
        }

        // 保证添加时 body 不为 null
        if (body == null) {
            body = new HashMap<>(5);
        }
        body.put(key, value);
        return this;
    }

    /**
     * <p>数据</p>
     *
     * @param data 数据
     * @return reply
     */
    public Reply withData(Object data) {
        return with("data", data);
    }

    /**
     * <p>总数</p>
     *
     * @param total 全部
     * @return reply
     */
    public Reply withTotal(int total) {
        return with("total", total);
    }

    /**
     * <p>一页行数</p>
     *
     * @param pageSize 一页行数
     * @return reply
     */
    public Reply withPageSize(int pageSize) {
        return with("pageSize", pageSize);
    }

    public Map<String, Object> getBody() {
        return body;
    }
}
