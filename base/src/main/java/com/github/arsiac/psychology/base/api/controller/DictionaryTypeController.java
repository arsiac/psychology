package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.DictionaryTypeApi;
import com.github.arsiac.psychology.base.pojo.dto.DictionaryTypeDTO;
import com.github.arsiac.psychology.base.pojo.vo.DictionaryTypeVO;
import com.github.arsiac.psychology.base.service.DictionaryTypeService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-04-21 13:14:59
 */
@RestController
public class DictionaryTypeController implements DictionaryTypeApi {
    /**
     * 服务
     * */
    private DictionaryTypeService dictionaryTypeService;

    @SystemLogger("查询全部")
    @Override
    public List<DictionaryTypeVO> queryAll() {
        return BeanCopy.copyList(dictionaryTypeService.queryAll(), DictionaryTypeVO.class);
    }

    @SystemLogger(value = "模糊查询", page = true)
    @Override
    public List<DictionaryTypeVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(dictionaryTypeService.queryFuzzy(BeanCopy.copy(param, DictionaryTypeDTO.class)), DictionaryTypeVO.class);
    }

    @SystemLogger("根据id查询")
    @Override
    public DictionaryTypeVO queryById(Long id) {
        return BeanCopy.copy(dictionaryTypeService.queryById(id), DictionaryTypeVO.class);
    }

    @SystemLogger("添加")
    @Override
    public boolean add(DictionaryTypeDTO dto) {
        return dictionaryTypeService.add(dto);
    }

    @SystemLogger("批量添加")
    @Override
    public boolean batchAdd(List<DictionaryTypeDTO> dtoList) {
        return dictionaryTypeService.batchAdd(dtoList);
    }

    @SystemLogger("修改")
    @Override
    public boolean modify(DictionaryTypeDTO dto) {
        return dictionaryTypeService.modify(dto);
    }

    @SystemLogger("删除")
    @Override
    public boolean remove(DictionaryTypeDTO dto) {
        return dictionaryTypeService.remove(dto);
    }

    @SystemLogger("批量删除")
    @Override
    public boolean batchRemove(List<DictionaryTypeDTO> dtoList) {
        return dictionaryTypeService.batchRemove(dtoList);
    }

    @Autowired
    public void setDictionaryTypeService(DictionaryTypeService dictionaryTypeService) {
        this.dictionaryTypeService = dictionaryTypeService;
    }
}
