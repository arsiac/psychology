package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.ProjectSourceDTO;
import com.github.arsiac.psychology.base.pojo.entity.ProjectSourceEntity;
import com.github.arsiac.psychology.base.dao.ProjectSourceMapper;
import com.github.arsiac.psychology.base.service.ProjectSourceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>课题来源服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@Service("projectSourceService")
public class ProjectSourceServiceImpl implements ProjectSourceService {
    /**
         * 权力 dao
         */
    private ProjectSourceMapper projectSourceMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<ProjectSourceDTO> queryAll() {
        return BeanCopy.copyList(projectSourceMapper.selectAll(), ProjectSourceDTO.class);
    }

    @Override
    public List<ProjectSourceDTO> queryFuzzy(ProjectSourceDTO dto) {
        // dto 为 null 则默认查询全部
        ProjectSourceEntity entity;
        if (dto == null) {
            entity = new ProjectSourceEntity();
        } else {
            entity = BeanCopy.copy(dto, ProjectSourceEntity.class);
        }
        return BeanCopy.copyListOrPage(projectSourceMapper.selectFuzzy(entity), ProjectSourceDTO.class);
    }

    @Override
    public ProjectSourceDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(projectSourceMapper.selectById(id), ProjectSourceDTO.class);
    }

    @Override
    public boolean add(ProjectSourceDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return projectSourceMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<ProjectSourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (ProjectSourceDTO dto : dtoList) {
            count += projectSourceMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(ProjectSourceDTO dto) {
        checkIdAndVersion(dto);
        return projectSourceMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(ProjectSourceDTO dto) {
        checkIdAndVersion(dto);

        try {
            return projectSourceMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<ProjectSourceDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (ProjectSourceDTO dto : dtoList) {
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
    private void checkIdAndVersion(ProjectSourceDTO dto) {
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
    public void setProjectSourceMapper(ProjectSourceMapper projectSourceMapper) {
        this.projectSourceMapper = projectSourceMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}