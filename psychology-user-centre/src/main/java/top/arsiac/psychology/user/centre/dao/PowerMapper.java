package top.arsiac.psychology.user.centre.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.pojo.entity.PowerEntity;

import java.util.List;


/**
 * <p>权力</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface PowerMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部权力
     * */
    List<PowerEntity> selectAll();

    /**
     * <p>模糊查找权力</p>
     *
     * @param power 权力信息
     * @return 权力列表
     * */
    List<PowerEntity> selectFuzzy(@Param("power") PowerEntity power);

    /**
     * <p>根据id查找权力</p>
     *
     * @param id 权力id
     * @return 权力信息
     * */
    PowerEntity selectById(@Param("id") Long id);

    /**
     * <p>增加权力</p>
     *
     * @param power 权力信息
     * @return 数据库变动行数
     * */
    int insert(@Param("power") PowerEntity power);

    /**
     * <p>更新权力</p>
     *
     * @param power 权力信息
     * @return 数据库变动行数
     * */
    int update(@Param("power") PowerEntity power);

    /**
     * <p>删除权力</p>
     *
     * @param id 权力id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
