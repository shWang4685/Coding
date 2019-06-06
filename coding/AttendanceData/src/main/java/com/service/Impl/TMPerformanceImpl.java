package com.service.Impl;

import com.dao.CompanyUserDao;
import com.dao.TMPerformanceDao;
import com.entity.CompanyUser;
import com.entity.TMPerformance;
import com.pojo.TMPerformanceInfo;
import com.service.TMPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TMPerformanceImpl  implements TMPerformanceService {

    @Autowired
    private TMPerformanceDao tmPerformanceDao;
    @Autowired
    private CompanyUserDao companyUserDao;

    /**
     * 获得所以的TM信息
     * @return
     */
    @Override
    public List<TMPerformance> getAllTMPerformanceInf() {
        return tmPerformanceDao.getAllTMPerformance();
    }

    /**
     * 通过TM名称获得TM的信息
     * @param user
     * @return
     */
    @Override
    public List<TMPerformance> getTMPerformanceByTMName(CompanyUser user) {
        return tmPerformanceDao.getTMPerformanceByTMName(user);
    }

    @Override
    public List<TMPerformance> getTMPerformanceByTLName(CompanyUser user) {
        return tmPerformanceDao.getTMPerformanceByTLName(user);
    }

    @Override
    public List<TMPerformance> getTMPerformanceByByUserId(CompanyUser user) {
        return tmPerformanceDao.getTMPerformanceByByUserId(user);
    }

    @Override
    public boolean addTMPerformance(TMPerformance tmPerformance) {
        System.out.println("进来了");
        System.out.println(tmPerformance.toString());
        int temp= tmPerformanceDao.insertTMPerformance(tmPerformance);
        System.out.println("temp:"+temp);
        if(temp<0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 将数据库中的字段转换成TMPerformanceInfo
     * @param tmPerformances
     * @return
     */
    @Override
    public List<TMPerformanceInfo> changeTMPerformance(List<TMPerformance> tmPerformances) {
        List<TMPerformanceInfo> tmPerformanceInfos=null;
        tmPerformanceInfos =new ArrayList<TMPerformanceInfo>();
        for (TMPerformance tmf:tmPerformances){
            TMPerformanceInfo tmPerformanceInfo=new TMPerformanceInfo();
            tmPerformanceInfo.setTmpfe_user_id(tmf.getTmpfe_user_id());
            //员工姓名,TL姓名
            if(companyUserDao.selectCompanyUserByUserId(tmf.getTmpfe_user_id())==null){
                continue;
            }
            tmPerformanceInfo.setTmpfe_user_name(companyUserDao.selectCompanyUserByUserId(tmf.getTmpfe_user_id()).getUser_name());
            tmPerformanceInfo.setTmpfe_tlName(companyUserDao.selectCompanyUserByUserId(tmf.getTmpfe_user_id()).getUser_TL());
            //评级
            tmPerformanceInfo.setTmpfe_rating(tmf.getTmpfe_rating());
            //考核总分
            tmPerformanceInfo.setTmpfe_totalScore(tmf.getTmpfe_totalScore());
            //CTO评分
            tmPerformanceInfo.setTmpfe_ctoScore(tmf.getTmpfe_ctoScore());
            //TL评分
            tmPerformanceInfo.setTmpfe_tlScore(tmf.getTmpfe_tlScore());

            //加分项
            String[] addPoint=tmf.getTmpfe_addPoint().split("/");
            for (int i=0;i<addPoint.length;i++){
                if(i==0){
                    //全勤
                    tmPerformanceInfo.setTmpfe_fullAtt(addPoint[i]);
                }else if(i==1){
                    //讲师
                    tmPerformanceInfo.setTmpfe_lecturer(addPoint[i]);
                }else if(i==2){
                    //团队无漏测
                    tmPerformanceInfo.setTmpfe_noLeakageTeam(addPoint[i]);
                }else if(i==3){
                    tmPerformanceInfo.setTmpfe_overValidBugTeam(addPoint[i]);
                }else if(i==4){
                    //团队有人获得个人有效BUG数排名奖励
                    tmPerformanceInfo.setTmpfe_bugRanking(addPoint[i]);
                }else if(i==5){
                    //获得团队人均有效BUG数排名奖励
                    tmPerformanceInfo.setTmpfe_bugAvgRanking(addPoint[i]);
                }else if(i==6){
                    //对项目较大贡献
                    tmPerformanceInfo.setTmpfe_contribution(addPoint[i]);
                }else if(i==7){
                    //客户表扬
                    tmPerformanceInfo.setTmpfe_praise(addPoint[i]);
                }
            }

            //扣分项
            String[] minusPoint=tmf.getTmpfe_minusPoint().split("/");
            for(int i=0;i<minusPoint.length;i++){
                if(i==0){
                    //个人迟到数扣分
                    tmPerformanceInfo.setTmpfe_tardiness(minusPoint[i]);
                }else if(i==1){
                    //团队人均迟到数>3
                    tmPerformanceInfo.setTmpfe_teamTardiness(minusPoint[i]);
                }else if(i==2){
                    //团队个人日均有效BUG数<3
                    tmPerformanceInfo.setTmpfe_lessValidBug(minusPoint[i]);
                }else if(i==3){
                    ////bug漏测

                    tmPerformanceInfo.setTmpfe_leakage(minusPoint[i]);
                }else if(i==4){
                    //客户投诉
                    tmPerformanceInfo.setTmpfe_complaint(minusPoint[i]);
                }else if(i==5){
                    //信息安全
                    tmPerformanceInfo.setTmpfe_InfoSafety(minusPoint[i]);
                }else  if(i==6){
                    //扣分说明
                    tmPerformanceInfo.setTmpfe_minusPointInfo(minusPoint[i]);
                }
            }
            //个人迟到数
            tmPerformanceInfo.setTmpfe_latenessNum(tmf.getTmpfe_latenessNum());
            //'是否漏测',
            tmPerformanceInfo.setTmpfe_TMleakageBool(tmf.getTmpfe_leakage());
            //团队原始数据
            String[] originalData=tmf.getTmpfe_originalData().split("/");
            for(int i=0;i<originalData.length;i++){
                if(i==0){
                    // 团队名称
                    tmPerformanceInfo.setTmpfe_teamName(originalData[i]);
                }else if(i==1){
                    // '原始数据:有效bug总数
                    tmPerformanceInfo.setTmpfe_bugRankingNum(originalData[i]);
                }else if(i==2){
                    // 团队人数
                    tmPerformanceInfo.setTmpfe_number(originalData[i]);
                }else if(i==3){
                    //工作日
                    tmPerformanceInfo.setTmpfe_workingDay(originalData[i]);
                }else if(i==4){
                    //自然工作人天
                    tmPerformanceInfo.setTempfe_workingDayMan(originalData[i]);
                }else if(i==5){
                    //人均Bug
                    tmPerformanceInfo.setTmpfe_bugAvgPer(originalData[i]);
                }else if(i==6){
                    ///是否获得双月团队人均有效BUG数排名奖励
                    tmPerformanceInfo.setTmpfe_dobMonthBugRanking(originalData[i]);
                } else if(i==7){
                    //迟到总数
                    tmPerformanceInfo.setTmpfe_teamAlllatenessNum(originalData[i]);
                }
                else if(i==8){
                    //迟到人均数
                    tmPerformanceInfo.setTmpfe_teamAlllatenessAvg(originalData[i]);
                }
                else if(i==9){
                    //团队漏测数
                    tmPerformanceInfo.setTmpfe_teamLeakageNum(originalData[i]);
                }
                else if(i==10){
                    ///团队是否漏测
                    tmPerformanceInfo.setTmpfe_teamLeakageBool(originalData[i]);
                }
                else if(i==11){
                    //团队双月个人是否获得奖
                    tmPerformanceInfo.setTmpfe_teamDobMonthRaward(originalData[i]);
                }
                else if(i==12){
                    //团队双月个人是否获得奖名单
                    tmPerformanceInfo.setTmpfe_teamDobMonthRawardName(originalData[i]);
                }
            }
            //'cto评语',
            tmPerformanceInfo.setTmpfe_ctoComment(tmf.getTmpfe_ctoComment());
            // 'TL评语',
            tmPerformanceInfo.setTmpfe_tlComment(tmf.getTmpfe_tlComment());
            //季度
            tmPerformanceInfo.setTmpfe_quarter(tmf.getTmpfe_quarter());
            //团队成员
            tmPerformanceInfo.setTempf_userList(tmf.getTmpfe_teamAllName());


            tmPerformanceInfos.add(tmPerformanceInfo);

        }
        return tmPerformanceInfos;
    }

    /**
     * 模糊查询，通过查询的名字和该名字的TL名字
     * @param likeName
     * @param TLName
     * @return
     */
    @Override
    public List<TMPerformance> getTMPerformanceByLikeNameOrTMName(String likeName, String TLName) {
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("likeName",likeName);
        hashMap.put("likeTLName",TLName);
        return tmPerformanceDao.selectTMPerByNameOrTLName(hashMap);
    }

    /**
     * 判断是否已经有该员工在当前季度的数据
     * @return
     */
    @Override
    public boolean checkTMPerformanceIsExist(TMPerformance tmPerformances) {
        List<TMPerformance> tmPerformanceList=tmPerformanceDao.selectTMPerByIdAndQuarter(tmPerformances);
        if(tmPerformanceList.size()>0){
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
    public boolean deleteTMPerfomanceIsExist(TMPerformance tmPerformances) {
       int temp= tmPerformanceDao.deleteTMPerByIdAndQuarter(tmPerformances);
       if(temp>0){
           return true;
       }else {
           return false;
       }
    }
}
