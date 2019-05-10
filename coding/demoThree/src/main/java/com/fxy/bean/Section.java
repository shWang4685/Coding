package com.fxy.bean;

import java.util.Date;

public class Section {
    private Integer id;

    private String name;

    private String avatar;

    private String info;

    private Integer videos;

    private Integer articles;

    private Date lastPublishArticleTime;

    private Date lastPublishVideoTime;

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

    public Integer getVideos() {
        return videos;
    }

    public void setVideos(Integer videos) {
        this.videos = videos;
    }

    public Integer getArticles() {
        return articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    public Date getLastPublishArticleTime() {
        return lastPublishArticleTime;
    }

    public void setLastPublishArticleTime(Date lastPublishArticleTime) {
        this.lastPublishArticleTime = lastPublishArticleTime;
    }

    public Date getLastPublishVideoTime() {
        return lastPublishVideoTime;
    }

    public void setLastPublishVideoTime(Date lastPublishVideoTime) {
        this.lastPublishVideoTime = lastPublishVideoTime;
    }
}