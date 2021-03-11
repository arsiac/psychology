package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.PaperLevelDTO;
import com.github.arsiac.psychology.base.pojo.entity.PaperLevelEntity;
import com.github.arsiac.psychology.base.dao.PaperLevelMapper;
import com.github.arsiac.psychology.base.service.PaperLevelService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>论文级别服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 20:59:39
 */
@Service("paperLevelService")
public class PaperLevelServiceImpl implements PaperLevelService {
    /**
         * 权力 dao
         */
    private PaperLevelMapper paperLevelMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<PaperLevelDTO> queryAll() {
        return BeanCopy.copyList(paperLevelMapper.selectAll(), PaperLevelDTO.class);
    }

    @Override
    public List<PaperLevelDTO> queryFuzzy(PaperLevelDTO dto) {
        // dto 为 null 则默认查询全部
        PaperLevelEntity entity;
        if (dto == null) {
            entity = new PaperLevelEntity();
        } else {
            entity = BeanCopy.copy(dto, PaperLevelEntity.class);
        }
        return BeanCopy.copyListOrPage(paperLevelMapper.selectFuzzy(entity), PaperLevelDTO.class);
    }

    @Override
    public PaperLevelDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(paperLevelMapper.selectById(id), PaperLevelDTO.class);
    }

    @Override
    public boolean add(PaperLevelDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return paperLevelMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<PaperLevelDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PaperLevelDTO dto : dtoList) {
            count += paperLevelMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(PaperLevelDTO dto) {
        checkIdAndVersion(dto);
        return paperLevelMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(PaperLevelDTO dto) {
        checkIdAndVersion(dto);

        try {
            return paperLevelMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<PaperLevelDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PaperLevelDTO dto : dtoList) {
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
    private void checkIdAndVersion(PaperLevelDTO dto) {
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
    public void setPaperLevelMapper(PaperLevelMapper paperLevelMapper) {
        this.paperLevelMapper = paperLevelMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}