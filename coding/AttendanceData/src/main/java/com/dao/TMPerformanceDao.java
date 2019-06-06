package com.dao;

import com.entity.CompanyUser;
import com.entity.Performance;
import com.entity.TMPerformance;

import java.util.HashMap;
import java.util.List;

public interface TMPerformanceDao {
    List<TMPerformance> getTMPerformanceByTMName(CompanyUser user);
    List<TMPerformance> getTMPerformanceByTLName(CompanyUser user);
    List<TMPerformance> getAllTMPerformance();
    List<TMPerformance> getTMPerformanceByByUserId(CompanyUser user);
    int insertTMPerformance(TMPerformance tmPerformance);
    /**
     * 查询TMID为-id.季度为quarter的员工绩效
     * @param tmPerformance
     * @return
     */
    List<TMPerformance> selectTMPerByIdAndQuarter(TMPerformance tmPerformance);
    List<TMPerformance> selectTMPerByNameOrTLName(HashMap map);
    /**
     * 删除tmID为-id.季度为quarter的员工绩效
     * @param tmPerformance
     * @return
     */
    int deleteTMPerByIdAndQuarter(TMPerformance tmPerformance);


}
