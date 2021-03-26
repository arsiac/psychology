package com.github.arsiac.psychology.centre.dao;

import com.github.arsiac.psychology.centre.pojo.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>学生</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
@Mapper
public interface StudentMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部学生
     * */
    List<StudentEntity> selectAll();

    /**
     * <p>模糊查找学生</p>
     *
     * @param student 学生信息
     * @return 学生列表
     * */
    List<StudentEntity> selectFuzzy(@Param("student") StudentEntity student);

    /**
     * <p>根据id查询</p>
     *
     * @param id 学生id
     * @return 学生信息
     * */
    StudentEntity selectById(@Param("id") Long id);

    /**
     * <p>增加学生</p>
     *
     * @param student 学生信息
     * @return 数据库变动行数
     * */
    int insert(@Param("student") StudentEntity student);

    /**
     * <p>更新学生</p>
     *
     * @param student 学生信息
     * @return 数据库变动行数
     * */
    int update(@Param("student") StudentEntity student);

    /**
     * <p>删除学生</p>
     *
     * @param student 学生信息
     * @return 数据库变动行数
     * */
    int delete(@Param("student") StudentEntity student);
}
