package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.TitleDTO;

import java.util.List;


/**
 * <p>职称服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
public interface TitleService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部职称
     * */
    List<TitleDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 职称信息
     * @return 查询结果
     * */
    List<TitleDTO> queryFuzzy(TitleDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 职称id
     * @return 查询结果
     * */
    TitleDTO queryById(Long id);

    /**
     * <p>添加新职称</p>
     *
     * @param dto 职称信息
     * @return 是否成功
     */
    boolean add(TitleDTO dto);

    /**
     * <p>批量添加新职称</p>
     *
     * @param dtoList 职称信息
     * @return 是否成功
     */
    boolean batchAdd(List<TitleDTO> dtoList);

    /**
     * <p>更新职称</p>
     *
     * @param dto 职称信息
     * @return 是否成功
     */
    boolean modify(TitleDTO dto);

    /**
     * <p>删除职称</p>
     *
     * @param dto 职称信息 id version
     * @return 是否成功
     */
    boolean remove(TitleDTO dto);

    /**
     * <p>批量删除职称</p>
     *
     * @param dtoList 职称信息
     * @return 是否成功
     */
    boolean batchRemove(List<TitleDTO> dtoList);
}

