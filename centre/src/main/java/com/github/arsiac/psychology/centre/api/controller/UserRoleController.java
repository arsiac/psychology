package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.UserRoleApi;
import com.github.arsiac.psychology.centre.pojo.dto.UserRoleDTO;
import com.github.arsiac.psychology.centre.pojo.vo.UserRoleVO;
import com.github.arsiac.psychology.centre.service.UserRoleService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>用户-角色业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/6
 */
@RestController
public class UserRoleController implements UserRoleApi {
    /**
     * 用户-角色服务
     * */
    private UserRoleService userRoleService;

    @SystemLogger("查询全部用户的角色")
    @Override
    public List<UserRoleVO> queryAll() {
        return BeanCopy.copyList(userRoleService.queryAll(), UserRoleVO.class);
    }

    @SystemLogger("根据角色id查询")
    @Override
    public List<UserRoleVO> queryByRoleId(Long id) {
        return BeanCopy.copyList(userRoleService.queryByRoleId(id), UserRoleVO.class);
    }

    @SystemLogger("根据用户id查询")
    @Override
    public List<UserRoleVO> queryByUserId(Long id) {
        return BeanCopy.copyList(userRoleService.queryByUserId(id), UserRoleVO.class);
    }

    @SystemLogger("增加用户的角色")
    @Override
    public boolean add(UserRoleDTO dto) {
        return userRoleService.add(dto);
    }

    @SystemLogger("批量增加用户的角色")
    @Override
    public boolean batchAdd(List<UserRoleDTO> dtoList) {
        return userRoleService.batchAdd(dtoList);
    }

    @SystemLogger("修改用户的角色")
    @Override
    public boolean modify(UserRoleDTO dto) {
        return userRoleService.modify(dto);
    }

    @SystemLogger("删除用户的角色")
    @Override
    public boolean remove(UserRoleDTO dto) {
        return userRoleService.remove(dto);
    }

    @SystemLogger("批量删除用户的角色")
    @Override
    public boolean batchRemove(List<UserRoleDTO> dtoList) {
        return userRoleService.batchRemove(dtoList);
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
