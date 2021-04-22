package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.annotation.ClearQueryCache;
import com.github.arsiac.psychology.utils.annotation.QueryCache;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.QueryCacheNameSpace;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.DictionaryTypeDTO;
import com.github.arsiac.psychology.base.pojo.entity.DictionaryTypeEntity;
import com.github.arsiac.psychology.base.dao.DictionaryTypeMapper;
import com.github.arsiac.psychology.base.service.DictionaryTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
@Service("dictionaryTypeService")
public class DictionaryTypeServiceImpl implements DictionaryTypeService {
    /**
         * 权力 dao
         */
    private DictionaryTypeMapper dictionaryTypeMapper;

    @QueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public List<DictionaryTypeDTO> queryAll() {
        return BeanCopy.copyList(dictionaryTypeMapper.selectAll(), DictionaryTypeDTO.class);
    }

    @QueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public List<DictionaryTypeDTO> queryFuzzy(DictionaryTypeDTO dto) {
        // dto 为 null 则默认查询全部
        DictionaryTypeEntity entity;
        if (dto == null) {
            entity = new DictionaryTypeEntity();
        } else {
            entity = BeanCopy.copy(dto, DictionaryTypeEntity.class);
        }
        return dictionaryTypeMapper.selectFuzzy(entity);
    }

    @QueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public DictionaryTypeDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(dictionaryTypeMapper.selectById(id), DictionaryTypeDTO.class);
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public boolean add(DictionaryTypeDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 字典需要自己定义id
        if (dto.getId() == null) {
            throw PsychologyErrorCode.ID_NOT_AVAILABLE.createException();
        }

        // id 是否重复
        if (dictionaryTypeMapper.selectById(dto.getId()) != null) {
            throw PsychologyErrorCode.ID_ALREADY_EXISTS.createException();
        }
        return dictionaryTypeMapper.insert(dto) > 0;
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public boolean batchAdd(List<DictionaryTypeDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (DictionaryTypeDTO dto : dtoList) {
            count += dictionaryTypeMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public boolean modify(DictionaryTypeDTO dto) {
        checkIdAndVersion(dto);
        return dictionaryTypeMapper.update(dto) > 0;
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public boolean remove(DictionaryTypeDTO dto) {
        checkIdAndVersion(dto);

        try {
            return dictionaryTypeMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @ClearQueryCache(QueryCacheNameSpace.BASE_DICTIONARY_TYPE)
    @Override
    public boolean batchRemove(List<DictionaryTypeDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (DictionaryTypeDTO dto : dtoList) {
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
    private void checkIdAndVersion(DictionaryTypeDTO dto) {
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
    public void setDictionaryTypeMapper(DictionaryTypeMapper dictionaryTypeMapper) {
        this.dictionaryTypeMapper = dictionaryTypeMapper;
    }
}