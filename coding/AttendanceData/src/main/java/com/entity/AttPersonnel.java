package com.entity;

import java.util.Objects;

/**
 * @author 王仕衡
 * * 员工用户实体
 */
public class AttPersonnel {
    private int  personnel_jobId ;// '员工ID-用户账号-主键',
    private String personnel_password;// '员工登陆密码',
    private String personnel_name;//'员工姓名',
    private String personnel_sex;//'员工性别',
    private String personnel_email;//'员工邮箱',
    private int personnel_groupId;//'员工组ID',
    private int personnel_dept_id;//'员工部门ID',
    private String personnel_title ;//'员工职称',
    private String personnel_entryTime;//'入职时间',
    private String personnel_regularWorkerTime ;// '转正日期',
    private String personnel_mobile;//'电话号码',
    private String personnel_remark;//'备注'

    public AttPersonnel(){

    }

    public int getPersonnel_jobId() {
        return personnel_jobId;
    }

    public void setPersonnel_jobId(int personnel_jobId) {
        this.personnel_jobId = personnel_jobId;
    }

    public String getPersonnel_password() {
        return personnel_password;
    }

    public void setPersonnel_password(String personnel_password) {
        this.personnel_password = personnel_password;
    }

    public String getPersonnel_name() {
        return personnel_name;
    }

    public void setPersonnel_name(String personnel_name) {
        this.personnel_name = personnel_name;
    }

    public String getPersonnel_sex() {
        return personnel_sex;
    }

    public void setPersonnel_sex(String personnel_sex) {
        this.personnel_sex = personnel_sex;
    }

    public String getPersonnel_email() {
        return personnel_email;
    }

    public void setPersonnel_email(String personnel_email) {
        this.personnel_email = personnel_email;
    }

    public int getPersonnel_groupId() {
        return personnel_groupId;
    }

    public void setPersonnel_groupId(int personnel_groupId) {
        this.personnel_groupId = personnel_groupId;
    }

    public int getPersonnel_dept_id() {
        return personnel_dept_id;
    }

    public void setPersonnel_dept_id(int personnel_dept_id) {
        this.personnel_dept_id = personnel_dept_id;
    }

    public String getPersonnel_title() {
        return personnel_title;
    }

    public void setPersonnel_title(String personnel_title) {
        this.personnel_title = personnel_title;
    }

    public String getPersonnel_entryTime() {
        return personnel_entryTime;
    }

    public void setPersonnel_entryTime(String personnel_entryTime) {
        this.personnel_entryTime = personnel_entryTime;
    }

    public String getPersonnel_regularWorkerTime() {
        return personnel_regularWorkerTime;
    }

    public void setPersonnel_regularWorkerTime(String personnel_regularWorkerTime) {
        this.personnel_regularWorkerTime = personnel_regularWorkerTime;
    }

    public String getPersonnel_mobile() {
        return personnel_mobile;
    }

    public void setPersonnel_mobile(String personnel_mobile) {
        this.personnel_mobile = personnel_mobile;
    }

    public String getPersonnel_remark() {
        return personnel_remark;
    }

    public void setPersonnel_remark(String personnel_remark) {
        this.personnel_remark = personnel_remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttPersonnel that = (AttPersonnel) o;
        return personnel_jobId == that.personnel_jobId &&
                personnel_groupId == that.personnel_groupId &&
                personnel_dept_id == that.personnel_dept_id &&
                Objects.equals(personnel_password, that.personnel_password) &&
                Objects.equals(personnel_name, that.personnel_name) &&
                Objects.equals(personnel_sex, that.personnel_sex) &&
                Objects.equals(personnel_email, that.personnel_email) &&
                Objects.equals(personnel_title, that.personnel_title) &&
                Objects.equals(personnel_entryTime, that.personnel_entryTime) &&
                Objects.equals(personnel_regularWorkerTime, that.personnel_regularWorkerTime) &&
                Objects.equals(personnel_mobile, that.personnel_mobile) &&
                Objects.equals(personnel_remark, that.personnel_remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personnel_jobId, personnel_password, personnel_name, personnel_sex, personnel_email, personnel_groupId, personnel_dept_id, personnel_title, personnel_entryTime, personnel_regularWorkerTime, personnel_mobile, personnel_remark);
    }

    @Override
    public String toString() {
        return "AttPersonnel{" +
                "personnel_jobId=" + personnel_jobId +
                ", personnel_password='" + personnel_password + '\'' +
                ", personnel_name='" + personnel_name + '\'' +
                ", personnel_sex='" + personnel_sex + '\'' +
                ", personnel_email='" + personnel_email + '\'' +
                ", personnel_groupId=" + personnel_groupId +
                ", personnel_dept_id=" + personnel_dept_id +
                ", personnel_title='" + personnel_title + '\'' +
                ", personnel_entryTime='" + personnel_entryTime + '\'' +
                ", personnel_regularWorkerTime='" + personnel_regularWorkerTime + '\'' +
                ", personnel_mobile='" + personnel_mobile + '\'' +
                ", personnel_remark='" + personnel_remark + '\'' +
                '}';
    }
}
