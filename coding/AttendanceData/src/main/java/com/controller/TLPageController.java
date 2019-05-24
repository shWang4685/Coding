package com.controller;

import com.entity.CompanyUser;
import com.entity.Performance;
import com.entity.TMPerformance;
import com.google.common.io.Files;
import com.pojo.PerformanceInfo;
import com.service.PerformanceService;
import com.service.TMPerformanceService;
import com.utils.ExcelCSDN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
public class TLPageController {
    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private TMPerformanceService tmPerformanceService;

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
       for(TMPerformance pfd:tmPerformanceList){
           boolean bool=tmPerformanceService.addTMPerformance(pfd);
           if(!bool){
                System.out.println("插入数据出现了异常，请核查");
                break;
            }
        }

        //没什么作用，主要看js upload_file.js
        return "emplist";
    }



}
