package com.pojo;

import java.util.Objects;

public class TMPerformanceInfo {
    private  int tmpfe_id  ;//'TM绩效表ID-主键',
    private  int tmpfe_user_id ;//'员工ID',
    private  String tmpfe_user_name ;//'员工姓名',
    private  String tmpfe_tlName;//TL姓名
    private String tmpfe_rating ;//'评级',
    private String tmpfe_totalScore ;//'考核总分',
    private String tmpfe_ctoScore ;//'CTO评分',
    private String tmpfe_tlScore ;//'TL评分',

    private String tmpfe_fullAtt;//加分项：全勤
    private String tmpfe_lecturer;//讲师
    private String tmpfe_noLeakageTeam;//团队无漏测
    private String tmpfe_overValidBugTeam;//团队个人日均有效BUG数 ≧ 3
    private String tmpfe_bugRanking;//团队有人获得个人有效BUG数排名奖励
    private String tmpfe_bugAvgRanking;//获得团队人均有效BUG数排名奖励
    private String tmpfe_contribution;//对项目较大贡献
    private String tmpfe_praise;//客户表扬)

    private String tmpfe_tardiness;//扣分项：个人迟到数扣分
    private String tmpfe_teamTardiness;//团队人均迟到数>3
    private String tmpfe_lessValidBug;//团队个人日均有效BUG数<3
    private String tmpfe_leakage;//bug漏测
    private String tmpfe_complaint;//客户投诉
    private String tmpfe_InfoSafety;//信息安全

    private String tmpfe_latenessNum;//个人迟到次数
    private String tmpfe_TMleakageBool;//是否漏测


    private String tmpfe_teamName;// 团队名称
    private String tmpfe_bugRankingNum;// '原始数据:有效bug总数
    private String tmpfe_number;// 团队人数
    private String tmpfe_workingDay;//工作日
    private String tmpfe_bugAvgPer;//人均Bug
    private String tmpfe_dobMonthBugRanking;//是否获得双月团队人均有效BUG数排名奖励

    private String tmpfe_teamAlllatenessNum;//迟到总数
    private String tmpfe_teamAlllatenessAvg;//迟到人均数
    private String tmpfe_teamLeakageNum;//团队漏测数
    private String tmpfe_teamLeakageBool;//团队是否漏测
    private String tmpfe_teamDobMonthRaward;//团队双月个人是否获得奖
    private String tmpfe_teamDobMonthRawardName;//团队双月个人是否获得奖名单


    private String tmpfe_ctoComment ;// 'CTO评语',
    private String tmpfe_tlComment ;// 'TL评语'

    private int tmpfe_quarter;//'季度',


    public TMPerformanceInfo(){

    }

    public int getTmpfe_id() {
        return tmpfe_id;
    }

    public void setTmpfe_id(int tmpfe_id) {
        this.tmpfe_id = tmpfe_id;
    }

    public int getTmpfe_user_id() {
        return tmpfe_user_id;
    }

    public void setTmpfe_user_id(int tmpfe_user_id) {
        this.tmpfe_user_id = tmpfe_user_id;
    }

    public String getTmpfe_user_name() {
        return tmpfe_user_name;
    }

    public void setTmpfe_user_name(String tmpfe_user_name) {
        this.tmpfe_user_name = tmpfe_user_name;
    }

    public String getTmpfe_tlName() {
        return tmpfe_tlName;
    }

    public void setTmpfe_tlName(String tmpfe_tlName) {
        this.tmpfe_tlName = tmpfe_tlName;
    }

    public String getTmpfe_rating() {
        return tmpfe_rating;
    }

    public void setTmpfe_rating(String tmpfe_rating) {
        this.tmpfe_rating = tmpfe_rating;
    }

    public String getTmpfe_totalScore() {
        return tmpfe_totalScore;
    }

    public void setTmpfe_totalScore(String tmpfe_totalScore) {
        this.tmpfe_totalScore = tmpfe_totalScore;
    }

    public String getTmpfe_ctoScore() {
        return tmpfe_ctoScore;
    }

    public void setTmpfe_ctoScore(String tmpfe_ctoScore) {
        this.tmpfe_ctoScore = tmpfe_ctoScore;
    }

