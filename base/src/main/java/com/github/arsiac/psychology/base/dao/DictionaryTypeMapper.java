package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.dto.DictionaryTypeDTO;
import com.github.arsiac.psychology.base.pojo.entity.DictionaryTypeEntity;
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
public interface DictionaryTypeMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    List<DictionaryTypeEntity> selectAll();

    /**
     * <p>模糊查找</p>
     *
     * @param dictionaryType 信息
     * @return 列表
     * */
    List<DictionaryTypeDTO> selectFuzzy(@Param("dictionaryType") DictionaryTypeEntity dictionaryType);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 信息
     * */
    DictionaryTypeEntity selectById(@Param("id") Long id);

    /**
     * <p>增加</p>
     *
     * @param dictionaryType 信息
     * @return 数据库变动行数
     * */
    int insert(@Param("dictionaryType") DictionaryTypeEntity dictionaryType);

    /**
     * <p>更新</p>
     *
     * @param dictionaryType 信息
     * @return 数据库变动行数
     * */
    int update(@Param("dictionaryType") DictionaryTypeEntity dictionaryType);

    /**
     * <p>删除</p>
     *
     * @param dictionaryType 信息
     * @return 数据库变动行数
     * */
    int delete(@Param("dictionaryType") DictionaryTypeEntity dictionaryType);
}
