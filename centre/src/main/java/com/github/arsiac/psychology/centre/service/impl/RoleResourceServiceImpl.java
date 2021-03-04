package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.centre.dao.ResourceMapper;
import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;
import com.github.arsiac.psychology.centre.pojo.entity.RoleResourceEntity;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.arsiac.psychology.centre.dao.RoleResourceMapper;
import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;
import com.github.arsiac.psychology.centre.service.RoleResourceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>角色-资源服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl implements RoleResourceService {
    /**
     * 资源 dao
     * */
    private ResourceMapper resourceMapper;

    /**
     * 角色-资源 dao
     * */
    private RoleResourceMapper roleResourceMapper;

    /**
     * id 生成
     * */
    private IdGenerator idGenerator;

    @Override
    public List<RoleResourceDTO> queryAll() {
        return BeanCopy.copyList(roleResourceMapper.selectAll(), RoleResourceDTO.class);
    }

    @Override
    public List<RoleResourceDTO> queryByRoleId(Long id) {
        return BeanCopy.copyList(roleResourceMapper.selectByRoleId(id),
                RoleResourceDTO.class, this::copy2dto);
    }

    /**
     * <p>复制成dto, 查询资源</p>
     *
     * @param source entity
     * @param target dto
     */
    private void copy2dto(Object source, Object target) {
        RoleResourceEntity entity = (RoleResourceEntity) source;
        RoleResourceDTO dto = (RoleResourceDTO) target;

        if (entity.getResourceId() != null) {
            dto.setResourceDTO(BeanCopy.copy(resourceMapper.selectById(entity.getResourceId()), ResourceDTO.class));
        }
    }

    @Override
    public List<RoleResourceDTO> queryByResourceId(Long id) {
        return BeanCopy.copyList(roleResourceMapper.selectByResourceId(id), RoleResourceDTO.class);
    }

    @Override
    public boolean add(RoleResourceDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        dto.setId(idGenerator.generate());
        return roleResourceMapper.insert(dto) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchAdd(List<RoleResourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RoleResourceDTO dto : dtoList) {
            count += roleResourceMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(RoleResourceDTO dto) {
        checkIdAndVersion(dto);
        return roleResourceMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(RoleResourceDTO dto) {
        checkIdAndVersion(dto);
        return roleResourceMapper.delete(dto.getId(), dto.getVersion()) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchRemove(List<RoleResourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RoleResourceDTO dto : dtoList) {
            count += roleResourceMapper.delete(dto.getId(), dto.getVersion());
        }

        // true 则为全部删除成功
        // false 则为部分删除失败
        return count == dtoList.size();
    }


    /**
     * <p>检查dto的id和version</p>
     *
     * @param dto 要被检查的对象
     * */
    private void checkIdAndVersion(RoleResourceDTO dto) {
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
    public void setResourceMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    @Resource
    public void setRoleResourceMapper(RoleResourceMapper roleResourceMapper) {
        this.roleResourceMapper = roleResourceMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
