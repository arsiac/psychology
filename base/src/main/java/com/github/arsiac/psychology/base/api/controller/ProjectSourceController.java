package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.ProjectSourceApi;
import com.github.arsiac.psychology.base.dao.ProjectSourceMapper;
import com.github.arsiac.psychology.base.pojo.entity.ProjectSourceEntity;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目来源接口实现</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RestController
public class ProjectSourceController implements ProjectSourceApi {
    /**
     * 项目来源 dao
     * */
    private ProjectSourceMapper projectSourceMapper;

    @Override
    public List<ProjectSourceEntity> queryAll() {
        return projectSourceMapper.selectAll();
    }

    @Override
    public List<ProjectSourceEntity> queryFuzzy(ProjectSourceEntity entity) {
        return projectSourceMapper.selectFuzzy(entity);
    }

    @Override
    public ProjectSourceEntity queryById(Long id) {
        return null;
    }

    @Override
    public boolean add(ProjectSourceEntity entity) {
        return projectSourceMapper.insert(entity) > 0;
    }

    @Override
    public boolean modify(ProjectSourceEntity entity) {
        return projectSourceMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(List<ProjectSourceEntity> entityList) {
        int count = 0;
        try {
            for (ProjectSourceEntity entity : entityList) {
                count += projectSourceMapper.delete(entity.getId(), entity.getVersion());
            }
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException();
        }
        return count == entityList.size();
    }

    @Resource
    public void setProjectSourceMapper(ProjectSourceMapper projectSourceMapper) {
        this.projectSourceMapper = projectSourceMapper;
    }
}
