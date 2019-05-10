package com.sqxinxibu.neikanhoutai.service.Impl;

import com.sqxinxibu.neikanhoutai.dao.UserDao;
import com.sqxinxibu.neikanhoutai.entity.User;
import com.sqxinxibu.neikanhoutai.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


}
