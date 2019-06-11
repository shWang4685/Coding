package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.assist.ErrEnum;
import com.entity.CompanyUser;
import com.entity.Performance;
import com.entity.TMPerformance;
import com.google.common.io.Files;
import com.pojo.PagePerformance;
import com.pojo.PerformanceInfo;
import com.service.PerformanceService;
import com.service.TMPerformanceService;
import com.utils.ExcelCSDN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
public class TLPageController {
    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private TMPerformanceService tmPerformanceService;

    /**
     * 员工数据上传
     * @param file
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadEmp",method = RequestMethod.POST)
    public String uploadFile(@RequestPart("file") MultipartFile file,HttpServletRequest request,Model model) throws IOException {

        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");

        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取项目的路径 + 拼接得到文件要保存的位置
        String filePath = System.getProperties().getProperty("user.dir") + "\\AttendanceData\\src\\main\\resources\\file\\" + fileName;
        System.out.println(fileName);
        System.out.println(filePath);
        // 创建一个文件的对象
        File file1 = new File(filePath);
        // 创建父文件夹
        Files.createParentDirs(file1);
        // 把上传的文件复制到文件对象中
        file.transferTo(file1);
        //把上传的内容存到数据表中去
        List<Performance> performanceList=ExcelCSDN.getPerformancelInfoBySheet(filePath,0);
        for(Performance pf:performanceList){
            //判断是否已经存在该季度的数据
            if(performanceService.checkPerformanceIsExist(pf)){
                //更新数据1.先删除数据；2 再插入数据
                performanceService.deletePerfomanceIsExist(pf);
            }
            boolean bool=performanceService.addPerformance(pf);
            if(!bool){
                System.out.println("插入数据出现了异常，请何查");
                break;
            }
        }
//        //解析绩效数据表
//        List<Performance> performances=performanceService.getPerformanceByTLName(user);
//        System.out.println("size:"+performances.size());
//        //将绩效数据详情表存入model
//        List<PerformanceInfo>  performanceInfos=performanceService.changePerformance(performances);
//        model.addAttribute("performanceInfos",performanceInfos);
//        //从数据表中读取数据
        //没什么作用，主要看js upload_file.js
        return "emplist";
    }

    @RequestMapping(value = "/uploadTM",method = RequestMethod.POST)
    public String uploadTM(@RequestPart("file") MultipartFile file,HttpServletRequest request,Model model) throws IOException {
        CompanyUser user=(CompanyUser)request.getSession(false).getAttribute("CompanyUser");

        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取项目的路径 + 拼接得到文件要保存的位置
        String filePath = System.getProperties().getProperty("user.dir") + "\\AttendanceData\\src\\main\\resources\\file\\tm\\" + fileName;
        // 创建一个文件的对象
        File file1 = new File(filePath);
        // 创建父文件夹
        Files.createParentDirs(file1);
        // 把上传的文件复制到文件对象中
        file.transferTo(file1);
        //把上传的内容存到数据表中去
       List<TMPerformance> tmPerformanceList=ExcelCSDN.getTMPerformancelInfoBySheet(filePath,0);
       for(TMPerformance tm:tmPerformanceList){
           System.out.println(tm.toString());
       }
       for(TMPerformance pfd:tmPerformanceList){
           //判断是否已经存在该季度的数据
           if(tmPerformanceService.checkTMPerformanceIsExist(pfd)){
               //更新数据1.先删除数据；2 再插入数据

              tmPerformanceService.deleteTMPerfomanceIsExist(pfd);
           }
           boolean bool=tmPerformanceService.addTMPerformance(pfd);
           if(!bool){
               break;
           }

        }

        //没什么作用，主要看js upload_file.js
        return "emplist";
    }
    @RequestMapping(value = "/admin/pageIndex",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public PagePerformance checkLogin(@RequestBody String parms, HttpServletRequest request, HttpServletResponse response){
        //拿到参数查询页码中的数据存放到PagePerformance中
        PagePerformance ppf=new PagePerformance();
        JSONObject jsonObject = JSON.parseObject(parms);
        //获得页码
        int pageIndex=Integer.parseInt(jsonObject.getString("pageClickIndex"));
        ppf.setPageIndex(pageIndex);
        //获得数据
        List<Performance> performanceList=performanceService.selectPerformanceByPage(ppf);
        List<PerformanceInfo> performanceInfoList= performanceService.changePerformance(performanceList);
        //将数据存入PagePerformance 统一返回
        ppf.setPerformanceInfoList(performanceInfoList);
        return ppf;

//        //判断是否有该用户名称
//        CompanyUser user = companyUserService.checkLogin(parms);
//
//        if(user!=null){
//            HttpSession session = request.getSession();
//            // begin:拦截器所需
//            session.setAttribute("CompanyUser", user);
//            // end:拦截器所需
//            return Msg.success();
//        }else {
//            return Msg.error().add("errMsg", ErrEnum.PASSWORD_LOGIN_ERROR.getErrorMessage());
//        }
    }
}
