package com.demo.service;
import com.demo.entity.StudentClass;
import com.demo.mapping.StudentClassMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassService {
    /**
     * 注入服务
     */
    //@Autowired
    @Resource
    private StudentClassMapping classMapping;
    public StudentClass queryClass(int  id){
        return classMapping.getClassById(id);
    }


}
