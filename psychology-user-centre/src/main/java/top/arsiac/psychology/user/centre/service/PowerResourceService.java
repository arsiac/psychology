package top.arsiac.psychology.user.centre.service;


import top.arsiac.psychology.user.centre.pojo.dto.PowerResourceDTO;

import java.util.List;

/**
 * <p>权力-资源业务</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface PowerResourceService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部权限对应资源
     * */
    List<PowerResourceDTO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<PowerResourceDTO> queryByPowerId(Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<PowerResourceDTO> queryByResourceId(Long id);

    /**
     * <p>增加权限对应资源</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    boolean add(PowerResourceDTO dto);

    /**
     * <p>增加权限对应资源</p>
     *
     * @param dtoList 权限-资源信息
     * @return 数据库变动行数
     * */
    boolean batchAdd(List<PowerResourceDTO> dtoList);

    /**
     * <p>更新权限对应资源</p>
     *
     * @param dto 权限对应资源信息
     * @return 数据库变动行数
     * */
    boolean modify(PowerResourceDTO dto);

    /**
     * <p>删除权限对应资源</p>
     *
     * @param dto 权限对应资源信息
     * @return 数据库变动行数
     * */
    boolean remove(PowerResourceDTO dto);

    /**
     * <p>批量删除权限对应资源</p>
     *
     * @param dtoList 权限对应资源信息
     * @return 数据库变动行数
     * */
    boolean batchRemove(List<PowerResourceDTO> dtoList);
}
