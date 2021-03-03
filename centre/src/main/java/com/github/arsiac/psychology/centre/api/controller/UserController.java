package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.UserApi;
import com.github.arsiac.psychology.centre.pojo.dto.UserDTO;
import com.github.arsiac.psychology.centre.pojo.form.PasswordForm;
import com.github.arsiac.psychology.centre.pojo.form.param.UserParam;
import com.github.arsiac.psychology.centre.pojo.vo.UserVO;
import com.github.arsiac.psychology.centre.service.UserService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.CommonTool;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>用户业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/6
 */
@RestController
public class UserController implements UserApi {
    /**
     * 用户服务
     * */
    private UserService userService;

    @SystemLogger("查询全部")
    @Override
    public List<UserVO> queryAll() {
        return BeanCopy.copyList(userService.queryAll(), UserVO.class);
    }

    @SystemLogger(value = "模糊查询用户", page = true)
    @Override
    public List<UserVO> queryFuzzy(UserParam param) {
        List<UserDTO> userDTOList = userService.queryFuzzy(BeanCopy.copy(param, UserDTO.class));

        return BeanCopy.copyListOrPage(userDTOList, UserVO.class);
    }

    @SystemLogger("根据id查询用户")
    @Override
    public UserVO queryById(Long id) {
        return BeanCopy.copy(userService.queryById(id), UserVO.class);
    }

    @SystemLogger("添加用户")
    @Override
    public boolean add(UserDTO dto) {
        return userService.add(dto);
    }

    @SystemLogger("批量添加用户")
    @Override
    public boolean batchAdd(List<UserDTO> dtoList) {
        return userService.batchAdd(dtoList);
    }

    @SystemLogger("修改用户信息")
    @Override
    public boolean modify(UserDTO dto) {
        return userService.modify(dto);
    }

    @SystemLogger("修改密码")
    @Override
    public boolean changePassword(PasswordForm form) {
        if (form == null || form.getUserId() == null) {
            throw PsychologyErrorCode.ID_NOT_AVAILABLE.createException();
        }

        if (form.getOldPassword() == null || form.getNewPassword() == null) {
            throw PsychologyErrorCode.PASSWORD_IS_EMPTY.createException();
        }

        UserDTO userDTO = userService.queryById(form.getUserId());
        if (userDTO == null) {
            throw PsychologyErrorCode.USER_NOT_EXIST.createException();
        }

        String encrypt = CommonTool.encrypt(form.getOldPassword(), userDTO.getSalt());
        if (userDTO.getPassword().equals(encrypt)) {
            userDTO.setPassword(encrypt);
            return userService.modify(userDTO);
        }
        return false;
    }

    @SystemLogger("删除用户")
    @Override
    public boolean remove(UserDTO dto) {
        return userService.remove(dto);
    }

    @SystemLogger("批量删除用户L")
    @Override
    public boolean batchRemove(List<UserDTO> dtoList) {
        return userService.batchRemove(dtoList);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
