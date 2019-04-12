package course.service.inf;

import course.entity.User;

import java.util.List;

public interface UserServiceInf {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 获得所有的用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}
