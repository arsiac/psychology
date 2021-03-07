package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.ProjectSourceApi;
import com.github.arsiac.psychology.base.dao.ProjectSourceMapper;
import com.github.arsiac.psychology.base.pojo.entity.ProjectSourceEntity;
import com.github.arsiac.psychology.base.pojo.param.DictionaryParam;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
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

    /**
     * id
     * */
    private IdGenerator idGenerator;

    @SystemLogger("查询全部项目来源")
    @Override
    public List<ProjectSourceEntity> queryAll() {
        return projectSourceMapper.selectAll();
    }

    @SystemLogger(value = "模糊查询项目来源", page = true)
    @Override
    public List<ProjectSourceEntity> queryFuzzy(DictionaryParam param) {
        return projectSourceMapper.selectFuzzy(BeanCopy.copy(param, ProjectSourceEntity.class));
    }

    @SystemLogger("根据id查询项目来源")
    @Override
    public ProjectSourceEntity queryById(Long id) {
        return null;
    }

    @SystemLogger("添加项目来源")
    @Override
    public boolean add(ProjectSourceEntity entity) {
        entity.setId(idGenerator.generate());
        return projectSourceMapper.insert(entity) > 0;
    }

    @SystemLogger("修改项目来源")
    @Override
    public boolean modify(ProjectSourceEntity entity) {
        return projectSourceMapper.update(entity) > 0;
    }

    @SystemLogger("删除项目来源")
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

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
