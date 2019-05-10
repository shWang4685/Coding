package com.controller;

import com.assist.ErrEnum;
import com.assist.Msg;
import com.entity.CompanyUser;
import com.entity.Performance;
import com.service.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginDemoController {
    @Autowired
    private CompanyUserService companyUserService;

    @RequestMapping(value = "/logindemo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @CrossOrigin(origins ="http://localhost:8888")
    public Msg checkLogin(@RequestBody String parms, HttpServletRequest request, HttpServletResponse response){
        //判断是否有该用户名称
        System.out.println("进来了");
        CompanyUser user = companyUserService.checkLogin(parms);
        System.out.println("第一个user:"+user);
        if(user!=null){
            System.out.println("到了这里null");
            HttpSession session = request.getSession();
            // begin:拦截器所需
            session.setAttribute("CompanyUser", user);
            // end:拦截器所需
            return Msg.success();
        }else {
            return Msg.error().add("errMsg", ErrEnum.PASSWORD_LOGIN_ERROR.getErrorMessage());
        }
    }

}
