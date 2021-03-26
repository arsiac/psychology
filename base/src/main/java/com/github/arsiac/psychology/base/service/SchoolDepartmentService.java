package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.SchoolDepartmentDTO;

import java.util.List;


/**
 * <p>学院服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:55
 */
public interface SchoolDepartmentService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部学院
     * */
    List<SchoolDepartmentDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 学院信息
     * @return 查询结果
     * */
    List<SchoolDepartmentDTO> queryFuzzy(SchoolDepartmentDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 学院id
     * @return 查询结果
     * */
    SchoolDepartmentDTO queryById(Long id);

    /**
     * <p>添加新学院</p>
     *
     * @param dto 学院信息
     * @return 是否成功
     */
    boolean add(SchoolDepartmentDTO dto);

    /**
     * <p>批量添加新学院</p>
     *
     * @param dtoList 学院信息
     * @return 是否成功
     */
    boolean batchAdd(List<SchoolDepartmentDTO> dtoList);

    /**
     * <p>更新学院</p>
     *
     * @param dto 学院信息
     * @return 是否成功
     */
    boolean modify(SchoolDepartmentDTO dto);

    /**
     * <p>删除学院</p>
     *
     * @param dto 学院信息 id version
     * @return 是否成功
     */
    boolean remove(SchoolDepartmentDTO dto);

    /**
     * <p>批量删除学院</p>
     *
     * @param dtoList 学院信息
     * @return 是否成功
     */
    boolean batchRemove(List<SchoolDepartmentDTO> dtoList);
}

