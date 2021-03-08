package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.SubjectTypeApi;
import com.github.arsiac.psychology.base.dao.SubjectTypeMapper;
import com.github.arsiac.psychology.base.pojo.entity.SubjectTypeEntity;
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
 * <p>课题类型</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RestController
public class SubjectTypeController implements SubjectTypeApi {
    /**
     * 课题类型 dao
     * */
    private SubjectTypeMapper subjectTypeMapper;

    /**
     * id
     * */
    private IdGenerator idGenerator;

    @SystemLogger("查询全部课题类型")
    @Override
    public List<SubjectTypeEntity> queryAll() {
        return subjectTypeMapper.selectAll();
    }

    @SystemLogger(value = "模糊查询课题类型", page = true)
    @Override
    public List<SubjectTypeEntity> queryFuzzy(DictionaryParam param) {
        return subjectTypeMapper.selectFuzzy(BeanCopy.copy(param, SubjectTypeEntity.class));
    }

    @SystemLogger("根据id查询课题类型")
    @Override
    public SubjectTypeEntity queryById(Long id) {
        return null;
    }

    @SystemLogger("添加课题类型")
    @Override
    public boolean add(SubjectTypeEntity entity) {
        entity.setId(idGenerator.generate());
        return subjectTypeMapper.insert(entity) > 0;
    }

    @SystemLogger("修改课题类型")
    @Override
    public boolean modify(SubjectTypeEntity entity) {
        return subjectTypeMapper.update(entity) > 0;
    }

    @SystemLogger("删除课题类型")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(List<SubjectTypeEntity> entityList) {
        int count = 0;
        try {
            for (SubjectTypeEntity entity : entityList) {
                count += subjectTypeMapper.delete(entity.getId(), entity.getVersion());
            }
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException();
        }
        return count == entityList.size();
    }

    @Resource
    public void setSubjectTypeMapper(SubjectTypeMapper subjectTypeMapper) {
        this.subjectTypeMapper = subjectTypeMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
