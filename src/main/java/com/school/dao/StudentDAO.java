package com.school.dao;

import java.util.Date;
import java.util.List;

import com.school.vo.Student;

public interface StudentDAO {

	List<Student> fetchStudent(String studentRollNumber, String studentName, String program, Date dateStart,
			Date dateEnd);

	long enrollStudent(Student student);

}
