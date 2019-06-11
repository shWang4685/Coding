package com.controller;

import com.entity.CompanyUser;
import com.entity.Performance;
import com.entity.TMPerformance;
import com.entity.User;
import com.google.common.io.Files;
import com.pojo.Fruit;
import com.pojo.PagePerformance;
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
import java.text.DecimalFormat;
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
        String[] pageList={"emplist","login","regist","registSucess","registFail","uploadfile","indexUp","tmpage","allTMInfoPage","Thyleaf"};
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
        PagePerformance pagePerformance=new PagePerformance();
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");
        List<Performance> performances=null;
        PagePerformance ppf=new PagePerformance();
        ppf.setPageIndex(1);
        //如果权限等级为0那么存储所有的员工绩效
        //如果权限等级为1那么存储TL为xx的员工绩效
        //如果权限等级为2那么存储TM为xx的员工绩效
        //如果权限等级为3那么存储ID为xx的员工绩效
        if(user.getUser_permission()==0){
            //一共能查出多少条数据
            List<Performance> perfs=performanceService.getAllPerformanceInf();
            List<PerformanceInfo> perfInfs=performanceService.changePerformance(perfs);
            //获得权限为0的账号显示信息
           // performances=performanceService.getAllPerformanceInf();

            performances=performanceService.selectPerformanceByPage(ppf);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);

            //获得一共多少条数据
            String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+perfInfs.size()+" 条数据";
            model.addAttribute("performanceSize",performanceInfoSize);
            //获得总共多少页（一共多少条数据%每页显示多少个）
            DecimalFormat df=new DecimalFormat("0.00");
            int pageCount=perfInfs.size()/ pagePerformance.getPageCount();
            //61组数据，分7页而不是分6页
            if(perfInfs.size()% pagePerformance.getPageCount()!=0){
                model.addAttribute("pageCount",pageCount+1);
            }else {
                model.addAttribute("pageCount",pageCount);
            }
            return "adminpage";
        }else if(user.getUser_permission()==1){
            performances=performanceService.getPerformanceByTLName(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+performanceInfos.size()+" 条数据";
            model.addAttribute("performanceSize",performanceInfoSize);
            int pageCount=performanceInfos.size()/ pagePerformance.getPageCount();
            if(performanceInfos.size()% pagePerformance.getPageCount()!=0){
                model.addAttribute("pageCount",pageCount+1);
            }else {
                model.addAttribute("pageCount",pageCount);
            }
            return "adminpage";
        }else if (user.getUser_permission()==2){
            //查看到自己的数据信息
            List<TMPerformance> tmPerformances=tmPerformanceService.getTMPerformanceByByUserId(user);
            List<TMPerformanceInfo> tmPerformanceInfos=tmPerformanceService.changeTMPerformance(tmPerformances);
            model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
            String tmPerformanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+tmPerformanceInfos.size()+" 条数据";
            model.addAttribute("tmPerformanceSize",tmPerformanceInfoSize);

            return "tmpage";
        }else if (user.getUser_permission()==3){
            performances=performanceService.getPerformanceByByUserId(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+performanceInfos.size()+" 条数据";
            model.addAttribute("performanceSize",performanceInfoSize);
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
            String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+performanceInfos.size()+" 条数据";
            model.addAttribute("performanceSize",performanceInfoSize);
            return "adminpage";
        }else  if(user.getUser_permission()==1){
            performances=performanceService.getPerformanceByTLName(user);
            List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
            model.addAttribute("performanceInfos",performanceInfos);
            String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+performanceInfos.size()+" 条数据";
            model.addAttribute("performanceSize",performanceInfoSize);
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
            String tmPerformanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+tmPerformanceInfos.size()+" 条数据";
            model.addAttribute("tmPerformanceSize",tmPerformanceInfoSize);
            return "allTMInfoPage";
        }else if(user.getUser_permission()==1){
            //权限为1时候获得的本组TM信息
            List<TMPerformance> tmPerformances=tmPerformanceService.getTMPerformanceByTLName(user);
            List<TMPerformanceInfo> tmPerformanceInfos=  tmPerformanceService.changeTMPerformance(tmPerformances);
            model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
            String tmPerformanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+tmPerformanceInfos.size()+"条数据";
            model.addAttribute("tmPerformanceSize",tmPerformanceInfoSize);
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



    @RequestMapping(value = "/admin/showPerInfoByLikeNameH",method = RequestMethod.GET)
    public  String showP(Model model,@RequestParam String userName,@RequestParam String textTMByName
                         ,@RequestParam String textByTLName,
                         HttpServletRequest request){
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");

        //用户名称模糊查询出 数据
        List<Performance> performances= performanceService.getPerformanceByLikeName(userName.trim(),textTMByName.trim(),textByTLName.trim());
        //转换成实体
        List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
        //拉去一共多少条数
        String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+performanceInfos.size()+"条数据";
        model.addAttribute("performanceSize",performanceInfoSize);
        model.addAttribute("performanceInfos",performanceInfos);
        //局部刷新使用
        return "adminpage::content";
    }

    @RequestMapping(value = "/admin/showPerInfoByLikeNameOrTLName",method = RequestMethod.GET)
    public  String showTMP(Model model,@RequestParam String likeName,@RequestParam String likeTLName,HttpServletRequest request){
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");

        List<TMPerformance> tmPerformances=tmPerformanceService.getTMPerformanceByLikeNameOrTMName(likeName.trim(),likeTLName.trim());
        //转换成实体
        List<TMPerformanceInfo> tmPerformanceInfos=tmPerformanceService.changeTMPerformance(tmPerformances);
        //拉去一共多少条数
        String performanceInfoSize="亲爱的 "+user.getUser_name()+"   您好！   "+"为您展示"+tmPerformanceInfos.size()+"条数据";
        model.addAttribute("tmPerformanceSize",performanceInfoSize);
        model.addAttribute("tmPerformanceInfos",tmPerformanceInfos);
        //局部刷新使用
        return "allTMInfoPage::content";
    }

    @RequestMapping(value = "/fruit/detail")
    public String detail(Model model,int id) {
        List<Fruit> fruits = new ArrayList<>();
        if(id == 0) {
            String[] strings={"香蕉","苹果","凤梨","西瓜"};
            for(int i = 1; i <= strings.length; i++) {
                fruits.add(new Fruit(i,strings[i-1]));
            }
        } else if(id == 1) {
            String[] strings={"菠萝","草莓","西红柿","黑莓","百香果","葡萄"};
            for(int i = 1; i <= strings.length; i++) {
                fruits.add(new Fruit(i,strings[i-1]));
            }
        }
        model.addAttribute("fruits",fruits);
        return "Thyleaf";
    }
}
