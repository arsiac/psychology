package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.SchoolDepartmentApi;
import com.github.arsiac.psychology.base.pojo.dto.SchoolDepartmentDTO;
import com.github.arsiac.psychology.base.pojo.vo.SchoolDepartmentVO;
import com.github.arsiac.psychology.base.service.SchoolDepartmentService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>学院实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:55
 */
@RestController
public class SchoolDepartmentController implements SchoolDepartmentApi {
    /**
     * 学院服务
     * */
    private SchoolDepartmentService schoolDepartmentService;

    @SystemLogger("查询全部学院")
    @Override
    public List<SchoolDepartmentVO> queryAll() {
        return BeanCopy.copyList(schoolDepartmentService.queryAll(), SchoolDepartmentVO.class);
    }

    @SystemLogger(value = "模糊查询学院", page = true)
    @Override
    public List<SchoolDepartmentVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(schoolDepartmentService.queryFuzzy(BeanCopy.copy(param, SchoolDepartmentDTO.class)), SchoolDepartmentVO.class);
    }

    @SystemLogger("根据id查询学院")
    @Override
    public SchoolDepartmentVO queryById(Long id) {
        return BeanCopy.copy(schoolDepartmentService.queryById(id), SchoolDepartmentVO.class);
    }

    @SystemLogger("添加学院")
    @Override
    public boolean add(SchoolDepartmentDTO dto) {
        return schoolDepartmentService.add(dto);
    }

    @SystemLogger("批量添加学院")
    @Override
    public boolean batchAdd(List<SchoolDepartmentDTO> dtoList) {
        return schoolDepartmentService.batchAdd(dtoList);
    }

    @SystemLogger("修改学院")
    @Override
    public boolean modify(SchoolDepartmentDTO dto) {
        return schoolDepartmentService.modify(dto);
    }

    @SystemLogger("删除学院")
    @Override
    public boolean remove(SchoolDepartmentDTO dto) {
        return schoolDepartmentService.remove(dto);
    }

    @SystemLogger("批量删除学院")
    @Override
    public boolean batchRemove(List<SchoolDepartmentDTO> dtoList) {
        return schoolDepartmentService.batchRemove(dtoList);
    }

    @Autowired
    public void setSchoolDepartmentService(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }
}
