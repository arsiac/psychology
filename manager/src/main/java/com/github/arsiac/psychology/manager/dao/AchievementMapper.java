package com.github.arsiac.psychology.manager.dao;

import com.github.arsiac.psychology.manager.pojo.dto.AchievementDTO;
import com.github.arsiac.psychology.manager.pojo.entity.AchievementEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>成果</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@Mapper
public interface AchievementMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部成果
     * */
    List<AchievementEntity> selectAll();

    /**
     * <p>模糊查找成果</p>
     *
     * @param achievement 成果信息
     * @return 成果列表
     * */
    List<AchievementDTO> selectFuzzy(@Param("achievement") AchievementEntity achievement);

    /**
     * <p>根据id查询</p>
     *
     * @param id 成果id
     * @return 成果信息
     * */
    AchievementEntity selectById(@Param("id") Long id);

    /**
     * <p>增加成果</p>
     *
     * @param achievement 成果信息
     * @return 数据库变动行数
     * */
    int insert(@Param("achievement") AchievementEntity achievement);

    /**
     * <p>更新成果</p>
     *
     * @param achievement 成果信息
     * @return 数据库变动行数
     * */
    int update(@Param("achievement") AchievementEntity achievement);

    /**
     * <p>删除成果</p>
     *
     * @param achievement 成果信息
     * @return 数据库变动行数
     * */
    int delete(@Param("achievement") AchievementEntity achievement);
}
