package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.TeacherApi;
import com.github.arsiac.psychology.base.dao.TeacherMapper;
import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>教师接口实现</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RestController
public class TeacherController implements TeacherApi {
    /**
     * 教师 dao
     * */
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherEntity> queryAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public List<TeacherEntity> queryFuzzy(TeacherEntity entity) {
        return teacherMapper.selectFuzzy(entity);
    }

    @Override
    public TeacherEntity queryById(Long id) {
        return null;
    }

    @Override
    public boolean add(TeacherEntity entity) {
        return teacherMapper.insert(entity) > 0;
    }

    @Override
    public boolean modify(TeacherEntity entity) {
        return teacherMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(List<TeacherEntity> entityList) {
        int count = 0;
        try {
            for (TeacherEntity entity : entityList) {
                count += teacherMapper.delete(entity.getId(), entity.getVersion());
            }
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException();
        }
        return count == entityList.size();
    }

    @Resource
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }
}
