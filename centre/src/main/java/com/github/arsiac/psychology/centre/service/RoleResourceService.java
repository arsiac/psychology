package com.github.arsiac.psychology.centre.service;

import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;

import java.util.List;

/**
 * <p>角色-资源服务</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
public interface RoleResourceService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色-资源
     * */
    List<RoleResourceDTO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<RoleResourceDTO> queryByRoleId(Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 资源id
     * @return 查询结果
     * */
    List<RoleResourceDTO> queryByResourceId(Long id);

    /**
     * <p>增加角色-资源</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    boolean add(RoleResourceDTO dto);

    /**
     * <p>增加角色-资源</p>
     *
     * @param dtoList 角色-资源信息
     * @return 数据库变动行数
     * */
    boolean batchAdd(List<RoleResourceDTO> dtoList);

    /**
     * <p>更新角色-资源</p>
     *
     * @param dto 角色-资源信息
     * @return 数据库变动行数
     * */
    boolean modify(RoleResourceDTO dto);

    /**
     * <p>删除角色-资源</p>
     *
     * @param dto 角色-资源信息
     * @return 数据库变动行数
     * */
    boolean remove(RoleResourceDTO dto);

    /**
     * <p>批量删除角色-资源</p>
     *
     * @param dtoList 角色-资源信息
     * @return 数据库变动行数
     * */
    boolean batchRemove(List<RoleResourceDTO> dtoList);
}
