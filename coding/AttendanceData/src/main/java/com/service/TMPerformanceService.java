package com.service;

import com.entity.CompanyUser;
import com.entity.TMPerformance;
import com.pojo.TMPerformanceInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TMPerformanceService {
    List<TMPerformance> getAllTMPerformanceInf();
    List<TMPerformance> getTMPerformanceByTMName(CompanyUser user);
    List<TMPerformance> getTMPerformanceByTLName(CompanyUser user);
    List<TMPerformance> getTMPerformanceByByUserId(CompanyUser user);
    boolean addTMPerformance(TMPerformance tmPerformance);
    List<TMPerformanceInfo> changeTMPerformance(List<TMPerformance> tmPerformances);
    List<TMPerformance> getTMPerformanceByLikeNameOrTMName(String likeName,String TLName);
    boolean checkTMPerformanceIsExist(TMPerformance tmPerformances);
    boolean deleteTMPerfomanceIsExist(TMPerformance tmPerformances);
}
