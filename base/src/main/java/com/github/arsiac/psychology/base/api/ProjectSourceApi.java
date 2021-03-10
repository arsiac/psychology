package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.ProjectSourceDTO;
import com.github.arsiac.psychology.base.pojo.vo.ProjectSourceVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>课题来源业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "课题来源管理")
@RequestMapping("/project/source")
public interface ProjectSourceApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部课题来源
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<ProjectSourceVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 课题来源信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<ProjectSourceVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 课题来源id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    ProjectSourceVO queryById(@PathVariable Long id);

    /**
     * <p>添加新课题来源</p>
     *
     * @param dto 课题来源信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody ProjectSourceDTO dto);

    /**
     * <p>批量添加新课题来源</p>
     *
     * @param dtoList 课题来源信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<ProjectSourceDTO> dtoList);

    /**
     * <p>更新课题来源</p>
     *
     * @param dto 课题来源信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody ProjectSourceDTO dto);

    /**
     * <p>删除课题来源</p>
     *
     * @param dto 课题来源信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody ProjectSourceDTO dto);

    /**
     * <p>批量删除课题来源</p>
     *
     * @param dtoList 课题来源信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<ProjectSourceDTO> dtoList);
}
