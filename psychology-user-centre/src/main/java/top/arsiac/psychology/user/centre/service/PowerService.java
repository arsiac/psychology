package top.arsiac.psychology.user.centre.service;


import top.arsiac.psychology.user.centre.dao.dto.PowerDTO;

import java.util.List;

/**
 * <p>权力业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface PowerService {

    /**
     * <p>查找全部</p>
     *
     * @return 全部权力
     * */
    List<PowerDTO> queryAll();


}
