package com.entity;

import java.util.Objects;

public class TMPerformance {
    private int tmpfe_id ;//'TM绩效表ID-主键',
    private int tmpfe_user_id;// '员工ID',
    private String tmpfe_rating;//'评级',
    private String tmpfe_totalScore;//'考核总分',
    private String tmpfe_ctoScore;//'cto评分',
    private String tmpfe_tlScore;//'TL评分',
    private String  tmpfe_addPoint ;// '加分项',
    private String tmpfe_minusPoint;//'扣分项',
    private String  tmpfe_latenessNum;//'个人迟到次数',
    private String tmpfe_leakage;//'是否漏测',
    private String tmpfe_originalData;//'原始数据',
    private String tmpfe_ctoComment;//'cto评语',
    private String tmpfe_tlComment;// 'TL评语',
    private int tmpfe_quarter;//季度


    public  TMPerformance(){

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

    public String getTmpfe_addPoint() {
        return tmpfe_addPoint;
    }

    public void setTmpfe_addPoint(String tmpfe_addPoint) {
        this.tmpfe_addPoint = tmpfe_addPoint;
    }

    public String getTmpfe_minusPoint() {
        return tmpfe_minusPoint;
    }

    public void setTmpfe_minusPoint(String tmpfe_minusPoint) {
        this.tmpfe_minusPoint = tmpfe_minusPoint;
    }

    public String getTmpfe_latenessNum() {
        return tmpfe_latenessNum;
    }

    public void setTmpfe_latenessNum(String tmpfe_latenessNum) {
        this.tmpfe_latenessNum = tmpfe_latenessNum;
    }

    public String getTmpfe_leakage() {
        return tmpfe_leakage;
    }

    public void setTmpfe_leakage(String tmpfe_leakage) {
        this.tmpfe_leakage = tmpfe_leakage;
    }

    public String getTmpfe_originalData() {
        return tmpfe_originalData;
    }

    public void setTmpfe_originalData(String tmpfe_originalData) {
        this.tmpfe_originalData = tmpfe_originalData;
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
        TMPerformance that = (TMPerformance) o;
        return tmpfe_id == that.tmpfe_id &&
                tmpfe_user_id == that.tmpfe_user_id &&
                tmpfe_quarter == that.tmpfe_quarter &&
                Objects.equals(tmpfe_rating, that.tmpfe_rating) &&
                Objects.equals(tmpfe_totalScore, that.tmpfe_totalScore) &&
                Objects.equals(tmpfe_ctoScore, that.tmpfe_ctoScore) &&
                Objects.equals(tmpfe_tlScore, that.tmpfe_tlScore) &&
                Objects.equals(tmpfe_addPoint, that.tmpfe_addPoint) &&
                Objects.equals(tmpfe_minusPoint, that.tmpfe_minusPoint) &&
                Objects.equals(tmpfe_latenessNum, that.tmpfe_latenessNum) &&
                Objects.equals(tmpfe_leakage, that.tmpfe_leakage) &&
                Objects.equals(tmpfe_originalData, that.tmpfe_originalData) &&
                Objects.equals(tmpfe_ctoComment, that.tmpfe_ctoComment) &&
                Objects.equals(tmpfe_tlComment, that.tmpfe_tlComment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tmpfe_id, tmpfe_user_id, tmpfe_rating, tmpfe_totalScore, tmpfe_ctoScore, tmpfe_tlScore, tmpfe_addPoint, tmpfe_minusPoint, tmpfe_latenessNum, tmpfe_leakage, tmpfe_originalData, tmpfe_ctoComment, tmpfe_tlComment, tmpfe_quarter);
    }

    @Override
    public String toString() {
        return "TMPerformance{" +
                "tmpfe_id=" + tmpfe_id +
                ", tmpfe_user_id=" + tmpfe_user_id +
                ", tmpfe_rating='" + tmpfe_rating + '\'' +
                ", tmpfe_totalScore='" + tmpfe_totalScore + '\'' +
                ", tmpfe_ctoScore='" + tmpfe_ctoScore + '\'' +
                ", tmpfe_tlScore='" + tmpfe_tlScore + '\'' +
                ", tmpfe_addPoint='" + tmpfe_addPoint + '\'' +
                ", tmpfe_minusPoint='" + tmpfe_minusPoint + '\'' +
                ", tmpfe_latenessNum='" + tmpfe_latenessNum + '\'' +
                ", tmpfe_leakage='" + tmpfe_leakage + '\'' +
                ", tmpfe_originalData='" + tmpfe_originalData + '\'' +
                ", tmpfe_ctoComment='" + tmpfe_ctoComment + '\'' +
                ", tmpfe_tlComment='" + tmpfe_tlComment + '\'' +
                ", tmpfe_quarter=" + tmpfe_quarter +
                '}';
    }
}
