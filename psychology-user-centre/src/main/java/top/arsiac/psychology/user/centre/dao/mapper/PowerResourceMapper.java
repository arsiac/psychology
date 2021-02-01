package top.arsiac.psychology.user.centre.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.dao.entity.PowerResourceEntity;

import java.util.List;


/**
 * <p>权限对应资源</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface PowerResourceMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部权限对应资源
     * */
    List<PowerResourceEntity> selectAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param roleId 角色id
     * @return 查询结果
     * */
    List<PowerResourceEntity> selectByPowerId(@Param("powerId") Long roleId);

    /**
     * <p>根据用户id查询</p>
     *
     * @param userId 角色id
     * @return 查询结果
     * */
    List<PowerResourceEntity> selectByResourceId(@Param("resourceId") Long userId);

    /**
     * <p>增加权限对应资源</p>
     *
     * @param userRole 权限对应资源信息
     * @return 数据库变动行数
     * */
    int insert(@Param("powerResource") PowerResourceEntity userRole);

    /**
     * <p>更新权限对应资源</p>
     *
     * @param userRole 权限对应资源信息
     * @return 数据库变动行数
     * */
    int update(@Param("powerResource") PowerResourceEntity userRole);

    /**
     * <p>删除权限对应资源</p>
     *
     * @param id 权限对应资源 id
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
