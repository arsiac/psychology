package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.SubjectTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>课题类别</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Mapper
public interface SubjectTypeMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部课题类别
     * */
    List<SubjectTypeEntity> selectAll();

    /**
     * <p>模糊查找课题类别</p>
     *
     * @param subjectType 课题类别信息
     * @return 课题类别列表
     * */
    List<SubjectTypeEntity> selectFuzzy(@Param("subjectType") SubjectTypeEntity subjectType);

    /**
     * <p>根据id查询</p>
     *
     * @param id 课题类别id
     * @return 课题类别信息
     * */
    SubjectTypeEntity selectById(@Param("id") Long id);

    /**
     * <p>增加课题类别</p>
     *
     * @param subjectType 课题类别信息
     * @return 数据库变动行数
     * */
    int insert(@Param("subjectType") SubjectTypeEntity subjectType);

    /**
     * <p>更新课题类别</p>
     *
     * @param subjectType 课题类别信息
     * @return 数据库变动行数
     * */
    int update(@Param("subjectType") SubjectTypeEntity subjectType);

    /**
     * <p>删除课题类别</p>
     *
     * @param subjectType 课题类别信息
     * @return 数据库变动行数
     * */
    int delete(@Param("subjectType") SubjectTypeEntity subjectType);
}
