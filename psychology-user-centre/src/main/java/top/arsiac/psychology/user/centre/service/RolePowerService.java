package top.arsiac.psychology.user.centre.service;


import top.arsiac.psychology.user.centre.dao.dto.RolePowerDTO;

import java.util.List;

/**
 * <p>角色-权力业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface RolePowerService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色-权力
     * */
    List<RolePowerDTO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<RolePowerDTO> queryByRoleId(Long id);

    /**
     * <p>根据权力id查询</p>
     *
     * @param id 权力id
     * @return 查询结果
     * */
    List<RolePowerDTO> queryByPowerId(Long id);

    /**
     * <p>增加角色-权力</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    boolean add(RolePowerDTO dto);

    /**
     * <p>增加角色-权力</p>
     *
     * @param dtoList 角色-权力信息
     * @return 数据库变动行数
     * */
    boolean batchAdd(List<RolePowerDTO> dtoList);

    /**
     * <p>更新角色-权力</p>
     *
     * @param dto 角色-权力信息
     * @return 数据库变动行数
     * */
    boolean modify(RolePowerDTO dto);

    /**
     * <p>删除角色-权力</p>
     *
     * @param dto 角色-权力信息
     * @return 数据库变动行数
     * */
    boolean remove(RolePowerDTO dto);

    /**
     * <p>批量删除角色-权力</p>
     *
     * @param dtoList 角色-权力信息
     * @return 数据库变动行数
     * */
    boolean batchRemove(List<RolePowerDTO> dtoList);
}
