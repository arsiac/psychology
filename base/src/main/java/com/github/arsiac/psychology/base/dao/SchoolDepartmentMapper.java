package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.SchoolDepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>学院</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:55
 */
@Mapper
public interface SchoolDepartmentMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部学院
     * */
    List<SchoolDepartmentEntity> selectAll();

    /**
     * <p>模糊查找学院</p>
     *
     * @param schoolDepartment 学院信息
     * @return 学院列表
     * */
    List<SchoolDepartmentEntity> selectFuzzy(@Param("schoolDepartment") SchoolDepartmentEntity schoolDepartment);

    /**
     * <p>根据id查询</p>
     *
     * @param id 学院id
     * @return 学院信息
     * */
    SchoolDepartmentEntity selectById(@Param("id") Long id);

    /**
     * <p>增加学院</p>
     *
     * @param schoolDepartment 学院信息
     * @return 数据库变动行数
     * */
    int insert(@Param("schoolDepartment") SchoolDepartmentEntity schoolDepartment);

    /**
     * <p>更新学院</p>
     *
     * @param schoolDepartment 学院信息
     * @return 数据库变动行数
     * */
    int update(@Param("schoolDepartment") SchoolDepartmentEntity schoolDepartment);

    /**
     * <p>删除学院</p>
     *
     * @param schoolDepartment 学院信息
     * @return 数据库变动行数
     * */
    int delete(@Param("schoolDepartment") SchoolDepartmentEntity schoolDepartment);
}
