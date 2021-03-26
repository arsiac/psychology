package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.pojo.dto.StudentDTO;
import com.github.arsiac.psychology.centre.pojo.entity.StudentEntity;
import com.github.arsiac.psychology.centre.dao.StudentMapper;
import com.github.arsiac.psychology.centre.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>学生服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:08:15
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    /**
         * 权力 dao
         */
    private StudentMapper studentMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<StudentDTO> queryAll() {
        return BeanCopy.copyList(studentMapper.selectAll(), StudentDTO.class);
    }

    @Override
    public List<StudentDTO> queryFuzzy(StudentDTO dto) {
        // dto 为 null 则默认查询全部
        StudentEntity entity;
        if (dto == null) {
            entity = new StudentEntity();
        } else {
            entity = BeanCopy.copy(dto, StudentEntity.class);
        }
        return BeanCopy.copyListOrPage(studentMapper.selectFuzzy(entity), StudentDTO.class);
    }

    @Override
    public StudentDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(studentMapper.selectById(id), StudentDTO.class);
    }

    @Override
    public boolean add(StudentDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return studentMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<StudentDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (StudentDTO dto : dtoList) {
            count += studentMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(StudentDTO dto) {
        checkIdAndVersion(dto);
        return studentMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(StudentDTO dto) {
        checkIdAndVersion(dto);

        try {
            return studentMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<StudentDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (StudentDTO dto : dtoList) {
            count += remove(dto) ? 1 : 0;
        }

        // true 则为全部删除成功
        // false 则为部分删除失败
        return count == dtoList.size();
    }

    /**
     * <p>检查dto的id和version</p>
     *
     * @param dto 要被检查的对象
     */
    private void checkIdAndVersion(StudentDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        if (dto.getId() == null) {
            throw PsychologyErrorCode.ID_NOT_AVAILABLE.createException();
        }
        if (dto.getVersion() == null) {
            throw PsychologyErrorCode.VERSION_NOT_AVAILABLE.createException();
        }
    }

    @Resource
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}