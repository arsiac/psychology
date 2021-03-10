package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.DepartmentDTO;

import java.util.List;


/**
 * <p>系别服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
public interface DepartmentService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部系别
     * */
    List<DepartmentDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 系别信息
     * @return 查询结果
     * */
    List<DepartmentDTO> queryFuzzy(DepartmentDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 系别id
     * @return 查询结果
     * */
    DepartmentDTO queryById(Long id);

    /**
     * <p>添加新系别</p>
     *
     * @param dto 系别信息
     * @return 是否成功
     */
    boolean add(DepartmentDTO dto);

    /**
     * <p>批量添加新系别</p>
     *
     * @param dtoList 系别信息
     * @return 是否成功
     */
    boolean batchAdd(List<DepartmentDTO> dtoList);

    /**
     * <p>更新系别</p>
     *
     * @param dto 系别信息
     * @return 是否成功
     */
    boolean modify(DepartmentDTO dto);

    /**
     * <p>删除系别</p>
     *
     * @param dto 系别信息 id version
     * @return 是否成功
     */
    boolean remove(DepartmentDTO dto);

    /**
     * <p>批量删除系别</p>
     *
     * @param dtoList 系别信息
     * @return 是否成功
     */
    boolean batchRemove(List<DepartmentDTO> dtoList);
}

