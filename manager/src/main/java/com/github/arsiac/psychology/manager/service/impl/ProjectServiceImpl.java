package com.github.arsiac.psychology.manager.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.manager.pojo.dto.ProjectDTO;
import com.github.arsiac.psychology.manager.pojo.entity.ProjectEntity;
import com.github.arsiac.psychology.manager.dao.ProjectMapper;
import com.github.arsiac.psychology.manager.service.ProjectService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>科研立项服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    /**
         * 权力 dao
         */
    private ProjectMapper projectMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<ProjectDTO> queryAll() {
        return BeanCopy.copyList(projectMapper.selectAll(), ProjectDTO.class);
    }

    @Override
    public List<ProjectDTO> queryFuzzy(ProjectDTO dto) {
        // dto 为 null 则默认查询全部
        ProjectEntity entity;
        if (dto == null) {
            entity = new ProjectEntity();
        } else {
            entity = BeanCopy.copy(dto, ProjectEntity.class);
        }
        return BeanCopy.copyListOrPage(projectMapper.selectFuzzy(entity), ProjectDTO.class);
    }

    @Override
    public ProjectDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(projectMapper.selectById(id), ProjectDTO.class);
    }

    @Override
    public boolean add(ProjectDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return projectMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<ProjectDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (ProjectDTO dto : dtoList) {
            count += projectMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(ProjectDTO dto) {
        checkIdAndVersion(dto);
        return projectMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(ProjectDTO dto) {
        checkIdAndVersion(dto);

        try {
            return projectMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<ProjectDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (ProjectDTO dto : dtoList) {
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
    private void checkIdAndVersion(ProjectDTO dto) {
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
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}