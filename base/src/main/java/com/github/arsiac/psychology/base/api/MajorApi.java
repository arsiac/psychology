package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.MajorDTO;
import com.github.arsiac.psychology.base.pojo.vo.MajorVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>专业业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "专业管理")
@RequestMapping("/major")
public interface MajorApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部专业
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<MajorVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 专业信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<MajorVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 专业id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    MajorVO queryById(@PathVariable Long id);

    /**
     * <p>添加新专业</p>
     *
     * @param dto 专业信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody MajorDTO dto);

    /**
     * <p>批量添加新专业</p>
     *
     * @param dtoList 专业信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<MajorDTO> dtoList);

    /**
     * <p>更新专业</p>
     *
     * @param dto 专业信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody MajorDTO dto);

    /**
     * <p>删除专业</p>
     *
     * @param dto 专业信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody MajorDTO dto);

    /**
     * <p>批量删除专业</p>
     *
     * @param dtoList 专业信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<MajorDTO> dtoList);
}
