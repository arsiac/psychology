package com.github.arsiac.psychology.centre.api;

import com.github.arsiac.psychology.centre.pojo.dto.TeacherDTO;
import com.github.arsiac.psychology.centre.pojo.param.TeacherParam;
import com.github.arsiac.psychology.centre.pojo.vo.TeacherVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>教师业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "教师管理")
@RequestMapping("/teacher")
public interface TeacherApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部教师
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<TeacherVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 教师信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<TeacherVO> queryFuzzy(TeacherParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 教师id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    TeacherVO queryById(@PathVariable Long id);

    /**
     * <p>添加新教师</p>
     *
     * @param dto 教师信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody TeacherDTO dto);

    /**
     * <p>批量添加新教师</p>
     *
     * @param dtoList 教师信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<TeacherDTO> dtoList);

    /**
     * <p>更新教师</p>
     *
     * @param dto 教师信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody TeacherDTO dto);

    /**
     * <p>删除教师</p>
     *
     * @param dto 教师信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody TeacherDTO dto);

    /**
     * <p>批量删除教师</p>
     *
     * @param dtoList 教师信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<TeacherDTO> dtoList);
}
