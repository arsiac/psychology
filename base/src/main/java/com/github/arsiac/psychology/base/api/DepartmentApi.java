package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>系别api</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RequestMapping("/department")
public interface DepartmentApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部系别
     * */
    @GetMapping("/all")
    List<DepartmentEntity> queryAll();

    /**
     * <p>模糊查找系别</p>
     *
     * @param param 系别信息
     * @return 系别列表
     * */
    @GetMapping
    List<DepartmentEntity> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 系别id
     * @return 系别信息
     * */
    @GetMapping("/{id}")
    DepartmentEntity queryById(@PathVariable Long id);

    /**
     * <p>增加系别</p>
     *
     * @param entity 系别信息
     * @return 数据库变动行数
     * */
    @PostMapping
    boolean add(@RequestBody DepartmentEntity entity);

    /**
     * <p>更新系别</p>
     *
     * @param entity 系别信息
     * @return 数据库变动行数
     * */
    @PutMapping
    boolean modify(@RequestBody DepartmentEntity entity);

    /**
     * <p>删除系别</p>
     *
     * @param entityList 系别信息
     * @return 数据库变动行数
     * */
    @DeleteMapping
    boolean remove(@RequestBody List<DepartmentEntity> entityList);
}
