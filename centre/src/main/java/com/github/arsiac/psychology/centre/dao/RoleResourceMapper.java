package com.github.arsiac.psychology.centre.dao;


import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;
import com.github.arsiac.psychology.centre.pojo.entity.RoleResourceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>角色-资源mapper</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
@Mapper
public interface RoleResourceMapper {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户对应角色
     * */
    List<RoleResourceEntity> selectAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<RoleResourceDTO> selectByRoleId(@Param("roleId") Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<RoleResourceEntity> selectByResourceId(@Param("resourceId") Long id);

    /**
     * <p>增加用户对应角色</p>
     *
     * @param roleResourceEntity 用户对应角色信息
     * @return 数据库变动行数
     * */
    int insert(@Param("roleResource") RoleResourceEntity roleResourceEntity);

    /**
     * <p>更新用户对应角色</p>
     *
     * @param roleResourceEntity 用户对应角色信息
     * @return 数据库变动行数
     * */
    int update(@Param("roleResource") RoleResourceEntity roleResourceEntity);

    /**
     * <p>删除用户对应角色</p>
     *
     * @param id 用户对应角色 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
