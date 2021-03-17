package com.github.arsiac.psychology.manager.dao;

import com.github.arsiac.psychology.manager.pojo.dto.OpusDTO;
import com.github.arsiac.psychology.manager.pojo.entity.OpusEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@Mapper
public interface OpusMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    List<OpusEntity> selectAll();

    /**
     * <p>模糊查找</p>
     *
     * @param opus 信息
     * @return 列表
     * */
    List<OpusDTO> selectFuzzy(@Param("opus") OpusEntity opus);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 信息
     * */
    OpusEntity selectById(@Param("id") Long id);

    /**
     * <p>增加</p>
     *
     * @param opus 信息
     * @return 数据库变动行数
     * */
    int insert(@Param("opus") OpusEntity opus);

    /**
     * <p>更新</p>
     *
     * @param opus 信息
     * @return 数据库变动行数
     * */
    int update(@Param("opus") OpusEntity opus);

    /**
     * <p>删除</p>
     *
     * @param opus 信息
     * @return 数据库变动行数
     * */
    int delete(@Param("opus") OpusEntity opus);
}
