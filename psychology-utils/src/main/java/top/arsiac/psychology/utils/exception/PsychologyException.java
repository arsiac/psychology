package top.arsiac.psychology.utils.exception;

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
     * 错误细节 (后端看到)
     * */
    private final String detail;

    /**
     * @param code 错误码
     * @param message 错误信息
     * @param detail 详细信息
     * */
    public PsychologyException(int code, String message, String detail) {
        super(message);
        this.code = code;
        this.detail = detail == null ? "" : detail;
    }

    /**
     * @param code 错误码
     * @param message 错误信息
     * */
    public PsychologyException(int code, String message) {
        super(message);
        this.code = code;
        this.detail = "";
    }

    /**
     * @param message 错误信息
     * */
    public PsychologyException(String message) {
        super(message);
        this.code = 0;
        this.detail = "";
    }

    public String getDetail() {
        return detail;
    }

    public int getCode() {
        return code;
    }

    /**
     * <p>获取全部错误信息 (message(code) -> detail)</p>
     * */
    public String getMainMessage() {
        return "".equals(detail) ? super.getMessage() : String.format("%s(%d) -> %s", super.getMessage(), code, detail);
    }
}
