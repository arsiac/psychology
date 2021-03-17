package com.github.arsiac.psychology.manager.api.controller;

import com.github.arsiac.psychology.manager.api.AchievementApi;
import com.github.arsiac.psychology.manager.pojo.dto.AchievementDTO;
import com.github.arsiac.psychology.manager.pojo.param.AchievementParam;
import com.github.arsiac.psychology.manager.pojo.vo.AchievementVO;
import com.github.arsiac.psychology.manager.service.AchievementService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>成果实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
@RestController
public class AchievementController implements AchievementApi {
    /**
     * 成果服务
     * */
    private AchievementService achievementService;

    @SystemLogger("查询全部成果")
    @Override
    public List<AchievementVO> queryAll() {
        return BeanCopy.copyList(achievementService.queryAll(), AchievementVO.class);
    }

    @SystemLogger(value = "模糊查询成果", page = true)
    @Override
    public List<AchievementVO> queryFuzzy(AchievementParam param) {
        return BeanCopy.copyListOrPage(achievementService.queryFuzzy(BeanCopy.copy(param, AchievementDTO.class)),
                AchievementVO.class, this::copy2vo);
    }

    /**
     * <p>复制成果类型名称和获奖等级名称</p>
     *
     * @param source dto
     * @param target vo
     * */
    private void copy2vo(Object source, Object target) {
        AchievementDTO dto = (AchievementDTO) source;
        AchievementVO vo = (AchievementVO) target;

        if (dto.getAchievementType() != null) {
            vo.setAchievementTypeName(dto.getAchievementType().getName());
        }

        if (dto.getRewordLevel() != null) {
            vo.setRewordLevelName(dto.getRewordLevel().getName());
        }
    }

    @SystemLogger("根据id查询成果")
    @Override
    public AchievementVO queryById(Long id) {
        return BeanCopy.copy(achievementService.queryById(id), AchievementVO.class);
    }

    @SystemLogger("添加成果")
    @Override
    public boolean add(AchievementDTO dto) {
        return achievementService.add(dto);
    }

    @SystemLogger("批量添加成果")
    @Override
    public boolean batchAdd(List<AchievementDTO> dtoList) {
        return achievementService.batchAdd(dtoList);
    }

    @SystemLogger("修改成果")
    @Override
    public boolean modify(AchievementDTO dto) {
        return achievementService.modify(dto);
    }

    @SystemLogger("删除成果")
    @Override
    public boolean remove(AchievementDTO dto) {
        return achievementService.remove(dto);
    }

    @SystemLogger("批量删除成果")
    @Override
    public boolean batchRemove(List<AchievementDTO> dtoList) {
        return achievementService.batchRemove(dtoList);
    }

    @Autowired
    public void setAchievementService(AchievementService achievementService) {
        this.achievementService = achievementService;
    }
}
