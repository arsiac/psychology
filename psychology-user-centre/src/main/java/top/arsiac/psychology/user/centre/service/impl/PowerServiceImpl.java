package top.arsiac.psychology.user.centre.service.impl;

import top.arsiac.psychology.user.centre.dao.dto.PowerDTO;
import top.arsiac.psychology.user.centre.dao.entity.PowerEntity;
import top.arsiac.psychology.user.centre.dao.mapper.PowerMapper;
import top.arsiac.psychology.user.centre.service.PowerService;
import top.arsiac.psychology.utils.common.BeanCopy;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>权力业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class PowerServiceImpl implements PowerService {
    /**
     * 权力 dao
     * */
    private PowerMapper powerMapper;

    @Override
    public List<PowerDTO> queryAll() {
        return BeanCopy.copyList(powerMapper.selectAll(), PowerDTO.class);
    }

    @Override
    public List<PowerDTO> queryFuzzy(PowerDTO dto) {
        // dto 为 null 则默认查询全部
        PowerEntity entity;
        if (dto == null) {
            entity = new PowerEntity();
        } else {
            entity = BeanCopy.copy(dto, PowerEntity.class);
        }
        return BeanCopy.copyList(powerMapper.selectFuzzy(entity), PowerDTO.class);
    }

    @Override
    public PowerDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(powerMapper.selectById(id), PowerDTO.class);
    }

    @Override
    public boolean add(PowerDTO dto) {
        return false;
    }

    @Override
    public boolean batchAdd(List<PowerDTO> dtoList) {
        return false;
    }

    @Override
    public boolean modify(PowerDTO dto) {
        return false;
    }

    @Override
    public boolean remove(PowerDTO dto) {
        return false;
    }

    @Override
    public boolean batchRemove(List<PowerDTO> dtoList) {
        return false;
    }

    @Resource
    public void setPowerMapper(PowerMapper powerMapper) {
        this.powerMapper = powerMapper;
    }
}
