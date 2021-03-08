package com.github.arsiac.psychology.manager.service;

import com.github.arsiac.psychology.manager.pojo.dto.ProjectDTO;

import java.util.List;


/**
 * <p>科研立项服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
public interface ProjectService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部科研立项
     * */
    List<ProjectDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 科研立项信息
     * @return 查询结果
     * */
    List<ProjectDTO> queryFuzzy(ProjectDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 科研立项id
     * @return 查询结果
     * */
    ProjectDTO queryById(Long id);

    /**
     * <p>添加新科研立项</p>
     *
     * @param dto 科研立项信息
     * @return 是否成功
     */
    boolean add(ProjectDTO dto);

    /**
     * <p>批量添加新科研立项</p>
     *
     * @param dtoList 科研立项信息
     * @return 是否成功
     */
    boolean batchAdd(List<ProjectDTO> dtoList);

    /**
     * <p>更新科研立项</p>
     *
     * @param dto 科研立项信息
     * @return 是否成功
     */
    boolean modify(ProjectDTO dto);

    /**
     * <p>删除科研立项</p>
     *
     * @param dto 科研立项信息 id version
     * @return 是否成功
     */
    boolean remove(ProjectDTO dto);

    /**
     * <p>批量删除科研立项</p>
     *
     * @param dtoList 科研立项信息
     * @return 是否成功
     */
    boolean batchRemove(List<ProjectDTO> dtoList);
}

