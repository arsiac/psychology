package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.DictionaryTypeDTO;
import com.github.arsiac.psychology.base.pojo.vo.DictionaryTypeVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>字典类型管理</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "管理")
@RequestMapping("/dictionary-type")
public interface DictionaryTypeApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<DictionaryTypeVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<DictionaryTypeVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    DictionaryTypeVO queryById(@PathVariable Long id);

    /**
     * <p>添加新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody DictionaryTypeDTO dto);

    /**
     * <p>批量添加新</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<DictionaryTypeDTO> dtoList);

    /**
     * <p>更新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody DictionaryTypeDTO dto);

    /**
     * <p>删除</p>
     *
     * @param dto 信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody DictionaryTypeDTO dto);

    /**
     * <p>批量删除</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<DictionaryTypeDTO> dtoList);
}
