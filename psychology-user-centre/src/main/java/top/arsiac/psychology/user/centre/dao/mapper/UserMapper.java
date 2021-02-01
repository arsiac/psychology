package top.arsiac.psychology.user.centre.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.arsiac.psychology.user.centre.dao.entity.UserEntity;

import java.util.List;


/**
 * <p>用户表</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Mapper
public interface UserMapper {

    /**
     * <p>查找全部</p>
     *
     * @return 全部用户
     * */
    List<UserEntity> selectAll();

    /**
     * <p>模糊查找用户</p>
     *
     * @param user 用户信息
     * @return 用户列表
     * */
    List<UserEntity> selectFuzzy(@Param("user") UserEntity user);

    /**
     * <p>根据id查询</p>
     *
     * @param id 用户id
     * @return 用户信息
     * */
    UserEntity selectById(@Param("id") Long id);

    /**
     * <p>增加用户</p>
     *
     * @param user 用户信息
     * @return 数据库变动行数
     * */
    int insert(@Param("user") UserEntity user);

    /**
     * <p>更新用户</p>
     *
     * @param user 用户信息
     * @return 数据库变动行数
     * */
    int update(@Param("user") UserEntity user);

    /**
     * <p>删除用户</p>
     *
     * @param id 用户 id
     * @param version 版本
     * @return 数据库变动行数
     * */
    int delete(@Param("id") Long id, @Param("version") Integer version);
}
