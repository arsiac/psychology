package com.github.arsiac.psychology.base.service.impl;

import com.github.arsiac.psychology.utils.common.BeanCopy;
import com.github.arsiac.psychology.utils.common.IdGenerator;
import com.github.arsiac.psychology.utils.exception.PsychologyErrorCode;
import org.springframework.stereotype.Service;
import com.github.arsiac.psychology.base.pojo.dto.MajorDTO;
import com.github.arsiac.psychology.base.pojo.entity.MajorEntity;
import com.github.arsiac.psychology.base.dao.MajorMapper;
import com.github.arsiac.psychology.base.service.MajorService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>专业服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-27 02:12:56
 */
@Service("majorService")
public class MajorServiceImpl implements MajorService {
    /**
         * 权力 dao
         */
    private MajorMapper majorMapper;

    /**
     * id 生成器
     */
    private IdGenerator idGenerator;

    @Override
    public List<MajorDTO> queryAll() {
        return BeanCopy.copyList(majorMapper.selectAll(), MajorDTO.class);
    }

    @Override
    public List<MajorDTO> queryFuzzy(MajorDTO dto) {
        // dto 为 null 则默认查询全部
        MajorEntity entity;
        if (dto == null) {
            entity = new MajorEntity();
        } else {
            entity = BeanCopy.copy(dto, MajorEntity.class);
        }
        return BeanCopy.copyListOrPage(majorMapper.selectFuzzy(entity), MajorDTO.class);
    }

    @Override
    public MajorDTO queryById(Long id) {
        if (id == null) {
            throw PsychologyErrorCode.ID_IS_NULL.createException();
        }
        return BeanCopy.copy(majorMapper.selectById(id), MajorDTO.class);
    }

    @Override
    public boolean add(MajorDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        // 生成id
        dto.setId(idGenerator.generate());
        return majorMapper.insert(dto) > 0;
    }

    @Override
    public boolean batchAdd(List<MajorDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.INSERT_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (MajorDTO dto : dtoList) {
            count += majorMapper.insert(dto);
        }

        // true 则为全部插入成功
        // false 则为部分插入失败
        return dtoList.size() == count;
    }

    @Override
    public boolean modify(MajorDTO dto) {
        checkIdAndVersion(dto);
        return majorMapper.update(dto) > 0;
    }

    @Override
    public boolean remove(MajorDTO dto) {
        checkIdAndVersion(dto);

        try {
            return majorMapper.delete(dto) > 0;
        } catch (Exception e) {
            throw PsychologyErrorCode.CANNOT_DELETE_FOREIGN_KEY.createException(e);
        }
    }

    @Override
    public boolean batchRemove(List<MajorDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            throw PsychologyErrorCode.DELETE_LIST_IS_EMPTY.createException();
        }

        int count = 0;
        for (MajorDTO dto : dtoList) {
            count += remove(dto) ? 1 : 0;
        }

        // true 则为全部删除成功
        // false 则为部分删除失败
        return count == dtoList.size();
    }

    /**
     * <p>检查dto的id和version</p>
     *
     * @param dto 要被检查的对象
     */
    private void checkIdAndVersion(MajorDTO dto) {
        if (dto == null) {
            throw PsychologyErrorCode.DATA_IS_EMPTY.createException();
        }
        if (dto.getId() == null) {
            throw PsychologyErrorCode.ID_NOT_AVAILABLE.createException();
        }
        if (dto.getVersion() == null) {
            throw PsychologyErrorCode.VERSION_NOT_AVAILABLE.createException();
        }
    }

    @Resource
    public void setMajorMapper(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}