package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.vo.UserVO;

import java.util.List;

/**
 * <p>用户管理接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@CrossOrigin
@RequestMapping(value = "/user")
public interface UserApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户
     * */
    @GetMapping("/all")
    List<UserVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param vo 用户信息
     * @return 查询结果
     * */
    @GetMapping
    List<UserVO> queryFuzzy(UserVO vo);

    /**
     * <p>根据id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    @GetMapping("/{id}")
    UserVO queryById(@PathVariable Long id);

    /**
     * <p>添加新用户</p>
     *
     * @param vo 用户信息
     * @return 是否成功
     */
    @PostMapping
    boolean add(UserVO vo);

    /**
     * <p>批量添加新用户</p>
     *
     * @param voList 用户信息
     * @return 是否成功
     */
    @PostMapping("/batch")
    boolean batchAdd(List<UserVO> voList);

    /**
     * <p>更新用户</p>
     *
     * @param vo 用户信息
     * @return 是否成功
     */
    @PutMapping
    boolean modify(UserVO vo);

    /**
     * <p>删除用户</p>
     *
     * @param vo 用户信息 id version
     * @return 是否成功
     */
    @DeleteMapping
    boolean remove(UserVO vo);

    /**
     * <p>批量删除用户</p>
     *
     * @param voList 用户信息
     * @return 是否成功
     */
    @DeleteMapping("/batch")
    boolean batchRemove(List<UserVO> voList);
}
