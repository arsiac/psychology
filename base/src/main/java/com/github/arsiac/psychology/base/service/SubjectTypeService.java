package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.SubjectTypeDTO;

import java.util.List;


/**
 * <p>课题类别服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
public interface SubjectTypeService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部课题类别
     * */
    List<SubjectTypeDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 课题类别信息
     * @return 查询结果
     * */
    List<SubjectTypeDTO> queryFuzzy(SubjectTypeDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 课题类别id
     * @return 查询结果
     * */
    SubjectTypeDTO queryById(Long id);

    /**
     * <p>添加新课题类别</p>
     *
     * @param dto 课题类别信息
     * @return 是否成功
     */
    boolean add(SubjectTypeDTO dto);

    /**
     * <p>批量添加新课题类别</p>
     *
     * @param dtoList 课题类别信息
     * @return 是否成功
     */
    boolean batchAdd(List<SubjectTypeDTO> dtoList);

    /**
     * <p>更新课题类别</p>
     *
     * @param dto 课题类别信息
     * @return 是否成功
     */
    boolean modify(SubjectTypeDTO dto);

    /**
     * <p>删除课题类别</p>
     *
     * @param dto 课题类别信息 id version
     * @return 是否成功
     */
    boolean remove(SubjectTypeDTO dto);

    /**
     * <p>批量删除课题类别</p>
     *
     * @param dtoList 课题类别信息
     * @return 是否成功
     */
    boolean batchRemove(List<SubjectTypeDTO> dtoList);
}

