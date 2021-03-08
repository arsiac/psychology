package com.github.arsiac.psychology.base.api;

import com.github.arsiac.psychology.base.pojo.entity.TitleEntity;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>职称api</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RequestMapping("/title")
public interface TitleApi {
    /**
     * <p>查找全部</p>
     *
     * @return 全部职称
     * */
    @GetMapping("/all")
    List<TitleEntity> queryAll();

    /**
     * <p>模糊查找职称</p>
     *
     * @param param 职称信息
     * @return 职称列表
     * */
    @GetMapping
    List<TitleEntity> queryFuzzy(DictionaryParam param);

    /**
     * <p>根据id查询</p>
     *
     * @param id 职称id
     * @return 职称信息
     * */
    @GetMapping("/{id}")
    TitleEntity queryById(@PathVariable Long id);

    /**
     * <p>增加职称</p>
     *
     * @param entity 职称信息
     * @return 数据库变动行数
     * */
    @PostMapping
    boolean add(@RequestBody TitleEntity entity);

    /**
     * <p>更新职称</p>
     *
     * @param entity 职称信息
     * @return 数据库变动行数
     * */
    @PutMapping
    boolean modify(@RequestBody TitleEntity entity);

    /**
     * <p>删除职称</p>
     *
     * @param entityList 职称信息
     * @return 数据库变动行数
     * */
    @DeleteMapping
    boolean remove(@RequestBody List<TitleEntity> entityList);
}
