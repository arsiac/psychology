package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>教师api</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RequestMapping("/teacher")
public interface TeacherApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部教师
     * */
    @SystemLogger("查询全部教师")
    @GetMapping("/all")
    List<TeacherEntity> queryAll();

    /**
     * <p>模糊查找教师</p>
     *
     * @param entity 教师信息
     * @return 教师列表
     * */
    @SystemLogger("模糊查询教师")
    @GetMapping
    List<TeacherEntity> queryFuzzy(TeacherEntity entity);

    /**
     * <p>根据id查询</p>
     *
     * @param id 教师id
     * @return 教师信息
     * */
    @SystemLogger("根据id查询教师")
    @GetMapping("/{id}")
    TeacherEntity queryById(@PathVariable Long id);

    /**
     * <p>增加教师</p>
     *
     * @param entity 教师信息
     * @return 数据库变动行数
     * */
    @SystemLogger("添加教师")
    @PostMapping
    boolean add(@RequestBody TeacherEntity entity);

    /**
     * <p>更新教师</p>
     *
     * @param entity 教师信息
     * @return 数据库变动行数
     * */
    @SystemLogger("修改教师")
    @PutMapping
    boolean modify(@RequestBody TeacherEntity entity);

    /**
     * <p>删除教师</p>
     *
     * @param entityList 教师信息
     * @return 数据库变动行数
     * */
    @SystemLogger("删除教师")
    @DeleteMapping
    boolean remove(@RequestBody List<TeacherEntity> entityList);
}
