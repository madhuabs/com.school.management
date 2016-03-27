package com.school.dao;

import com.school.vo.Student;

public interface StudentDAO {

	Student fetchStudent(Student student);

	long enrollStudent(Student student);

}
