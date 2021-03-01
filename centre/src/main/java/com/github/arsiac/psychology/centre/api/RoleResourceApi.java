package com.github.arsiac.psychology.centre.api;

import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;
import com.github.arsiac.psychology.centre.pojo.vo.RoleResourceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>角色-资源api</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
@Api(tags = "角色资源管理")
@RequestMapping("/role/resource")
public interface RoleResourceApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部角色-资源
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<RoleResourceVO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 角色id
     * @return 查询结果
     * */
    @ApiOperation("根据角色id查询")
    @GetMapping("/role/{id}")
    List<RoleResourceVO> queryByRoleId(@PathVariable Long id);

    /**
     * <p>根据用户id查询</p>
     *
     * @param id 资源id
     * @return 查询结果
     * */
    @ApiOperation("根据资源id查询")
    @GetMapping("/resource/{id}")
    List<RoleResourceVO> queryByResourceId(@PathVariable Long id);

    /**
     * <p>增加角色-资源</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    @ApiOperation("增加")
    @PostMapping
    boolean add(RoleResourceDTO dto);

    /**
     * <p>增加角色-资源</p>
     *
     * @param dtoList 角色-资源信息
     * @return 数据库变动行数
     * */
    @ApiOperation("批量增加")
    @PostMapping("/batch")
    boolean batchAdd(List<RoleResourceDTO> dtoList);

    /**
     * <p>更新角色-资源</p>
     *
     * @param dto 角色-资源信息
     * @return 数据库变动行数
     * */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(RoleResourceDTO dto);

    /**
     * <p>删除角色-资源</p>
     *
     * @param dto 角色-资源信息
     * @return 数据库变动行数
     * */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(RoleResourceDTO dto);

    /**
     * <p>批量删除角色-资源</p>
     *
     * @param dtoList 角色-资源信息
     * @return 数据库变动行数
     * */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(List<RoleResourceDTO> dtoList);
}
