package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.DepartmentApi;
import com.github.arsiac.psychology.base.dao.DepartmentMapper;
import com.github.arsiac.psychology.base.pojo.entity.DepartmentEntity;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
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

    /**
     * id
     * */
    private IdGenerator idGenerator;

    @SystemLogger("查询全部系别")
    @Override
    public List<DepartmentEntity> queryAll() {
        return departmentMapper.selectAll();
    }

    @SystemLogger(value = "模糊查询系别", page = true)
    @Override
    public List<DepartmentEntity> queryFuzzy(DictionaryParam param) {
        return departmentMapper.selectFuzzy(BeanCopy.copy(param, DepartmentEntity.class));
    }

    @SystemLogger("根据id查询系别")
    @Override
    public DepartmentEntity queryById(Long id) {
        return null;
    }

    @SystemLogger("添加系别")
    @Override
    public boolean add(DepartmentEntity entity) {
        entity.setId(idGenerator.generate());
        return departmentMapper.insert(entity) > 0;
    }

    @SystemLogger("修改系别")
    @Override
    public boolean modify(DepartmentEntity entity) {
        return departmentMapper.update(entity) > 0;
    }

    @SystemLogger("删除系别")
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

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
