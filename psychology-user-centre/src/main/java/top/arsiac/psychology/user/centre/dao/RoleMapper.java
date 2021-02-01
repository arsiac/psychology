package top.arsiac.psychology.user.centre.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.pojo.entity.RoleEntity;

import java.util.List;


/**
 * <p>角色表</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface RoleMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部角色
     * */
    List<RoleEntity> selectAll();

    /**
     * <p>模糊查找角色</p>
     *
     * @param role 角色信息
     * @return 角色列表
     * */
    List<RoleEntity> selectFuzzy(@Param("role") RoleEntity role);

    /**
     * <p>根据id查询</p>
     *
     * @param id 角色id
     * @return 角色信息
     * */
    RoleEntity selectById(@Param("id") Long id);

    /**
     * <p>增加角色</p>
     *
     * @param role 角色信息
     * @return 数据库变动行数
     * */
    int insert(@Param("role") RoleEntity role);

    /**
     * <p>更新角色</p>
     *
     * @param role 角色信息
     * @return 数据库变动行数
     * */
    int update(@Param("role") RoleEntity role);

    /**
     * <p>删除角色</p>
     *
     * @param id 角色 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
