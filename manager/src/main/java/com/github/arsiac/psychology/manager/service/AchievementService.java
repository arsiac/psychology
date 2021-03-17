package com.github.arsiac.psychology.manager.service;

import com.github.arsiac.psychology.manager.pojo.dto.AchievementDTO;

import java.util.List;


/**
 * <p>成果服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
public interface AchievementService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部成果
     * */
    List<AchievementDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 成果信息
     * @return 查询结果
     * */
    List<AchievementDTO> queryFuzzy(AchievementDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 成果id
     * @return 查询结果
     * */
    AchievementDTO queryById(Long id);

    /**
     * <p>添加新成果</p>
     *
     * @param dto 成果信息
     * @return 是否成功
     */
    boolean add(AchievementDTO dto);

    /**
     * <p>批量添加新成果</p>
     *
     * @param dtoList 成果信息
     * @return 是否成功
     */
    boolean batchAdd(List<AchievementDTO> dtoList);

    /**
     * <p>更新成果</p>
     *
     * @param dto 成果信息
     * @return 是否成功
     */
    boolean modify(AchievementDTO dto);

    /**
     * <p>删除成果</p>
     *
     * @param dto 成果信息 id version
     * @return 是否成功
     */
    boolean remove(AchievementDTO dto);

    /**
     * <p>批量删除成果</p>
     *
     * @param dtoList 成果信息
     * @return 是否成功
     */
    boolean batchRemove(List<AchievementDTO> dtoList);
}

