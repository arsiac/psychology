package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.SchoolDepartmentDTO;
import com.github.arsiac.psychology.base.pojo.vo.SchoolDepartmentVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>学院业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "学院管理")
@RequestMapping("/school/department")
public interface SchoolDepartmentApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部学院
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<SchoolDepartmentVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 学院信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<SchoolDepartmentVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 学院id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    SchoolDepartmentVO queryById(@PathVariable Long id);

    /**
     * <p>添加新学院</p>
     *
     * @param dto 学院信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody SchoolDepartmentDTO dto);

    /**
     * <p>批量添加新学院</p>
     *
     * @param dtoList 学院信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<SchoolDepartmentDTO> dtoList);

    /**
     * <p>更新学院</p>
     *
     * @param dto 学院信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody SchoolDepartmentDTO dto);

    /**
     * <p>删除学院</p>
     *
     * @param dto 学院信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody SchoolDepartmentDTO dto);

    /**
     * <p>批量删除学院</p>
     *
     * @param dtoList 学院信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<SchoolDepartmentDTO> dtoList);
}
