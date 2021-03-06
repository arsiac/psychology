package com.github.arsiac.psychology.centre.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;
import com.github.arsiac.psychology.centre.pojo.entity.ResourceEntity;
import com.github.arsiac.psychology.centre.dao.ResourceMapper;
import com.github.arsiac.psychology.centre.service.ResourceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>资源业务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/1/31
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    /**
     * 权力 dao
     */
    private ResourceMapper resourceMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<ResourceDTO> queryAll() {
        return BeanCopy.copyList(resourceMapper.selectAll(), ResourceDTO.class);
    }

    @Override
    public List<ResourceDTO> queryFuzzy(ResourceDTO dto) {
        // dto 为 null 则默认查询全部
        ResourceEntity entity;
        if (dto == null) {
            entity = new ResourceEntity();
        } else {
            entity = BeanCopy.copy(dto, ResourceEntity.class);
        }
        return resourceMapper.selectFuzzy(entity);
    }

    @Override
    public ResourceDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(resourceMapper.selectById(id), ResourceDTO.class);
    }

    @Override
    public boolean add(ResourceDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return resourceMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<ResourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (ResourceDTO dto : dtoList) {
            count += resourceMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(ResourceDTO dto) {
        checkIdAndVersion(dto);
        return resourceMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(ResourceDTO dto) {
        checkIdAndVersion(dto);

        try {
            return resourceMapper.delete(dto.getId(), dto.getVersion()) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<ResourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (ResourceDTO dto : dtoList) {
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
    private void checkIdAndVersion(ResourceDTO dto) {
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
    public void setResourceMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
