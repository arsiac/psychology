package com.github.arsiac.psychology.centre.service;


import com.github.arsiac.psychology.centre.pojo.dto.RoleDTO;

import java.util.List;

/**
 * <p>角色业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface RoleService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色
     * */
    List<RoleDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 角色信息
     * @return 查询结果
     * */
    List<RoleDTO> queryFuzzy(RoleDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    RoleDTO queryById(Long id);

    /**
     * <p>添加新角色</p>
     *
     * @param dto 角色信息
     * @return 是否成功
     */
    boolean add(RoleDTO dto);

    /**
     * <p>批量添加新角色</p>
     *
     * @param dtoList 角色信息
     * @return 是否成功
     */
    boolean batchAdd(List<RoleDTO> dtoList);

    /**
     * <p>更新角色</p>
     *
     * @param dto 角色信息
     * @return 是否成功
     */
    boolean modify(RoleDTO dto);

    /**
     * <p>删除角色</p>
     *
     * @param dto 角色信息 id version
     * @return 是否成功
     */
    boolean remove(RoleDTO dto);

    /**
     * <p>批量删除角色</p>
     *
     * @param dtoList 角色信息
     * @return 是否成功
     */
    boolean batchRemove(List<RoleDTO> dtoList);
}
