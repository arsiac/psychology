package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.RewordLevelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>获奖等级</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@Mapper
public interface RewordLevelMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部获奖等级
     * */
    List<RewordLevelEntity> selectAll();

    /**
     * <p>模糊查找获奖等级</p>
     *
     * @param rewordLevel 获奖等级信息
     * @return 获奖等级列表
     * */
    List<RewordLevelEntity> selectFuzzy(@Param("rewordLevel") RewordLevelEntity rewordLevel);

    /**
     * <p>根据id查询</p>
     *
     * @param id 获奖等级id
     * @return 获奖等级信息
     * */
    RewordLevelEntity selectById(@Param("id") Long id);

    /**
     * <p>增加获奖等级</p>
     *
     * @param rewordLevel 获奖等级信息
     * @return 数据库变动行数
     * */
    int insert(@Param("rewordLevel") RewordLevelEntity rewordLevel);

    /**
     * <p>更新获奖等级</p>
     *
     * @param rewordLevel 获奖等级信息
     * @return 数据库变动行数
     * */
    int update(@Param("rewordLevel") RewordLevelEntity rewordLevel);

    /**
     * <p>删除获奖等级</p>
     *
     * @param rewordLevel 获奖等级信息
     * @return 数据库变动行数
     * */
    int delete(@Param("rewordLevel") RewordLevelEntity rewordLevel);
}
