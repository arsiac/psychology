package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.ResourceApi;
import top.arsiac.psychology.user.centre.pojo.dto.ResourceDTO;
import top.arsiac.psychology.user.centre.pojo.vo.ResourceVO;
import top.arsiac.psychology.user.centre.service.ResourceService;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.common.BeanCopy;

import java.security.interfaces.RSAKey;
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
