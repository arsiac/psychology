package com.github.arsiac.psychology.centre.service;

import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;
import com.github.arsiac.psychology.centre.pojo.form.RegisterForm;

import java.util.List;

/**
 * <p>用户业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface UserService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户
     * */
    List<UserDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 用户信息
     * @return 查询结果
     * */
    List<UserDTO> queryFuzzy(UserDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    UserDTO queryById(Long id);

    /**
     * <p>根据用户名查询</p>
     *
     * @param name 用户名
     * @return 查询结果
     * */
    UserDTO queryByName(String name);

    /**
     * <p>添加新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    boolean add(UserDTO dto);

    /**
     * <p>注册用户</p>
     *
     * @param form 注册表单
     * @return 是否成功
     */
    boolean register(RegisterForm form);

    /**
     * <p>批量添加新用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    boolean batchAdd(List<UserDTO> dtoList);

    /**
     * <p>更新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    boolean modify(UserDTO dto);

    /**
     * <p>删除用户</p>
     *
     * @param dto 用户信息 id version
     * @return 是否成功
     */
    boolean remove(UserDTO dto);

    /**
     * <p>批量删除用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    boolean batchRemove(List<UserDTO> dtoList);
}
