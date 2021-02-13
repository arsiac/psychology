package top.arsiac.psychology.utils.exception;

/**
 * <p>工具包错误枚举</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public enum PsychologyErrorCode {
    /**
     * 创建目标对象失败
     * */
    CREATE_TARGET_OBJECT_FAILED(1001, "创建目标对象失败"),
    SOURCE_OBJECT_IS_NULL(1002, "源对象为空"),
    TARGET_OBJECT_IS_NULL(1003, "目标对象为空"),
    INSERT_LIST_IS_EMPTY(1004, "增加列表为空"),
    DELETE_LIST_IS_EMPTY(1005, "删除列表为空"),
    ID_IS_NULL(1006, "id为null"),
    ID_NOT_AVAILABLE(1007, "未提供id"),
    VERSION_NOT_AVAILABLE(1008, "未提供版本"),
    SOME_DATA_INSERT_FAILED(1009, "部分数据增加失败"),
    SOME_DATA_DELETE_FAILED(1009, "部分数据删除失败"),
    DATA_ALREADY_EXIST(1010, "数据已经存在"),
    INSERT_FAILED(1011, "插入失败"),
    DELETE_FAILED(1012, "删除失败"),
    DATA_IS_EMPTY(1013, "传入数据为空"),

    /*
     * 登录
     * */
    USERNAME_IS_EMPTY(1014, "用户名为空"),
    PASSWORD_IS_EMPTY(1015, "密码为空"),
    CAPTURE_IS_EMPTY(1016, "验证码为空"),
    USERNAME_OR_PASSWORD_ERROR(1017, "用户名不存在或密码错误"),

    LOAD_FONT_ERROR(1018, "加载字体出错");

    /**
     * 错误码
     * */
    private final int code;

    /**
     * 错误信息
     * */
    private final String message;

    PsychologyErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据错误码创建异常
     * @param detail 异常详细信息
     * @return 异常对象
     * */
    public PsychologyException createException(String detail) {
        return new PsychologyException(code, message, detail);
    }

    /**
     * 根据错误码创建异常
     * @param exception 其他异常信息
     * @return 异常对象
     * */
    public PsychologyException createException(Throwable exception) {
        return createException(exception == null ? null : exception.getMessage());
    }

    /**
     * 根据错误码创建异常
     * @return 异常对象
     * */
    public PsychologyException createException() {
        return createException((String) null);
    }
}
