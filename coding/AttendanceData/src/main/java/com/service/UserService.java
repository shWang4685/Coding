package com.service;

import com.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    void saveUser(User user);
}