    public String getTmpfe_tlScore() {
        return tmpfe_tlScore;
    }

    public void setTmpfe_tlScore(String tmpfe_tlScore) {
        this.tmpfe_tlScore = tmpfe_tlScore;
    }

    public String getTmpfe_fullAtt() {
        return tmpfe_fullAtt;
    }

    public void setTmpfe_fullAtt(String tmpfe_fullAtt) {
        this.tmpfe_fullAtt = tmpfe_fullAtt;
    }

    public String getTmpfe_lecturer() {
        return tmpfe_lecturer;
    }

    public void setTmpfe_lecturer(String tmpfe_lecturer) {
        this.tmpfe_lecturer = tmpfe_lecturer;
    }

    public String getTmpfe_noLeakageTeam() {
        return tmpfe_noLeakageTeam;
    }

    public void setTmpfe_noLeakageTeam(String tmpfe_noLeakageTeam) {
        this.tmpfe_noLeakageTeam = tmpfe_noLeakageTeam;
    }

    public String getTmpfe_overValidBugTeam() {
        return tmpfe_overValidBugTeam;
    }

    public void setTmpfe_overValidBugTeam(String tmpfe_overValidBugTeam) {
        this.tmpfe_overValidBugTeam = tmpfe_overValidBugTeam;
    }

    public String getTmpfe_bugRanking() {
        return tmpfe_bugRanking;
    }

    public void setTmpfe_bugRanking(String tmpfe_bugRanking) {
        this.tmpfe_bugRanking = tmpfe_bugRanking;
    }

    public String getTmpfe_bugAvgRanking() {
        return tmpfe_bugAvgRanking;
    }

    public void setTmpfe_bugAvgRanking(String tmpfe_bugAvgRanking) {
        this.tmpfe_bugAvgRanking = tmpfe_bugAvgRanking;
    }

    public String getTmpfe_contribution() {
        return tmpfe_contribution;
    }

    public void setTmpfe_contribution(String tmpfe_contribution) {
        this.tmpfe_contribution = tmpfe_contribution;
    }

    public String getTmpfe_praise() {
        return tmpfe_praise;
    }

    public void setTmpfe_praise(String tmpfe_praise) {
        this.tmpfe_praise = tmpfe_praise;
    }

    public String getTmpfe_tardiness() {
        return tmpfe_tardiness;
    }

    public void setTmpfe_tardiness(String tmpfe_tardiness) {
        this.tmpfe_tardiness = tmpfe_tardiness;
    }

    public String getTmpfe_teamTardiness() {
        return tmpfe_teamTardiness;
    }

    public void setTmpfe_teamTardiness(String tmpfe_teamTardiness) {
        this.tmpfe_teamTardiness = tmpfe_teamTardiness;
    }

    public String getTmpfe_lessValidBug() {
        return tmpfe_lessValidBug;
    }

    public void setTmpfe_lessValidBug(String tmpfe_lessValidBug) {
        this.tmpfe_lessValidBug = tmpfe_lessValidBug;
    }

    public String getTmpfe_leakage() {
        return tmpfe_leakage;
    }

    public void setTmpfe_leakage(String tmpfe_leakage) {
        this.tmpfe_leakage = tmpfe_leakage;
    }

    public String getTmpfe_complaint() {
        return tmpfe_complaint;
    }

    public void setTmpfe_complaint(String tmpfe_complaint) {
        this.tmpfe_complaint = tmpfe_complaint;
    }

    public String getTmpfe_InfoSafety() {
        return tmpfe_InfoSafety;
    }

    public void setTmpfe_InfoSafety(String tmpfe_InfoSafety) {
        this.tmpfe_InfoSafety = tmpfe_InfoSafety;
    }

    public String getTmpfe_latenessNum() {
        return tmpfe_latenessNum;
    }

    public void setTmpfe_latenessNum(String tmpfe_latenessNum) {
        this.tmpfe_latenessNum = tmpfe_latenessNum;
    }

    public String getTmpfe_TMleakageBool() {
        return tmpfe_TMleakageBool;
    }

    public void setTmpfe_TMleakageBool(String tmpfe_TMleakageBool) {
        this.tmpfe_TMleakageBool = tmpfe_TMleakageBool;
    }

