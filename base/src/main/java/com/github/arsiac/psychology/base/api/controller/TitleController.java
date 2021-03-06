package com.github.arsiac.psychology.base.api.controller;

import com.github.arsiac.psychology.base.api.TitleApi;
import com.github.arsiac.psychology.base.dao.TitleMapper;
import com.github.arsiac.psychology.base.pojo.entity.TitleEntity;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>职称接口实现</p>
 * 
 * @author arsiac
 * @version 1.0
 * @since  2021/3/6
 */
@RestController
public class TitleController implements TitleApi {
    /**
     * 职称 dao
     * */
    private TitleMapper titleMapper;

    /**
     * id
     * */
    private IdGenerator idGenerator;

    @Override
    public List<TitleEntity> queryAll() {
        return titleMapper.selectAll();
    }

    @Override
    public List<TitleEntity> queryFuzzy(TitleEntity entity) {
        return titleMapper.selectFuzzy(entity);
    }

    @Override
    public TitleEntity queryById(Long id) {
        return null;
    }

    @Override
    public boolean add(TitleEntity entity) {
        entity.setId(idGenerator.generate());
        return titleMapper.insert(entity) > 0;
    }

    @Override
    public boolean modify(TitleEntity entity) {
        return titleMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(List<TitleEntity> entityList) {
        int count = 0;
        try {
            for (TitleEntity entity : entityList) {
                count += titleMapper.delete(entity.getId(), entity.getVersion());
            }
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException();
        }
        return count == entityList.size();
    }

    @Resource
    public void setTitleMapper(TitleMapper titleMapper) {
        this.titleMapper = titleMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
