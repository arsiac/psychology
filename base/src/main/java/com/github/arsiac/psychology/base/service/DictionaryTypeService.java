package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.DictionaryTypeDTO;

import java.util.List;


/**
 * <p>服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
public interface DictionaryTypeService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    List<DictionaryTypeDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 信息
     * @return 查询结果
     * */
    List<DictionaryTypeDTO> queryFuzzy(DictionaryTypeDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 查询结果
     * */
    DictionaryTypeDTO queryById(Long id);

    /**
     * <p>添加新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    boolean add(DictionaryTypeDTO dto);

    /**
     * <p>批量添加新</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    boolean batchAdd(List<DictionaryTypeDTO> dtoList);

    /**
     * <p>更新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    boolean modify(DictionaryTypeDTO dto);

    /**
     * <p>删除</p>
     *
     * @param dto 信息 id version
     * @return 是否成功
     */
    boolean remove(DictionaryTypeDTO dto);

    /**
     * <p>批量删除</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    boolean batchRemove(List<DictionaryTypeDTO> dtoList);
}