    public String getTmpfe_teamName() {
        return tmpfe_teamName;
    }

    public void setTmpfe_teamName(String tmpfe_teamName) {
        this.tmpfe_teamName = tmpfe_teamName;
    }

    public String getTmpfe_bugRankingNum() {
        return tmpfe_bugRankingNum;
    }

    public void setTmpfe_bugRankingNum(String tmpfe_bugRankingNum) {
        this.tmpfe_bugRankingNum = tmpfe_bugRankingNum;
    }

    public String getTmpfe_number() {
        return tmpfe_number;
    }

    public void setTmpfe_number(String tmpfe_number) {
        this.tmpfe_number = tmpfe_number;
    }

    public String getTmpfe_workingDay() {
        return tmpfe_workingDay;
    }

    public void setTmpfe_workingDay(String tmpfe_workingDay) {
        this.tmpfe_workingDay = tmpfe_workingDay;
    }

    public String getTmpfe_bugAvgPer() {
        return tmpfe_bugAvgPer;
    }

    public void setTmpfe_bugAvgPer(String tmpfe_bugAvgPer) {
        this.tmpfe_bugAvgPer = tmpfe_bugAvgPer;
    }

    public String getTmpfe_dobMonthBugRanking() {
        return tmpfe_dobMonthBugRanking;
    }

    public void setTmpfe_dobMonthBugRanking(String tmpfe_dobMonthBugRanking) {
        this.tmpfe_dobMonthBugRanking = tmpfe_dobMonthBugRanking;
    }

    public String getTmpfe_teamAlllatenessNum() {
        return tmpfe_teamAlllatenessNum;
    }

    public void setTmpfe_teamAlllatenessNum(String tmpfe_teamAlllatenessNum) {
        this.tmpfe_teamAlllatenessNum = tmpfe_teamAlllatenessNum;
    }

    public String getTmpfe_teamAlllatenessAvg() {
        return tmpfe_teamAlllatenessAvg;
    }

    public void setTmpfe_teamAlllatenessAvg(String tmpfe_teamAlllatenessAvg) {
        this.tmpfe_teamAlllatenessAvg = tmpfe_teamAlllatenessAvg;
    }

    public String getTmpfe_teamLeakageNum() {
        return tmpfe_teamLeakageNum;
    }

    public void setTmpfe_teamLeakageNum(String tmpfe_teamLeakageNum) {
        this.tmpfe_teamLeakageNum = tmpfe_teamLeakageNum;
    }

    public String getTmpfe_teamLeakageBool() {
        return tmpfe_teamLeakageBool;
    }

    public void setTmpfe_teamLeakageBool(String tmpfe_teamLeakageBool) {
        this.tmpfe_teamLeakageBool = tmpfe_teamLeakageBool;
    }

    public String getTmpfe_teamDobMonthRaward() {
        return tmpfe_teamDobMonthRaward;
    }

    public void setTmpfe_teamDobMonthRaward(String tmpfe_teamDobMonthRaward) {
        this.tmpfe_teamDobMonthRaward = tmpfe_teamDobMonthRaward;
    }

    public String getTmpfe_teamDobMonthRawardName() {
        return tmpfe_teamDobMonthRawardName;
    }

    public void setTmpfe_teamDobMonthRawardName(String tmpfe_teamDobMonthRawardName) {
        this.tmpfe_teamDobMonthRawardName = tmpfe_teamDobMonthRawardName;
    }

    public String getTmpfe_ctoComment() {
        return tmpfe_ctoComment;
    }

    public void setTmpfe_ctoComment(String tmpfe_ctoComment) {
        this.tmpfe_ctoComment = tmpfe_ctoComment;
    }

    public String getTmpfe_tlComment() {
        return tmpfe_tlComment;
    }

    public void setTmpfe_tlComment(String tmpfe_tlComment) {
        this.tmpfe_tlComment = tmpfe_tlComment;
    }

    public int getTmpfe_quarter() {
        return tmpfe_quarter;
    }

