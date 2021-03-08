package com.github.arsiac.psychology.manager.api;

import com.github.arsiac.psychology.manager.pojo.dto.ProjectDTO;
import com.github.arsiac.psychology.manager.pojo.param.ProjectParam;
import com.github.arsiac.psychology.manager.pojo.vo.ProjectVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>科研立项业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "科研立项管理")
@RequestMapping("/project")
public interface ProjectApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部科研立项
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<ProjectVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 科研立项信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<ProjectVO> queryFuzzy(ProjectParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 科研立项id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    ProjectVO queryById(@PathVariable Long id);

    /**
     * <p>添加新科研立项</p>
     *
     * @param dto 科研立项信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody ProjectDTO dto);

    /**
     * <p>批量添加新科研立项</p>
     *
     * @param dtoList 科研立项信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<ProjectDTO> dtoList);

    /**
     * <p>更新科研立项</p>
     *
     * @param dto 科研立项信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody ProjectDTO dto);

    /**
     * <p>删除科研立项</p>
     *
     * @param dto 科研立项信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody ProjectDTO dto);

    /**
     * <p>批量删除科研立项</p>
     *
     * @param dtoList 科研立项信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<ProjectDTO> dtoList);
}
