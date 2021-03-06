package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.ProjectSourceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>课题来源</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/5
 */
@Mapper
public interface ProjectSourceMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部项目来源
     * */
    List<ProjectSourceEntity> selectAll();

    /**
     * <p>模糊查找项目来源</p>
     *
     * @param projectSource 项目来源信息
     * @return 项目来源列表
     * */
    List<ProjectSourceEntity> selectFuzzy(@Param("projectSource") ProjectSourceEntity projectSource);

    /**
     * <p>根据id查询</p>
     *
     * @param id 项目来源id
     * @return 项目来源信息
     * */
    ProjectSourceEntity selectById(@Param("id") Long id);

    /**
     * <p>增加项目来源</p>
     *
     * @param projectSource 项目来源信息
     * @return 数据库变动行数
     * */
    int insert(@Param("projectSource") ProjectSourceEntity projectSource);

    /**
     * <p>更新项目来源</p>
     *
     * @param projectSource 项目来源信息
     * @return 数据库变动行数
     * */
    int update(@Param("projectSource") ProjectSourceEntity projectSource);

    /**
     * <p>删除项目来源</p>
     *
     * @param id 项目来源 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
