package com.github.arsiac.psychology.centre.service;

import com.github.arsiac.psychology.centre.pojo.dto.StudentDTO;

import java.util.List;


/**
 * <p>学生服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
public interface StudentService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部学生
     * */
    List<StudentDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 学生信息
     * @return 查询结果
     * */
    List<StudentDTO> queryFuzzy(StudentDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 学生id
     * @return 查询结果
     * */
    StudentDTO queryById(Long id);

    /**
     * <p>添加新学生</p>
     *
     * @param dto 学生信息
     * @return 是否成功
     */
    boolean add(StudentDTO dto);

    /**
     * <p>批量添加新学生</p>
     *
     * @param dtoList 学生信息
     * @return 是否成功
     */
    boolean batchAdd(List<StudentDTO> dtoList);

    /**
     * <p>更新学生</p>
     *
     * @param dto 学生信息
     * @return 是否成功
     */
    boolean modify(StudentDTO dto);

    /**
     * <p>删除学生</p>
     *
     * @param dto 学生信息 id version
     * @return 是否成功
     */
    boolean remove(StudentDTO dto);

    /**
     * <p>批量删除学生</p>
     *
     * @param dtoList 学生信息
     * @return 是否成功
     */
    boolean batchRemove(List<StudentDTO> dtoList);
}

