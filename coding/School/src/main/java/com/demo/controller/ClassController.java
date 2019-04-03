package com.demo.controller;

import com.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {
    /**     * 注入服务     */
    @Autowired
    private ClassService classService;
    /**
     ** 查询老师信息
     * @param id id
     * @return 信息
     * */
    @RequestMapping(value = "/class")
    public String getClassMessage(int id) {
        return classService.queryClass(id).toString();
    }
}
