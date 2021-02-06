package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.PowerResourceApi;
import top.arsiac.psychology.user.centre.pojo.dto.PowerResourceDTO;
import top.arsiac.psychology.user.centre.pojo.vo.PowerResourceVO;
import top.arsiac.psychology.user.centre.service.PowerResourceService;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.common.BeanCopy;

import java.util.List;

/**
 * <p>权力-资源业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/5
 */
@RestController
public class PowerResourceController implements PowerResourceApi {
    /**
     * 权力-资源服务
     * */
    private PowerResourceService powerResourceService;

    @SystemLogger
    @Override
    public List<PowerResourceVO> queryAll() {
        return BeanCopy.copyList(powerResourceService.queryAll(), PowerResourceVO.class);
    }

    @SystemLogger
    @Override
    public List<PowerResourceVO> queryByResourceId(Long id) {
        return BeanCopy.copyList(powerResourceService.queryByResourceId(id), PowerResourceVO.class);
    }

    @SystemLogger
    @Override
    public List<PowerResourceVO> queryByPowerId(Long id) {
        return BeanCopy.copyList(powerResourceService.queryByPowerId(id), PowerResourceVO.class);
    }

    @SystemLogger
    @Override
    public boolean add(PowerResourceDTO dto) {
        return powerResourceService.add(dto);
    }

    @SystemLogger
    @Override
    public boolean batchAdd(List<PowerResourceDTO> dtoList) {
        return powerResourceService.batchAdd(dtoList);
    }

    @SystemLogger
    @Override
    public boolean modify(PowerResourceDTO dto) {
        return powerResourceService.modify(dto);
    }

    @SystemLogger
    @Override
    public boolean remove(PowerResourceDTO dto) {
        return powerResourceService.remove(dto);
    }

    @SystemLogger
    @Override
    public boolean batchRemove(List<PowerResourceDTO> dtoList) {
        return powerResourceService.batchRemove(dtoList);
    }

    @Autowired
    public void setPowerResourceService(PowerResourceService powerResourceService) {
        this.powerResourceService = powerResourceService;
    }
}
