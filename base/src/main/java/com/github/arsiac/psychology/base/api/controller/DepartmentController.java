package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.DepartmentApi;
import com.github.arsiac.psychology.base.pojo.dto.DepartmentDTO;
import com.github.arsiac.psychology.base.pojo.vo.DepartmentVO;
import com.github.arsiac.psychology.base.service.DepartmentService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>系别实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@RestController
public class DepartmentController implements DepartmentApi {
    /**
     * 系别服务
     * */
    private DepartmentService departmentService;

    @SystemLogger("查询全部系别")
    @Override
    public List<DepartmentVO> queryAll() {
        return BeanCopy.copyList(departmentService.queryAll(), DepartmentVO.class);
    }

    @SystemLogger(value = "模糊查询系别", page = true)
    @Override
    public List<DepartmentVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(departmentService.queryFuzzy(BeanCopy.copy(param, DepartmentDTO.class)), DepartmentVO.class);
    }

    @SystemLogger("根据id查询系别")
    @Override
    public DepartmentVO queryById(Long id) {
        return BeanCopy.copy(departmentService.queryById(id), DepartmentVO.class);
    }

    @SystemLogger("添加系别")
    @Override
    public boolean add(DepartmentDTO dto) {
        return departmentService.add(dto);
    }

    @SystemLogger("批量添加系别")
    @Override
    public boolean batchAdd(List<DepartmentDTO> dtoList) {
        return departmentService.batchAdd(dtoList);
    }

    @SystemLogger("修改系别")
    @Override
    public boolean modify(DepartmentDTO dto) {
        return departmentService.modify(dto);
    }

    @SystemLogger("删除系别")
    @Override
    public boolean remove(DepartmentDTO dto) {
        return departmentService.remove(dto);
    }

    @SystemLogger("批量删除系别")
    @Override
    public boolean batchRemove(List<DepartmentDTO> dtoList) {
        return departmentService.batchRemove(dtoList);
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
