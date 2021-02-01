package top.arsiac.psychology.user.centre.service;


import top.arsiac.psychology.user.centre.pojo.dto.PowerDTO;

import java.util.List;

/**
 * <p>权力业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface PowerService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部权力
     * */
    List<PowerDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 权力信息
     * @return 查询结果
     * */
    List<PowerDTO> queryFuzzy(PowerDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 权力id
     * @return 查询结果
     * */
    PowerDTO queryById(Long id);

    /**
     * <p>添加新权力</p>
     *
     * @param dto 权力信息
     * @return 是否成功
     */
    boolean add(PowerDTO dto);

    /**
     * <p>批量添加新权力</p>
     *
     * @param dtoList 权力信息
     * @return 是否成功
     */
    boolean batchAdd(List<PowerDTO> dtoList);

    /**
     * <p>更新权力</p>
     *
     * @param dto 权力信息
     * @return 是否成功
     */
    boolean modify(PowerDTO dto);

    /**
     * <p>删除权力</p>
     *
     * @param dto 权力信息 id version
     * @return 是否成功
     */
    boolean remove(PowerDTO dto);

    /**
     * <p>批量删除权力</p>
     *
     * @param dtoList 权力信息
     * @return 是否成功
     */
    boolean batchRemove(List<PowerDTO> dtoList);
}
