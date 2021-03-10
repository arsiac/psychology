package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.RewordLevelDTO;
import com.github.arsiac.psychology.base.pojo.vo.RewordLevelVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>获奖等级业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "获奖等级管理")
@RequestMapping("/rewordLevel")
public interface RewordLevelApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部获奖等级
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<RewordLevelVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 获奖等级信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<RewordLevelVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 获奖等级id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    RewordLevelVO queryById(@PathVariable Long id);

    /**
     * <p>添加新获奖等级</p>
     *
     * @param dto 获奖等级信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody RewordLevelDTO dto);

    /**
     * <p>批量添加新获奖等级</p>
     *
     * @param dtoList 获奖等级信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<RewordLevelDTO> dtoList);

    /**
     * <p>更新获奖等级</p>
     *
     * @param dto 获奖等级信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody RewordLevelDTO dto);

    /**
     * <p>删除获奖等级</p>
     *
     * @param dto 获奖等级信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody RewordLevelDTO dto);

    /**
     * <p>批量删除获奖等级</p>
     *
     * @param dtoList 获奖等级信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<RewordLevelDTO> dtoList);
}
