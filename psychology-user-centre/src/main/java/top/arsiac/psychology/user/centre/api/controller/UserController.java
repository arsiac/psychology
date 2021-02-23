package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.UserApi;
import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;
import top.arsiac.psychology.user.centre.pojo.form.param.UserParam;
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
