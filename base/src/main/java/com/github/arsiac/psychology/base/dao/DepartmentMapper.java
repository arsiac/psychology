package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>系别</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Mapper
public interface DepartmentMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部系别
     * */
    List<DepartmentEntity> selectAll();

    /**
     * <p>模糊查找系别</p>
     *
     * @param department 系别信息
     * @return 系别列表
     * */
    List<DepartmentEntity> selectFuzzy(@Param("department") DepartmentEntity department);

    /**
     * <p>根据id查询</p>
     *
     * @param id 系别id
     * @return 系别信息
     * */
    DepartmentEntity selectById(@Param("id") Long id);

    /**
     * <p>增加系别</p>
     *
     * @param department 系别信息
     * @return 数据库变动行数
     * */
    int insert(@Param("department") DepartmentEntity department);

    /**
     * <p>更新系别</p>
     *
     * @param department 系别信息
     * @return 数据库变动行数
     * */
    int update(@Param("department") DepartmentEntity department);

    /**
     * <p>删除系别</p>
     *
     * @param department 系别信息
     * @return 数据库变动行数
     * */
    int delete(@Param("department") DepartmentEntity department);
}
