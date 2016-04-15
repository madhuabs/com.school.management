package com.school.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.service.StudentService;
import com.school.vo.Status;
import com.school.vo.Student;

@Component
@Path("/student")
public class StudentRestService {
	@Autowired
	private StudentService studentService;

	@Path("enrollment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Status enrollStudent(Student student) {
		return studentService.enrollStudent(student);
	}

	@Path("fetchStudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public List<Student> fetchStudent(Student student) {
		return studentService.fetchStudent(student);
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
