package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
@Mapper
public interface DictionaryMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    List<DictionaryEntity> selectAll();

    /**
     * <p>模糊查找</p>
     *
     * @param dictionary 信息
     * @return 列表
     * */
    List<DictionaryEntity> selectFuzzy(@Param("dictionary") DictionaryEntity dictionary);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 信息
     * */
    DictionaryEntity selectById(@Param("id") Long id);

    /**
     * <p>增加</p>
     *
     * @param dictionary 信息
     * @return 数据库变动行数
     * */
    int insert(@Param("dictionary") DictionaryEntity dictionary);

    /**
     * <p>更新</p>
     *
     * @param dictionary 信息
     * @return 数据库变动行数
     * */
    int update(@Param("dictionary") DictionaryEntity dictionary);

    /**
     * <p>删除</p>
     *
     * @param dictionary 信息
     * @return 数据库变动行数
     * */
    int delete(@Param("dictionary") DictionaryEntity dictionary);
}
