package com.service.Impl;

import com.dao.CompanyUserDao;
import com.dao.PerformanceDao;
import com.entity.CompanyUser;
import com.entity.Performance;
import com.pojo.PagePerformance;
import com.pojo.PerformanceInfo;
import com.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class PerformanceImpl implements PerformanceService {
    @Autowired
    private  PerformanceDao performanceDao;

    @Autowired
    private CompanyUserDao companyUserDao;
    /**
     * 获得所有员工的绩效信息
     * @return
     */
    @Override
    public List<Performance> getAllPerformanceInf() {
        return performanceDao.getAllPerformanceInf();
    }

    /**
     * 获得员工TM为 tmName的员工绩效
     * @param user
     * @return
     */
    @Override
    public List<Performance> getPerformanceByTMName(CompanyUser user) {
        return performanceDao.getPerformanceByTMName(user);
    }
    /**
     * 获得员工TL为 tmName的员工绩效
     * @param user
     * @return
     */
    @Override
    public List<Performance> getPerformanceByTLName(CompanyUser user) {
        return performanceDao.getPerformanceByTLName(user);
    }

    /**
     * 获得员工ID为user_id 的员工绩效
     * @param user
     * @return
     */
    @Override
    public List<Performance> getPerformanceByByUserId(CompanyUser user) {
        return performanceDao.getPerformanceByByUserId(user);
    }

    @Override
    public List<Performance> getPerformanceByLikeName(String  likeName,String likeTMName,String likeTLName) {
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("likeName",likeName);
        hashMap.put("likeTMName",likeTMName);
        hashMap.put("likeTLName",likeTLName);
        return performanceDao.selectLikeByName(hashMap) ;
    }

    /**
     * 将数据库中的绩效数据项对象转换成20条字段的实体
     * @param performances
     * @return
     */
    @Override
    public List<PerformanceInfo> changePerformance(List<Performance> performances) {
        List<PerformanceInfo> performanceInfos=new ArrayList<PerformanceInfo>();
        for (Performance pf:performances){
            PerformanceInfo  performanceInfo=new PerformanceInfo();
            performanceInfo.setPfe_id(pf.getPfe_id());
            //将员工ID转成员工姓名存到 performanceInfo
            if(companyUserDao.selectCompanyUserByUserId(pf.getPfe_user_id())==null){
                continue;
            }
            performanceInfo.setPfe_user_name(companyUserDao.selectCompanyUserByUserId(pf.getPfe_user_id()).getUser_name());
            performanceInfo.setPfe_tm_name(companyUserDao.selectCompanyUserByUserId(pf.getPfe_user_id()).getUser_TM());
            performanceInfo.setPfe_rating(pf.getPfe_rating());
            performanceInfo.setPfe_totalScore(pf.getPfe_totalScore());
            performanceInfo.setPfe_tmScore(pf.getPfe_tmScore());
            performanceInfo.setPfe_tlScore(pf.getPfe_tlScore());

            //加分项
            String temp=pf.getPfe_addPoint();
            String[] temps=temp.split("/");
            for(int i=0;i<temps.length;i++){
                if(i==0){
                    performanceInfo.setPfe_fullAtt(temps[i]);
                }else if(i==1){
                    performanceInfo.setPfe_lecturer(temps[i]);
                }else if(i==2){
                    performanceInfo.setPfe_noLeakage(temps[i]);
                }else if(i==3){
                    performanceInfo.setPfe_overValidBug(temps[i]);
                }else if(i==4){
                    performanceInfo.setPfe_bugRanking(temps[i]);
                }else  if(i==5){
                    performanceInfo.setPfe_contribution(temps[i]);
                }else if(i==6){
                    performanceInfo.setPfe_praise(temps[i]);
                }
            }
            //扣分项
            String[] minus=pf.getPfe_minusPoint().split("/");
            for(int j=0;j<minus.length;j++){
                if(j==0){
                    performanceInfo.setPfe_tardiness(minus[j]);
                }else if(j==1){
                    performanceInfo.setPfe_lessValidBug(minus[j]);
                }else if(j==2){
                    performanceInfo.setPfe_leakage(minus[j]);
                }else if(j==3){
                    performanceInfo.setPfe_complaint(minus[j]);
                }else if(j==4){
                    performanceInfo.setPfe_InfoSafety(minus[j]);
                }
            }
            //原始数据
           String[] original=pf.getPfe_originalData().split("/");
           for(int i=0;i<original.length;i++){
               if(i==0){
                   performanceInfo.setPfe_bugRankingNum(original[i]);
               }else if(i==1){
                   performanceInfo.setPfe_workingDay(original[i]);
               }else if(i==2){
                   performanceInfo.setPfe_bugPerDay(original[i]);
               }else if(i==3){
                   performanceInfo.setPfe_LatenessNum(original[i]);
               }else if(i==4){
                   performanceInfo.setPfe_missing(original[i]);
               }
           }
            performanceInfo.setPfe_tmComment(pf.getPfe_tmComment());
            performanceInfo.setPfe_tlComment(pf.getPfe_tlComment());
            performanceInfo.setPfe_quarter(pf.getPfe_quarter());
            performanceInfos.add(performanceInfo);
        }

        return performanceInfos;
    }

    /**
     * 往绩效数据表中插入数据
     * @param performance
     * @return
     */
    @Override
    public boolean addPerformance(Performance performance) {
        boolean bool=true;
        if(performanceDao.insertPerformance(performance)<0){
            bool=false;
        }
        return bool;
    }

    /**
     * 判断是否已经有该员工在当前季度的数据
     * @return
     */
    @Override
    public boolean checkPerformanceIsExist(Performance performance) {
        List<Performance> temp=performanceDao.selectPerByIdAndQuarter(performance);
        if(temp.size()>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除id为pfe_user_id/季度为：pfe_quarter的绩效数据，这里主要用在上传数据替换
     * @return
     */
    @Override
    public boolean deletePerfomanceIsExist(Performance performance) {
        int temp=performanceDao.deletePerByIdAndQuarter(performance);
        if(temp>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Performance> selectPerformanceByPage( PagePerformance pagePerformance) {
        HashMap<String,Integer> hashMap=new HashMap<String,Integer>();

        System.out.println("offset:"+pagePerformance.getPageIndex());
        System.out.println("limit:"+pagePerformance.getPageCount());

        //开始值：页码+(页码-1)*limit
        hashMap.put("offset",1+((pagePerformance.getPageIndex()-1)*pagePerformance.getPageCount()));
        hashMap.put("limit",pagePerformance.getPageCount());
        return performanceDao.selectByPage(hashMap);
    }


}
