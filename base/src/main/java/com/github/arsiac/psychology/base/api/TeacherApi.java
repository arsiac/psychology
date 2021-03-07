package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.base.pojo.param.TeacherParam;
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
    @GetMapping("/all")
    List<TeacherEntity> queryAll();

    /**
     * <p>模糊查找教师</p>
     *
     * @param param 教师信息
     * @return 教师列表
     * */
    @GetMapping
    List<TeacherEntity> queryFuzzy(TeacherParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 教师id
     * @return 教师信息
     * */
    @GetMapping("/{id}")
    TeacherEntity queryById(@PathVariable Long id);

    /**
     * <p>增加教师</p>
     *
     * @param entity 教师信息
     * @return 数据库变动行数
     * */
    @PostMapping
    boolean add(@RequestBody TeacherEntity entity);

    /**
     * <p>更新教师</p>
     *
     * @param entity 教师信息
     * @return 数据库变动行数
     * */
    @PutMapping
    boolean modify(@RequestBody TeacherEntity entity);

    /**
     * <p>删除教师</p>
     *
     * @param entityList 教师信息
     * @return 数据库变动行数
     * */
    @DeleteMapping
    boolean remove(@RequestBody List<TeacherEntity> entityList);
}
