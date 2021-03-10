package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.SubjectTypeDTO;
import com.github.arsiac.psychology.base.pojo.vo.SubjectTypeVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>课题类别业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "课题类别管理")
@RequestMapping("/subject/type")
public interface SubjectTypeApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部课题类别
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<SubjectTypeVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 课题类别信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<SubjectTypeVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 课题类别id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    SubjectTypeVO queryById(@PathVariable Long id);

    /**
     * <p>添加新课题类别</p>
     *
     * @param dto 课题类别信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody SubjectTypeDTO dto);

    /**
     * <p>批量添加新课题类别</p>
     *
     * @param dtoList 课题类别信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<SubjectTypeDTO> dtoList);

    /**
     * <p>更新课题类别</p>
     *
     * @param dto 课题类别信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody SubjectTypeDTO dto);

    /**
     * <p>删除课题类别</p>
     *
     * @param dto 课题类别信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody SubjectTypeDTO dto);

    /**
     * <p>批量删除课题类别</p>
     *
     * @param dtoList 课题类别信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<SubjectTypeDTO> dtoList);
}
