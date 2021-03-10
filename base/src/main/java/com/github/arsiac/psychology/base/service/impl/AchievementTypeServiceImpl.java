package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.AchievementTypeDTO;
import com.github.arsiac.psychology.base.pojo.entity.AchievementTypeEntity;
import com.github.arsiac.psychology.base.dao.AchievementTypeMapper;
import com.github.arsiac.psychology.base.service.AchievementTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>成果形式服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@Service("achievementTypeService")
public class AchievementTypeServiceImpl implements AchievementTypeService {
    /**
         * 权力 dao
         */
    private AchievementTypeMapper achievementTypeMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<AchievementTypeDTO> queryAll() {
        return BeanCopy.copyList(achievementTypeMapper.selectAll(), AchievementTypeDTO.class);
    }

    @Override
    public List<AchievementTypeDTO> queryFuzzy(AchievementTypeDTO dto) {
        // dto 为 null 则默认查询全部
        AchievementTypeEntity entity;
        if (dto == null) {
            entity = new AchievementTypeEntity();
        } else {
            entity = BeanCopy.copy(dto, AchievementTypeEntity.class);
        }
        return BeanCopy.copyListOrPage(achievementTypeMapper.selectFuzzy(entity), AchievementTypeDTO.class);
    }

    @Override
    public AchievementTypeDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(achievementTypeMapper.selectById(id), AchievementTypeDTO.class);
    }

    @Override
    public boolean add(AchievementTypeDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return achievementTypeMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<AchievementTypeDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (AchievementTypeDTO dto : dtoList) {
            count += achievementTypeMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(AchievementTypeDTO dto) {
        checkIdAndVersion(dto);
        return achievementTypeMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(AchievementTypeDTO dto) {
        checkIdAndVersion(dto);

        try {
            return achievementTypeMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<AchievementTypeDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (AchievementTypeDTO dto : dtoList) {
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
    private void checkIdAndVersion(AchievementTypeDTO dto) {
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
    public void setAchievementTypeMapper(AchievementTypeMapper achievementTypeMapper) {
        this.achievementTypeMapper = achievementTypeMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}