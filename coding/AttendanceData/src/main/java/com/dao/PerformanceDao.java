package com.dao;

import com.entity.CompanyUser;
import com.entity.Performance;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PerformanceDao {
    /**
     * 获得员工的所有绩效信息
     * @return
     */
    List<Performance> getAllPerformanceInf();

    /**
     * 获得员工TM为 tmName的员工绩效
     * @param user
     * @return
     */
    List<Performance> getPerformanceByTMName(CompanyUser user);

    /**
     * 获得员工ID为user_id 的员工绩效
     * @param user
     * @return
     */
    List<Performance> getPerformanceByByUserId(CompanyUser user);
}
