package com.entity;

import java.util.Objects;

public class CompanyUser {
    private int user_id;//员工ID-主键'
    private String user_account;//'员工登陆账号',
    private String user_password ;//'员工登陆密码',
    private String user_name;//'员工姓名',
    private String user_TM ;//'TM姓名',
    private String user_TL;//'TL姓名',
    private int user_permission;//'权限级别'
    private String user_email;//邮箱
    private  int user_state;//账号是否激活
    private String user_code;//激活码

    public CompanyUser(){

    }
    public CompanyUser(String user_account,String user_password){
        this.user_account=user_account;
        this.user_password=user_password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_TM() {
        return user_TM;
    }

    public void setUser_TM(String user_TM) {
        this.user_TM = user_TM;
    }

    public String getUser_TL() {
        return user_TL;
    }

    public void setUser_TL(String user_TL) {
        this.user_TL = user_TL;
    }

    public int getUser_permission() {
        return user_permission;
    }

    public void setUser_permission(int user_permission) {
        this.user_permission = user_permission;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    @Override
    public String toString() {
        return "CompanyUser{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_TM='" + user_TM + '\'' +
                ", user_TL='" + user_TL + '\'' +
                ", user_permission=" + user_permission +
                ", user_email='" + user_email + '\'' +
                ", user_state=" + user_state +
                ", user_code='" + user_code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyUser that = (CompanyUser) o;
        return user_id == that.user_id &&
                user_permission == that.user_permission &&
                user_state == that.user_state &&
                Objects.equals(user_account, that.user_account) &&
                Objects.equals(user_password, that.user_password) &&
                Objects.equals(user_name, that.user_name) &&
                Objects.equals(user_TM, that.user_TM) &&
                Objects.equals(user_TL, that.user_TL) &&
                Objects.equals(user_email, that.user_email) &&
                Objects.equals(user_code, that.user_code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user_id, user_account, user_password, user_name, user_TM, user_TL, user_permission, user_email, user_state, user_code);
    }
}
