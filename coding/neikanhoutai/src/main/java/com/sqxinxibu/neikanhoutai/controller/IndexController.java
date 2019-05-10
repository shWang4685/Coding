package com.sqxinxibu.neikanhoutai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sqxinxibu.neikanhoutai.entity.User;
import com.sqxinxibu.neikanhoutai.service.Impl.AdminUserServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private AdminUserServiceImpl adminUserService;

    //注册
    @RequestMapping("/register")
    public Map<String, String> register(Model model, HttpServletResponse httpResponse, @RequestParam String username, @RequestParam String password, @RequestParam(value = "next",required = false)String next){
//        System.out.println("注册接口参数：username=="+username);
//        System.out.println("注册接口参数：password=="+password);
//        System.out.println("注册接口参数：next=="+next);
        Map<String,String> map = adminUserService.register(username,password);
        if (map.containsKey("ticket")){
            Cookie cookie = new Cookie("ticket",map.get("ticket"));
            cookie.setPath("/");
            httpResponse.addCookie(cookie);
            System.out.println("返回map数据1："+map);
            return map;
        }else {
            model.addAttribute("msg",map.get("msg"));
            System.out.println("返回map数据2："+map);

            return map;
        }
    }

    //登录
    @RequestMapping("/login")
    public String login(Model model, HttpServletResponse httpResponse, @RequestParam String username,@RequestParam String password,@RequestParam(value = "next",required = false)String next){
        //System.out.println("登录接口参数：next=="+next);
        Map<String,String> map = adminUserService.login(username,password);

        String json=JSON.toJSONString(map);
        System.out.println("登录查询返回信息："+ json);

        return  json;

//        if (map.containsKey("ticket")) {
////            Cookie cookie = new Cookie("ticket",map.get("ticket"));
////            cookie.setMaxAge(360);
////            cookie.setPath("/");
////            httpResponse.addCookie(cookie);
////
////            if (StringUtils.isNotBlank(next)){
////                return "redirect:"+next;
////            }
//
//            return "登录成功";
//        }else {
//            model.addAttribute("msg", map.get("msg"));
//            return "您还未注册，请先注册";
//        }

    }

}
