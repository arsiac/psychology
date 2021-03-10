package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.RewordLevelApi;
import com.github.arsiac.psychology.base.pojo.dto.RewordLevelDTO;
import com.github.arsiac.psychology.base.pojo.vo.RewordLevelVO;
import com.github.arsiac.psychology.base.service.RewordLevelService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>获奖等级实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@RestController
public class RewordLevelController implements RewordLevelApi {
    /**
     * 获奖等级服务
     * */
    private RewordLevelService rewordLevelService;

    @SystemLogger("查询全部获奖等级")
    @Override
    public List<RewordLevelVO> queryAll() {
        return BeanCopy.copyList(rewordLevelService.queryAll(), RewordLevelVO.class);
    }

    @SystemLogger(value = "模糊查询获奖等级", page = true)
    @Override
    public List<RewordLevelVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(rewordLevelService.queryFuzzy(BeanCopy.copy(param, RewordLevelDTO.class)), RewordLevelVO.class);
    }

    @SystemLogger("根据id查询获奖等级")
    @Override
    public RewordLevelVO queryById(Long id) {
        return BeanCopy.copy(rewordLevelService.queryById(id), RewordLevelVO.class);
    }

    @SystemLogger("添加获奖等级")
    @Override
    public boolean add(RewordLevelDTO dto) {
        return rewordLevelService.add(dto);
    }

    @SystemLogger("批量添加获奖等级")
    @Override
    public boolean batchAdd(List<RewordLevelDTO> dtoList) {
        return rewordLevelService.batchAdd(dtoList);
    }

    @SystemLogger("修改获奖等级")
    @Override
    public boolean modify(RewordLevelDTO dto) {
        return rewordLevelService.modify(dto);
    }

    @SystemLogger("删除获奖等级")
    @Override
    public boolean remove(RewordLevelDTO dto) {
        return rewordLevelService.remove(dto);
    }

    @SystemLogger("批量删除获奖等级")
    @Override
    public boolean batchRemove(List<RewordLevelDTO> dtoList) {
        return rewordLevelService.batchRemove(dtoList);
    }

    @Autowired
    public void setRewordLevelService(RewordLevelService rewordLevelService) {
        this.rewordLevelService = rewordLevelService;
    }
}
