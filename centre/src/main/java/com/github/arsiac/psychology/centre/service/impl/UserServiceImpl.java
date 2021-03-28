package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.centre.dao.TeacherMapper;
import com.github.arsiac.psychology.centre.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.centre.pojo.form.RegisterForm;
import com.github.arsiac.psychology.utils.common.CommonTool;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;
import com.github.arsiac.psychology.centre.pojo.entity.UserEntity;
import com.github.arsiac.psychology.centre.dao.UserMapper;
import com.github.arsiac.psychology.centre.service.UserService;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>用户业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/1/31
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 用户 dao
     */
    private UserMapper userMapper;

    /**
     * 教师 dao
     * */
    private TeacherMapper teacherMapper;

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

        return BeanCopy.copyListOrPage(userMapper.selectFuzzy(entity), UserDTO.class);
    }

    @Override
    public UserDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(userMapper.selectById(id), UserDTO.class);
    }

    @Override
    public UserDTO queryByName(String name) {
        if (CommonTool.isBlank(name)) {
            throw PsychologyErrorCode.USERNAME_IS_EMPTY.createException();
        }
        return BeanCopy.copy(userMapper.selectByUsername(name), UserDTO.class);
    }

    /**
     * <p>确认用户信息正确且不重复</p>
     *
     * @param user 用户信息
     */
    private void checkUserInfo(UserEntity user) {
        if (user == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }

        if (CommonTool.isBlank(user.getUsername())) {
            throw PsychologyErrorCode.USERNAME_IS_EMPTY.createException();
        }

        UserEntity entity = userMapper.selectByUsername(user.getUsername());
        if (entity != null) {
            throw PsychologyErrorCode.USERNAME_ALREADY_EXIST.createException(entity.getUsername());
        }
    }

    @Override
    public boolean add(UserDTO dto) {
        checkUserInfo(dto);

        String password = dto.getPassword();

        // 生成随机字符串作为盐
        dto.setSalt(CommonTool.randomString(32));

        // 加密密码
        dto.setPassword(CommonTool.encrypt(password, dto.getSalt()));

        // 生成id
        dto.setId(idGenerator.generate());
        return userMapper.insert(dto) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(RegisterForm form) {
        checkUserInfo(form);

        // 确认教师号存在
        String teacherCode = form.getCode();
        if (teacherCode == null || CommonTool.isBlank(teacherCode)) {
            throw PsychologyErrorCode.TEACHER_CODE_IS_EMPTY.createException(teacherCode);
        }

        // 查询教师
        TeacherEntity teacherEntity = teacherMapper.selectByCode(teacherCode);
        if (teacherEntity == null) {
            throw PsychologyErrorCode.TEACHER_CODE_IS_INVALID.createException(teacherCode);
        }

        final String teacherInfo = String.format("code: %s, name: %s", teacherEntity.getCode(), teacherEntity.getName());

        // 教师已注册账号
        if (teacherEntity.getAccount() != null) {
            throw PsychologyErrorCode.TEACHER_ALREADY_HAS_ACCOUNT.createException(teacherInfo);
        }


        // 创建用户id
        long userId = idGenerator.generate();
        form.setId(userId);
        teacherEntity.setAccount(userId);


        // 生成随机字符串作为盐
        form.setSalt(CommonTool.randomString(32));

        // 加密密码
        form.setPassword(CommonTool.encrypt(form.getPassword(), form.getSalt()));

        // 创建新用户
        int successCode = userMapper.insert(form);
        if (successCode > 0) {
            successCode = teacherMapper.update(teacherEntity);
            if (successCode > 0) {
                return true;

                // 更新教师账号信息失败
            } else {
                throw PsychologyErrorCode.UPDATE_TEACHER_ACCOUNT_FAILED.createException(teacherInfo );
            }

            // 创建用户失败
        } else {
            throw PsychologyErrorCode.CREATE_NEW_USER_FALIED.createException(teacherInfo);
        }
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
        String password = dto.getPassword();

        // 加密密码
        dto.setPassword(CommonTool.encrypt(password, dto.getSalt()));
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
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
