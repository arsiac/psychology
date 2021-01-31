package top.arsiac.psychology.utils.exception;

/**
 * <p>工具包错误枚举</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public enum PsychologyUtilErrorCode {
    /**
     * 创建目标对象失败
     * */
    CREATE_TARGET_OBJECT_FAILED(1, "创建目标对象失败"),
    SOURCE_OBJECT_IS_NULL(2, "源对象为空"),
    TARGET_OBJECT_IS_NULL(3, "目标对象为空");

    /**
     * 错误码
     * */
    private final int code;

    /**
     * 错误信息
     * */
    private final String message;

    PsychologyUtilErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据错误码创建异常
     * @param exception 其他异常信息
     * @return 异常对象
     * */
    public PsychologyUtilException createException(Throwable exception) {
        String errorMessage = exception == null ?
                String.format("错误码: %d, 错误信息: %s", this.code, this.message) :
                String.format("错误码: %d, 错误信息: %s, 异常信息: %s", this.code, this.message, exception.getMessage());
        return new PsychologyUtilException(errorMessage);
    }

    /**
     * 根据错误码创建异常
     * @return 异常对象
     * */
    public PsychologyUtilException createException() {
        return createException(null);
    }
}
