package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.RoleApi;
import com.github.arsiac.psychology.centre.pojo.dto.RoleDTO;
import com.github.arsiac.psychology.centre.pojo.form.param.RoleParam;
import com.github.arsiac.psychology.centre.pojo.vo.RoleVO;
import com.github.arsiac.psychology.centre.service.RoleService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>角色业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/5
 */
@RestController
public class RoleController implements RoleApi {
    /**
     * 角色服务
     * */
    private RoleService roleService;

    @SystemLogger("查询全部角色")
    @Override
    public List<RoleVO> queryAll() {
        return BeanCopy.copyList(roleService.queryAll(), RoleVO.class);
    }

    @SystemLogger(value = "模糊查询角色", page = true)
    @Override
    public List<RoleVO> queryFuzzy(RoleParam param) {
        return BeanCopy.copyListOrPage(roleService.queryFuzzy(BeanCopy.copy(param, RoleDTO.class)), RoleVO.class);
    }

    @SystemLogger("根据id查询角色")
    @Override
    public RoleVO queryById(Long id) {
        return BeanCopy.copy(roleService.queryById(id), RoleVO.class);
    }

    @SystemLogger("添加角色")
    @Override
    public boolean add(RoleDTO dto) {
        return roleService.add(dto);
    }

    @SystemLogger("批量添加角色")
    @Override
    public boolean batchAdd(List<RoleDTO> dtoList) {
        return roleService.batchAdd(dtoList);
    }

    @SystemLogger("修改角色")
    @Override
    public boolean modify(RoleDTO dto) {
        return roleService.modify(dto);
    }

    @SystemLogger("删除角色")
    @Override
    public boolean remove(RoleDTO dto) {
        return roleService.remove(dto);
    }

    @SystemLogger("批量删除角色")
    @Override
    public boolean batchRemove(List<RoleDTO> dtoList) {
        return roleService.batchRemove(dtoList);
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
