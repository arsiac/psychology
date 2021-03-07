package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.ProjectSourceEntity;
import com.github.arsiac.psychology.base.pojo.param.DictionaryParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>项目来源api</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RequestMapping("/project/source")
public interface ProjectSourceApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部项目来源
     * */
    @GetMapping("/all")
    List<ProjectSourceEntity> queryAll();

    /**
     * <p>模糊查找项目来源</p>
     *
     * @param param 项目来源信息
     * @return 项目来源列表
     * */
    @GetMapping
    List<ProjectSourceEntity> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 项目来源id
     * @return 项目来源信息
     * */
    @GetMapping("/{id}")
    ProjectSourceEntity queryById(@PathVariable Long id);

    /**
     * <p>增加项目来源</p>
     *
     * @param entity 项目来源信息
     * @return 数据库变动行数
     * */
    @PostMapping
    boolean add(@RequestBody ProjectSourceEntity entity);

    /**
     * <p>更新项目来源</p>
     *
     * @param entity 项目来源信息
     * @return 数据库变动行数
     * */
    @PutMapping
    boolean modify(@RequestBody ProjectSourceEntity entity);

    /**
     * <p>删除项目来源</p>
     *
     * @param entityList 项目来源信息
     * @return 数据库变动行数
     * */
    @DeleteMapping
    boolean remove(@RequestBody List<ProjectSourceEntity> entityList);
}
