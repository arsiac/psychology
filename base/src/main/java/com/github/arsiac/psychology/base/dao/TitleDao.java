package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.TitleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>职称</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/5
 */
@Mapper
public interface TitleDao {

    /**
     * <p>查找全部</p>
     *
     * @return 全部职称
     * */
    List<TitleEntity> selectAll();

    /**
     * <p>模糊查找职称</p>
     *
     * @param title 职称信息
     * @return 职称列表
     * */
    List<TitleEntity> selectFuzzy(@Param("title") TitleEntity title);

    /**
     * <p>根据id查询</p>
     *
     * @param id 职称id
     * @return 职称信息
     * */
    TitleEntity selectById(@Param("id") Long id);

    /**
     * <p>增加职称</p>
     *
     * @param title 职称信息
     * @return 数据库变动行数
     * */
    int insert(@Param("title") TitleEntity title);

    /**
     * <p>更新职称</p>
     *
     * @param title 职称信息
     * @return 数据库变动行数
     * */
    int update(@Param("title") TitleEntity title);

    /**
     * <p>删除职称</p>
     *
     * @param id 职称 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
