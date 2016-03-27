package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.dao.StudentDAO;
import com.school.vo.Status;
import com.school.vo.Student;

@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Status enrollStudent(Student student) {
		/*
		 * Validate Student exists based student first name,last name, DOB,
		 * gender Fathers First Name, Last Name.. all case incentive.
		 */
		Status status = new Status();
		if (studentDAO.fetchStudent(student) == null) {
			long result = studentDAO.enrollStudent(student);
			if (result > 0) {
				status.setStatuscd("1");
			} else {
				status.setStatuscd("0");
				status.setErrorDesc("Student Enrolled Successfully");
			}
		} else {
			status.setStatuscd("0");
			status.setErrorDesc("Student Details Already Exist.");
		}
		return status;

	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
