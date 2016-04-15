package com.school.service;

import java.util.List;

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
		List<Student> studentList = fetchStudent(student);
		if (!studentList.isEmpty()) {
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

	@Override
	public List<Student> fetchStudent(Student student) {
		List<Student> studentList = studentDAO.fetchStudent(student.getStudentRollNumber(), student.getStudentName(),
				student.getProgram(), student.getCreationDate(), student.getUpdatedDate());
		return studentList;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
