package com.github.arsiac.psychology.centre.api;

import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;
import com.github.arsiac.psychology.centre.pojo.form.PasswordForm;
import com.github.arsiac.psychology.centre.pojo.form.param.UserParam;
import com.github.arsiac.psychology.centre.pojo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>用户管理接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@Api(tags = "用户管理")
@RequestMapping(value = "/user")
public interface UserApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    @ResponseBody
    List<UserVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 用户信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    @ResponseBody
    List<UserVO> queryFuzzy(UserParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    @ResponseBody
    UserVO queryById(@PathVariable Long id);

    /**
     * <p>添加新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    @ResponseBody
    boolean add(@RequestBody UserDTO dto);

    /**
     * <p>批量添加新用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    @ResponseBody
    boolean batchAdd(@RequestBody List<UserDTO> dtoList);

    /**
     * <p>更新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    @ResponseBody
    boolean modify(@RequestBody UserDTO dto);


    /**
     * <p>修改密码</p>
     *
     * @param form 密码
     * @return 是否成功
     */
    @ApiOperation("修改密码")
    @PutMapping("/passwd")
    @ResponseBody
    boolean changePassword(@RequestBody PasswordForm form);

    /**
     * <p>删除用户</p>
     *
     * @param dto 用户信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    @ResponseBody
    boolean remove(@RequestBody UserDTO dto);

    /**
     * <p>批量删除用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    @ResponseBody
    boolean batchRemove(@RequestBody List<UserDTO> dtoList);
}
