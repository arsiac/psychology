package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.ProjectSourceApi;
import com.github.arsiac.psychology.base.pojo.dto.ProjectSourceDTO;
import com.github.arsiac.psychology.base.pojo.vo.ProjectSourceVO;
import com.github.arsiac.psychology.base.service.ProjectSourceService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>课题来源实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@RestController
public class ProjectSourceController implements ProjectSourceApi {
    /**
     * 课题来源服务
     * */
    private ProjectSourceService projectSourceService;

    @SystemLogger("查询全部课题来源")
    @Override
    public List<ProjectSourceVO> queryAll() {
        return BeanCopy.copyList(projectSourceService.queryAll(), ProjectSourceVO.class);
    }

    @SystemLogger(value = "模糊查询课题来源", page = true)
    @Override
    public List<ProjectSourceVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(projectSourceService.queryFuzzy(BeanCopy.copy(param, ProjectSourceDTO.class)), ProjectSourceVO.class);
    }

    @SystemLogger("根据id查询课题来源")
    @Override
    public ProjectSourceVO queryById(Long id) {
        return BeanCopy.copy(projectSourceService.queryById(id), ProjectSourceVO.class);
    }

    @SystemLogger("添加课题来源")
    @Override
    public boolean add(ProjectSourceDTO dto) {
        return projectSourceService.add(dto);
    }

    @SystemLogger("批量添加课题来源")
    @Override
    public boolean batchAdd(List<ProjectSourceDTO> dtoList) {
        return projectSourceService.batchAdd(dtoList);
    }

    @SystemLogger("修改课题来源")
    @Override
    public boolean modify(ProjectSourceDTO dto) {
        return projectSourceService.modify(dto);
    }

    @SystemLogger("删除课题来源")
    @Override
    public boolean remove(ProjectSourceDTO dto) {
        return projectSourceService.remove(dto);
    }

    @SystemLogger("批量删除课题来源")
    @Override
    public boolean batchRemove(List<ProjectSourceDTO> dtoList) {
        return projectSourceService.batchRemove(dtoList);
    }

    @Autowired
    public void setProjectSourceService(ProjectSourceService projectSourceService) {
        this.projectSourceService = projectSourceService;
    }
}
