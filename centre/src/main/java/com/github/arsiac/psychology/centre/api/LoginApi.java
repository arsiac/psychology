package com.github.arsiac.psychology.centre.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;
import com.github.arsiac.psychology.centre.pojo.entity.TokenEntity;
import com.github.arsiac.psychology.centre.pojo.form.LoginForm;
import com.github.arsiac.psychology.centre.pojo.form.RegisterForm;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>登录接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/11
 */
@Api(tags = "登录登出管理")
public interface LoginApi {
    /**
     * <p>注册</p>
     *
     * @param form 用户信息
     * @return 是否成功
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    boolean register(@RequestBody RegisterForm form);

    /**
     * <p>登录</p>
     *
     * @param loginForm 登录数据
     * @return token
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    TokenEntity login(@RequestBody LoginForm loginForm);

    /**
     * <p>获取用户的token</p>
     * <p>从redis中读取后返回</p>
     *
     * @param id 用户id
     * @return token
     */
    @ApiOperation("获取登录生成的token")
    @PostMapping("/login/{id}")
    String getToken(@PathVariable Long id);

    /**
     * <p>登出</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    @ApiOperation("登出")
    @PostMapping("/logout")
    boolean logout(@RequestBody UserDTO dto);

    /**
     * <p>获取验证码</p>
     *
     * @param response 回复
     * @throws IOException 写文件错误
     */
    @ApiOperation("获取验证码")
    @GetMapping("/captcha")
    void captcha(HttpServletResponse response) throws IOException;
}
