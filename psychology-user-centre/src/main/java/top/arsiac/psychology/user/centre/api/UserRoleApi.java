package top.arsiac.psychology.user.centre.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.UserRoleDTO;
import top.arsiac.psychology.user.centre.pojo.vo.UserRoleVO;

import java.util.List;

/**
 * <p>用户-角色接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/1
 */
@Api(tags = "用户-角色管理")
@CrossOrigin
@RequestMapping("/user/role")
public interface UserRoleApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户-角色
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    @ResponseBody
    List<UserRoleVO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    @ApiOperation("根据角色id查询")
    @GetMapping("/role/{id}")
    @ResponseBody
    List<UserRoleVO> queryByRoleId(@PathVariable Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    @ApiOperation("根据用户id查询")
    @GetMapping("/user/{id}")
    @ResponseBody
    List<UserRoleVO> queryByUserId(@PathVariable Long id);

    /**
     * <p>增加用户-角色</p>
     *
     * @param  dto 权限-资源信息
     * @return 数据库变动行数
     * */
    @ApiOperation("新增")
    @PostMapping
    @ResponseBody
    boolean add(@RequestBody  UserRoleDTO dto);

    /**
     * <p>增加用户-角色</p>
     *
     * @param  dtoList 用户-角色信息
     * @return 数据库变动行数
     * */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    @ResponseBody
    boolean batchAdd(@RequestBody List<UserRoleDTO>  dtoList);

    /**
     * <p>更新用户-角色</p>
     *
     * @param  dto 用户-角色信息
     * @return 数据库变动行数
     * */
    @ApiOperation("修改")
    @PutMapping
    @ResponseBody
    boolean modify(@RequestBody UserRoleDTO dto);

    /**
     * <p>删除用户-角色</p>
     *
     * @param  dto 用户-角色信息
     * @return 数据库变动行数
     * */
    @ApiOperation("删除")
    @DeleteMapping
    @ResponseBody
    boolean remove(@RequestBody  UserRoleDTO dto);

    /**
     * <p>批量删除用户-角色</p>
     *
     * @param  dtoList 用户-角色信息
     * @return 数据库变动行数
     * */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    @ResponseBody
    boolean batchRemove(@RequestBody List<UserRoleDTO>  dtoList);
}
