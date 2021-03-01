package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.RoleResourceApi;
import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;
import com.github.arsiac.psychology.centre.pojo.vo.RoleResourceVO;
import com.github.arsiac.psychology.centre.service.RoleResourceService;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>角色-资源接口实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/25
 */
@RestController
public class RoleResourceController implements RoleResourceApi {
    /**
     * 角色-资源服务
     * */
    private RoleResourceService roleResourceService;

    @Override
    public List<RoleResourceVO> queryAll() {
        return BeanCopy.copyList(roleResourceService.queryAll(), RoleResourceVO.class);
    }

    @Override
    public List<RoleResourceVO> queryByRoleId(Long id) {
        return BeanCopy.copyList(roleResourceService.queryByRoleId(id), RoleResourceVO.class);
    }

    @Override
    public List<RoleResourceVO> queryByResourceId(Long id) {
        return BeanCopy.copyList(roleResourceService.queryByResourceId(id), RoleResourceVO.class);
    }

    @Override
    public boolean add(RoleResourceDTO dto) {
        return roleResourceService.add(dto);
    }

    @Override
    public boolean batchAdd(List<RoleResourceDTO> dtoList) {
        return roleResourceService.batchAdd(dtoList);
    }

    @Override
    public boolean modify(RoleResourceDTO dto) {
        return roleResourceService.modify(dto);
    }

    @Override
    public boolean remove(RoleResourceDTO dto) {
        return roleResourceService.remove(dto);
    }

    @Override
    public boolean batchRemove(List<RoleResourceDTO> dtoList) {
        return roleResourceService.batchRemove(dtoList);
    }

    @Autowired
    public void setRoleResourceService(RoleResourceService roleResourceService) {
        this.roleResourceService = roleResourceService;
    }
}
