package top.arsiac.psychology.user.centre.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.arsiac.psychology.user.centre.pojo.vo.ResourceVO;

import java.util.List;

/**
 * <p>系统资源接口</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/24
 */
@Api(value = "/centre/system", tags = "系统资源")
@RequestMapping("/system")
public interface SystemApi {

    /**
     * <p>根据用户id获取资源</p>
     *
     * @param id 用户 id
     * @return 资源
     */
    @ApiOperation("根据用户id获取资源")
    @GetMapping("/menu/{id}")
    List<ResourceVO> getResourceByUserId(@PathVariable Long id);
}
