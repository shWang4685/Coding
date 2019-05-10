package com.sqxinxibu.neikanhoutai.dao;

import com.sqxinxibu.neikanhoutai.entity.LoginTicket;

public interface LoginTicketDao {
    int insertLoginticket(LoginTicket loginTicket);

    LoginTicket chaxunByticket(String ticket);
}
