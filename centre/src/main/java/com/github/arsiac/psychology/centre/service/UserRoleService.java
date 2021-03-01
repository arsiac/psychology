package com.github.arsiac.psychology.centre.service;


import com.github.arsiac.psychology.centre.pojo.dto.UserRoleDTO;

import java.util.List;

/**
 * <p>用户-角色业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface UserRoleService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户-角色
     * */
    List<UserRoleDTO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<UserRoleDTO> queryByRoleId(Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    List<UserRoleDTO> queryByUserId(Long id);

    /**
     * <p>增加用户-角色</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    boolean add(UserRoleDTO dto);

    /**
     * <p>增加用户-角色</p>
     *
     * @param dtoList 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean batchAdd(List<UserRoleDTO> dtoList);

    /**
     * <p>更新用户-角色</p>
     *
     * @param dto 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean modify(UserRoleDTO dto);

    /**
     * <p>删除用户-角色</p>
     *
     * @param dto 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean remove(UserRoleDTO dto);

    /**
     * <p>批量删除用户-角色</p>
     *
     * @param dtoList 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean batchRemove(List<UserRoleDTO> dtoList);
}
