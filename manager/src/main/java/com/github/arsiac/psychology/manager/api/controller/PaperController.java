package com.github.arsiac.psychology.manager.api.controller;

import com.github.arsiac.psychology.manager.api.PaperApi;
import com.github.arsiac.psychology.manager.pojo.dto.PaperDTO;
import com.github.arsiac.psychology.manager.pojo.param.PaperParam;
import com.github.arsiac.psychology.manager.pojo.vo.PaperVO;
import com.github.arsiac.psychology.manager.service.PaperService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
@RestController
public class PaperController implements PaperApi {
    /**
     * 服务
     * */
    private PaperService paperService;

    @SystemLogger("查询全部")
    @Override
    public List<PaperVO> queryAll() {
        return BeanCopy.copyList(paperService.queryAll(), PaperVO.class);
    }

    @SystemLogger(value = "模糊查询", page = true)
    @Override
    public List<PaperVO> queryFuzzy(PaperParam param) {
        return BeanCopy.copyListOrPage(paperService.queryFuzzy(BeanCopy.copy(param, PaperDTO.class)),
                PaperVO.class, this::copy2vo);
    }

    /**
     * <p>拷贝第一作者名称、通讯作者名称和论文等级名称</p>
     *
     * @param source dto
     * @param target vo
     * */
    private void copy2vo(Object source, Object target) {
        PaperDTO dto = (PaperDTO) source;
        PaperVO vo = (PaperVO) target;

        if (dto.getFirstAuthor() != null) {
            vo.setFirstAuthorName(dto.getFirstAuthor().getName());
        }

        if (dto.getCorrespondingAuthor() != null) {
            vo.setCorrespondingAuthorName(dto.getCorrespondingAuthor().getName());
        }

        if (dto.getPaperLevel() != null) {
            vo.setPaperLevelName(dto.getPaperLevel().getName());
        }
    }

    @SystemLogger("根据id查询")
    @Override
    public PaperVO queryById(Long id) {
        return BeanCopy.copy(paperService.queryById(id), PaperVO.class);
    }

    @SystemLogger("添加")
    @Override
    public boolean add(PaperDTO dto) {
        return paperService.add(dto);
    }

    @SystemLogger("批量添加")
    @Override
    public boolean batchAdd(List<PaperDTO> dtoList) {
        return paperService.batchAdd(dtoList);
    }

    @SystemLogger("修改")
    @Override
    public boolean modify(PaperDTO dto) {
        return paperService.modify(dto);
    }

    @SystemLogger("删除")
    @Override
    public boolean remove(PaperDTO dto) {
        return paperService.remove(dto);
    }

    @SystemLogger("批量删除")
    @Override
    public boolean batchRemove(List<PaperDTO> dtoList) {
        return paperService.batchRemove(dtoList);
    }

    @Autowired
    public void setPaperService(PaperService paperService) {
        this.paperService = paperService;
    }
}
