package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.TeacherApi;
import com.github.arsiac.psychology.base.pojo.dto.TeacherDTO;
import com.github.arsiac.psychology.base.pojo.param.TeacherParam;
import com.github.arsiac.psychology.base.pojo.vo.TeacherVO;
import com.github.arsiac.psychology.base.service.TeacherService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>教师实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@RestController
public class TeacherController implements TeacherApi {
    /**
     * 教师服务
     * */
    private TeacherService teacherService;

    @SystemLogger("查询全部教师")
    @Override
    public List<TeacherVO> queryAll() {
        return BeanCopy.copyList(teacherService.queryAll(), TeacherVO.class);
    }

    @SystemLogger(value = "模糊查询教师", page = true)
    @Override
    public List<TeacherVO> queryFuzzy(TeacherParam param) {
        return BeanCopy.copyListOrPage(teacherService.queryFuzzy(BeanCopy.copy(param, TeacherDTO.class)), TeacherVO.class);
    }

    @SystemLogger("根据id查询教师")
    @Override
    public TeacherVO queryById(Long id) {
        return BeanCopy.copy(teacherService.queryById(id), TeacherVO.class);
    }

    @SystemLogger("添加教师")
    @Override
    public boolean add(TeacherDTO dto) {
        return teacherService.add(dto);
    }

    @SystemLogger("批量添加教师")
    @Override
    public boolean batchAdd(List<TeacherDTO> dtoList) {
        return teacherService.batchAdd(dtoList);
    }

    @SystemLogger("修改教师")
    @Override
    public boolean modify(TeacherDTO dto) {
        return teacherService.modify(dto);
    }

    @SystemLogger("删除教师")
    @Override
    public boolean remove(TeacherDTO dto) {
        return teacherService.remove(dto);
    }

    @SystemLogger("批量删除教师")
    @Override
    public boolean batchRemove(List<TeacherDTO> dtoList) {
        return teacherService.batchRemove(dtoList);
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
