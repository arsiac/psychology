package top.arsiac.psychology.user.centre.service;


import top.arsiac.psychology.user.centre.pojo.dto.UserDTO;

import java.util.List;

/**
 * <p>用户业务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public interface UserService {
    /**
     * <p>查找全部</p>
     *
     * @return 全部用户
     * */
    List<UserDTO> queryAll();

    /**
     * <p>模糊查询</p>
     *
     * @param dto 用户信息
     * @return 查询结果
     * */
    List<UserDTO> queryFuzzy(UserDTO dto);

    /**
     * <p>根据id查询</p>
     *
     * @param id 用户id
     * @return 查询结果
     * */
    UserDTO queryById(Long id);

    /**
     * <p>添加新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    boolean add(UserDTO dto);

    /**
     * <p>批量添加新用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    boolean batchAdd(List<UserDTO> dtoList);

    /**
     * <p>更新用户</p>
     *
     * @param dto 用户信息
     * @return 是否成功
     */
    boolean modify(UserDTO dto);

    /**
     * <p>删除用户</p>
     *
     * @param dto 用户信息 id version
     * @return 是否成功
     */
    boolean remove(UserDTO dto);

    /**
     * <p>批量删除用户</p>
     *
     * @param dtoList 用户信息
     * @return 是否成功
     */
    boolean batchRemove(List<UserDTO> dtoList);
}
