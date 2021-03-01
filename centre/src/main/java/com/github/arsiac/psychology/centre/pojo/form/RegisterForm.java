package com.github.arsiac.psychology.centre.pojo.form;


import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;

/**
 * <p>注册表单</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/22
 */
public class RegisterForm extends UserDTO {

    /**
     * 教师编号
     * */
    private Long code;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "code=" + code +
                '}' + super.toString();
    }
}
