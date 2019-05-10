package com.sqxinxibu.neikanhoutai.service.Impl;

import com.sqxinxibu.neikanhoutai.dao.LoginTicketDao;
import com.sqxinxibu.neikanhoutai.entity.LoginTicket;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginTickerService {

    @Resource
    private LoginTicketDao loginTicketDao;


    public LoginTicket chaxunByLoginTicket(String ticket){
       return loginTicketDao.chaxunByticket(ticket);
    }
}
