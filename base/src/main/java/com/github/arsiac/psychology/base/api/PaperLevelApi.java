package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.PaperLevelDTO;
import com.github.arsiac.psychology.base.pojo.vo.PaperLevelVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>论文级别业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "论文级别管理")
@RequestMapping("/paper/level")
public interface PaperLevelApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部论文级别
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<PaperLevelVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 论文级别信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<PaperLevelVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 论文级别id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    PaperLevelVO queryById(@PathVariable Long id);

    /**
     * <p>添加新论文级别</p>
     *
     * @param dto 论文级别信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody PaperLevelDTO dto);

    /**
     * <p>批量添加新论文级别</p>
     *
     * @param dtoList 论文级别信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<PaperLevelDTO> dtoList);

    /**
     * <p>更新论文级别</p>
     *
     * @param dto 论文级别信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody PaperLevelDTO dto);

    /**
     * <p>删除论文级别</p>
     *
     * @param dto 论文级别信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody PaperLevelDTO dto);

    /**
     * <p>批量删除论文级别</p>
     *
     * @param dtoList 论文级别信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<PaperLevelDTO> dtoList);
}
