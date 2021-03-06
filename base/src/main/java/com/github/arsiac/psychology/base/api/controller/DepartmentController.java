package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.DepartmentApi;
import com.github.arsiac.psychology.base.dao.DepartmentMapper;
import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>系别接口实现</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RestController
public class DepartmentController implements DepartmentApi {
    /**
     * 系别 dao
     * */
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentEntity> queryAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public List<DepartmentEntity> queryFuzzy(DepartmentEntity entity) {
        return departmentMapper.selectFuzzy(entity);
    }

    @Override
    public DepartmentEntity queryById(Long id) {
        return null;
    }

    @Override
    public boolean add(DepartmentEntity entity) {
        return departmentMapper.insert(entity) > 0;
    }

    @Override
    public boolean modify(DepartmentEntity entity) {
        return departmentMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(List<DepartmentEntity> entityList) {
        int count = 0;
        try {
            for (DepartmentEntity entity : entityList) {
                count += departmentMapper.delete(entity.getId(), entity.getVersion());
            }
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException();
        }
        return count == entityList.size();
    }

    @Resource
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
}
