package com.github.arsiac.psychology.manager.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.manager.pojo.dto.AchievementDTO;
import com.github.arsiac.psychology.manager.pojo.entity.AchievementEntity;
import com.github.arsiac.psychology.manager.dao.AchievementMapper;
import com.github.arsiac.psychology.manager.service.AchievementService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>成果服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {
    /**
         * 权力 dao
         */
    private AchievementMapper achievementMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<AchievementDTO> queryAll() {
        return BeanCopy.copyList(achievementMapper.selectAll(), AchievementDTO.class);
    }

    @Override
    public List<AchievementDTO> queryFuzzy(AchievementDTO dto) {
        // dto 为 null 则默认查询全部
        AchievementEntity entity;
        if (dto == null) {
            entity = new AchievementEntity();
        } else {
            entity = BeanCopy.copy(dto, AchievementEntity.class);
        }
        return achievementMapper.selectFuzzy(entity);
    }

    @Override
    public AchievementDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(achievementMapper.selectById(id), AchievementDTO.class);
    }

    @Override
    public boolean add(AchievementDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return achievementMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<AchievementDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (AchievementDTO dto : dtoList) {
            count += achievementMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(AchievementDTO dto) {
        checkIdAndVersion(dto);
        return achievementMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(AchievementDTO dto) {
        checkIdAndVersion(dto);

        try {
            return achievementMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<AchievementDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (AchievementDTO dto : dtoList) {
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
    private void checkIdAndVersion(AchievementDTO dto) {
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
    public void setAchievementMapper(AchievementMapper achievementMapper) {
        this.achievementMapper = achievementMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}