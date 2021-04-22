package com.github.arsiac.psychology.centre.service.impl;

import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.dao.ResourceMapper;
import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;
import com.github.arsiac.psychology.centre.service.SystemService;

import javax.annotation.Resource;
import java.util.List;

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
     * 资源服务
     * */
    private ResourceMapper resourceMapper;

    @Override
    public List<ResourceDTO> queryResourceByUserId(Long id) {
       return resourceMapper.selectByUserId(id);
    }

    @Resource
    public void setResourceMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }
}
