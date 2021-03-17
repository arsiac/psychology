package com.github.arsiac.psychology.manager.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.manager.pojo.dto.PaperDTO;
import com.github.arsiac.psychology.manager.pojo.entity.PaperEntity;
import com.github.arsiac.psychology.manager.dao.PaperMapper;
import com.github.arsiac.psychology.manager.service.PaperService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {
    /**
         * 权力 dao
         */
    private PaperMapper paperMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<PaperDTO> queryAll() {
        return BeanCopy.copyList(paperMapper.selectAll(), PaperDTO.class);
    }

    @Override
    public List<PaperDTO> queryFuzzy(PaperDTO dto) {
        // dto 为 null 则默认查询全部
        PaperEntity entity;
        if (dto == null) {
            entity = new PaperEntity();
        } else {
            entity = BeanCopy.copy(dto, PaperEntity.class);
        }
        return paperMapper.selectFuzzy(entity);
    }

    @Override
    public PaperDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(paperMapper.selectById(id), PaperDTO.class);
    }

    @Override
    public boolean add(PaperDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return paperMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<PaperDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PaperDTO dto : dtoList) {
            count += paperMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(PaperDTO dto) {
        checkIdAndVersion(dto);
        return paperMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(PaperDTO dto) {
        checkIdAndVersion(dto);

        try {
            return paperMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<PaperDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (PaperDTO dto : dtoList) {
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
    private void checkIdAndVersion(PaperDTO dto) {
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
    public void setPaperMapper(PaperMapper paperMapper) {
        this.paperMapper = paperMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}