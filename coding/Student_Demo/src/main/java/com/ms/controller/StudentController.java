package com.ms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.pojo.Student;
import com.ms.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	/**
	 * restful风格实现页面跳转
	 */
	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page){
		return page;
	}
	
	//查询所有学生信息
	@RequestMapping("SelectAllStu")
	public ModelAndView SelectAllStu(@RequestParam(defaultValue="1") Integer page,
			HttpServletRequest request,HttpServletResponse response){
		PageHelper.startPage(page,5);
		List<Student> list=studentService.SelectAllStu();
		PageInfo pageinfo = new PageInfo(list,5);
		
		ModelAndView model = new ModelAndView();
		model.addObject("pageinfo", pageinfo);
		model.setViewName("showAllStu");
		return  model;
		
	}
	
	//添加学生信息
	@RequestMapping("dosertStu")
	public String insertStu(Student student){
		studentService.addStu(student);
		return "success";
		
	}
	
	//删除学生信息
	@RequestMapping("deleteStu")
	public String deleteStu(Student student){
		studentService.deleteStu(student);
		return "success";
		
	}
	
	//查询学生信息
	@RequestMapping("doselectStu")
	public String selectStu(Model model,Student student){
		List<Student> list=studentService.selectStu(student);
		model.addAttribute("list", list);
		return "selectStuResult";
	}
	
	//实现数据回显
	@RequestMapping("updateStu")
	public String updateStu(Student student,Model model,
			@RequestParam(value = "id", required = true) Integer id){
		Student stu=studentService.selectStuById(student);
		
		model.addAttribute("student", stu);
		
		return "updateStuView";
	}
	
	//修改学生的信息
	@RequestMapping("doupdateStu")
	public String doupdate(Student student){
		studentService.updateStu(student);
		return "success";
		
	}

}
