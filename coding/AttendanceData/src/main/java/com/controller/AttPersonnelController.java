package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.AttPersonnel;
import com.entity.ResponsePram;
import com.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.AttPersonnelService;
import com.service.Impl.AttPersonnelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController
public class AttPersonnelController {

    @Autowired
    private AttPersonnelService attPersonnelService;
    /**
     * 获得员工信息
     * @return
     */
    @RequestMapping(value = "/getAllAttPersonnel",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAllAttPersonnel(){
      //  AttPersonnelService attPersonnelService=new AttPersonnelImpl();
        //将str转化为相应的JSONObject对象
        //JSONObject jsonObject = JSONObject.parseObject();
       // AttPersonnelService attPersonnelService=new AttPersonnelImpl();
        List<AttPersonnel> attPersonnelList=attPersonnelService.getAllAttPersonnel();
        String json= JSON.toJSONString(attPersonnelList);
        System.out.println(json);
        return json;
    }
    /**
     *添加用户
     * @param parms
     * 插入的内容
     * @return
     */
    @RequestMapping(value = "/insertAttPersonnel",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertAttPersonnel(@RequestBody String parms){
        //AttPersonnelService attPersonnelService=new AttPersonnelImpl();
        int temp=attPersonnelService.insertAttPersonnel(parms);
        System.out.println("----------："+temp);
        Map<String,ResponsePram> map = new HashMap<String,ResponsePram>();
        String json;
        if(temp>0){
            ResponsePram rp = new ResponsePram("200", "插入成功");
            map.put("result", rp);
            json = JSON.toJSONString(map);
        }else {
            ResponsePram rp = new ResponsePram("411", "插入数据错误");
            map.put("result", rp);
            json = JSON.toJSONString(map);
        }
        return json;

    }


}
