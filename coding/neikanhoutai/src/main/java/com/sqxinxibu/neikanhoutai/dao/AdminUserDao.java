package com.sqxinxibu.neikanhoutai.dao;

import com.sqxinxibu.neikanhoutai.entity.AdminUser;
import com.sqxinxibu.neikanhoutai.entity.LoginTicket;
import com.sqxinxibu.neikanhoutai.entity.User;

import java.util.List;

public interface AdminUserDao {
    AdminUser seletByNameLogin(String name);

    List<AdminUser> seletByName(String name);

    int insertUser(AdminUser user);

    int insertLoginticket(LoginTicket loginTicket);

    LoginTicket selectByPrimaryKey(int id);
}
