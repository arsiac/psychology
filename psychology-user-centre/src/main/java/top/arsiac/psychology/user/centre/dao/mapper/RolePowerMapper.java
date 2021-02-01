package top.arsiac.psychology.user.centre.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.dao.entity.RolePowerEntity;

import java.util.List;


/**
 * <p>角色对应权力表</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface RolePowerMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部角色对应权力
     * */
    List<RolePowerEntity> selectAll();

    /**
     * <p>根据权力id查询</p>
     *
     * @param powerId 权力id
     * @return 查询结果
     * */
    List<RolePowerEntity> selectByPowerId(@Param("powerId") Long powerId);

    /**
     * <p>根据角色id查询</p>
     *
     * @param roleId 角色id
     * @return 查询结果
     * */
    List<RolePowerEntity> selectByRoleId(@Param("roleId") Long roleId);


    /**
     * <p>增加角色对应权力</p>
     *
     * @param rolePower 角色对应权力信息
     * @return 数据库变动行数
     * */
    int insert(@Param("rolePower") RolePowerEntity rolePower);

    /**
     * <p>更新角色对应权力</p>
     *
     * @param rolePower 角色对应权力信息
     * @return 数据库变动行数
     * */
    int update(@Param("rolePower") RolePowerEntity rolePower);

    /**
     * <p>删除角色对应权力</p>
     *
     * @param id 角色对应权力 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
