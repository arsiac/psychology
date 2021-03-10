package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.dto.AchievementTypeDTO;
import com.github.arsiac.psychology.base.pojo.vo.AchievementTypeVO;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>成果形式业务接口声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@Api(tags = "成果形式管理")
@RequestMapping("/achievement/type")
public interface AchievementTypeApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部成果形式
     * */
    @ApiOperation("查询全部")
    @GetMapping("/all")
    List<AchievementTypeVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param param 成果形式信息
     * @return 查询结果
     * */
    @ApiOperation("模糊查询")
    @GetMapping
    List<AchievementTypeVO> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 成果形式id
     * @return 查询结果
     * */
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    AchievementTypeVO queryById(@PathVariable Long id);

    /**
     * <p>添加新成果形式</p>
     *
     * @param dto 成果形式信息
     * @return 是否成功
     */
    @ApiOperation("新增")
    @PostMapping
    boolean add(@RequestBody AchievementTypeDTO dto);

    /**
     * <p>批量添加新成果形式</p>
     *
     * @param dtoList 成果形式信息
     * @return 是否成功
     */
    @ApiOperation("批量新增")
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<AchievementTypeDTO> dtoList);

    /**
     * <p>更新成果形式</p>
     *
     * @param dto 成果形式信息
     * @return 是否成功
     */
    @ApiOperation("修改")
    @PutMapping
    boolean modify(@RequestBody AchievementTypeDTO dto);

    /**
     * <p>删除成果形式</p>
     *
     * @param dto 成果形式信息 id version
     * @return 是否成功
     */
    @ApiOperation("删除")
    @DeleteMapping
    boolean remove(@RequestBody AchievementTypeDTO dto);

    /**
     * <p>批量删除成果形式</p>
     *
     * @param dtoList 成果形式信息
     * @return 是否成功
     */
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<AchievementTypeDTO> dtoList);
}
