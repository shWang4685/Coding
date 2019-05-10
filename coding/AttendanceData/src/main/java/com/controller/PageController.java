package com.controller;

import com.entity.CompanyUser;
import com.entity.User;
import org.apache.catalina.Context;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    /**
     * restful风格实现页面跳转
     */
    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page){
        String goPage=null;
        String[] pageList={"emplist","login"};
        for(String str:pageList){
            if(page.equals(str.toString().trim())){
                goPage=page;
                break;
            }else {
                goPage="login";
            }
        }
        return goPage;
    }
//    @RequestMapping(value = "/login")
//    public String login(){
//        System.out.println("到这里来了：");
//        return "login";
//    }

    @RequestMapping(value = "/indexList",method = RequestMethod.POST)
    @ResponseBody
    public String showInfo(){
        System.out.println("shshshsh");
        return "empList";
    }


    @RequestMapping(value = "/getCheck",method = RequestMethod.POST)
    public String checkBoby(Model model, ModelMap map, HttpSession session){
////        String name= (String) session.getAttribute("data");
//////        System.out.println(name);
        System.out.println("id1:"+session.getId());

        System.out.println("-----------------进来了");
        User user=new User("admin",18);
        List<User> users=new ArrayList<User>();
        users.add(user);
        map.addAttribute("users",users);
        List<User> userser= (List<User>) map.get("users");

        model.addAttribute("users",users);
        return "emplist";
    }

    @RequestMapping(value = "/getAllEmp",method = RequestMethod.POST)
    public String  getAllEmp(HttpServletRequest request, HttpServletResponse response){
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");
        System.out.println("s--------l:"+user.toString());

        return "emplist";
    }
}
