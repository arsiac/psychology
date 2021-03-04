package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.ResourceApi;
import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;
import com.github.arsiac.psychology.centre.pojo.form.param.ResourceParam;
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

    @SystemLogger("查找全部资源")
    @Override
    public List<ResourceVO> queryAll() {
        return BeanCopy.copyList(resourceService.queryAll(), ResourceVO.class);
    }

    @SystemLogger(value = "模糊查询", page = true)
    @Override
    public List<ResourceVO> queryFuzzy(ResourceParam param) {
        return BeanCopy.copyListOrPage(resourceService.queryFuzzy(BeanCopy.copy(param, ResourceDTO.class)), ResourceVO.class);
    }

    @SystemLogger("使用id查询")
    @Override
    public ResourceVO queryById(Long id) {
        return BeanCopy.copy(resourceService.queryById(id), ResourceVO.class);
    }

    @SystemLogger("新增")
    @Override
    public boolean add(ResourceDTO dto) {
        return resourceService.add(dto);
    }

    @SystemLogger("批量新增")
    @Override
    public boolean batchAdd(List<ResourceDTO> dtoList) {
        return resourceService.batchAdd(dtoList);
    }

    @SystemLogger("修改")
    @Override
    public boolean modify(ResourceDTO dto) {
        return resourceService.modify(dto);
    }

    @SystemLogger("删除")
    @Override
    public boolean remove(ResourceDTO dto) {
        return resourceService.remove(dto);
    }

    @SystemLogger("批量删除")
    @Override
    public boolean batchRemove(List<ResourceDTO> dtoList) {
        return resourceService.batchRemove(dtoList);
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
