package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.MajorApi;
import com.github.arsiac.psychology.base.pojo.dto.MajorDTO;
import com.github.arsiac.psychology.base.pojo.vo.MajorVO;
import com.github.arsiac.psychology.base.service.MajorService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>专业实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:56
 */
@RestController
public class MajorController implements MajorApi {
    /**
     * 专业服务
     * */
    private MajorService majorService;

    @SystemLogger("查询全部专业")
    @Override
    public List<MajorVO> queryAll() {
        return BeanCopy.copyList(majorService.queryAll(), MajorVO.class);
    }

    @SystemLogger(value = "模糊查询专业", page = true)
    @Override
    public List<MajorVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(majorService.queryFuzzy(BeanCopy.copy(param, MajorDTO.class)), MajorVO.class);
    }

    @SystemLogger("根据id查询专业")
    @Override
    public MajorVO queryById(Long id) {
        return BeanCopy.copy(majorService.queryById(id), MajorVO.class);
    }

    @SystemLogger("添加专业")
    @Override
    public boolean add(MajorDTO dto) {
        return majorService.add(dto);
    }

    @SystemLogger("批量添加专业")
    @Override
    public boolean batchAdd(List<MajorDTO> dtoList) {
        return majorService.batchAdd(dtoList);
    }

    @SystemLogger("修改专业")
    @Override
    public boolean modify(MajorDTO dto) {
        return majorService.modify(dto);
    }

    @SystemLogger("删除专业")
    @Override
    public boolean remove(MajorDTO dto) {
        return majorService.remove(dto);
    }

    @SystemLogger("批量删除专业")
    @Override
    public boolean batchRemove(List<MajorDTO> dtoList) {
        return majorService.batchRemove(dtoList);
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }
}
