package com.github.arsiac.psychology.base.dao;

import com.github.arsiac.psychology.base.pojo.entity.PaperLevelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>论文级别</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 20:59:39
 */
@Mapper
public interface PaperLevelMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部论文级别
     * */
    List<PaperLevelEntity> selectAll();

    /**
     * <p>模糊查找论文级别</p>
     *
     * @param paperLevel 论文级别信息
     * @return 论文级别列表
     * */
    List<PaperLevelEntity> selectFuzzy(@Param("paperLevel") PaperLevelEntity paperLevel);

    /**
     * <p>根据id查询</p>
     *
     * @param id 论文级别id
     * @return 论文级别信息
     * */
    PaperLevelEntity selectById(@Param("id") Long id);

    /**
     * <p>增加论文级别</p>
     *
     * @param paperLevel 论文级别信息
     * @return 数据库变动行数
     * */
    int insert(@Param("paperLevel") PaperLevelEntity paperLevel);

    /**
     * <p>更新论文级别</p>
     *
     * @param paperLevel 论文级别信息
     * @return 数据库变动行数
     * */
    int update(@Param("paperLevel") PaperLevelEntity paperLevel);

    /**
     * <p>删除论文级别</p>
     *
     * @param paperLevel 论文级别信息
     * @return 数据库变动行数
     * */
    int delete(@Param("paperLevel") PaperLevelEntity paperLevel);
}
