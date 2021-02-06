package top.arsiac.psychology.user.centre.service.impl;

import org.springframework.stereotype.Service;
import top.arsiac.psychology.user.centre.pojo.dto.PowerDTO;
import top.arsiac.psychology.user.centre.pojo.entity.PowerEntity;
import top.arsiac.psychology.user.centre.dao.PowerMapper;
import top.arsiac.psychology.user.centre.service.PowerService;
import top.arsiac.psychology.utils.common.IdGenerator;
import top.arsiac.psychology.utils.common.BeanCopy;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>权力业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/1/31
 */
@Service
public class PowerServiceImpl implements PowerService {
    /**
     * 权力 dao
     */
    private PowerMapper powerMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

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
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return powerMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<PowerDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PowerDTO dto : dtoList) {
            count += powerMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(PowerDTO dto) {
        checkIdAndVersion(dto);
        return powerMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(PowerDTO dto) {
        checkIdAndVersion(dto);
        return powerMapper.delete(dto.getId(), dto.getVersion()) > 0;
    }

    @Override
    public boolean batchRemove(List<PowerDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PowerDTO dto : dtoList) {
            count += powerMapper.delete(dto.getId(), dto.getVersion());
        }

        // true 则为全部删除成功
        // false 则为部分删除失败
        return count == dtoList.size();
    }

    /**
     * <p>检查dto的id和version</p>
     *
     * @param dto 要被检查的对象
     */
    private void checkIdAndVersion(PowerDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        if (dto.getId() == null) {
            throw PsychologyErrorCode.ID_NOT_AVAILABLE.createException();
        }
        if (dto.getVersion() == null) {
            throw PsychologyErrorCode.VERSION_NOT_AVAILABLE.createException();
        }
    }

    @Resource
    public void setPowerMapper(PowerMapper powerMapper) {
        this.powerMapper = powerMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
