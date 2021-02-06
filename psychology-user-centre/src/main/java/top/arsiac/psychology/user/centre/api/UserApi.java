package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
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
    @ResponseBody
    List<UserVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 用户信息
     * @return 查询结果
     * */
    @GetMapping
    @ResponseBody
    List<UserVO> queryFuzzy(@RequestBody UserDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    @GetMapping("/{id}")
    @ResponseBody
    UserVO queryById(@PathVariable Long id);

    /**
     * <p>添加新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    @PostMapping
    @ResponseBody
    boolean add(@RequestBody UserDTO dto);

    /**
     * <p>批量添加新用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    @PostMapping("/batch")
    @ResponseBody
    boolean batchAdd(@RequestBody List<UserDTO> dtoList);

    /**
     * <p>更新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    @PutMapping
    @ResponseBody
    boolean modify(@RequestBody UserDTO dto);

    /**
     * <p>删除用户</p>
     *
     * @param dto 用户信息 id version
     * @return 是否成功
     */
    @DeleteMapping
    @ResponseBody
    boolean remove(@RequestBody UserDTO dto);

    /**
     * <p>批量删除用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    @DeleteMapping("/batch")
    @ResponseBody
    boolean batchRemove(@RequestBody List<UserDTO> dtoList);
}
