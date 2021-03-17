package com.github.arsiac.psychology.manager.api;

import com.github.arsiac.psychology.manager.pojo.dto.PaperDTO;
import com.github.arsiac.psychology.manager.pojo.param.PaperParam;
import com.github.arsiac.psychology.manager.pojo.vo.PaperVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "管理")
@RequestMapping("/paper")
public interface PaperApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<PaperVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<PaperVO> queryFuzzy(PaperParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    PaperVO queryById(@PathVariable Long id);

    /**
     * <p>添加新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody PaperDTO dto);

    /**
     * <p>批量添加新</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<PaperDTO> dtoList);

    /**
     * <p>更新</p>
     *
     * @param dto 信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody PaperDTO dto);

    /**
     * <p>删除</p>
     *
     * @param dto 信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody PaperDTO dto);

    /**
     * <p>批量删除</p>
     *
     * @param dtoList 信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<PaperDTO> dtoList);
}
