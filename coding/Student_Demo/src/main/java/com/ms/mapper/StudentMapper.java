package com.ms.mapper;

import java.util.List;

import com.ms.pojo.Student;

public interface StudentMapper {

	public List<Student> SelectAllStu();
	
	public void insertStu(Student student);
	
	public void deleteStu(Student student);
	
	public List<Student> selectStu(Student student);
	
	public Student selectStuById(Student student);
	
	public void updateStu(Student student);
}
