package com.github.arsiac.psychology.centre.dao;

import com.github.arsiac.psychology.centre.pojo.dto.TeacherDTO;
import com.github.arsiac.psychology.centre.pojo.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>教师</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
@Mapper
public interface TeacherMapper {
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
    List<TeacherDTO> selectFuzzy(@Param("teacher") TeacherEntity teacher);

    /**
     * <p>根据id查询</p>
     *
     * @param id 教师id
     * @return 教师信息
     * */
    TeacherEntity selectById(@Param("id") Long id);

    /**
     * <p>根据教师编码查询</p>
     *
     * @param code 教师编码
     * @return 教师信息
     */
    TeacherEntity selectByCode(@Param("code") String code);

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
     * @param teacher 教师信息
     * @return 数据库变动行数
     * */
    int delete(@Param("teacher") TeacherEntity teacher);
}
