package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.ResourceApi;
import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;
import com.github.arsiac.psychology.centre.pojo.vo.ResourceVO;
import com.github.arsiac.psychology.centre.service.ResourceService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>资源业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/5
 */
@RestController
public class ResourceController implements ResourceApi {
    /**
     * 资源服务
     * */
    private ResourceService resourceService;

    @SystemLogger
    @Override
    public List<ResourceVO> queryAll() {
        return BeanCopy.copyList(resourceService.queryAll(), ResourceVO.class);
    }

    @SystemLogger
    @Override
    public List<ResourceVO> queryFuzzy(ResourceDTO dto) {
        return BeanCopy.copyList(resourceService.queryFuzzy(dto), ResourceVO.class);
    }

    @SystemLogger
    @Override
    public ResourceVO queryById(Long id) {
        return BeanCopy.copy(resourceService.queryById(id), ResourceVO.class);
    }

    @SystemLogger
    @Override
    public boolean add(ResourceDTO dto) {
        return resourceService.add(dto);
    }

    @SystemLogger
    @Override
    public boolean batchAdd(List<ResourceDTO> dtoList) {
        return resourceService.batchAdd(dtoList);
    }

    @SystemLogger
    @Override
    public boolean modify(ResourceDTO dto) {
        return resourceService.modify(dto);
    }

    @SystemLogger
    @Override
    public boolean remove(ResourceDTO dto) {
        return resourceService.remove(dto);
    }

    @SystemLogger
    @Override
    public boolean batchRemove(List<ResourceDTO> dtoList) {
        return resourceService.batchRemove(dtoList);
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
