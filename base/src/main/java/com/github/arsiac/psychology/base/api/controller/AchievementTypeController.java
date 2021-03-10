package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.AchievementTypeApi;
import com.github.arsiac.psychology.base.pojo.dto.AchievementTypeDTO;
import com.github.arsiac.psychology.base.pojo.vo.AchievementTypeVO;
import com.github.arsiac.psychology.base.service.AchievementTypeService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.entity.DictionaryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>成果形式实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-11 00:10:06
 */
@RestController
public class AchievementTypeController implements AchievementTypeApi {
    /**
     * 成果形式服务
     * */
    private AchievementTypeService achievementTypeService;

    @SystemLogger("查询全部成果形式")
    @Override
    public List<AchievementTypeVO> queryAll() {
        return BeanCopy.copyList(achievementTypeService.queryAll(), AchievementTypeVO.class);
    }

    @SystemLogger(value = "模糊查询成果形式", page = true)
    @Override
    public List<AchievementTypeVO> queryFuzzy(DictionaryParam param) {
        return BeanCopy.copyListOrPage(achievementTypeService.queryFuzzy(BeanCopy.copy(param, AchievementTypeDTO.class)), AchievementTypeVO.class);
    }

    @SystemLogger("根据id查询成果形式")
    @Override
    public AchievementTypeVO queryById(Long id) {
        return BeanCopy.copy(achievementTypeService.queryById(id), AchievementTypeVO.class);
    }

    @SystemLogger("添加成果形式")
    @Override
    public boolean add(AchievementTypeDTO dto) {
        return achievementTypeService.add(dto);
    }

    @SystemLogger("批量添加成果形式")
    @Override
    public boolean batchAdd(List<AchievementTypeDTO> dtoList) {
        return achievementTypeService.batchAdd(dtoList);
    }

    @SystemLogger("修改成果形式")
    @Override
    public boolean modify(AchievementTypeDTO dto) {
        return achievementTypeService.modify(dto);
    }

    @SystemLogger("删除成果形式")
    @Override
    public boolean remove(AchievementTypeDTO dto) {
        return achievementTypeService.remove(dto);
    }

    @SystemLogger("批量删除成果形式")
    @Override
    public boolean batchRemove(List<AchievementTypeDTO> dtoList) {
        return achievementTypeService.batchRemove(dtoList);
    }

    @Autowired
    public void setAchievementTypeService(AchievementTypeService achievementTypeService) {
        this.achievementTypeService = achievementTypeService;
    }
}
