package com.sqxinxibu.neikanhoutai.service.Impl;

import com.sqxinxibu.neikanhoutai.dao.AdminUserDao;
import com.sqxinxibu.neikanhoutai.dao.LoginTicketDao;
import com.sqxinxibu.neikanhoutai.entity.AdminUser;
import com.sqxinxibu.neikanhoutai.entity.LoginTicket;
import com.sqxinxibu.neikanhoutai.service.AdminUserService;
import com.sqxinxibu.neikanhoutai.util.JblogUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;

    @Resource
    private LoginTicketDao loginTicketDao;

    @Override
    public AdminUser seletByName(String name) {
        return null;
    }
    //注册
    public Map<String,String> register(String username, String password){
        Map<String,String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isBlank(username)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }

        List<AdminUser> userList= adminUserDao.seletByName(username);
        if (userList!=null&&userList.size()>0){
            map.put("msg","用户名已经被占用");
            return map;
        }
        //System.out.println("账号："+username);
        //System.out.println("密码："+password);
        String jiayan=UUID.randomUUID().toString().substring(0,5);

        //System.out.println("加盐："+jiayan);
        String mima=JblogUtil.MD5(password+jiayan);
        //System.out.println("密码加密："+mima);

        AdminUser user = new AdminUser();
        user.setName(username);
        user.setSalt(jiayan);
        user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png",random.nextInt(1000)));
        user.setPassword(mima);
        user.setRole("user");
        int jieguo=adminUserDao.insertUser(user);

        //System.out.println("user对象信息："+JSONObject.toJSONString(user));

        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);

        return map;
    }
    //登录
    public Map<String,String> login(String username, String password){
        Map<String,String> map = new HashMap<>();
        if (StringUtils.isBlank(username)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }
        //查询用户存不存在
        AdminUser adminUser=adminUserDao.seletByNameLogin(username);
        //System.out.println("登录查询用户："+ JSON.toJSONString(adminUser));
        if (adminUser==null){
            map.put("msg","用户名不存在");
            return map;
        }

        String mima=adminUser.getPassword();
        //System.out.println("查询到的密码："+mima);
        String jiayan=adminUser.getSalt();
        //System.out.println("查询到的加盐："+jiayan);

        //System.out.println("登录时的密码："+password);
        String mimas=JblogUtil.MD5(password+jiayan);
        //System.out.println("登录时的密码加密后："+mimas);

        //检测密码是否正确
        if(!mima.equals(mimas)){
            map.put("msg","密码错误，请输入正确密码");
            return map;
        }

        int id=adminUser.getId();
        LoginTicket loginTicket=adminUserDao.selectByPrimaryKey(id);
        //System.out.println("查询到的ticket: "+loginTicket.getTicket());
        map.put("ticket",loginTicket.getTicket());
        return map;

    }
    public String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));

        //System.out.println("生成ticket: "+ JSONObject.toJSONString(loginTicket));
        int a=loginTicketDao.insertLoginticket(loginTicket);

        return loginTicket.getTicket();

    }



}
