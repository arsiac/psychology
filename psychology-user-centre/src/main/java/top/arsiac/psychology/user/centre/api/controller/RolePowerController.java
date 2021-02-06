package top.arsiac.psychology.user.centre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.arsiac.psychology.user.centre.api.RolePowerApi;
import top.arsiac.psychology.user.centre.pojo.dto.RolePowerDTO;
import top.arsiac.psychology.user.centre.pojo.vo.RolePowerVO;
import top.arsiac.psychology.user.centre.service.RolePowerService;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.common.BeanCopy;

import java.util.List;

/**
 * <p>角色-权力业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/6
 */
@RestController
public class RolePowerController implements RolePowerApi {
    /**
     * 角色-权力服务
     * */
    private RolePowerService rolePowerService;

    @SystemLogger
    @Override
    public List<RolePowerVO> queryAll() {
        return BeanCopy.copyList(rolePowerService.queryAll(), RolePowerVO.class);
    }

    @SystemLogger
    @Override
    public List<RolePowerVO> queryByRoleId(Long id) {
        return BeanCopy.copyList(rolePowerService.queryByRoleId(id), RolePowerVO.class);
    }

    @SystemLogger
    @Override
    public List<RolePowerVO> queryByPowerId(Long id) {
        return BeanCopy.copyList(rolePowerService.queryByPowerId(id), RolePowerVO.class);
    }

    @SystemLogger
    @Override
    public boolean add(RolePowerDTO dto) {
        return rolePowerService.add(dto);
    }

    @SystemLogger
    @Override
    public boolean batchAdd(List<RolePowerDTO> dtoList) {
        return rolePowerService.batchAdd(dtoList);
    }

    @SystemLogger
    @Override
    public boolean modify(RolePowerDTO dto) {
        return rolePowerService.modify(dto);
    }

    @SystemLogger
    @Override
    public boolean remove(RolePowerDTO dto) {
        return rolePowerService.remove(dto);
    }

    @SystemLogger
    @Override
    public boolean batchRemove(List<RolePowerDTO> dtoList) {
        return rolePowerService.batchRemove(dtoList);
    }

    @Autowired
    public void setRolePowerService(RolePowerService rolePowerService) {
        this.rolePowerService = rolePowerService;
    }
}
