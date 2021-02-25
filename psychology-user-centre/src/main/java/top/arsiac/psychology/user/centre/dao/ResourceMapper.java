package top.arsiac.psychology.user.centre.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.pojo.entity.ResourceEntity;

import java.util.List;
import java.util.Set;


/**
 * <p>资源表</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface ResourceMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部资源
     * */
    List<ResourceEntity> selectAll();

    /**
     * <p>模糊查找资源</p>
     *
     * @param resource 资源信息
     * @return 资源列表
     * */
    List<ResourceEntity> selectFuzzy(@Param("resource") ResourceEntity resource);

    /**
     * <p>查询指定的资源</p>
     *
     * @param ids 资源id
     * @return 资源
     */
    List<ResourceEntity> selectIn(@Param("ids") Set<Long> ids);

    /**
     * <p>根据id查询</p>
     *
     * @param id 资源id
     * @return 资源信息
     * */
    ResourceEntity selectById(@Param("id") Long id);

    /**
     * <p>增加资源</p>
     *
     * @param resource 资源信息
     * @return 数据库变动行数
     * */
    int insert(@Param("resource") ResourceEntity resource);

    /**
     * <p>更新资源</p>
     *
     * @param resource 资源信息
     * @return 数据库变动行数
     * */
    int update(@Param("resource") ResourceEntity resource);

    /**
     * <p>删除资源</p>
     *
     * @param id 资源 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
