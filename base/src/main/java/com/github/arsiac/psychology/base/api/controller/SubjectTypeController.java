package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.SubjectTypeApi;
import com.github.arsiac.psychology.base.pojo.dto.SubjectTypeDTO;
import com.github.arsiac.psychology.base.pojo.vo.SubjectTypeVO;
import com.github.arsiac.psychology.base.service.SubjectTypeService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>课题类别实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@RestController
public class SubjectTypeController implements SubjectTypeApi {
    /**
     * 课题类别服务
     * */
    private SubjectTypeService subjectTypeService;

    @SystemLogger("查询全部课题类别")
    @Override
    public List<SubjectTypeVO> queryAll() {
        return BeanCopy.copyList(subjectTypeService.queryAll(), SubjectTypeVO.class);
    }

    @SystemLogger(value = "模糊查询课题类别", page = true)
    @Override
    public List<SubjectTypeVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(subjectTypeService.queryFuzzy(BeanCopy.copy(param, SubjectTypeDTO.class)), SubjectTypeVO.class);
    }

    @SystemLogger("根据id查询课题类别")
    @Override
    public SubjectTypeVO queryById(Long id) {
        return BeanCopy.copy(subjectTypeService.queryById(id), SubjectTypeVO.class);
    }

    @SystemLogger("添加课题类别")
    @Override
    public boolean add(SubjectTypeDTO dto) {
        return subjectTypeService.add(dto);
    }

    @SystemLogger("批量添加课题类别")
    @Override
    public boolean batchAdd(List<SubjectTypeDTO> dtoList) {
        return subjectTypeService.batchAdd(dtoList);
    }

    @SystemLogger("修改课题类别")
    @Override
    public boolean modify(SubjectTypeDTO dto) {
        return subjectTypeService.modify(dto);
    }

    @SystemLogger("删除课题类别")
    @Override
    public boolean remove(SubjectTypeDTO dto) {
        return subjectTypeService.remove(dto);
    }

    @SystemLogger("批量删除课题类别")
    @Override
    public boolean batchRemove(List<SubjectTypeDTO> dtoList) {
        return subjectTypeService.batchRemove(dtoList);
    }

    @Autowired
    public void setSubjectTypeService(SubjectTypeService subjectTypeService) {
        this.subjectTypeService = subjectTypeService;
    }
}
