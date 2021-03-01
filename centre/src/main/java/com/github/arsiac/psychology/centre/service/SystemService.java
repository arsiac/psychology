package com.github.arsiac.psychology.centre.service;

import com.github.arsiac.psychology.centre.pojo.dto.ResourceDTO;

import java.util.List;

/**
 * <p>系统资源服务声明</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/24
 */
public interface SystemService {
    /**
     * <p>根据用户id查询资源</p>
     *
     * @param id 用户id
     * @return 资源
     */
    List<ResourceDTO> queryResourceByUserId(Long id);
}
