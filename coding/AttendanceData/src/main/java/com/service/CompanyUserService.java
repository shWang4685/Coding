package com.service;

import com.entity.CompanyUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyUserService {
    CompanyUser checkLogin(String parms);

}
