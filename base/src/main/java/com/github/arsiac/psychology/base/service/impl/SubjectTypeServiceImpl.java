package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.SubjectTypeDTO;
import com.github.arsiac.psychology.base.pojo.entity.SubjectTypeEntity;
import com.github.arsiac.psychology.base.dao.SubjectTypeMapper;
import com.github.arsiac.psychology.base.service.SubjectTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>课题类别服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Service("subjectTypeService")
public class SubjectTypeServiceImpl implements SubjectTypeService {
    /**
         * 权力 dao
         */
    private SubjectTypeMapper subjectTypeMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<SubjectTypeDTO> queryAll() {
        return BeanCopy.copyList(subjectTypeMapper.selectAll(), SubjectTypeDTO.class);
    }

    @Override
    public List<SubjectTypeDTO> queryFuzzy(SubjectTypeDTO dto) {
        // dto 为 null 则默认查询全部
        SubjectTypeEntity entity;
        if (dto == null) {
            entity = new SubjectTypeEntity();
        } else {
            entity = BeanCopy.copy(dto, SubjectTypeEntity.class);
        }
        return BeanCopy.copyListOrPage(subjectTypeMapper.selectFuzzy(entity), SubjectTypeDTO.class);
    }

    @Override
    public SubjectTypeDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(subjectTypeMapper.selectById(id), SubjectTypeDTO.class);
    }

    @Override
    public boolean add(SubjectTypeDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return subjectTypeMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<SubjectTypeDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (SubjectTypeDTO dto : dtoList) {
            count += subjectTypeMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(SubjectTypeDTO dto) {
        checkIdAndVersion(dto);
        return subjectTypeMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(SubjectTypeDTO dto) {
        checkIdAndVersion(dto);

        try {
            return subjectTypeMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<SubjectTypeDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (SubjectTypeDTO dto : dtoList) {
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
    private void checkIdAndVersion(SubjectTypeDTO dto) {
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
    public void setSubjectTypeMapper(SubjectTypeMapper subjectTypeMapper) {
        this.subjectTypeMapper = subjectTypeMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}