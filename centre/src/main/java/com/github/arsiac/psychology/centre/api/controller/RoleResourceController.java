package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.RoleResourceApi;
import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;
import com.github.arsiac.psychology.centre.pojo.vo.RoleResourceVO;
import com.github.arsiac.psychology.centre.service.RoleResourceService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
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

    @SystemLogger("查询全部")
    @Override
    public List<RoleResourceVO> queryAll() {
        return BeanCopy.copyList(roleResourceService.queryAll(), RoleResourceVO.class);
    }

    @SystemLogger("根据角色id查询")
    @Override
    public List<RoleResourceVO> queryByRoleId(Long id) {
        return BeanCopy.copyList(roleResourceService.queryByRoleId(id), RoleResourceVO.class, this::copy2vo);
    }

    /**
     * <p>复制成vo</p>
     *
     * @param source entity
     * @param target dto
     */
    private void copy2vo(Object source, Object target) {
        RoleResourceDTO dto = (RoleResourceDTO) source;
        RoleResourceVO vo = (RoleResourceVO) target;

        if (dto.getResourceEntity() != null) {
            vo.setResourceName(dto.getResourceEntity().getName());
        }
    }

    @SystemLogger("根据资源id查询")
    @Override
    public List<RoleResourceVO> queryByResourceId(Long id) {
        return BeanCopy.copyList(roleResourceService.queryByResourceId(id), RoleResourceVO.class);
    }

    @SystemLogger("添加角色-资源")
    @Override
    public boolean add(RoleResourceDTO dto) {
        return roleResourceService.add(dto);
    }

    @SystemLogger("批量添加角色-资源")
    @Override
    public boolean batchAdd(List<RoleResourceDTO> dtoList) {
        return roleResourceService.batchAdd(dtoList);
    }

    @SystemLogger("修改角色-资源")
    @Override
    public boolean modify(RoleResourceDTO dto) {
        return roleResourceService.modify(dto);
    }

    @SystemLogger("删除角色-资源")
    @Override
    public boolean remove(RoleResourceDTO dto) {
        return roleResourceService.remove(dto);
    }

    @SystemLogger("批量删除角色-资源")
    @Override
    public boolean batchRemove(List<RoleResourceDTO> dtoList) {
        return roleResourceService.batchRemove(dtoList);
    }

    @Autowired
    public void setRoleResourceService(RoleResourceService roleResourceService) {
        this.roleResourceService = roleResourceService;
    }
}
