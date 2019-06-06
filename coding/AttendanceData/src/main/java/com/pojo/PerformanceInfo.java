package com.pojo;

import java.util.Objects;

public class PerformanceInfo {
    private  int pfe_id ;//'绩效表ID-主键',
    private  int pfe_user_id ;//'员工ID',
    private  String pfe_user_name ;//'员工姓名',
    private String pfe_tm_name;//TM姓名
    private String pfe_rating;//'评级',
    private String pfe_totalScore;//'考核总分',
    private String pfe_tmScore;//'TM评分',
    private String pfe_tlScore;//'TL评分',

    private String pfe_fullAtt;//加分项：全勤
    private String pfe_lecturer;//讲师
    private String pfe_noLeakage;//无漏测
    private String pfe_overValidBug;//有效bug>=3
    private String pfe_bugRanking;//有效bug排名第一
    private String pfe_contribution;//对项目较大贡献
    private String pfe_praise;//客户表扬)

    private String pfe_tardiness;//扣分项：个人迟到数
    private String pfe_lessValidBug;//有效bug数<3
    private String pfe_leakage;//bug漏测
    private String pfe_complaint;//客户投诉
    private String pfe_InfoSafety;//信息安全

    private String pfe_bugRankingNum;// '原始数据:有效bug总数
    private String pfe_workingDay;//工作日
    private String pfe_bugPerDay;//日均有效bug数
    private String pfe_LatenessNum;//个人迟到次数
    private String pfe_missing;//是否漏测

    private String pfe_tmComment ;// 'TM评语',
    private String pfe_tlComment ;// 'TL评语'

    private int pfe_quarter;//'季度',
    public PerformanceInfo(){

    }

    public String getPfe_tm_name() {
        return pfe_tm_name;
    }

    public void setPfe_tm_name(String pfe_tm_name) {
        this.pfe_tm_name = pfe_tm_name;
    }

    public int getPfe_id() {
        return pfe_id;
    }

    public void setPfe_id(int pfe_id) {
        this.pfe_id = pfe_id;
    }

    public int getPfe_user_id() {
        return pfe_user_id;
    }

    public void setPfe_user_id(int pfe_user_id) {
        this.pfe_user_id = pfe_user_id;
    }

    public String getPfe_user_name() {
        return pfe_user_name;
    }

    public void setPfe_user_name(String pfe_user_name) {
        this.pfe_user_name = pfe_user_name;
    }

    public String getPfe_rating() {
        return pfe_rating;
    }

    public void setPfe_rating(String pfe_rating) {
        this.pfe_rating = pfe_rating;
    }

    public String getPfe_totalScore() {
        return pfe_totalScore;
    }

    public void setPfe_totalScore(String pfe_totalScore) {
        this.pfe_totalScore = pfe_totalScore;
    }

    public String getPfe_tmScore() {
        return pfe_tmScore;
    }

    public void setPfe_tmScore(String pfe_tmScore) {
        this.pfe_tmScore = pfe_tmScore;
    }

    public String getPfe_tlScore() {
        return pfe_tlScore;
    }

    public void setPfe_tlScore(String pfe_tlScore) {
        this.pfe_tlScore = pfe_tlScore;
    }

    public String getPfe_fullAtt() {
        return pfe_fullAtt;
    }

    public void setPfe_fullAtt(String pfe_fullAtt) {
        this.pfe_fullAtt = pfe_fullAtt;
    }

    public String getPfe_lecturer() {
        return pfe_lecturer;
    }

    public void setPfe_lecturer(String pfe_lecturer) {
        this.pfe_lecturer = pfe_lecturer;
    }

    public String getPfe_noLeakage() {
        return pfe_noLeakage;
    }

    public void setPfe_noLeakage(String pfe_noLeakage) {
        this.pfe_noLeakage = pfe_noLeakage;
    }

    public String getPfe_overValidBug() {
        return pfe_overValidBug;
    }

    public void setPfe_overValidBug(String pfe_overValidBug) {
        this.pfe_overValidBug = pfe_overValidBug;
    }

