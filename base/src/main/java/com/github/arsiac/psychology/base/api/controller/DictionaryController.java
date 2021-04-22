package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.DictionaryApi;
import com.github.arsiac.psychology.base.pojo.dto.DictionaryDTO;
import com.github.arsiac.psychology.base.pojo.param.DictionaryParam;
import com.github.arsiac.psychology.base.pojo.vo.DictionaryVO;
import com.github.arsiac.psychology.base.service.DictionaryService;
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
 * @since  2021-04-21 13:14:59
 */
@RestController
public class DictionaryController implements DictionaryApi {
    /**
     * 服务
     * */
    private DictionaryService dictionaryService;

    @SystemLogger("查询全部")
    @Override
    public List<DictionaryVO> queryAll() {
        return BeanCopy.copyList(dictionaryService.queryAll(), DictionaryVO.class);
    }

    @SystemLogger(value = "模糊查询", page = true)
    @Override
    public List<DictionaryVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(dictionaryService.queryFuzzy(BeanCopy.copy(param, DictionaryDTO.class)),
                DictionaryVO.class, this::copy2vo);
    }

    /**
     * <p>拷贝字典类型信息</p>
     *
     * @param source dto
     * @param target vo
     * */
    private void copy2vo(Object source, Object target) {
        DictionaryDTO dto = (DictionaryDTO) source;
        DictionaryVO vo = (DictionaryVO) target;

        if (dto.getDictionaryTypeEntity() != null) {
            vo.setDictionaryTypeName(dto.getDictionaryTypeEntity().getName());
        }
    }

    @SystemLogger("根据id查询")
    @Override
    public DictionaryVO queryById(Long id) {
        return BeanCopy.copy(dictionaryService.queryById(id), DictionaryVO.class);
    }

    @SystemLogger("添加")
    @Override
    public boolean add(DictionaryDTO dto) {
        return dictionaryService.add(dto);
    }

    @SystemLogger("批量添加")
    @Override
    public boolean batchAdd(List<DictionaryDTO> dtoList) {
        return dictionaryService.batchAdd(dtoList);
    }

    @SystemLogger("修改")
    @Override
    public boolean modify(DictionaryDTO dto) {
        return dictionaryService.modify(dto);
    }

    @SystemLogger("删除")
    @Override
    public boolean remove(DictionaryDTO dto) {
        return dictionaryService.remove(dto);
    }

    @SystemLogger("批量删除")
    @Override
    public boolean batchRemove(List<DictionaryDTO> dtoList) {
        return dictionaryService.batchRemove(dtoList);
    }

    @Autowired
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }
}
