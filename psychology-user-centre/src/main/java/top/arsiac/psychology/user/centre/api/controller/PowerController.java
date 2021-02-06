package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.PowerApi;
import top.arsiac.psychology.user.centre.pojo.dto.PowerDTO;
import top.arsiac.psychology.user.centre.pojo.vo.PowerVO;
import top.arsiac.psychology.user.centre.service.PowerService;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.common.BeanCopy;

import java.util.List;

/**
 * <p>权力业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/5
 */
@RestController
public class PowerController implements PowerApi {
    /**
     * 权力服务
     * */
    private PowerService powerService;
    
    @SystemLogger
    @Override
    public List<PowerVO> queryAll() {
        return BeanCopy.copyList(powerService.queryAll(), PowerVO.class);
    }

    @SystemLogger
    @Override
    public List<PowerVO> queryFuzzy(PowerDTO dto) {
        return BeanCopy.copyList(powerService.queryFuzzy(dto), PowerVO.class);
    }

    @SystemLogger
    @Override
    public PowerVO queryById(Long id) {
        return BeanCopy.copy(powerService.queryById(id), PowerVO.class);
    }

    @SystemLogger
    @Override
    public boolean add(PowerDTO dto) {
        return powerService.add(dto);
    }

    @SystemLogger
    @Override
    public boolean batchAdd(List<PowerDTO> dtoList) {
        return powerService.batchAdd(dtoList);
    }

    @SystemLogger
    @Override
    public boolean modify(PowerDTO dto) {
        return powerService.modify(dto);
    }

    @Override
    public boolean remove(PowerDTO dto) {
        return powerService.remove(dto);
    }

    @SystemLogger
    @Override
    public boolean batchRemove(List<PowerDTO> dtoList) {
        return powerService.batchRemove(dtoList);
    }

    @Autowired
    public void setPowerService(PowerService powerService) {
        this.powerService = powerService;
    }
}
