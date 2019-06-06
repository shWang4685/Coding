package com.dao;

import com.entity.CompanyUser;
import com.entity.Performance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
    List<Performance> getPerformanceByTLName(CompanyUser user) ;
    /**
     * 获得员工ID为user_id 的员工绩效
     * @param user
     * @return
     */
    List<Performance> getPerformanceByByUserId(CompanyUser user);
    int insertPerformance(Performance performance);


    /**
     * 查询员工ID为-id.季度为quarter的员工绩效
     * @param performance
     * @return
     */
    List<Performance> selectPerByIdAndQuarter(Performance performance);

    /**
     * 删除员工ID为-id.季度为quarter的员工绩效
     * @param performance
     * @return
     */
    int deletePerByIdAndQuarter(Performance performance);

    List<Performance> selectLikeByName(HashMap hashMap);

    /**
     * hashMap中存放：查询的页码，每页多少个
     *offset  :页码
     * limit  :每页多少个
     * @param hashMap
     * @return
     */
    List<Performance> selectByPage(HashMap hashMap);
}
