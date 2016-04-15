package com.school.service;

import java.util.List;

import com.school.vo.Status;
import com.school.vo.Student;

public interface StudentService {
	Status enrollStudent(Student student);

	List<Student> fetchStudent(Student student);
}
