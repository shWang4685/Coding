package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.mapper.StudentMapper;
import com.ms.pojo.Student;
import com.ms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public List<Student> SelectAllStu() {
		
		return studentMapper.SelectAllStu();
	}

	@Override
	public void addStu(Student student) {
		studentMapper.insertStu(student);
	}

	@Override
	public void deleteStu(Student student) {
		studentMapper.deleteStu(student);
	}

	@Override
	public List<Student> selectStu(Student student) {
		return studentMapper.selectStu(student);
	}

	@Override
	public Student selectStuById(Student student) {
		return studentMapper.selectStuById(student);
	}

	@Override
	public void updateStu(Student student) {
		studentMapper.updateStu(student);
	}

}
