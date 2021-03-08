package com.github.arsiac.psychology.manager.api.controller;

import com.github.arsiac.psychology.manager.api.ProjectApi;
import com.github.arsiac.psychology.manager.pojo.dto.ProjectDTO;
import com.github.arsiac.psychology.manager.pojo.param.ProjectParam;
import com.github.arsiac.psychology.manager.pojo.vo.ProjectVO;
import com.github.arsiac.psychology.manager.service.ProjectService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>科研立项实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-08 14:14:30
 */
@RestController
public class ProjectController implements ProjectApi {
    /**
     * 科研立项服务
     * */
    private ProjectService projectService;

    @SystemLogger("查询全部科研立项")
    @Override
    public List<ProjectVO> queryAll() {
        return BeanCopy.copyList(projectService.queryAll(), ProjectVO.class);
    }

    @SystemLogger(value = "模糊查询科研立项", page = true)
    @Override
    public List<ProjectVO> queryFuzzy(ProjectParam param) {
        return BeanCopy.copyListOrPage(projectService.queryFuzzy(BeanCopy.copy(param, ProjectDTO.class)), ProjectVO.class);
    }

    @SystemLogger("根据id查询科研立项")
    @Override
    public ProjectVO queryById(Long id) {
        return BeanCopy.copy(projectService.queryById(id), ProjectVO.class);
    }

    @SystemLogger("添加科研立项")
    @Override
    public boolean add(ProjectDTO dto) {
        return projectService.add(dto);
    }

    @SystemLogger("批量添加科研立项")
    @Override
    public boolean batchAdd(List<ProjectDTO> dtoList) {
        return projectService.batchAdd(dtoList);
    }

    @SystemLogger("修改科研立项")
    @Override
    public boolean modify(ProjectDTO dto) {
        return projectService.modify(dto);
    }

    @SystemLogger("删除科研立项")
    @Override
    public boolean remove(ProjectDTO dto) {
        return projectService.remove(dto);
    }

    @SystemLogger("批量删除科研立项")
    @Override
    public boolean batchRemove(List<ProjectDTO> dtoList) {
        return projectService.batchRemove(dtoList);
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
