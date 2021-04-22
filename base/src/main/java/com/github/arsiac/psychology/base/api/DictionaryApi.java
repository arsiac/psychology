package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.DictionaryDTO;
import com.github.arsiac.psychology.base.pojo.param.DictionaryParam;
import com.github.arsiac.psychology.base.pojo.vo.DictionaryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>字典管理</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "管理")
@RequestMapping("/dictionary")
public interface DictionaryApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<DictionaryVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<DictionaryVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    DictionaryVO queryById(@PathVariable Long id);

    /**
     * <p>添加新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody DictionaryDTO dto);

    /**
     * <p>批量添加新</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<DictionaryDTO> dtoList);

    /**
     * <p>更新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody DictionaryDTO dto);

    /**
     * <p>删除</p>
     *
     * @param dto 信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody DictionaryDTO dto);

    /**
     * <p>批量删除</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<DictionaryDTO> dtoList);
}
