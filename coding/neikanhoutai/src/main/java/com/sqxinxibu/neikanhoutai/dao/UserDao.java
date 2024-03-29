package com.sqxinxibu.neikanhoutai.dao;

import com.sqxinxibu.neikanhoutai.entity.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User seletByName(String name);
}
