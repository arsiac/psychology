package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.centre.dao.RoleMapper;
import com.github.arsiac.psychology.centre.pojo.dto.RoleDTO;
import com.github.arsiac.psychology.centre.pojo.entity.UserRoleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.arsiac.psychology.centre.pojo.dto.UserRoleDTO;
import com.github.arsiac.psychology.centre.dao.UserRoleMapper;
import com.github.arsiac.psychology.centre.service.UserRoleService;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>用户-角色业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    /**
     * 角色dao
     * */
    private RoleMapper roleMapper;

    /**
     * 用户角色 dao
     * */
    private UserRoleMapper userRoleMapper;

    /**
     * id 生成器
     * */
    private IdGenerator idGenerator;

    @Override
    public List<UserRoleDTO> queryAll() {
        return BeanCopy.copyList(userRoleMapper.selectAll(), UserRoleDTO.class);
    }

    @Override
    public List<UserRoleDTO> queryByRoleId(Long id) {
        if (id == null) {
            return new ArrayList<>(0);
        }

        return BeanCopy.copyList(userRoleMapper.selectByRoleId(id), UserRoleDTO.class);
    }

    @Override
    public List<UserRoleDTO> queryByUserId(Long id) {
        if (id == null) {
            return new ArrayList<>(0);
        }

        return BeanCopy.copyList(userRoleMapper.selectByUserId(id), UserRoleDTO.class, this::copy2dto);
    }

    /**
     * <p>拷贝为dto</p>
     *
     * @param source entity
     * @param target dto
     */
    private void copy2dto(Object source, Object target) {
        UserRoleEntity entity = (UserRoleEntity) source;
        UserRoleDTO dto = (UserRoleDTO) target;

        if (entity.getRoleId() != null) {
            dto.setRoleDTO(BeanCopy.copy(roleMapper.selectById(entity.getRoleId()), RoleDTO.class));
        }
    }

    @Override
    public boolean add(UserRoleDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());

        return userRoleMapper.insert(dto) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchAdd(List<UserRoleDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (UserRoleDTO dto : dtoList) {
            count += userRoleMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(UserRoleDTO dto) {
        checkIdAndVersion(dto);
        return userRoleMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(UserRoleDTO dto) {
        checkIdAndVersion(dto);
        try {
            return userRoleMapper.delete(dto.getId(), dto.getVersion()) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.DELETE_FAILED.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<UserRoleDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (UserRoleDTO dto : dtoList) {
            count += userRoleMapper.delete(dto.getId(), dto.getVersion());
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
    private void checkIdAndVersion(UserRoleDTO dto) {
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
    public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
