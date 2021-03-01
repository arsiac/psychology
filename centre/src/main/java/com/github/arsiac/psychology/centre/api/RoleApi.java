package com.github.arsiac.psychology.centre.api;

import com.github.arsiac.psychology.centre.pojo.dto.RoleDTO;
import com.github.arsiac.psychology.centre.pojo.vo.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>角色业务接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "角色管理")
@RequestMapping("/role")
public interface RoleApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<RoleVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 角色信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<RoleVO> queryFuzzy(RoleDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    RoleVO queryById(@PathVariable Long id);

    /**
     * <p>添加新角色</p>
     *
     * @param dto 角色信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody RoleDTO dto);

    /**
     * <p>批量添加新角色</p>
     *
     * @param dtoList 角色信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<RoleDTO> dtoList);

    /**
     * <p>更新角色</p>
     *
     * @param dto 角色信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody RoleDTO dto);

    /**
     * <p>删除角色</p>
     *
     * @param dto 角色信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody RoleDTO dto);

    /**
     * <p>批量删除角色</p>
     *
     * @param dtoList 角色信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<RoleDTO> dtoList);
}
