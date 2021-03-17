package com.github.arsiac.psychology.manager.api;

import com.github.arsiac.psychology.manager.pojo.dto.AchievementDTO;
import com.github.arsiac.psychology.manager.pojo.param.AchievementParam;
import com.github.arsiac.psychology.manager.pojo.vo.AchievementVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>成果业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "成果管理")
@RequestMapping("/achievement")
public interface AchievementApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部成果
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<AchievementVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 成果信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<AchievementVO> queryFuzzy(AchievementParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 成果id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    AchievementVO queryById(@PathVariable Long id);

    /**
     * <p>添加新成果</p>
     *
     * @param dto 成果信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody AchievementDTO dto);

    /**
     * <p>批量添加新成果</p>
     *
     * @param dtoList 成果信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<AchievementDTO> dtoList);

    /**
     * <p>更新成果</p>
     *
     * @param dto 成果信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody AchievementDTO dto);

    /**
     * <p>删除成果</p>
     *
     * @param dto 成果信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody AchievementDTO dto);

    /**
     * <p>批量删除成果</p>
     *
     * @param dtoList 成果信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<AchievementDTO> dtoList);
}
