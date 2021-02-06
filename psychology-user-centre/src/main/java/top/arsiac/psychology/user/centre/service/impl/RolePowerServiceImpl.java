package top.arsiac.psychology.user.centre.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.arsiac.psychology.user.centre.pojo.dto.RolePowerDTO;
import top.arsiac.psychology.user.centre.dao.RolePowerMapper;
import top.arsiac.psychology.user.centre.service.RolePowerService;
import top.arsiac.psychology.utils.common.IdGenerator;
import top.arsiac.psychology.utils.common.BeanCopy;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>角色-权力业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
@Service
public class RolePowerServiceImpl implements RolePowerService {
    /**
     * 权力资源 dao
     * */
    private RolePowerMapper rolePowerMapper;

    /**
     * id 生成器
     * */
    private IdGenerator idGenerator;

    @Override
    public List<RolePowerDTO> queryAll() {
        return BeanCopy.copyList(rolePowerMapper.selectAll(), RolePowerDTO.class);
    }

    @Override
    public List<RolePowerDTO> queryByPowerId(Long id) {
        if (id == null) {
            return new ArrayList<>(0);
        }

        return BeanCopy.copyList(rolePowerMapper.selectByPowerId(id), RolePowerDTO.class);
    }

    @Override
    public List<RolePowerDTO> queryByRoleId(Long id) {
        return BeanCopy.copyList(rolePowerMapper.selectByRoleId(id), RolePowerDTO.class);
    }

    @Override
    public boolean add(RolePowerDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return rolePowerMapper.insert(dto) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchAdd(List<RolePowerDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RolePowerDTO dto : dtoList) {
            count += rolePowerMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(RolePowerDTO dto) {
        checkIdAndVersion(dto);
        return rolePowerMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(RolePowerDTO dto) {
        checkIdAndVersion(dto);
        try {
            return rolePowerMapper.delete(dto.getId(), dto.getVersion()) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.DELETE_FAILED.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<RolePowerDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RolePowerDTO dto : dtoList) {
            count += rolePowerMapper.delete(dto.getId(), dto.getVersion());
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
    private void checkIdAndVersion(RolePowerDTO dto) {
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
    public void setRolePowerMapper(RolePowerMapper rolePowerMapper) {
        this.rolePowerMapper = rolePowerMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
