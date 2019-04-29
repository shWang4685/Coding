package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository

public interface UserDao {
    int insert(User record);

}
