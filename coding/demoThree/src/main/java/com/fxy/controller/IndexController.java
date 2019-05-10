package com.fxy.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@RestController
public class IndexController {

	/**
	 * @Title: index
	 * @Description: 跳转到注册页面
	 * @return String
	 * @throws 
	 * @author fxy 
	 * @date 2018年3月7日
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "register";
	}
	
	
	/**
	 * @Title: signin
	 * @Description: 跳转到登录页面
	 * @return String
	 * @throws 
	 * @author fxy 
	 * @date 2018年3月7日
	 */
	@RequestMapping(value = "/signin")
	public String signin() {
		return "login";
	}
	
	
	/**
	 * @description 跳转到创建文件夹页面
	 * @param mkdis
	 * @return
	 */
	@RequestMapping(value = "/mkdirs")
	public String mkdirs() {
		return "mkdirs";
	}
	
	@RequestMapping(value = "/publishArticle")
	public String publishArticle() {
		return "article/publish";
	}
}