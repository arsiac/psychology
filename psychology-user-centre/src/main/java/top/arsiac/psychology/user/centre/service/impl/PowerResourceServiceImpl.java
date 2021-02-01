package top.arsiac.psychology.user.centre.service.impl;

import org.springframework.transaction.annotation.Transactional;
import top.arsiac.psychology.user.centre.pojo.dto.PowerResourceDTO;
import top.arsiac.psychology.user.centre.dao.PowerResourceMapper;
import top.arsiac.psychology.user.centre.service.PowerResourceService;
import top.arsiac.psychology.utils.common.IdGenerator;
import top.arsiac.psychology.utils.common.BeanCopy;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>权力-资源业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class PowerResourceServiceImpl implements PowerResourceService {
    /**
     * 权力资源 dao
     * */
    private PowerResourceMapper powerResourceMapper;

    /**
     * id 生成器
     * */
    private IdGenerator idGenerator;

    @Override
    public List<PowerResourceDTO> queryAll() {
        return BeanCopy.copyList(powerResourceMapper.selectAll(), PowerResourceDTO.class);
    }

    @Override
    public List<PowerResourceDTO> queryByPowerId(Long id) {
        if (id == null) {
            return new ArrayList<>(0);
        }

        return BeanCopy.copyList(powerResourceMapper.selectByPowerId(id), PowerResourceDTO.class);
    }

    @Override
    public List<PowerResourceDTO> queryByResourceId(Long id) {
        return BeanCopy.copyList(powerResourceMapper.selectByResourceId(id), PowerResourceDTO.class);
    }

    @Override
    public boolean add(PowerResourceDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return powerResourceMapper.insert(dto) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchAdd(List<PowerResourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PowerResourceDTO dto : dtoList) {
            count += powerResourceMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(PowerResourceDTO dto) {
        checkIdAndVersion(dto);
        return powerResourceMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(PowerResourceDTO dto) {
        checkIdAndVersion(dto);
        try {
            return powerResourceMapper.delete(dto.getId(), dto.getVersion()) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.DELETE_FAILED.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<PowerResourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PowerResourceDTO dto : dtoList) {
            count += powerResourceMapper.delete(dto.getId(), dto.getVersion());
        }

        // true 则为全部删除成功
        // false 则为部分删除失败
        return count == dtoList.size();
    }

    /**
     * <p>检查dto的id和version</p>
     *
     * @param dto 要被检查的对象
     * */
    private void checkIdAndVersion(PowerResourceDTO dto) {
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
    public void setPowerResourceMapper(PowerResourceMapper powerResourceMapper) {
        this.powerResourceMapper = powerResourceMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
