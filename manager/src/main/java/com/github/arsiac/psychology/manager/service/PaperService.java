package com.github.arsiac.psychology.manager.service;

import com.github.arsiac.psychology.manager.pojo.dto.PaperDTO;

import java.util.List;


/**
 * <p>服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
public interface PaperService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    List<PaperDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 信息
     * @return 查询结果
     * */
    List<PaperDTO> queryFuzzy(PaperDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 查询结果
     * */
    PaperDTO queryById(Long id);

    /**
     * <p>添加新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    boolean add(PaperDTO dto);

    /**
     * <p>批量添加新</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    boolean batchAdd(List<PaperDTO> dtoList);

    /**
     * <p>更新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    boolean modify(PaperDTO dto);

    /**
     * <p>删除</p>
     *
     * @param dto 信息 id version
     * @return 是否成功
     */
    boolean remove(PaperDTO dto);

    /**
     * <p>批量删除</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    boolean batchRemove(List<PaperDTO> dtoList);
}

