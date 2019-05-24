package com.service;

import com.entity.CompanyUser;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CompanyUserService {
    CompanyUser checkLogin(String parms);
    CompanyUser selectCompanyUserByUserID(int parms);
    CompanyUser selectCompanyUserByAccount(String user_account);
    int saveCompanyUser(CompanyUser comanyUser);
    Map<String,String> checkRegits(String parms);
    int registSave(String parms,String code);
    int updataStateByCode(String code);
}
