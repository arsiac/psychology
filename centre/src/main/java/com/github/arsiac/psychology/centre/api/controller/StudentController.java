package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.StudentApi;
import com.github.arsiac.psychology.centre.pojo.dto.StudentDTO;
import com.github.arsiac.psychology.centre.pojo.param.StudentParam;
import com.github.arsiac.psychology.centre.pojo.vo.StudentVO;
import com.github.arsiac.psychology.centre.service.StudentService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>学生实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
@RestController
public class StudentController implements StudentApi {
    /**
     * 学生服务
     * */
    private StudentService studentService;

    @SystemLogger("查询全部学生")
    @Override
    public List<StudentVO> queryAll() {
        return BeanCopy.copyList(studentService.queryAll(), StudentVO.class);
    }

    @SystemLogger(value = "模糊查询学生", page = true)
    @Override
    public List<StudentVO> queryFuzzy(StudentParam param) {
        return BeanCopy.copyListOrPage(studentService.queryFuzzy(BeanCopy.copy(param, StudentDTO.class)),
                StudentVO.class, this::copy2vo);
    }

    /**
     * <p>拷贝专业和学院名称</p>
     *
     * @param source dto
     * @param target vo
     */
    private void copy2vo(Object source, Object target) {
        StudentDTO dto = (StudentDTO) source;
        StudentVO vo = (StudentVO) target;

        if (dto.getMajorEntity() != null) {
            vo.setMajorName(dto.getMajorEntity().getName());
        }

        if (dto.getSchoolDepartmentEntity() != null) {
            vo.setSchoolDepartmentName(dto.getSchoolDepartmentEntity().getName());
        }
    }

    @SystemLogger("根据id查询学生")
    @Override
    public StudentVO queryById(Long id) {
        return BeanCopy.copy(studentService.queryById(id), StudentVO.class);
    }

    @SystemLogger("添加学生")
    @Override
    public boolean add(StudentDTO dto) {
        return studentService.add(dto);
    }

    @SystemLogger("批量添加学生")
    @Override
    public boolean batchAdd(List<StudentDTO> dtoList) {
        return studentService.batchAdd(dtoList);
    }

    @SystemLogger("修改学生")
    @Override
    public boolean modify(StudentDTO dto) {
        return studentService.modify(dto);
    }

    @SystemLogger("删除学生")
    @Override
    public boolean remove(StudentDTO dto) {
        return studentService.remove(dto);
    }

    @SystemLogger("批量删除学生")
    @Override
    public boolean batchRemove(List<StudentDTO> dtoList) {
        return studentService.batchRemove(dtoList);
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