    public String getPfe_bugRanking() {
        return pfe_bugRanking;
    }

    public void setPfe_bugRanking(String pfe_bugRanking) {
        this.pfe_bugRanking = pfe_bugRanking;
    }

    public String getPfe_contribution() {
        return pfe_contribution;
    }

    public void setPfe_contribution(String pfe_contribution) {
        this.pfe_contribution = pfe_contribution;
    }

    public String getPfe_praise() {
        return pfe_praise;
    }

    public void setPfe_praise(String pfe_praise) {
        this.pfe_praise = pfe_praise;
    }

    public String getPfe_tardiness() {
        return pfe_tardiness;
    }

    public void setPfe_tardiness(String pfe_tardiness) {
        this.pfe_tardiness = pfe_tardiness;
    }

    public String getPfe_lessValidBug() {
        return pfe_lessValidBug;
    }

    public void setPfe_lessValidBug(String pfe_lessValidBug) {
        this.pfe_lessValidBug = pfe_lessValidBug;
    }

    public String getPfe_leakage() {
        return pfe_leakage;
    }

    public void setPfe_leakage(String pfe_leakage) {
        this.pfe_leakage = pfe_leakage;
    }

    public String getPfe_complaint() {
        return pfe_complaint;
    }

    public void setPfe_complaint(String pfe_complaint) {
        this.pfe_complaint = pfe_complaint;
    }

    public String getPfe_InfoSafety() {
        return pfe_InfoSafety;
    }

    public void setPfe_InfoSafety(String pfe_InfoSafety) {
        this.pfe_InfoSafety = pfe_InfoSafety;
    }

    public String getPfe_bugRankingNum() {
        return pfe_bugRankingNum;
    }

    public void setPfe_bugRankingNum(String pfe_bugRankingNum) {
        this.pfe_bugRankingNum = pfe_bugRankingNum;
    }

    public String getPfe_workingDay() {
        return pfe_workingDay;
    }

    public void setPfe_workingDay(String pfe_workingDay) {
        this.pfe_workingDay = pfe_workingDay;
    }

    public String getPfe_bugPerDay() {
        return pfe_bugPerDay;
    }

    public void setPfe_bugPerDay(String pfe_bugPerDay) {
        this.pfe_bugPerDay = pfe_bugPerDay;
    }

    public String getPfe_LatenessNum() {
        return pfe_LatenessNum;
    }

    public void setPfe_LatenessNum(String pfe_LatenessNum) {
        this.pfe_LatenessNum = pfe_LatenessNum;
    }

    public String getPfe_missing() {
        return pfe_missing;
    }

    public void setPfe_missing(String pfe_missing) {
        this.pfe_missing = pfe_missing;
    }

    public String getPfe_tmComment() {
        return pfe_tmComment;
    }

    public void setPfe_tmComment(String pfe_tmComment) {
        this.pfe_tmComment = pfe_tmComment;
    }

    public String getPfe_tlComment() {
        return pfe_tlComment;
    }

    public void setPfe_tlComment(String pfe_tlComment) {
        this.pfe_tlComment = pfe_tlComment;
    }

    public int getPfe_quarter() {
        return pfe_quarter;
    }

    public void setPfe_quarter(int pfe_quarter) {
        this.pfe_quarter = pfe_quarter;
    }

