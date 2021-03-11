package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.TeacherDTO;
import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.base.dao.TeacherMapper;
import com.github.arsiac.psychology.base.service.TeacherService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>教师服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    /**
         * 权力 dao
         */
    private TeacherMapper teacherMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<TeacherDTO> queryAll() {
        return BeanCopy.copyList(teacherMapper.selectAll(), TeacherDTO.class);
    }

    @Override
    public List<TeacherDTO> queryFuzzy(TeacherDTO dto) {
        // dto 为 null 则默认查询全部
        TeacherEntity entity;
        if (dto == null) {
            entity = new TeacherEntity();
        } else {
            entity = BeanCopy.copy(dto, TeacherEntity.class);
        }
        return teacherMapper.selectFuzzy(entity);
    }

    @Override
    public TeacherDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(teacherMapper.selectById(id), TeacherDTO.class);
    }

    @Override
    public boolean add(TeacherDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return teacherMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<TeacherDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (TeacherDTO dto : dtoList) {
            count += teacherMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(TeacherDTO dto) {
        checkIdAndVersion(dto);
        return teacherMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(TeacherDTO dto) {
        checkIdAndVersion(dto);

        try {
            return teacherMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<TeacherDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (TeacherDTO dto : dtoList) {
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
    private void checkIdAndVersion(TeacherDTO dto) {
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
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}