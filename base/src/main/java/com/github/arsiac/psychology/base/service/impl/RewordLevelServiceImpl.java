package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.RewordLevelDTO;
import com.github.arsiac.psychology.base.pojo.entity.RewordLevelEntity;
import com.github.arsiac.psychology.base.dao.RewordLevelMapper;
import com.github.arsiac.psychology.base.service.RewordLevelService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>获奖等级服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@Service("rewordLevelService")
public class RewordLevelServiceImpl implements RewordLevelService {
    /**
         * 权力 dao
         */
    private RewordLevelMapper rewordLevelMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<RewordLevelDTO> queryAll() {
        return BeanCopy.copyList(rewordLevelMapper.selectAll(), RewordLevelDTO.class);
    }

    @Override
    public List<RewordLevelDTO> queryFuzzy(RewordLevelDTO dto) {
        // dto 为 null 则默认查询全部
        RewordLevelEntity entity;
        if (dto == null) {
            entity = new RewordLevelEntity();
        } else {
            entity = BeanCopy.copy(dto, RewordLevelEntity.class);
        }
        return BeanCopy.copyListOrPage(rewordLevelMapper.selectFuzzy(entity), RewordLevelDTO.class);
    }

    @Override
    public RewordLevelDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(rewordLevelMapper.selectById(id), RewordLevelDTO.class);
    }

    @Override
    public boolean add(RewordLevelDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return rewordLevelMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<RewordLevelDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RewordLevelDTO dto : dtoList) {
            count += rewordLevelMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(RewordLevelDTO dto) {
        checkIdAndVersion(dto);
        return rewordLevelMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(RewordLevelDTO dto) {
        checkIdAndVersion(dto);

        try {
            return rewordLevelMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<RewordLevelDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (RewordLevelDTO dto : dtoList) {
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
    private void checkIdAndVersion(RewordLevelDTO dto) {
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
    public void setRewordLevelMapper(RewordLevelMapper rewordLevelMapper) {
        this.rewordLevelMapper = rewordLevelMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}