package top.arsiac.psychology.user.centre.api;

import org.springframework.web.bind.annotation.*;
import top.arsiac.psychology.user.centre.pojo.dto.ResourceDTO;
import top.arsiac.psychology.user.centre.pojo.vo.ResourceVO;

import java.util.List;

/**
 * <p>资源业务接口声明</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/2/2
 */
@CrossOrigin
@RequestMapping("/resource")
public interface ResourceApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部资源
     * */
    @GetMapping("/all")
    List<ResourceVO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 资源信息
     * @return 查询结果
     * */
    @GetMapping
    List<ResourceVO> queryFuzzy(@RequestBody ResourceDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 资源id
     * @return 查询结果
     * */
    @GetMapping("/{id}")
    ResourceVO queryById(@PathVariable Long id);

    /**
     * <p>添加新资源</p>
     *
     * @param dto 资源信息
     * @return 是否成功
     */
    @PostMapping
    boolean add(@RequestBody ResourceDTO dto);

    /**
     * <p>批量添加新资源</p>
     *
     * @param dtoList 资源信息
     * @return 是否成功
     */
    @PostMapping("/batch")
    boolean batchAdd(@RequestBody List<ResourceDTO> dtoList);

    /**
     * <p>更新资源</p>
     *
     * @param dto 资源信息
     * @return 是否成功
     */
    @PutMapping
    boolean modify(@RequestBody ResourceDTO dto);

    /**
     * <p>删除资源</p>
     *
     * @param dto 资源信息 id version
     * @return 是否成功
     */
    @DeleteMapping
    boolean remove(@RequestBody ResourceDTO dto);

    /**
     * <p>批量删除资源</p>
     *
     * @param dtoList 资源信息
     * @return 是否成功
     */
    @DeleteMapping("/batch")
    boolean batchRemove(@RequestBody List<ResourceDTO> dtoList);
}