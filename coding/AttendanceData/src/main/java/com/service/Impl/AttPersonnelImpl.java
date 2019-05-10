package com.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.AttPersonnelDao;
import com.entity.AttPersonnel;
import com.service.AttPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttPersonnelImpl implements AttPersonnelService {

    @Autowired
    private AttPersonnelDao attPersonnelDao;
    @Override
    public List<AttPersonnel> getAllAttPersonnel() {
        return attPersonnelDao.getAllAttPersonnel();
    }

    @Override
    public int insertAttPersonnel(String parm) {
        int temp = -1;
        System.out.println(parm);
        //AttPersonnel attPersonnel=new AttPersonnel();
        //将字符串转换成json对象
        JSONObject jsonObject=JSONObject.parseObject(parm);
        //将字符串解析成AttPersonnel对象
        String str = jsonObject.getString("addAttPersonnelInfo"); //取出addAttPersonnelInfo对应的值,值为字符串
        //使用JSONArray.parseArray(String, Class<T>)将字符串转为指定对象集合
        List<AttPersonnel> listPram = (List<AttPersonnel>) JSONArray.parseArray(str, AttPersonnel.class);
        // {"addAttPersonnelInfo":[{"orderNum":"20180109170317448001","batchNum":"test","node":"001"}] }
        for (AttPersonnel att : listPram) {
            System.out.println(att.toString());
            temp=attPersonnelDao.insertAttPer(att);
        }
        return temp;
    }


}
