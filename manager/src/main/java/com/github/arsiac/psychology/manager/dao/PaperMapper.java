package com.github.arsiac.psychology.manager.dao;

import com.github.arsiac.psychology.manager.pojo.dto.PaperDTO;
import com.github.arsiac.psychology.manager.pojo.entity.PaperEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
@Mapper
public interface PaperMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    List<PaperEntity> selectAll();

    /**
     * <p>模糊查找</p>
     *
     * @param paper 信息
     * @return 列表
     * */
    List<PaperDTO> selectFuzzy(@Param("paper") PaperEntity paper);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 信息
     * */
    PaperEntity selectById(@Param("id") Long id);

    /**
     * <p>增加</p>
     *
     * @param paper 信息
     * @return 数据库变动行数
     * */
    int insert(@Param("paper") PaperEntity paper);

    /**
     * <p>更新</p>
     *
     * @param paper 信息
     * @return 数据库变动行数
     * */
    int update(@Param("paper") PaperEntity paper);

    /**
     * <p>删除</p>
     *
     * @param paper 信息
     * @return 数据库变动行数
     * */
    int delete(@Param("paper") PaperEntity paper);
}
