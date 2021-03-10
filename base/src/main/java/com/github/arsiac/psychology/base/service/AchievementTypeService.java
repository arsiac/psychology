package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.AchievementTypeDTO;

import java.util.List;


/**
 * <p>成果形式服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
public interface AchievementTypeService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部成果形式
     * */
    List<AchievementTypeDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 成果形式信息
     * @return 查询结果
     * */
    List<AchievementTypeDTO> queryFuzzy(AchievementTypeDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 成果形式id
     * @return 查询结果
     * */
    AchievementTypeDTO queryById(Long id);

    /**
     * <p>添加新成果形式</p>
     *
     * @param dto 成果形式信息
     * @return 是否成功
     */
    boolean add(AchievementTypeDTO dto);

    /**
     * <p>批量添加新成果形式</p>
     *
     * @param dtoList 成果形式信息
     * @return 是否成功
     */
    boolean batchAdd(List<AchievementTypeDTO> dtoList);

    /**
     * <p>更新成果形式</p>
     *
     * @param dto 成果形式信息
     * @return 是否成功
     */
    boolean modify(AchievementTypeDTO dto);

    /**
     * <p>删除成果形式</p>
     *
     * @param dto 成果形式信息 id version
     * @return 是否成功
     */
    boolean remove(AchievementTypeDTO dto);

    /**
     * <p>批量删除成果形式</p>
     *
     * @param dtoList 成果形式信息
     * @return 是否成功
     */
    boolean batchRemove(List<AchievementTypeDTO> dtoList);
}

