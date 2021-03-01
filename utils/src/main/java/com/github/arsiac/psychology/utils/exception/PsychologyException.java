package com.github.arsiac.psychology.utils.exception;

/**
 * <p>工具包错误异常</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class PsychologyException extends RuntimeException {
    /**
     * 错误码
     * */
    private final int code;

    /**
     * 错误信息
     * */
    private final String brief;

    /**
     * 错误细节
     * */
    private final String detail;

    /**
     * @param code 错误码
     * @param brief 错误信息
     * @param detail 详细信息
     * */
    public PsychologyException(int code, String brief, String detail) {
        super(detail == null || "".equals(detail) ?
                String.format("%s(%d)", brief, code) :
                String.format("%s(%d) -> %s", brief, code, detail));
        this.brief = brief;
        this.code = code;
        this.detail = detail == null ? "" : detail;
    }

    /**
     * @param code 错误码
     * @param brief 错误信息
     * */
    public PsychologyException(int code, String brief) {
        this(code, brief, "");
    }

    /**
     * @param brief 错误信息
     * */
    public PsychologyException(String brief) {
        this(0, brief);
    }

    public String getBrief() {
        return brief;
    }

    public String getDetail() {
        return detail;
    }

    public int getCode() {
        return code;
    }
}
