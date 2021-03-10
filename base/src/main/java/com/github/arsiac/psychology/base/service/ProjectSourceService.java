package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.ProjectSourceDTO;

import java.util.List;


/**
 * <p>课题来源服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
public interface ProjectSourceService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部课题来源
     * */
    List<ProjectSourceDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 课题来源信息
     * @return 查询结果
     * */
    List<ProjectSourceDTO> queryFuzzy(ProjectSourceDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 课题来源id
     * @return 查询结果
     * */
    ProjectSourceDTO queryById(Long id);

    /**
     * <p>添加新课题来源</p>
     *
     * @param dto 课题来源信息
     * @return 是否成功
     */
    boolean add(ProjectSourceDTO dto);

    /**
     * <p>批量添加新课题来源</p>
     *
     * @param dtoList 课题来源信息
     * @return 是否成功
     */
    boolean batchAdd(List<ProjectSourceDTO> dtoList);

    /**
     * <p>更新课题来源</p>
     *
     * @param dto 课题来源信息
     * @return 是否成功
     */
    boolean modify(ProjectSourceDTO dto);

    /**
     * <p>删除课题来源</p>
     *
     * @param dto 课题来源信息 id version
     * @return 是否成功
     */
    boolean remove(ProjectSourceDTO dto);

    /**
     * <p>批量删除课题来源</p>
     *
     * @param dtoList 课题来源信息
     * @return 是否成功
     */
    boolean batchRemove(List<ProjectSourceDTO> dtoList);
}

