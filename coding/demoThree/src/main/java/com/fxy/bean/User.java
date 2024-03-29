package com.fxy.bean;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private String phone;

    private Integer articles;

    private Integer videos;

    private String avatar;

    private String info;

    private Integer roleId;

    private Integer missNumber;

    private Date missTime;

    private Date allowTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getArticles() {
        return articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    public Integer getVideos() {
        return videos;
    }

    public void setVideos(Integer videos) {
        this.videos = videos;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMissNumber() {
        return missNumber;
    }

    public void setMissNumber(Integer missNumber) {
        this.missNumber = missNumber;
    }

    public Date getMissTime() {
        return missTime;
    }

    public void setMissTime(Date missTime) {
        this.missTime = missTime;
    }

    public Date getAllowTime() {
        return allowTime;
    }

    public void setAllowTime(Date allowTime) {
        this.allowTime = allowTime;
    }
}