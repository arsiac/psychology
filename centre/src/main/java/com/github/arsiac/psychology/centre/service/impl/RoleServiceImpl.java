package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.pojo.dto.RoleDTO;
import com.github.arsiac.psychology.centre.pojo.entity.RoleEntity;
import com.github.arsiac.psychology.centre.dao.RoleMapper;
import com.github.arsiac.psychology.centre.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>角色业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/1/31
 */
@Service
public class RoleServiceImpl implements RoleService {
    /**
     * 权力 dao
     */
    private RoleMapper roleMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<RoleDTO> queryAll() {
        return BeanCopy.copyList(roleMapper.selectAll(), RoleDTO.class);
    }

    @Override
    public List<RoleDTO> queryFuzzy(RoleDTO dto) {
        // dto 为 null 则默认查询全部
        RoleEntity entity;
        if (dto == null) {
            entity = new RoleEntity();
        } else {
            entity = BeanCopy.copy(dto, RoleEntity.class);
        }
        return BeanCopy.copyList(roleMapper.selectFuzzy(entity), RoleDTO.class);
    }

    @Override
    public RoleDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(roleMapper.selectById(id), RoleDTO.class);
    }

    @Override
    public boolean add(RoleDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return roleMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<RoleDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RoleDTO dto : dtoList) {
            count += roleMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(RoleDTO dto) {
        checkIdAndVersion(dto);
        return roleMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(RoleDTO dto) {
        checkIdAndVersion(dto);
        return roleMapper.delete(dto.getId(), dto.getVersion()) > 0;
    }

    @Override
    public boolean batchRemove(List<RoleDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RoleDTO dto : dtoList) {
            count += roleMapper.delete(dto.getId(), dto.getVersion());
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
    private void checkIdAndVersion(RoleDTO dto) {
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
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
