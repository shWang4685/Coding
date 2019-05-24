package com.controller;

import com.entity.CompanyUser;
import com.entity.Performance;
import com.entity.TMPerformance;
import com.entity.User;
import com.google.common.io.Files;
import com.pojo.PerformanceInfo;
import com.pojo.TMPerformanceInfo;
import com.service.CompanyUserService;
import com.service.PerformanceService;
import com.service.TMPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private CompanyUserService companyUserService;

    @Autowired
    private TMPerformanceService tmPerformanceService;
    /**
     * restful风格实现页面跳转
     */
    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page){
        String goPage=null;
        String[] pageList={"emplist","login","regist","registSucess","registFail","uploadfile","indexUp","tmpage","allTMInfoPage"};
        for(String str:pageList){
            if(page.equals(str.toString().trim())){
                goPage=page;
                break;
            }else{
                goPage="login";
            }
        }
        return goPage;
    }

    /**
     * 激活账户接口
     * @param code
     * @return
     */
    @RequestMapping(value = "/registActivation",method = RequestMethod.GET)
    public String  registActivation (@RequestParam String code){
        if(companyUserService.updataStateByCode(code.trim())>0){
            return "registSucess";
        }else {
            return "registFail";
        }
    }

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

    /**
     * 跳转到员工绩效页面。并且将数据传输过去
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getAllEmp",method = RequestMethod.POST)
    public String  getAllEmp(HttpServletRequest request, HttpServletResponse response,Model model){
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");
        List<Performance> performances=null;
        //如果权限等级为0那么存储所有的员工绩效
        //如果权限等级为1那么存储TL为xx的员工绩效
        //如果权限等级为2那么存储TM为xx的员工绩效
        //如果权限等级为3那么存储ID为xx的员工绩效
        if(user.getUser_permission()==0){
            performances=performanceService.getAllPerformanceInf();
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "adminpage";
        }else if(user.getUser_permission()==1){
            performances=performanceService.getPerformanceByTLName(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "adminpage";
        }else if (user.getUser_permission()==2){
            //查看到自己的数据信息
            List<TMPerformance> tmPerformances=tmPerformanceService.getTMPerformanceByByUserId(user);
            List<TMPerformanceInfo> tmPerformanceInfos=tmPerformanceService.changeTMPerformance(tmPerformances);
            model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
            return "tmpage";
        }else if (user.getUser_permission()==3){
            performances=performanceService.getPerformanceByByUserId(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "emplist";
        }else {
            model.addAttribute("performanceInfos",null);
            return "emplist";
        }
    }

    /**
     * 该接口为TM使用调用自己的数据，
     * 1.如过权限大于2时候，调用时候拉起下属的普通员工信息
     * 2.如果小于2时候，拉起显示自己的绩效（普通员工）
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllEmpWithTM",method = RequestMethod.POST)
    public String  getAllEmpWithTM(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Performance> performances=null;
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");
        //如果是员工的TM是自己的名字，就拉取团队组员的信息（为了防止登录后，访问该接口)
        if(user.getUser_permission()==0){
            performances=performanceService.getAllPerformanceInf();
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "adminpage";
        }else  if(user.getUser_permission()==1){
            performances=performanceService.getPerformanceByTLName(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "adminpage";
        } else if(user.getUser_permission()==2){
            //查看到自己组的数据信息
            performances=performanceService.getPerformanceByTMName(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "emplist";
        }else if (user.getUser_permission()==3){
            performances=performanceService.getPerformanceByByUserId(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "emplist";
        }
       model.addAttribute("performanceInfos",null);
       return "emplist";
    }


    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    public  String uploadIndex(){
        return "uploadfile";
    }


    /**
     * 获得TM的信息
     * 如果权限是0：获得所有的TM信息
     * 如果权限是1：获得本组的TM信息
     * 如果全权限2：获得自己的信息
     * 如果权限是3：获得自己的信息
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllTMData",method = RequestMethod.POST)
    public String  getAllTMData(HttpServletRequest request, HttpServletResponse response,Model model){
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");
        if(user.getUser_permission()==0){
            //权限为0时候获得所有的TM信息
            List<TMPerformance> tmPerformances=tmPerformanceService.getAllTMPerformanceInf();
            List<TMPerformanceInfo> tmPerformanceInfos= tmPerformanceService.changeTMPerformance(tmPerformances);
            model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
            return "allTMInfoPage";
        }else if(user.getUser_permission()==1){
            //权限为1时候获得的本组TM信息
            List<TMPerformance> tmPerformances=tmPerformanceService.getTMPerformanceByTLName(user);
            List<TMPerformanceInfo> tmPerformanceInfos=  tmPerformanceService.changeTMPerformance(tmPerformances);
            model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
            return "allTMInfoPage";
        } else if(user.getUser_permission()==2){
            //查看到自己的数据信息
            List<TMPerformance> tmPerformances=tmPerformanceService.getTMPerformanceByByUserId(user);
            List<TMPerformanceInfo> tmPerformanceInfos=tmPerformanceService.changeTMPerformance(tmPerformances);
            model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
            return "tmpage";
        }else if (user.getUser_permission()==3){
            List<Performance> performances=performanceService.getPerformanceByByUserId(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            return "emplist";
        }
        model.addAttribute("performanceInfos",null);
        return "emplist";
    }
}
