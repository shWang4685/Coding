package com.demo.entity;

import java.util.Objects;

public class StudentClass {
    private  int class_id;
    private String class_name;
    private String class_teacher;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_teacher() {
        return class_teacher;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", class_teacher='" + class_teacher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass that = (StudentClass) o;
        return class_id == that.class_id &&
                Objects.equals(class_name, that.class_name) &&
                Objects.equals(class_teacher, that.class_teacher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(class_id, class_name, class_teacher);
    }

    public StudentClass(int class_id, String class_name, String class_teacher) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.class_teacher = class_teacher;
    }
}
