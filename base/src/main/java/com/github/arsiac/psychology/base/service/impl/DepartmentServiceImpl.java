package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.DepartmentDTO;
import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.base.dao.DepartmentMapper;
import com.github.arsiac.psychology.base.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>系别服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    /**
         * 权力 dao
         */
    private DepartmentMapper departmentMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<DepartmentDTO> queryAll() {
        return BeanCopy.copyList(departmentMapper.selectAll(), DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> queryFuzzy(DepartmentDTO dto) {
        // dto 为 null 则默认查询全部
        DepartmentEntity entity;
        if (dto == null) {
            entity = new DepartmentEntity();
        } else {
            entity = BeanCopy.copy(dto, DepartmentEntity.class);
        }
        return BeanCopy.copyListOrPage(departmentMapper.selectFuzzy(entity), DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(departmentMapper.selectById(id), DepartmentDTO.class);
    }

    @Override
    public boolean add(DepartmentDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return departmentMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<DepartmentDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (DepartmentDTO dto : dtoList) {
            count += departmentMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(DepartmentDTO dto) {
        checkIdAndVersion(dto);
        return departmentMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(DepartmentDTO dto) {
        checkIdAndVersion(dto);

        try {
            return departmentMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<DepartmentDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (DepartmentDTO dto : dtoList) {
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
    private void checkIdAndVersion(DepartmentDTO dto) {
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
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}