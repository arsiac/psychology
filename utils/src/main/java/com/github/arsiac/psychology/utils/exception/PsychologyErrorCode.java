package com.github.arsiac.psychology.utils.exception;

/**
 * <p>工具包错误枚举</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public enum PsychologyErrorCode {
    /**
     * 未知错误
     * */
    UNKNOWN_ERROR(9999, "未知错误"),
    /**
     * 对象拷贝
     * */
    CREATE_TARGET_OBJECT_FAILED(1001, "创建目标对象失败"),
    SOURCE_OBJECT_IS_NULL(1002, "源对象为空"),
    TARGET_OBJECT_IS_NULL(1003, "目标对象为空"),

    /**
     * CURD
     * */
    INSERT_LIST_IS_EMPTY(2001, "增加列表为空"),
    DELETE_LIST_IS_EMPTY(2002, "删除列表为空"),
    ID_IS_NULL(2003, "id为null"),
    ID_NOT_AVAILABLE(2004, "未提供id"),
    VERSION_NOT_AVAILABLE(2005, "未提供版本"),
    SOME_DATA_INSERT_FAILED(2006, "部分数据增加失败"),
    SOME_DATA_DELETE_FAILED(2007, "部分数据删除失败"),
    DATA_ALREADY_EXIST(2008, "数据已经存在"),
    INSERT_FAILED(2009, "插入失败"),
    DELETE_FAILED(2010, "删除失败"),
    DATA_IS_EMPTY(2011, "传入数据为空"),
    ROLE_NOT_AVAILABLE(2012, "未提供角色"),
    RESOURCE_NOT_AVAILABLE(2013, "未提供资源"),
    CANNOT_DELETE_FOREIGN_KEY(2013, "该数据已经被使用，无法删除"),

    /*
     * 登录注册
     * */
    USERNAME_IS_EMPTY(3001, "用户名为空"),
    PASSWORD_IS_EMPTY(3002, "密码为空"),
    CAPTURE_IS_EMPTY(3003, "验证码为空"),
    USERNAME_OR_PASSWORD_ERROR(3004, "用户名不存在或密码错误"),
    CAPTURE_WRONG(3005, "验证码错误"),
    CAPTURE_INVALID(3006, "验证码已失效"),
    USERNAME_ALREADY_EXIST(3007, "用户名已存在"),
    USER_NOT_EXIST(3008, "用户不存在"),
    PASSWORD_ERROR(3009, "密码错误"),
    TEACHER_CODE_IS_EMPTY(3010, "未提供教师编码"),
    TEACHER_CODE_IS_INVALID(3011, "教师编码无效"),
    TEACHER_ALREADY_HAS_ACCOUNT(3012, "该教师已注册账号"),
    UPDATE_TEACHER_ACCOUNT_FAILED(3013, "注册失败(更新账号到教师失败)"),
    CREATE_NEW_USER_FALIED(3014, "注册失败(创建新用户失败)"),

    /**
     * 其他
     * */
    LOAD_FONT_ERROR(4001, "加载字体出错");

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
