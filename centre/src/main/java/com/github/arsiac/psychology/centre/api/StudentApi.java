package com.github.arsiac.psychology.centre.api;

import com.github.arsiac.psychology.centre.pojo.dto.StudentDTO;
import com.github.arsiac.psychology.centre.pojo.param.StudentParam;
import com.github.arsiac.psychology.centre.pojo.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>学生业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "学生管理")
@RequestMapping("/student")
public interface StudentApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部学生
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<StudentVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 学生信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<StudentVO> queryFuzzy(StudentParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 学生id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    StudentVO queryById(@PathVariable Long id);

    /**
     * <p>添加新学生</p>
     *
     * @param dto 学生信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody StudentDTO dto);

    /**
     * <p>批量添加新学生</p>
     *
     * @param dtoList 学生信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<StudentDTO> dtoList);

    /**
     * <p>更新学生</p>
     *
     * @param dto 学生信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody StudentDTO dto);

    /**
     * <p>删除学生</p>
     *
     * @param dto 学生信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody StudentDTO dto);

    /**
     * <p>批量删除学生</p>
     *
     * @param dtoList 学生信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<StudentDTO> dtoList);
}
