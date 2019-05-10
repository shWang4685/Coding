package com.ms.service;

import java.util.List;

import com.ms.pojo.Student;

public interface StudentService {

	public List<Student> SelectAllStu();
	
	public void addStu(Student student);
	
	public void deleteStu(Student student);
	
	public List<Student> selectStu(Student student);
	
	public Student selectStuById(Student student);
	
	public void updateStu(Student student);
}
