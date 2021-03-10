package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.AchievementTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>成果形式</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@Mapper
public interface AchievementTypeMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部成果形式
     * */
    List<AchievementTypeEntity> selectAll();

    /**
     * <p>模糊查找成果形式</p>
     *
     * @param achievementType 成果形式信息
     * @return 成果形式列表
     * */
    List<AchievementTypeEntity> selectFuzzy(@Param("achievementType") AchievementTypeEntity achievementType);

    /**
     * <p>根据id查询</p>
     *
     * @param id 成果形式id
     * @return 成果形式信息
     * */
    AchievementTypeEntity selectById(@Param("id") Long id);

    /**
     * <p>增加成果形式</p>
     *
     * @param achievementType 成果形式信息
     * @return 数据库变动行数
     * */
    int insert(@Param("achievementType") AchievementTypeEntity achievementType);

    /**
     * <p>更新成果形式</p>
     *
     * @param achievementType 成果形式信息
     * @return 数据库变动行数
     * */
    int update(@Param("achievementType") AchievementTypeEntity achievementType);

    /**
     * <p>删除成果形式</p>
     *
     * @param achievementType 成果形式信息
     * @return 数据库变动行数
     * */
    int delete(@Param("achievementType") AchievementTypeEntity achievementType);
}
