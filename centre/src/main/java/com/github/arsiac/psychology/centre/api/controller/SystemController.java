package com.github.arsiac.psychology.centre.api.controller;

import com.github.arsiac.psychology.centre.api.SystemApi;
import com.github.arsiac.psychology.centre.pojo.vo.ResourceVO;
import com.github.arsiac.psychology.centre.service.SystemService;
import com.github.arsiac.psychology.utils.annotation.SystemLogger;
import com.github.arsiac.psychology.utils.common.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>系统接口实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/24
 */
@RestController
public class SystemController implements SystemApi {
    /**
     * 系统资源服务
     * */
    private SystemService systemService;

    @Override
    @SystemLogger("获取用户资源")
    public List<ResourceVO> getResourceByUserId(Long id) {
        return BeanCopy.copyList(systemService.queryResourceByUserId(id), ResourceVO.class);
    }

    @Autowired
    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }
}
