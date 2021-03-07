package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.TeacherApi;
import com.github.arsiac.psychology.base.dao.TeacherMapper;
import com.github.arsiac.psychology.base.pojo.dto.TeacherDTO;
import com.github.arsiac.psychology.base.pojo.entity.TeacherEntity;
import com.github.arsiac.psychology.base.pojo.param.TeacherParam;
import com.github.arsiac.psychology.base.pojo.vo.TeacherVO;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
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

    /**
     * id
     * */
    private IdGenerator idGenerator;

    @SystemLogger("查询全部教师")
    @Override
    public List<TeacherEntity> queryAll() {
        return teacherMapper.selectAll();
    }

    @SystemLogger(value = "模糊查询教师", page = true)
    @Override
    public List<TeacherVO> queryFuzzy(TeacherParam param) {
        return BeanCopy.copyList(teacherMapper.selectFuzzy(
                BeanCopy.copy(param, TeacherEntity.class)
        ), TeacherVO.class, this::copy2vo);
    }

    /**
     * <p>拷贝成vo</p>
     *
     * @param source dto
     * @param target vo
     */
    private void copy2vo(Object source, Object target) {
        TeacherDTO dto = (TeacherDTO) source;
        TeacherVO vo = (TeacherVO) target;
        if (dto.getTitleEntity() != null) {
            vo.setTitleName(dto.getTitleEntity().getName());
        }
        if (dto.getDepartmentEntity() != null) {
            vo.setDepartmentName(dto.getDepartmentEntity().getName());
        }
    }

    @SystemLogger("根据id查询教师")
    @Override
    public TeacherEntity queryById(Long id) {
        return null;
    }

    @SystemLogger("添加教师")
    @Override
    public boolean add(TeacherEntity entity) {
        entity.setId(idGenerator.generate());
        return teacherMapper.insert(entity) > 0;
    }

    @SystemLogger("修改教师")
    @Override
    public boolean modify(TeacherEntity entity) {
        return teacherMapper.update(entity) > 0;
    }

    @SystemLogger("删除教师")
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

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
