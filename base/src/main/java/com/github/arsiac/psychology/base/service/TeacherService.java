package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.TeacherDTO;

import java.util.List;


/**
 * <p>教师服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
public interface TeacherService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部教师
     * */
    List<TeacherDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 教师信息
     * @return 查询结果
     * */
    List<TeacherDTO> queryFuzzy(TeacherDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 教师id
     * @return 查询结果
     * */
    TeacherDTO queryById(Long id);

    /**
     * <p>添加新教师</p>
     *
     * @param dto 教师信息
     * @return 是否成功
     */
    boolean add(TeacherDTO dto);

    /**
     * <p>批量添加新教师</p>
     *
     * @param dtoList 教师信息
     * @return 是否成功
     */
    boolean batchAdd(List<TeacherDTO> dtoList);

    /**
     * <p>更新教师</p>
     *
     * @param dto 教师信息
     * @return 是否成功
     */
    boolean modify(TeacherDTO dto);

    /**
     * <p>删除教师</p>
     *
     * @param dto 教师信息 id version
     * @return 是否成功
     */
    boolean remove(TeacherDTO dto);

    /**
     * <p>批量删除教师</p>
     *
     * @param dtoList 教师信息
     * @return 是否成功
     */
    boolean batchRemove(List<TeacherDTO> dtoList);
}

