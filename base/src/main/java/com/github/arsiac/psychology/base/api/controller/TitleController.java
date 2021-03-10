package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.TitleApi;
import com.github.arsiac.psychology.base.pojo.dto.TitleDTO;
import com.github.arsiac.psychology.base.pojo.vo.TitleVO;
import com.github.arsiac.psychology.base.service.TitleService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>职称实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:07
 */
@RestController
public class TitleController implements TitleApi {
    /**
     * 职称服务
     * */
    private TitleService titleService;

    @SystemLogger("查询全部职称")
    @Override
    public List<TitleVO> queryAll() {
        return BeanCopy.copyList(titleService.queryAll(), TitleVO.class);
    }

    @SystemLogger(value = "模糊查询职称", page = true)
    @Override
    public List<TitleVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(titleService.queryFuzzy(BeanCopy.copy(param, TitleDTO.class)), TitleVO.class);
    }

    @SystemLogger("根据id查询职称")
    @Override
    public TitleVO queryById(Long id) {
        return BeanCopy.copy(titleService.queryById(id), TitleVO.class);
    }

    @SystemLogger("添加职称")
    @Override
    public boolean add(TitleDTO dto) {
        return titleService.add(dto);
    }

    @SystemLogger("批量添加职称")
    @Override
    public boolean batchAdd(List<TitleDTO> dtoList) {
        return titleService.batchAdd(dtoList);
    }

    @SystemLogger("修改职称")
    @Override
    public boolean modify(TitleDTO dto) {
        return titleService.modify(dto);
    }

    @SystemLogger("删除职称")
    @Override
    public boolean remove(TitleDTO dto) {
        return titleService.remove(dto);
    }

    @SystemLogger("批量删除职称")
    @Override
    public boolean batchRemove(List<TitleDTO> dtoList) {
        return titleService.batchRemove(dtoList);
    }

    @Autowired
    public void setTitleService(TitleService titleService) {
        this.titleService = titleService;
    }
}
