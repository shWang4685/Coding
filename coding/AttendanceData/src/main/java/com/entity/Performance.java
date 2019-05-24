package com.entity;

import java.util.Objects;

public class Performance {
    private  int pfe_id ;//'绩效表ID-主键',
    private  int pfe_user_id ;//'员工ID',
    private String pfe_rating;//'评级',
    private String pfe_totalScore;//'考核总分',
    private String  pfe_tmScore;//'TM评分',
    private String pfe_tlScore;//'TL评分',
    private String pfe_addPoint;//'加分项(全勤,培训讲师,无漏测,有效bug>=3,有效bug排名第一,对项目较大贡献,客户表扬)',
    private String pfe_minusPoint;//'扣分项(个人迟到数,有效bug数<3,bug漏测,客户投诉,信息安全)',
    private String pfe_originalData;// '原始数据(有效bug总数,工作日,日均有效bug数,个人迟到次数,是否漏测)',
    private String pfe_tmComment ;// 'TM评语',
    private String pfe_tlComment ;// 'TL评语'
    private int pfe_quarter;//'季度',

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

    public String getPfe_addPoint() {
        return pfe_addPoint;
    }

    public void setPfe_addPoint(String pfe_addPoint) {
        this.pfe_addPoint = pfe_addPoint;
    }

    public String getPfe_minusPoint() {
        return pfe_minusPoint;
    }

    public void setPfe_minusPoint(String pfe_minusPoint) {
        this.pfe_minusPoint = pfe_minusPoint;
    }

    public String getPfe_originalData() {
        return pfe_originalData;
    }

    public void setPfe_originalData(String pfe_originalData) {
        this.pfe_originalData = pfe_originalData;
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
        return "Performance{" +
                "pfe_id=" + pfe_id +
                ", pfe_user_id=" + pfe_user_id +
                ", pfe_rating='" + pfe_rating + '\'' +
                ", pfe_totalScore='" + pfe_totalScore + '\'' +
                ", pfe_tmScore='" + pfe_tmScore + '\'' +
                ", pfe_tlScore='" + pfe_tlScore + '\'' +
                ", pfe_addPoint='" + pfe_addPoint + '\'' +
                ", pfe_minusPoint='" + pfe_minusPoint + '\'' +
                ", pfe_originalData='" + pfe_originalData + '\'' +
                ", pfe_tmComment='" + pfe_tmComment + '\'' +
                ", pfe_tlComment='" + pfe_tlComment + '\'' +
                ", pfe_quarter=" + pfe_quarter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performance that = (Performance) o;
        return pfe_id == that.pfe_id &&
                pfe_user_id == that.pfe_user_id &&
                pfe_quarter == that.pfe_quarter &&
                Objects.equals(pfe_rating, that.pfe_rating) &&
                Objects.equals(pfe_totalScore, that.pfe_totalScore) &&
                Objects.equals(pfe_tmScore, that.pfe_tmScore) &&
                Objects.equals(pfe_tlScore, that.pfe_tlScore) &&
                Objects.equals(pfe_addPoint, that.pfe_addPoint) &&
                Objects.equals(pfe_minusPoint, that.pfe_minusPoint) &&
                Objects.equals(pfe_originalData, that.pfe_originalData) &&
                Objects.equals(pfe_tmComment, that.pfe_tmComment) &&
                Objects.equals(pfe_tlComment, that.pfe_tlComment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pfe_id, pfe_user_id, pfe_rating, pfe_totalScore, pfe_tmScore, pfe_tlScore, pfe_addPoint, pfe_minusPoint, pfe_originalData, pfe_tmComment, pfe_tlComment, pfe_quarter);
    }
}
