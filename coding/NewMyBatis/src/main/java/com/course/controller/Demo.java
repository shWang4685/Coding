package com.course.controller;
import com.course.model.SchoolClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {

    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addClass",method = RequestMethod.POST)
    @ApiOperation(value = "向数据表class_tbl中添加数据",httpMethod = "POST")
    public int addClass(@RequestBody SchoolClass schoolClass){
        return template.insert("addClass",schoolClass);
    }

    @RequestMapping(value = "/updataClass",method = RequestMethod.POST)
    @ApiOperation(value = "修改班级信息",httpMethod = "POST")
    public int updataClass(@RequestBody SchoolClass schoolClass){
        return  template.update("updataClass",schoolClass);
    }

    @RequestMapping(value = "/deleteClass",method = RequestMethod.GET)
    @ApiOperation(value = "删除班级信息",httpMethod = "GET")
    public int deleteClass(@RequestParam int id){
        return  template.delete("deleteClass",id);
    }
}
