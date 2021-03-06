package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.SubjectTypeEntity;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>课题类型api</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RequestMapping("/subject/type")
public interface SubjectTypeApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部课题类型
     * */
    @SystemLogger("查询全部课题类型")
    @GetMapping("/all")
    List<SubjectTypeEntity> queryAll();

    /**
     * <p>模糊查找课题类型</p>
     *
     * @param entity 课题类型信息
     * @return 课题类型列表
     * */
    @SystemLogger("模糊查询课题类型")
    @GetMapping
    List<SubjectTypeEntity> queryFuzzy(SubjectTypeEntity entity);

    /**
     * <p>根据id查询</p>
     *
     * @param id 课题类型id
     * @return 课题类型信息
     * */
    @SystemLogger("根据id查询课题类型")
    @GetMapping("/{id}")
    SubjectTypeEntity queryById(@PathVariable Long id);

    /**
     * <p>增加课题类型</p>
     *
     * @param entity 课题类型信息
     * @return 数据库变动行数
     * */
    @SystemLogger("添加课题类型")
    @PostMapping
    boolean add(@RequestBody SubjectTypeEntity entity);

    /**
     * <p>更新课题类型</p>
     *
     * @param entity 课题类型信息
     * @return 数据库变动行数
     * */
    @SystemLogger("修改课题类型")
    @PutMapping
    boolean modify(@RequestBody SubjectTypeEntity entity);

    /**
     * <p>删除课题类型</p>
     *
     * @param entityList 课题类型信息
     * @return 数据库变动行数
     * */
    @SystemLogger("删除课题类型")
    @DeleteMapping
    boolean remove(@RequestBody List<SubjectTypeEntity> entityList);
}
