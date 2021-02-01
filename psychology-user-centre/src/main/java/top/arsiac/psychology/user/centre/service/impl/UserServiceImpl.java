package top.arsiac.psychology.user.centre.service.impl;

import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.entity.UserEntity;
import top.arsiac.psychology.user.centre.dao.UserMapper;
import top.arsiac.psychology.user.centre.service.UserService;
import top.arsiac.psychology.utils.common.IdGenerator;
import top.arsiac.psychology.utils.common.BeanCopy;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>用户业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/1/31
 */
public class UserServiceImpl implements UserService {
    /**
     * 用户 dao
     */
    private UserMapper userMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<UserDTO> queryAll() {
        return BeanCopy.copyList(userMapper.selectAll(), UserDTO.class);
    }

    @Override
    public List<UserDTO> queryFuzzy(UserDTO dto) {
        // dto 为 null 则默认查询全部
        UserEntity entity;
        if (dto == null) {
            entity = new UserEntity();
        } else {
            entity = BeanCopy.copy(dto, UserEntity.class);
        }
        return BeanCopy.copyList(userMapper.selectFuzzy(entity), UserDTO.class);
    }

    @Override
    public UserDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(userMapper.selectById(id), UserDTO.class);
    }

    @Override
    public boolean add(UserDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return userMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<UserDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (UserDTO dto : dtoList) {
            count += userMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(UserDTO dto) {
        checkIdAndVersion(dto);
        return userMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(UserDTO dto) {
        checkIdAndVersion(dto);
        return userMapper.delete(dto.getId(), dto.getVersion()) > 0;
    }

    @Override
    public boolean batchRemove(List<UserDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (UserDTO dto : dtoList) {
            count += userMapper.delete(dto.getId(), dto.getVersion());
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
    private void checkIdAndVersion(UserDTO dto) {
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
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
