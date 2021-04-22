package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.annotation.ClearQueryCache;
import com.github.arsiac.psychology.utils.annotation.QueryCache;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.common.QueryCacheNameSpace;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.DictionaryDTO;
import com.github.arsiac.psychology.base.pojo.entity.DictionaryEntity;
import com.github.arsiac.psychology.base.dao.DictionaryMapper;
import com.github.arsiac.psychology.base.service.DictionaryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    /**
         * 权力 dao
         */
    private DictionaryMapper dictionaryMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @QueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public List<DictionaryDTO> queryAll() {
        return BeanCopy.copyList(dictionaryMapper.selectAll(), DictionaryDTO.class);
    }

    @QueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public List<DictionaryDTO> queryFuzzy(DictionaryDTO dto) {
        // dto 为 null 则默认查询全部
        DictionaryEntity entity;
        if (dto == null) {
            entity = new DictionaryEntity();
        } else {
            entity = BeanCopy.copy(dto, DictionaryEntity.class);
        }
        return BeanCopy.copyListOrPage(dictionaryMapper.selectFuzzy(entity), DictionaryDTO.class);
    }

    @QueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public DictionaryDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(dictionaryMapper.selectById(id), DictionaryDTO.class);
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public boolean add(DictionaryDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }

        dto.setId(idGenerator.generate());
        return dictionaryMapper.insert(dto) > 0;
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public boolean batchAdd(List<DictionaryDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (DictionaryDTO dto : dtoList) {
            count += dictionaryMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public boolean modify(DictionaryDTO dto) {
        checkIdAndVersion(dto);
        return dictionaryMapper.update(dto) > 0;
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public boolean remove(DictionaryDTO dto) {
        checkIdAndVersion(dto);

        try {
            return dictionaryMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY)
    @Override
    public boolean batchRemove(List<DictionaryDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (DictionaryDTO dto : dtoList) {
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
    private void checkIdAndVersion(DictionaryDTO dto) {
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
    public void setDictionaryMapper(DictionaryMapper dictionaryMapper) {
        this.dictionaryMapper = dictionaryMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}