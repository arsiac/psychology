package com.github.arsiac.psychology.manager.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.manager.pojo.dto.OpusDTO;
import com.github.arsiac.psychology.manager.pojo.entity.OpusEntity;
import com.github.arsiac.psychology.manager.dao.OpusMapper;
import com.github.arsiac.psychology.manager.service.OpusService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@Service("opusService")
public class OpusServiceImpl implements OpusService {
    /**
         * 权力 dao
         */
    private OpusMapper opusMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<OpusDTO> queryAll() {
        return BeanCopy.copyList(opusMapper.selectAll(), OpusDTO.class);
    }

    @Override
    public List<OpusDTO> queryFuzzy(OpusDTO dto) {
        // dto 为 null 则默认查询全部
        OpusEntity entity;
        if (dto == null) {
            entity = new OpusEntity();
        } else {
            entity = BeanCopy.copy(dto, OpusEntity.class);
        }
        return opusMapper.selectFuzzy(entity);
    }

    @Override
    public OpusDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(opusMapper.selectById(id), OpusDTO.class);
    }

    @Override
    public boolean add(OpusDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return opusMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<OpusDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (OpusDTO dto : dtoList) {
            count += opusMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(OpusDTO dto) {
        checkIdAndVersion(dto);
        return opusMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(OpusDTO dto) {
        checkIdAndVersion(dto);

        try {
            return opusMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<OpusDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (OpusDTO dto : dtoList) {
            count += remove(dto) ? 1 : 0;
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
    private void checkIdAndVersion(OpusDTO dto) {
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
    public void setOpusMapper(OpusMapper opusMapper) {
        this.opusMapper = opusMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}