    @Override
    public String toString() {
        return "PerformanceInfo{" +
                "pfe_id=" + pfe_id +
                ", pfe_user_id=" + pfe_user_id +
                ", pfe_user_name='" + pfe_user_name + '\'' +
                ", pfe_rating='" + pfe_rating + '\'' +
                ", pfe_totalScore='" + pfe_totalScore + '\'' +
                ", pfe_tmScore='" + pfe_tmScore + '\'' +
                ", pfe_tlScore='" + pfe_tlScore + '\'' +
                ", pfe_fullAtt='" + pfe_fullAtt + '\'' +
                ", pfe_lecturer='" + pfe_lecturer + '\'' +
                ", pfe_noLeakage='" + pfe_noLeakage + '\'' +
                ", pfe_overValidBug='" + pfe_overValidBug + '\'' +
                ", pfe_bugRanking='" + pfe_bugRanking + '\'' +
                ", pfe_contribution='" + pfe_contribution + '\'' +
                ", pfe_praise='" + pfe_praise + '\'' +
                ", pfe_tardiness='" + pfe_tardiness + '\'' +
                ", pfe_lessValidBug='" + pfe_lessValidBug + '\'' +
                ", pfe_leakage='" + pfe_leakage + '\'' +
                ", pfe_complaint='" + pfe_complaint + '\'' +
                ", pfe_InfoSafety='" + pfe_InfoSafety + '\'' +
                ", pfe_bugRankingNum='" + pfe_bugRankingNum + '\'' +
                ", pfe_workingDay='" + pfe_workingDay + '\'' +
                ", pfe_bugPerDay='" + pfe_bugPerDay + '\'' +
                ", pfe_LatenessNum='" + pfe_LatenessNum + '\'' +
                ", pfe_missing='" + pfe_missing + '\'' +
                ", pfe_tmComment='" + pfe_tmComment + '\'' +
                ", pfe_tlComment='" + pfe_tlComment + '\'' +
                ", pfe_quarter=" + pfe_quarter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformanceInfo that = (PerformanceInfo) o;
        return pfe_id == that.pfe_id &&
                pfe_user_id == that.pfe_user_id &&
                pfe_quarter == that.pfe_quarter &&
                Objects.equals(pfe_user_name, that.pfe_user_name) &&
                Objects.equals(pfe_rating, that.pfe_rating) &&
                Objects.equals(pfe_totalScore, that.pfe_totalScore) &&
                Objects.equals(pfe_tmScore, that.pfe_tmScore) &&
                Objects.equals(pfe_tlScore, that.pfe_tlScore) &&
                Objects.equals(pfe_fullAtt, that.pfe_fullAtt) &&
                Objects.equals(pfe_lecturer, that.pfe_lecturer) &&
                Objects.equals(pfe_noLeakage, that.pfe_noLeakage) &&
                Objects.equals(pfe_overValidBug, that.pfe_overValidBug) &&
                Objects.equals(pfe_bugRanking, that.pfe_bugRanking) &&
                Objects.equals(pfe_contribution, that.pfe_contribution) &&
                Objects.equals(pfe_praise, that.pfe_praise) &&
                Objects.equals(pfe_tardiness, that.pfe_tardiness) &&
                Objects.equals(pfe_lessValidBug, that.pfe_lessValidBug) &&
                Objects.equals(pfe_leakage, that.pfe_leakage) &&
                Objects.equals(pfe_complaint, that.pfe_complaint) &&
                Objects.equals(pfe_InfoSafety, that.pfe_InfoSafety) &&
                Objects.equals(pfe_bugRankingNum, that.pfe_bugRankingNum) &&
                Objects.equals(pfe_workingDay, that.pfe_workingDay) &&
                Objects.equals(pfe_bugPerDay, that.pfe_bugPerDay) &&
                Objects.equals(pfe_LatenessNum, that.pfe_LatenessNum) &&
                Objects.equals(pfe_missing, that.pfe_missing) &&
                Objects.equals(pfe_tmComment, that.pfe_tmComment) &&
                Objects.equals(pfe_tlComment, that.pfe_tlComment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pfe_id, pfe_user_id, pfe_user_name, pfe_rating, pfe_totalScore, pfe_tmScore, pfe_tlScore, pfe_fullAtt, pfe_lecturer, pfe_noLeakage, pfe_overValidBug, pfe_bugRanking, pfe_contribution, pfe_praise, pfe_tardiness, pfe_lessValidBug, pfe_leakage, pfe_complaint, pfe_InfoSafety, pfe_bugRankingNum, pfe_workingDay, pfe_bugPerDay, pfe_LatenessNum, pfe_missing, pfe_tmComment, pfe_tlComment, pfe_quarter);
    }
}
