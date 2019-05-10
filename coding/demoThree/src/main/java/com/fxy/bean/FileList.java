package com.fxy.bean;

public class FileList {
    private Integer id;

    private String filename;

    private Integer filefolder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getFilefolder() {
        return filefolder;
    }

    public void setFilefolder(Integer filefolder) {
        this.filefolder = filefolder;
    }
}