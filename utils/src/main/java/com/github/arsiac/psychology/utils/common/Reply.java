package com.github.arsiac.psychology.utils.common;


import java.util.HashMap;

/**
 * <p>回复</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/11
 */
public class Reply extends HashMap<String, Object> {

    public Reply() {
        this(200, "success");
    }

    public Reply(int code, String msg) {
        put("code", code);
        put("message", msg);
    }

    /**
     * <p>添加新属性</p>
     *
     * @param key 属性名
     * @param value 属性值
     * @return reply
     */
    public Reply with(String key, Object value) {
        put(key, value);
        return this;
    }

    /**
     * <p>添加数据</p>
     *
     * @param data 数据
     * @return reply
     */
    public Reply data(Object data) {
        return with("data", data);
    }

    /**
     * <p>添加 total</p>
     *
     * @param total 总行数
     * @return reply
     */
    public Reply total(Object total) {
        return with("total", total);
    }

    /**
     * <p>添加 pageSize</p>
     *
     * @param pageSize 行数
     * @return reply
     */
    public Reply pageSize(Object pageSize) {
        return with("pageSize", pageSize);
    }

    /**
     * <p>添加 pageNum</p>
     *
     * @param pageNum 行数
     * @return reply
     */
    public Reply pageNum(Object pageNum) {
        return with("pageNum", pageNum);
    }

    public static Reply success() {
        return new Reply();
    }

    public static Reply success(String msg) {
        Reply reply = new Reply();
        return reply.with("message", msg);
    }

    public static Reply error(int code, String msg) {
        return new Reply(code, msg);
    }

}