    public void setTmpfe_quarter(int tmpfe_quarter) {
        this.tmpfe_quarter = tmpfe_quarter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TMPerformanceInfo that = (TMPerformanceInfo) o;
        return tmpfe_id == that.tmpfe_id &&
                tmpfe_user_id == that.tmpfe_user_id &&
                tmpfe_quarter == that.tmpfe_quarter &&
                Objects.equals(tmpfe_user_name, that.tmpfe_user_name) &&
                Objects.equals(tmpfe_tlName, that.tmpfe_tlName) &&
                Objects.equals(tmpfe_rating, that.tmpfe_rating) &&
                Objects.equals(tmpfe_totalScore, that.tmpfe_totalScore) &&
                Objects.equals(tmpfe_ctoScore, that.tmpfe_ctoScore) &&
                Objects.equals(tmpfe_tlScore, that.tmpfe_tlScore) &&
                Objects.equals(tmpfe_fullAtt, that.tmpfe_fullAtt) &&
                Objects.equals(tmpfe_lecturer, that.tmpfe_lecturer) &&
                Objects.equals(tmpfe_noLeakageTeam, that.tmpfe_noLeakageTeam) &&
                Objects.equals(tmpfe_overValidBugTeam, that.tmpfe_overValidBugTeam) &&
                Objects.equals(tmpfe_bugRanking, that.tmpfe_bugRanking) &&
                Objects.equals(tmpfe_bugAvgRanking, that.tmpfe_bugAvgRanking) &&
                Objects.equals(tmpfe_contribution, that.tmpfe_contribution) &&
                Objects.equals(tmpfe_praise, that.tmpfe_praise) &&
                Objects.equals(tmpfe_tardiness, that.tmpfe_tardiness) &&
                Objects.equals(tmpfe_teamTardiness, that.tmpfe_teamTardiness) &&
                Objects.equals(tmpfe_lessValidBug, that.tmpfe_lessValidBug) &&
                Objects.equals(tmpfe_leakage, that.tmpfe_leakage) &&
                Objects.equals(tmpfe_complaint, that.tmpfe_complaint) &&
                Objects.equals(tmpfe_InfoSafety, that.tmpfe_InfoSafety) &&
                Objects.equals(tmpfe_latenessNum, that.tmpfe_latenessNum) &&
                Objects.equals(tmpfe_TMleakageBool, that.tmpfe_TMleakageBool) &&
                Objects.equals(tmpfe_teamName, that.tmpfe_teamName) &&
                Objects.equals(tmpfe_bugRankingNum, that.tmpfe_bugRankingNum) &&
                Objects.equals(tmpfe_number, that.tmpfe_number) &&
                Objects.equals(tmpfe_workingDay, that.tmpfe_workingDay) &&
                Objects.equals(tmpfe_bugAvgPer, that.tmpfe_bugAvgPer) &&
                Objects.equals(tmpfe_dobMonthBugRanking, that.tmpfe_dobMonthBugRanking) &&
                Objects.equals(tmpfe_teamAlllatenessNum, that.tmpfe_teamAlllatenessNum) &&
                Objects.equals(tmpfe_teamAlllatenessAvg, that.tmpfe_teamAlllatenessAvg) &&
                Objects.equals(tmpfe_teamLeakageNum, that.tmpfe_teamLeakageNum) &&
                Objects.equals(tmpfe_teamLeakageBool, that.tmpfe_teamLeakageBool) &&
                Objects.equals(tmpfe_teamDobMonthRaward, that.tmpfe_teamDobMonthRaward) &&
                Objects.equals(tmpfe_teamDobMonthRawardName, that.tmpfe_teamDobMonthRawardName) &&
                Objects.equals(tmpfe_ctoComment, that.tmpfe_ctoComment) &&
                Objects.equals(tmpfe_tlComment, that.tmpfe_tlComment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tmpfe_id, tmpfe_user_id, tmpfe_user_name, tmpfe_tlName, tmpfe_rating, tmpfe_totalScore, tmpfe_ctoScore, tmpfe_tlScore, tmpfe_fullAtt, tmpfe_lecturer, tmpfe_noLeakageTeam, tmpfe_overValidBugTeam, tmpfe_bugRanking, tmpfe_bugAvgRanking, tmpfe_contribution, tmpfe_praise, tmpfe_tardiness, tmpfe_teamTardiness, tmpfe_lessValidBug, tmpfe_leakage, tmpfe_complaint, tmpfe_InfoSafety, tmpfe_latenessNum, tmpfe_TMleakageBool, tmpfe_teamName, tmpfe_bugRankingNum, tmpfe_number, tmpfe_workingDay, tmpfe_bugAvgPer, tmpfe_dobMonthBugRanking, tmpfe_teamAlllatenessNum, tmpfe_teamAlllatenessAvg, tmpfe_teamLeakageNum, tmpfe_teamLeakageBool, tmpfe_teamDobMonthRaward, tmpfe_teamDobMonthRawardName, tmpfe_ctoComment, tmpfe_tlComment, tmpfe_quarter);
    }

