package com.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONObject;
import com.dao.CompanyUserDao;

import com.entity.CompanyUser;
import com.service.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyUserImpl implements CompanyUserService {
    @Autowired
    private CompanyUserDao companyUserDao;
    @Override
    public CompanyUser checkLogin(String parms) {
        //将字符串转换成json对象，再转换成CompanyUser对象
        List<CompanyUser> CompanyUserList = JSON.parseArray(JSON.parseObject(parms).getString("CompanyUser"),CompanyUser.class);
        return companyUserDao.checkLogin(CompanyUserList.get(0));
    }

    /**
     * 通过员工编号查询用户信息
     * @param parms
     * @return
     */
    @Override
    public CompanyUser selectCompanyUserByUserID(int parms) {
        return companyUserDao.selectCompanyUserByUserId(parms);
    }

    /**
     *用户用户名称查询用户信息
     * @param user_account
     * @return
     */
    @Override
    public CompanyUser selectCompanyUserByAccount(String user_account) {
        return companyUserDao.selectCompanyUserByUserAccount(user_account);
    }

    @Override
    public int saveCompanyUser(CompanyUser comanyUser) {
        return companyUserDao.insertCompanyUser(comanyUser);
    }

    /**
     * 注册验证，验证用户名是否有效。验证员工编号是否有效，验证邮箱是否被注册
     * @param parms
     * @return
     */
    @Override
    public Map<String,String> checkRegits(String parms) {
        Map<String,String> msgCheck=new HashMap<String,String>();
        //将parms转成json对象
        JSONObject jsonObject = JSON.parseObject(parms);
        JSONArray jsonArray = jsonObject.getJSONArray("RigistUserInfo");
        JSONObject jo = jsonArray.getJSONObject(0);
        msgCheck.put("email",jo.getString("email").trim());
        //校验用户名称已经存在
        if(companyUserDao.selectCompanyUserByUserAccount(jo.getString("username"))!=null){
            //用户名已经存在
            msgCheck.put("regitsName","1");
        }else {
            msgCheck.put("regitsName","0");
        }
        //校验工号是否已经存在
        String str=jo.getString("jobnum");
        if(companyUserDao.selectCompanyUserByUserId(Integer.parseInt(str.substring(1)))!=null){
            //工号已经被注册过
            msgCheck.put("regitsJobNum","1");
        }else {
            msgCheck.put("regitsJobNum","0");
        }
        //校验邮箱是否已经被注册
        if(companyUserDao.selectCompanyUserByEmail(jo.getString("email"))!=null){
            //邮箱已经被注册过
            msgCheck.put("regitsEmail","1");
        }else {
            msgCheck.put("regitsEmail","0");
        }
        return msgCheck;
    }

    @Override
    public int registSave(String parms,String  code) {
        //将parms转成json对象
        JSONObject jsonObject = JSON.parseObject(parms);
        JSONArray jsonArray = jsonObject.getJSONArray("RigistUserInfo");
        JSONObject jo = jsonArray.getJSONObject(0);

        int user_id =Integer.parseInt(jo.getString("jobnum").substring(1));//员工ID-主键'
        String user_account=jo.getString("username").trim();//'员工登陆账号',
        String user_password =jo.getString("password").trim();//'员工登陆密码',
        String user_name=jo.getString("realname").trim();//'员工姓名',
        String user_TM=jo.getString("TMSelect").trim(); ;//'TM姓名',
        String user_TL=jo.getString("TLSelect").trim();//'TL姓名',
        int user_permission=3;//'权限级别'
        String user_email=jo.getString("email").trim();;//邮箱
        int user_state=0;//账号是否激活

        CompanyUser companyUser=new CompanyUser();
        companyUser.setUser_id(user_id);
        companyUser.setUser_account(user_account);
        companyUser.setUser_password(user_password);
        companyUser.setUser_name(user_name);
        companyUser.setUser_TM(user_TM);
        companyUser.setUser_TL(user_TL);
        companyUser.setUser_permission(user_permission);
        companyUser.setUser_email(user_email);
        companyUser.setUser_state(user_state);
        companyUser.setUser_code(code);


        return companyUserDao.insertCompanyUser(companyUser);
    }

    @Override
    public int updataStateByCode(String code) {
        return companyUserDao.updataCompanyUserStateByCode(code);
    }


}
