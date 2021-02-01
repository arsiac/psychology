package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.arsiac.psychology.user.centre.pojo.vo.UserRoleVO;

import java.util.List;

/**
 * <p>用户-角色接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/1
 */
@CrossOrigin
@RequestMapping("/user/role")
public interface UserRoleApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户-角色
     * */
    @GetMapping("/all")
    List<UserRoleVO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    List<UserRoleVO> queryByRoleId(Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    List<UserRoleVO> queryByUserId(Long id);

    /**
     * <p>增加用户-角色</p>
     *
     * @param vo 权限-资源信息
     * @return 数据库变动行数
     * */
    boolean add(UserRoleVO vo);

    /**
     * <p>增加用户-角色</p>
     *
     * @param voList 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean batchAdd(List<UserRoleVO> voList);

    /**
     * <p>更新用户-角色</p>
     *
     * @param vo 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean modify(UserRoleVO vo);

    /**
     * <p>删除用户-角色</p>
     *
     * @param vo 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean remove(UserRoleVO vo);

    /**
     * <p>批量删除用户-角色</p>
     *
     * @param voList 用户-角色信息
     * @return 数据库变动行数
     * */
    boolean batchRemove(List<UserRoleVO> voList);
}
