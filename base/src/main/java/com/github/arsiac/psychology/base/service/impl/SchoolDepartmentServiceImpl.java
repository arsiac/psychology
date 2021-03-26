package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.SchoolDepartmentDTO;
import com.github.arsiac.psychology.base.pojo.entity.SchoolDepartmentEntity;
import com.github.arsiac.psychology.base.dao.SchoolDepartmentMapper;
import com.github.arsiac.psychology.base.service.SchoolDepartmentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>学院服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:55
 */
@Service("schoolDepartmentService")
public class SchoolDepartmentServiceImpl implements SchoolDepartmentService {
    /**
         * 权力 dao
         */
    private SchoolDepartmentMapper schoolDepartmentMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<SchoolDepartmentDTO> queryAll() {
        return BeanCopy.copyList(schoolDepartmentMapper.selectAll(), SchoolDepartmentDTO.class);
    }

    @Override
    public List<SchoolDepartmentDTO> queryFuzzy(SchoolDepartmentDTO dto) {
        // dto 为 null 则默认查询全部
        SchoolDepartmentEntity entity;
        if (dto == null) {
            entity = new SchoolDepartmentEntity();
        } else {
            entity = BeanCopy.copy(dto, SchoolDepartmentEntity.class);
        }
        return BeanCopy.copyListOrPage(schoolDepartmentMapper.selectFuzzy(entity), SchoolDepartmentDTO.class);
    }

    @Override
    public SchoolDepartmentDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(schoolDepartmentMapper.selectById(id), SchoolDepartmentDTO.class);
    }

    @Override
    public boolean add(SchoolDepartmentDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return schoolDepartmentMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<SchoolDepartmentDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (SchoolDepartmentDTO dto : dtoList) {
            count += schoolDepartmentMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(SchoolDepartmentDTO dto) {
        checkIdAndVersion(dto);
        return schoolDepartmentMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(SchoolDepartmentDTO dto) {
        checkIdAndVersion(dto);

        try {
            return schoolDepartmentMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<SchoolDepartmentDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (SchoolDepartmentDTO dto : dtoList) {
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
    private void checkIdAndVersion(SchoolDepartmentDTO dto) {
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
    public void setSchoolDepartmentMapper(SchoolDepartmentMapper schoolDepartmentMapper) {
        this.schoolDepartmentMapper = schoolDepartmentMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}