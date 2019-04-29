package com.service.Impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    /**
     * 添加用户
     * @param user
     */

    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.insert(user);
    }


}
