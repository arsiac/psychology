package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.PaperLevelApi;
import com.github.arsiac.psychology.base.pojo.dto.PaperLevelDTO;
import com.github.arsiac.psychology.base.pojo.vo.PaperLevelVO;
import com.github.arsiac.psychology.base.service.PaperLevelService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>论文级别实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 20:59:39
 */
@RestController
public class PaperLevelController implements PaperLevelApi {
    /**
     * 论文级别服务
     * */
    private PaperLevelService paperLevelService;

    @SystemLogger("查询全部论文级别")
    @Override
    public List<PaperLevelVO> queryAll() {
        return BeanCopy.copyList(paperLevelService.queryAll(), PaperLevelVO.class);
    }

    @SystemLogger(value = "模糊查询论文级别", page = true)
    @Override
    public List<PaperLevelVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(paperLevelService.queryFuzzy(BeanCopy.copy(param, PaperLevelDTO.class)), PaperLevelVO.class);
    }

    @SystemLogger("根据id查询论文级别")
    @Override
    public PaperLevelVO queryById(Long id) {
        return BeanCopy.copy(paperLevelService.queryById(id), PaperLevelVO.class);
    }

    @SystemLogger("添加论文级别")
    @Override
    public boolean add(PaperLevelDTO dto) {
        return paperLevelService.add(dto);
    }

    @SystemLogger("批量添加论文级别")
    @Override
    public boolean batchAdd(List<PaperLevelDTO> dtoList) {
        return paperLevelService.batchAdd(dtoList);
    }

    @SystemLogger("修改论文级别")
    @Override
    public boolean modify(PaperLevelDTO dto) {
        return paperLevelService.modify(dto);
    }

    @SystemLogger("删除论文级别")
    @Override
    public boolean remove(PaperLevelDTO dto) {
        return paperLevelService.remove(dto);
    }

    @SystemLogger("批量删除论文级别")
    @Override
    public boolean batchRemove(List<PaperLevelDTO> dtoList) {
        return paperLevelService.batchRemove(dtoList);
    }

    @Autowired
    public void setPaperLevelService(PaperLevelService paperLevelService) {
        this.paperLevelService = paperLevelService;
    }
}
