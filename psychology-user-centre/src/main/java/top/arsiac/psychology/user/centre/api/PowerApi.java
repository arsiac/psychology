package top.arsiac.psychology.user.centre.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.PowerDTO;
import top.arsiac.psychology.user.centre.pojo.vo.PowerVO;

import java.util.List;

/**
 * <p>权力业务接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/5
 */
@RequestMapping("/power")
@Api(tags = "权力管理")
public interface PowerApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部权力
     * */
    @GetMapping("/all")
    @ApiOperation(value = "查找全部", httpMethod = "GET")
    List<PowerVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 权力信息
     * @return 查询结果
     * */
    @GetMapping
    @ApiOperation(value = "模糊查询", httpMethod = "GET")
    List<PowerVO> queryFuzzy(PowerDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 权力id
     * @return 查询结果
     * */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据 id 查询", httpMethod = "GET")
    PowerVO queryById(@PathVariable Long id);

    /**
     * <p>添加新权力</p>
     *
     * @param dto 权力信息
     * @return 是否成功
     */
    @PostMapping
    @ApiOperation(value = "增加", httpMethod = "POST")
    boolean add(@RequestBody PowerDTO dto);

    /**
     * <p>批量添加新权力</p>
     *
     * @param dtoList 权力信息
     * @return 是否成功
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量增加", httpMethod = "POST")
    boolean batchAdd(@RequestBody List<PowerDTO> dtoList);

    /**
     * <p>更新权力</p>
     *
     * @param dto 权力信息
     * @return 是否成功
     */
    @PutMapping
    @ApiOperation(value = "修改", httpMethod = "PUT")
    boolean modify(@RequestBody PowerDTO dto);

    /**
     * <p>删除权力</p>
     *
     * @param dto 权力信息 id version
     * @return 是否成功
     */
    @DeleteMapping
    @ApiOperation(value = "删除", httpMethod = "DELETE")
    boolean remove(@RequestBody PowerDTO dto);

    /**
     * <p>批量删除权力</p>
     *
     * @param dtoList 权力信息
     * @return 是否成功
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除", httpMethod = "DELETE")
    boolean batchRemove(@RequestBody List<PowerDTO> dtoList);
}
