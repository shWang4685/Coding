package com.sqxinxibu.neikanhoutai.service;

import com.sqxinxibu.neikanhoutai.entity.User;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

}
