package com.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.CompanyUserDao;
import com.entity.AttPersonnel;
import com.entity.CompanyUser;
import com.service.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CompanyUserImpl implements CompanyUserService {
    @Autowired
    private CompanyUserDao companyUserDao;
    @Override
    public CompanyUser checkLogin(String parms) {
        JSONObject jsonObject=JSONObject.parseObject(parms);
        System.out.println("jsonObject:"+jsonObject);
        String lineArray = JSONArray.toJSONString(jsonObject);
        System.out.println("lineArray:"+lineArray);
        HashMap parseMap = JSON.parseObject(lineArray,HashMap.class);
        List<CompanyUser> singleOrderList = JSON.parseArray(JSON.parseObject(lineArray).getString("CompanyUser"),CompanyUser.class);

        return companyUserDao.checkUser(singleOrderList.get(0));
    }
}
