package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.PaperLevelDTO;

import java.util.List;


/**
 * <p>论文级别服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 20:59:39
 */
public interface PaperLevelService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部论文级别
     * */
    List<PaperLevelDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 论文级别信息
     * @return 查询结果
     * */
    List<PaperLevelDTO> queryFuzzy(PaperLevelDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 论文级别id
     * @return 查询结果
     * */
    PaperLevelDTO queryById(Long id);

    /**
     * <p>添加新论文级别</p>
     *
     * @param dto 论文级别信息
     * @return 是否成功
     */
    boolean add(PaperLevelDTO dto);

    /**
     * <p>批量添加新论文级别</p>
     *
     * @param dtoList 论文级别信息
     * @return 是否成功
     */
    boolean batchAdd(List<PaperLevelDTO> dtoList);

    /**
     * <p>更新论文级别</p>
     *
     * @param dto 论文级别信息
     * @return 是否成功
     */
    boolean modify(PaperLevelDTO dto);

    /**
     * <p>删除论文级别</p>
     *
     * @param dto 论文级别信息 id version
     * @return 是否成功
     */
    boolean remove(PaperLevelDTO dto);

    /**
     * <p>批量删除论文级别</p>
     *
     * @param dtoList 论文级别信息
     * @return 是否成功
     */
    boolean batchRemove(List<PaperLevelDTO> dtoList);
}

