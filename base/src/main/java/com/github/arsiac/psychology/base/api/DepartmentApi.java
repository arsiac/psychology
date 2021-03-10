package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.DepartmentDTO;
import com.github.arsiac.psychology.base.pojo.vo.DepartmentVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>系别业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "系别管理")
@RequestMapping("/department")
public interface DepartmentApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部系别
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<DepartmentVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 系别信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<DepartmentVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 系别id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    DepartmentVO queryById(@PathVariable Long id);

    /**
     * <p>添加新系别</p>
     *
     * @param dto 系别信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody DepartmentDTO dto);

    /**
     * <p>批量添加新系别</p>
     *
     * @param dtoList 系别信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<DepartmentDTO> dtoList);

    /**
     * <p>更新系别</p>
     *
     * @param dto 系别信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody DepartmentDTO dto);

    /**
     * <p>删除系别</p>
     *
     * @param dto 系别信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody DepartmentDTO dto);

    /**
     * <p>批量删除系别</p>
     *
     * @param dtoList 系别信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<DepartmentDTO> dtoList);
}
