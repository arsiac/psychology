package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.MajorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>专业</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:56
 */
@Mapper
public interface MajorMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部专业
     * */
    List<MajorEntity> selectAll();

    /**
     * <p>模糊查找专业</p>
     *
     * @param major 专业信息
     * @return 专业列表
     * */
    List<MajorEntity> selectFuzzy(@Param("major") MajorEntity major);

    /**
     * <p>根据id查询</p>
     *
     * @param id 专业id
     * @return 专业信息
     * */
    MajorEntity selectById(@Param("id") Long id);

    /**
     * <p>增加专业</p>
     *
     * @param major 专业信息
     * @return 数据库变动行数
     * */
    int insert(@Param("major") MajorEntity major);

    /**
     * <p>更新专业</p>
     *
     * @param major 专业信息
     * @return 数据库变动行数
     * */
    int update(@Param("major") MajorEntity major);

    /**
     * <p>删除专业</p>
     *
     * @param major 专业信息
     * @return 数据库变动行数
     * */
    int delete(@Param("major") MajorEntity major);
}
