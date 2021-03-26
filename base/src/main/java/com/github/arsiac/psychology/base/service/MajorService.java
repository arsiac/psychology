package com.github.arsiac.psychology.base.service;

import com.github.arsiac.psychology.base.pojo.dto.MajorDTO;

import java.util.List;


/**
 * <p>专业服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:56
 */
public interface MajorService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部专业
     * */
    List<MajorDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 专业信息
     * @return 查询结果
     * */
    List<MajorDTO> queryFuzzy(MajorDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 专业id
     * @return 查询结果
     * */
    MajorDTO queryById(Long id);

    /**
     * <p>添加新专业</p>
     *
     * @param dto 专业信息
     * @return 是否成功
     */
    boolean add(MajorDTO dto);

    /**
     * <p>批量添加新专业</p>
     *
     * @param dtoList 专业信息
     * @return 是否成功
     */
    boolean batchAdd(List<MajorDTO> dtoList);

    /**
     * <p>更新专业</p>
     *
     * @param dto 专业信息
     * @return 是否成功
     */
    boolean modify(MajorDTO dto);

    /**
     * <p>删除专业</p>
     *
     * @param dto 专业信息 id version
     * @return 是否成功
     */
    boolean remove(MajorDTO dto);

    /**
     * <p>批量删除专业</p>
     *
     * @param dtoList 专业信息
     * @return 是否成功
     */
    boolean batchRemove(List<MajorDTO> dtoList);
}

