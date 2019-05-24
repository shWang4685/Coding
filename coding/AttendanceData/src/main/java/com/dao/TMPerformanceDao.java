package com.dao;

import com.entity.CompanyUser;
import com.entity.Performance;
import com.entity.TMPerformance;

import java.util.List;

public interface TMPerformanceDao {
    List<TMPerformance> getTMPerformanceByTMName(CompanyUser user);
    List<TMPerformance> getTMPerformanceByTLName(CompanyUser user);
    List<TMPerformance> getAllTMPerformance();
    List<TMPerformance> getTMPerformanceByByUserId(CompanyUser user);
    int insertTMPerformance(TMPerformance tmPerformance);

}
