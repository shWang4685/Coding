package com.controller;

import com.alibaba.fastjson.JSON;
import com.entity.ResponsePram;
import com.service.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("logincase")
public class CompanyUserController {

    @Autowired
    private CompanyUserService companyUserService;

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @CrossOrigin(origins = "http://localhost:8888")
    public int checkLogin(@RequestBody String parms, HttpSession session, HttpServletResponse response){
        //将数据存储到session中

        session.setAttribute("data", "孤傲苍狼");
        System.out.println(session.getAttribute("data").toString());
        System.out.println("id2:"+session.getId());
        //判断是否有该用户名称
        companyUserService.checkLogin(parms);
        int temp;
        if(companyUserService.checkLogin(parms)==null){
            temp=0;
        }else {
            temp=1;
            session.setAttribute("user","hshshs");
        }
        return temp;
    }
}
