package com.dao;

import com.entity.CompanyUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyUserDao {
    CompanyUser checkUser(CompanyUser user);
    CompanyUser checkLogin(CompanyUser user);
    CompanyUser selectCompanyUserByUserId(int user_id);
}
