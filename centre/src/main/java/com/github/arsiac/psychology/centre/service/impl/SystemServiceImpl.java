package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.centre.pojo.dto.RoleResourceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.dao.ResourceMapper;
import com.github.arsiac.psychology.centre.dao.RoleResourceMapper;
import com.github.arsiac.psychology.centre.dao.UserRoleMapper;
import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;
import com.github.arsiac.psychology.centre.pojo.entity.*;
import com.github.arsiac.psychology.centre.service.SystemService;
import com.github.arsiac.psychology.utils.common.BeanCopy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>系统资源服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/24
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {
    /**
     * 用户-角色服务
     * */
    private UserRoleMapper userRoleMapper;

    /**
     * 角色-资源服务
     * */
    private RoleResourceMapper roleResourceMapper;

    /**
     * 资源服务
     * */
    private ResourceMapper resourceMapper;

    @Override
    public List<ResourceDTO> queryResourceByUserId(Long id) {
        // 查询用户对应的角色
        List<UserRoleEntity> userRoleEntityList = userRoleMapper.selectByUserId(id);

        // 查询角色对应的资源
        Set<Long> resourceSet = new HashSet<>();
        userRoleEntityList.forEach(userRole -> {
            // 获取角色对应的资源
            List<RoleResourceDTO> roleResourceDTOList = roleResourceMapper.selectByRoleId(userRole.getRoleId());

            // 将资源放入set
            roleResourceDTOList.forEach(roleResource -> resourceSet.add(roleResource.getResourceId()));
        });

        List<ResourceEntity> resourceEntityList;
        // 为空就不执行搜索，防止报错
        if (resourceSet.isEmpty()) {
            resourceEntityList = new ArrayList<>(0);
        } else {
            resourceEntityList = resourceMapper.selectIn(resourceSet);
        }
        return BeanCopy.copyList(resourceEntityList, ResourceDTO.class);
    }

    @Autowired
    public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Autowired
    public void setRolePowerMapper(RoleResourceMapper roleResourceMapper) {
        this.roleResourceMapper = roleResourceMapper;
    }

    @Autowired
    public void setResourceMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }
}
