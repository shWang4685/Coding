package com.controller;
import com.assist.ErrEnum;
import com.assist.Msg;
import com.entity.CompanyUser;
import com.entity.Performance;
import com.service.CompanyUserService;
import com.service.MailService;
import com.utils.CodeUtil;
import com.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
public class UserInfoController {
    @Autowired
    private CompanyUserService companyUserService;

    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/logindemo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    //@CrossOrigin(origins ="http://localhost:8888")
    public Msg checkLogin(@RequestBody String parms, HttpServletRequest request, HttpServletResponse response){
        //判断是否有该用户名称
        CompanyUser user = companyUserService.checkLogin(parms);

        if(user!=null){
            HttpSession session = request.getSession();
            // begin:拦截器所需
            session.setAttribute("CompanyUser", user);
            // end:拦截器所需
            return Msg.success();
        }else {
            return Msg.error().add("errMsg", ErrEnum.PASSWORD_LOGIN_ERROR.getErrorMessage());
        }
    }

    @RequestMapping(value = "/registAction",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    //@CrossOrigin(origins ="http://localhost:8888")
    public Msg registAction(@RequestBody String parms){
        //校验参数是否已经存在,将校验的信息放到map中
        Map<String,String> registCheckResult=companyUserService.checkRegits(parms);
        System.out.println(registCheckResult.get("email"));
        if(registCheckResult.get("regitsName").equals("1")||registCheckResult.get("regitsJobNum").equals("1")
                ||registCheckResult.get("regitsEmail").equals("1")){
            Msg msg=new Msg();
            msg.setMsg("注册信息填写已存在");
            msg.setCode(102);
            msg.setMapStr(registCheckResult);
            return  msg;
        }else {
            //生成激活码
            String code=CodeUtil.generateUniqueCode();
            int temp=companyUserService.registSave(parms,code);
            if(temp>0){
                //发个邮件
                // 设置邮件内容
                //设置主题
                String themeText="主题：账户注册激活"+System.currentTimeMillis();
                System.out.println("时间戳："+themeText);
                String content = "<html><head></head><body><h1>这是一封激活邮件,请复制以下链接到浏览器激活</h1><h3><a href=http://192.168.71.211:8888/registActivation?code="
                        + code + "'>http://192.168.71.211:8888/registActivation?code=" + code
                        + "</href></h3></body></html>";
                mailService.sendSimplemail(registCheckResult.get("email"), themeText, content);
                return Msg.registSucess();
            }else {
                return Msg.error();
            }
        }
    }


}
