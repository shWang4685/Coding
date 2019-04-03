package com.demo.mapping;

import com.demo.entity.StudentClass;
import org.apache.ibatis.annotations.Param;


public interface  StudentClassMapping {
    StudentClass getClassById(@Param("id") int id);
}
