package com.school.dao;

import org.springframework.stereotype.Component;

import com.school.vo.Student;

@Component
public class StudentDAOImpl implements StudentDAO {
	@Override
	public long enrollStudent(Student student) {
		return 0;
	}

	@Override
	public Student fetchStudent(Student student) {
		return null;
	}
}
