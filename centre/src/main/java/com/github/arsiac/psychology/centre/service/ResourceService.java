package com.github.arsiac.psychology.centre.service;


import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;

import java.util.List;

/**
 * <p>资源业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface ResourceService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部资源
     * */
    List<ResourceDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 资源信息
     * @return 查询结果
     * */
    List<ResourceDTO> queryFuzzy(ResourceDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 资源id
     * @return 查询结果
     * */
    ResourceDTO queryById(Long id);

    /**
     * <p>添加新资源</p>
     *
     * @param dto 资源信息
     * @return 是否成功
     */
    boolean add(ResourceDTO dto);

    /**
     * <p>批量添加新资源</p>
     *
     * @param dtoList 资源信息
     * @return 是否成功
     */
    boolean batchAdd(List<ResourceDTO> dtoList);

    /**
     * <p>更新资源</p>
     *
     * @param dto 资源信息
     * @return 是否成功
     */
    boolean modify(ResourceDTO dto);

    /**
     * <p>删除资源</p>
     *
     * @param dto 资源信息 id version
     * @return 是否成功
     */
    boolean remove(ResourceDTO dto);

    /**
     * <p>批量删除资源</p>
     *
     * @param dtoList 资源信息
     * @return 是否成功
     */
    boolean batchRemove(List<ResourceDTO> dtoList);
}