    @Override
    public String toString() {
        return "TMPerformanceInfo{" +
                "tmpfe_id=" + tmpfe_id +
                ", tmpfe_user_id=" + tmpfe_user_id +
                ", tmpfe_user_name='" + tmpfe_user_name + '\'' +
                ", tmpfe_tlName='" + tmpfe_tlName + '\'' +
                ", tmpfe_rating='" + tmpfe_rating + '\'' +
                ", tmpfe_totalScore='" + tmpfe_totalScore + '\'' +
                ", tmpfe_ctoScore='" + tmpfe_ctoScore + '\'' +
                ", tmpfe_tlScore='" + tmpfe_tlScore + '\'' +
                ", tmpfe_fullAtt='" + tmpfe_fullAtt + '\'' +
                ", tmpfe_lecturer='" + tmpfe_lecturer + '\'' +
                ", tmpfe_noLeakageTeam='" + tmpfe_noLeakageTeam + '\'' +
                ", tmpfe_overValidBugTeam='" + tmpfe_overValidBugTeam + '\'' +
                ", tmpfe_bugRanking='" + tmpfe_bugRanking + '\'' +
                ", tmpfe_bugAvgRanking='" + tmpfe_bugAvgRanking + '\'' +
                ", tmpfe_contribution='" + tmpfe_contribution + '\'' +
                ", tmpfe_praise='" + tmpfe_praise + '\'' +
                ", tmpfe_tardiness='" + tmpfe_tardiness + '\'' +
                ", tmpfe_teamTardiness='" + tmpfe_teamTardiness + '\'' +
                ", tmpfe_lessValidBug='" + tmpfe_lessValidBug + '\'' +
                ", tmpfe_leakage='" + tmpfe_leakage + '\'' +
                ", tmpfe_complaint='" + tmpfe_complaint + '\'' +
                ", tmpfe_InfoSafety='" + tmpfe_InfoSafety + '\'' +
                ", tmpfe_latenessNum='" + tmpfe_latenessNum + '\'' +
                ", tmpfe_TMleakageBool='" + tmpfe_TMleakageBool + '\'' +
                ", tmpfe_teamName='" + tmpfe_teamName + '\'' +
                ", tmpfe_bugRankingNum='" + tmpfe_bugRankingNum + '\'' +
                ", tmpfe_number='" + tmpfe_number + '\'' +
                ", tmpfe_workingDay='" + tmpfe_workingDay + '\'' +
                ", tmpfe_bugAvgPer='" + tmpfe_bugAvgPer + '\'' +
                ", tmpfe_dobMonthBugRanking='" + tmpfe_dobMonthBugRanking + '\'' +
                ", tmpfe_teamAlllatenessNum='" + tmpfe_teamAlllatenessNum + '\'' +
                ", tmpfe_teamAlllatenessAvg='" + tmpfe_teamAlllatenessAvg + '\'' +
                ", tmpfe_teamLeakageNum='" + tmpfe_teamLeakageNum + '\'' +
                ", tmpfe_teamLeakageBool='" + tmpfe_teamLeakageBool + '\'' +
                ", tmpfe_teamDobMonthRaward='" + tmpfe_teamDobMonthRaward + '\'' +
                ", tmpfe_teamDobMonthRawardName='" + tmpfe_teamDobMonthRawardName + '\'' +
                ", tmpfe_ctoComment='" + tmpfe_ctoComment + '\'' +
                ", tmpfe_tlComment='" + tmpfe_tlComment + '\'' +
                ", tmpfe_quarter=" + tmpfe_quarter +
                '}';
    }
}
