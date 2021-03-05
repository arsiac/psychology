package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>教师</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/5
 */
@Mapper
public interface TeacherDao {

    /**
     * <p>查找全部</p>
     *
     * @return 全部教师
     * */
    List<TeacherEntity> selectAll();

    /**
     * <p>模糊查找教师</p>
     *
     * @param teacher 教师信息
     * @return 教师列表
     * */
    List<TeacherEntity> selectFuzzy(@Param("teacher") TeacherEntity teacher);

    /**
     * <p>根据id查询</p>
     *
     * @param id 教师id
     * @return 教师信息
     * */
    TeacherEntity selectById(@Param("id") Long id);

    /**
     * <p>增加教师</p>
     *
     * @param teacher 教师信息
     * @return 数据库变动行数
     * */
    int insert(@Param("teacher") TeacherEntity teacher);

    /**
     * <p>更新教师</p>
     *
     * @param teacher 教师信息
     * @return 数据库变动行数
     * */
    int update(@Param("teacher") TeacherEntity teacher);

    /**
     * <p>删除教师</p>
     *
     * @param id 教师 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
