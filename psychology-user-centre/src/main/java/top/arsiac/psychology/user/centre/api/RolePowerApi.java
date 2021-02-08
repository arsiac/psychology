package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.RolePowerDTO;
import top.arsiac.psychology.user.centre.pojo.vo.RolePowerVO;

import java.util.List;

/**
 * <p>角色-权力业务接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@CrossOrigin
@RequestMapping("/role/power")
public interface RolePowerApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色-权力
     * */
    @GetMapping("/all")
    @ResponseBody
    List<RolePowerVO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    @GetMapping("/role/{id}")
    @ResponseBody
    List<RolePowerVO> queryByRoleId(@PathVariable Long id);

    /**
     * <p>根据权力id查询</p>
     *
     * @param id 权力id
     * @return 查询结果
     * */
    @GetMapping("/power/{id}")
    @ResponseBody
    List<RolePowerVO> queryByPowerId(@PathVariable Long id);

    /**
     * <p>增加角色-权力</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    @PostMapping
    @ResponseBody
    boolean add(@RequestBody RolePowerDTO dto);

    /**
     * <p>增加角色-权力</p>
     *
     * @param dtoList 角色-权力信息
     * @return 数据库变动行数
     * */
    @PostMapping("/batch")
    @ResponseBody
    boolean batchAdd(@RequestBody List<RolePowerDTO> dtoList);

    /**
     * <p>更新角色-权力</p>
     *
     * @param dto 角色-权力信息
     * @return 数据库变动行数
     * */
    @PutMapping
    @ResponseBody
    boolean modify(@RequestBody RolePowerDTO dto);

    /**
     * <p>删除角色-权力</p>
     *
     * @param dto 角色-权力信息
     * @return 数据库变动行数
     * */
    @DeleteMapping
    @ResponseBody
    boolean remove(@RequestBody RolePowerDTO dto);

    /**
     * <p>批量删除角色-权力</p>
     *
     * @param dtoList 角色-权力信息
     * @return 数据库变动行数
     * */
    @DeleteMapping("/batch")
    @ResponseBody
    boolean batchRemove(@RequestBody List<RolePowerDTO> dtoList);
}