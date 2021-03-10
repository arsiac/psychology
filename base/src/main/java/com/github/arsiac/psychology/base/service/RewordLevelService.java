package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.RewordLevelDTO;

import java.util.List;


/**
 * <p>获奖等级服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
public interface RewordLevelService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部获奖等级
     * */
    List<RewordLevelDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 获奖等级信息
     * @return 查询结果
     * */
    List<RewordLevelDTO> queryFuzzy(RewordLevelDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 获奖等级id
     * @return 查询结果
     * */
    RewordLevelDTO queryById(Long id);

    /**
     * <p>添加新获奖等级</p>
     *
     * @param dto 获奖等级信息
     * @return 是否成功
     */
    boolean add(RewordLevelDTO dto);

    /**
     * <p>批量添加新获奖等级</p>
     *
     * @param dtoList 获奖等级信息
     * @return 是否成功
     */
    boolean batchAdd(List<RewordLevelDTO> dtoList);

    /**
     * <p>更新获奖等级</p>
     *
     * @param dto 获奖等级信息
     * @return 是否成功
     */
    boolean modify(RewordLevelDTO dto);

    /**
     * <p>删除获奖等级</p>
     *
     * @param dto 获奖等级信息 id version
     * @return 是否成功
     */
    boolean remove(RewordLevelDTO dto);

    /**
     * <p>批量删除获奖等级</p>
     *
     * @param dtoList 获奖等级信息
     * @return 是否成功
     */
    boolean batchRemove(List<RewordLevelDTO> dtoList);
}

