package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.PowerResourceDTO;
import top.arsiac.psychology.user.centre.pojo.vo.PowerResourceVO;

import java.util.List;

/**
 * <p>权力-资源业务接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/5
 */
@CrossOrigin
@RequestMapping("/power/resource")
public interface PowerResourceApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部权力-资源
     * */
    @GetMapping("/all")
    @ResponseBody
    List<PowerResourceVO> queryAll();

    /**
     * <p>根据角色id查询</p>
     *
     * @param id 资源id
     * @return 查询结果
     * */
    @GetMapping("/resource/{id}")
    @ResponseBody
    List<PowerResourceVO> queryByResourceId(@PathVariable Long id);

    /**
     * <p>根据权力id查询</p>
     *
     * @param id 权力id
     * @return 查询结果
     * */
    @GetMapping("/power/{id}")
    @ResponseBody
    List<PowerResourceVO> queryByPowerId(@PathVariable Long id);

    /**
     * <p>增加权力-资源</p>
     *
     * @param dto 权限-资源信息
     * @return 数据库变动行数
     * */
    @PostMapping
    @ResponseBody
    boolean add(@RequestBody PowerResourceDTO dto);

    /**
     * <p>增加权力-资源</p>
     *
     * @param dtoList 权力-资源信息
     * @return 数据库变动行数
     * */
    @PostMapping("/batch")
    @ResponseBody
    boolean batchAdd(@RequestBody List<PowerResourceDTO> dtoList);

    /**
     * <p>更新权力-资源</p>
     *
     * @param dto 权力-资源信息
     * @return 数据库变动行数
     * */
    @PutMapping
    @ResponseBody
    boolean modify(@RequestBody PowerResourceDTO dto);

    /**
     * <p>删除权力-资源</p>
     *
     * @param dto 权力-资源信息
     * @return 数据库变动行数
     * */
    @DeleteMapping
    @ResponseBody
    boolean remove(@RequestBody PowerResourceDTO dto);

    /**
     * <p>批量删除权力-资源</p>
     *
     * @param dtoList 权力-资源信息
     * @return 数据库变动行数
     * */
    @DeleteMapping("/batch")
    @ResponseBody
    boolean batchRemove(@RequestBody List<PowerResourceDTO> dtoList);
}