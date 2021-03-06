package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
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
    @SystemLogger("查询全部系别")
    @GetMapping("/all")
    List<DepartmentEntity> queryAll();

    /**
     * <p>模糊查找系别</p>
     *
     * @param entity 系别信息
     * @return 系别列表
     * */
    @SystemLogger("模糊查询系别")
    @GetMapping
    List<DepartmentEntity> queryFuzzy(DepartmentEntity entity);

    /**
     * <p>根据id查询</p>
     *
     * @param id 系别id
     * @return 系别信息
     * */
    @SystemLogger("根据id查询系别")
    @GetMapping("/{id}")
    DepartmentEntity queryById(@PathVariable Long id);

    /**
     * <p>增加系别</p>
     *
     * @param entity 系别信息
     * @return 数据库变动行数
     * */
    @SystemLogger("添加系别")
    @PostMapping
    boolean add(@RequestBody DepartmentEntity entity);

    /**
     * <p>更新系别</p>
     *
     * @param entity 系别信息
     * @return 数据库变动行数
     * */
    @SystemLogger("修改系别")
    @PutMapping
    boolean modify(@RequestBody DepartmentEntity entity);

    /**
     * <p>删除系别</p>
     *
     * @param entityList 系别信息
     * @return 数据库变动行数
     * */
    @SystemLogger("删除系别")
    @DeleteMapping
    boolean remove(@RequestBody List<DepartmentEntity> entityList);
}
