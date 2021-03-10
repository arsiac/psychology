package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.TitleDTO;
import com.github.arsiac.psychology.base.pojo.entity.TitleEntity;
import com.github.arsiac.psychology.base.dao.TitleMapper;
import com.github.arsiac.psychology.base.service.TitleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>职称服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Service("titleService")
public class TitleServiceImpl implements TitleService {
    /**
         * 权力 dao
         */
    private TitleMapper titleMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<TitleDTO> queryAll() {
        return BeanCopy.copyList(titleMapper.selectAll(), TitleDTO.class);
    }

    @Override
    public List<TitleDTO> queryFuzzy(TitleDTO dto) {
        // dto 为 null 则默认查询全部
        TitleEntity entity;
        if (dto == null) {
            entity = new TitleEntity();
        } else {
            entity = BeanCopy.copy(dto, TitleEntity.class);
        }
        return BeanCopy.copyListOrPage(titleMapper.selectFuzzy(entity), TitleDTO.class);
    }

    @Override
    public TitleDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(titleMapper.selectById(id), TitleDTO.class);
    }

    @Override
    public boolean add(TitleDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return titleMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<TitleDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (TitleDTO dto : dtoList) {
            count += titleMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(TitleDTO dto) {
        checkIdAndVersion(dto);
        return titleMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(TitleDTO dto) {
        checkIdAndVersion(dto);

        try {
            return titleMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<TitleDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (TitleDTO dto : dtoList) {
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
    private void checkIdAndVersion(TitleDTO dto) {
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
    public void setTitleMapper(TitleMapper titleMapper) {
        this.titleMapper = titleMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}