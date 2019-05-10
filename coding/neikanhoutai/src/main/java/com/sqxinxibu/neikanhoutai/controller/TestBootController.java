package com.sqxinxibu.neikanhoutai.controller;

import com.sqxinxibu.neikanhoutai.entity.User;
import com.sqxinxibu.neikanhoutai.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class TestBootController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public String toIndex(HttpServletRequest request, Model model){
        System.out.println("showUser方法");
        return "showUser方法";
    }

}