package com.service;

import com.entity.CompanyUser;
import com.entity.Performance;
import com.pojo.PerformanceInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PerformanceService {
    List<Performance> getAllPerformanceInf();
    List<Performance> getPerformanceByTMName(CompanyUser user);
    List<Performance> getPerformanceByTLName(CompanyUser user);
    List<Performance> getPerformanceByByUserId(CompanyUser user);
    List<PerformanceInfo> changePerformance(List<Performance> performances);
    boolean addPerformance(Performance performance);
}
