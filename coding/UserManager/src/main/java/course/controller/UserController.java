package course.controller;

import course.entity.User;
import course.service.inf.UserServiceInf;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Api(value = "user",description = "这是我的第一个版本的demo")
@RequestMapping("/user")
public class UserController {
        @Autowired
        private UserServiceInf userServiceInf;
        @RequestMapping(value = "/getAll",produces ={"application.yml/json;charset=UTF-8"},method =RequestMethod.GET)
        @ApiOperation(value = "向数据表user_tbl中添加数据",httpMethod = "GET")
        public List<User>  getAll(){
                return userServiceInf.getAllUser();
                //return "ss";
        }



}
