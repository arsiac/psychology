package com.github.arsiac.psychology.manager.dao;

import com.github.arsiac.psychology.manager.pojo.dto.ProjectDTO;
import com.github.arsiac.psychology.manager.pojo.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>科研立项</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
@Mapper
public interface ProjectMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部科研立项
     * */
    List<ProjectEntity> selectAll();

    /**
     * <p>模糊查找科研立项</p>
     *
     * @param project 科研立项信息
     * @return 科研立项列表
     * */
    List<ProjectDTO> selectFuzzy(@Param("project") ProjectEntity project);

    /**
     * <p>根据id查询</p>
     *
     * @param id 科研立项id
     * @return 科研立项信息
     * */
    ProjectEntity selectById(@Param("id") Long id);

    /**
     * <p>增加科研立项</p>
     *
     * @param project 科研立项信息
     * @return 数据库变动行数
     * */
    int insert(@Param("project") ProjectEntity project);

    /**
     * <p>更新科研立项</p>
     *
     * @param project 科研立项信息
     * @return 数据库变动行数
     * */
    int update(@Param("project") ProjectEntity project);

    /**
     * <p>删除科研立项</p>
     *
     * @param project 科研立项信息
     * @return 数据库变动行数
     * */
    int delete(@Param("project") ProjectEntity project);
}
