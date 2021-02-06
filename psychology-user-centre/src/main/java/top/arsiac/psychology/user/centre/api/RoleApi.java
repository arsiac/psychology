package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.RoleDTO;
import top.arsiac.psychology.user.centre.pojo.vo.RoleVO;

import java.util.List;

/**
 * <p>角色业务接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@CrossOrigin
@RequestMapping("/role")
public interface RoleApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色
     * */
    @GetMapping("/all")
    List<RoleVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 角色信息
     * @return 查询结果
     * */
    @GetMapping
    List<RoleVO> queryFuzzy(@RequestBody RoleDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    @GetMapping("/{id}")
    RoleVO queryById(@PathVariable Long id);

    /**
     * <p>添加新角色</p>
     *
     * @param dto 角色信息
     * @return 是否成功
     */
    @PostMapping
    boolean add(@RequestBody RoleDTO dto);

    /**
     * <p>批量添加新角色</p>
     *
     * @param dtoList 角色信息
     * @return 是否成功
     */
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<RoleDTO> dtoList);

    /**
     * <p>更新角色</p>
     *
     * @param dto 角色信息
     * @return 是否成功
     */
    @PutMapping
    boolean modify(@RequestBody RoleDTO dto);

    /**
     * <p>删除角色</p>
     *
     * @param dto 角色信息 id version
     * @return 是否成功
     */
    @DeleteMapping
    boolean remove(@RequestBody RoleDTO dto);

    /**
     * <p>批量删除角色</p>
     *
     * @param dtoList 角色信息
     * @return 是否成功
     */
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<RoleDTO> dtoList);
}
