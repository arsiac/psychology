package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.UserApi;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.vo.UserVO;
import top.arsiac.psychology.user.centre.service.UserService;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.common.BeanCopy;

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

    @SystemLogger
    @Override
    public List<UserVO> queryAll() {
        return BeanCopy.copyList(userService.queryAll(), UserVO.class);
    }

    @SystemLogger
    @Override
    public List<UserVO> queryFuzzy(UserDTO dto) {
        return BeanCopy.copyList(userService.queryFuzzy(dto), UserVO.class);
    }

    @SystemLogger
    @Override
    public UserVO queryById(Long id) {
        return BeanCopy.copy(userService.queryById(id), UserVO.class);
    }

    @SystemLogger
    @Override
    public boolean add(UserDTO dto) {
        return userService.add(dto);
    }

    @SystemLogger
    @Override
    public boolean batchAdd(List<UserDTO> dtoList) {
        return userService.batchAdd(dtoList);
    }

    @SystemLogger
    @Override
    public boolean modify(UserDTO dto) {
        return userService.modify(dto);
    }

    @SystemLogger
    @Override
    public boolean remove(UserDTO dto) {
        return userService.remove(dto);
    }

    @SystemLogger
    @Override
    public boolean batchRemove(List<UserDTO> dtoList) {
        return userService.batchRemove(dtoList);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}