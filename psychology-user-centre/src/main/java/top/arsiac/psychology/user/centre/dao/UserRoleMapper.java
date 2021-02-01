package top.arsiac.psychology.user.centre.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.pojo.entity.UserRoleEntity;

import java.util.List;


/**
 * <p>用户对应角色</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface UserRoleMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部用户对应角色
     * */
    List<UserRoleEntity> selectAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param roleId 角色id
     * @return 查询结果
     * */
    List<UserRoleEntity> selectByRoleId(@Param("roleId") Long roleId);

    /**
     * <p>根据用户id查询</p>
     *
     * @param userId 角色id
     * @return 查询结果
     * */
    List<UserRoleEntity> selectByUserId(@Param("userId") Long userId);

    /**
     * <p>增加用户对应角色</p>
     *
     * @param userRole 用户对应角色信息
     * @return 数据库变动行数
     * */
    int insert(@Param("userRole") UserRoleEntity userRole);

    /**
     * <p>更新用户对应角色</p>
     *
     * @param userRole 用户对应角色信息
     * @return 数据库变动行数
     * */
    int update(@Param("userRole") UserRoleEntity userRole);

    /**
     * <p>删除用户对应角色</p>
     *
     * @param id 用户对应角色 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
