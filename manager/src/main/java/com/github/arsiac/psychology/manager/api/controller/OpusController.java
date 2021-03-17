package com.github.arsiac.psychology.manager.api.controller;

import com.github.arsiac.psychology.manager.api.OpusApi;
import com.github.arsiac.psychology.manager.pojo.dto.OpusDTO;
import com.github.arsiac.psychology.manager.pojo.param.OpusParam;
import com.github.arsiac.psychology.manager.pojo.vo.OpusVO;
import com.github.arsiac.psychology.manager.service.OpusService;
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
 * @since  2021-03-12 00:14:16
 */
@RestController
public class OpusController implements OpusApi {
    /**
     * 服务
     * */
    private OpusService opusService;

    @SystemLogger("查询全部")
    @Override
    public List<OpusVO> queryAll() {
        return BeanCopy.copyList(opusService.queryAll(), OpusVO.class);
    }

    @SystemLogger(value = "模糊查询", page = true)
    @Override
    public List<OpusVO> queryFuzzy(OpusParam param) {
        return BeanCopy.copyListOrPage(opusService.queryFuzzy(BeanCopy.copy(param, OpusDTO.class)),
                OpusVO.class, this::copy2vo);
    }

    /**
     * <p>拷贝成果类型名称和作者名称</p>
     *
     * @param source dto
     * @param target vo
     * */
    private void copy2vo(Object source, Object target) {
        OpusDTO dto = (OpusDTO) source;
        OpusVO vo = (OpusVO) target;

        if (dto.getAuthor() != null) {
            vo.setAuthorName(dto.getAuthor().getName());
        }

        if (dto.getAchievementType() != null) {
            vo.setAchievementTypeName(dto.getAchievementType().getName());
        }
    }

    @SystemLogger("根据id查询")
    @Override
    public OpusVO queryById(Long id) {
        return BeanCopy.copy(opusService.queryById(id), OpusVO.class);
    }

    @SystemLogger("添加")
    @Override
    public boolean add(OpusDTO dto) {
        return opusService.add(dto);
    }

    @SystemLogger("批量添加")
    @Override
    public boolean batchAdd(List<OpusDTO> dtoList) {
        return opusService.batchAdd(dtoList);
    }

    @SystemLogger("修改")
    @Override
    public boolean modify(OpusDTO dto) {
        return opusService.modify(dto);
    }

    @SystemLogger("删除")
    @Override
    public boolean remove(OpusDTO dto) {
        return opusService.remove(dto);
    }

    @SystemLogger("批量删除")
    @Override
    public boolean batchRemove(List<OpusDTO> dtoList) {
        return opusService.batchRemove(dtoList);
    }

    @Autowired
    public void setOpusService(OpusService opusService) {
        this.opusService = opusService;
    }
}
