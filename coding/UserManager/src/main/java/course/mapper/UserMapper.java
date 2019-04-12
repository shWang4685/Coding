package course.mapper;


import course.entity.User;

import java.util.List;

public interface  UserMapper {
    int deleteByPrimaryKey(Integer userId);
    int insert(User record);
    List<User> getAllUser();
}
