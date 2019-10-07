package com.jpmc.learner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.learner.models.Response;
import com.jpmc.learner.models.User;
import com.jpmc.learner.service.UserService;

@RestController

public class StudentRestController {
	/*@Autowired
	private UserService studentService;

	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(value = "/list-students")
	public List<User> StudentList() {
		List<User> StudentList = studentService.getAllStudents();
		System.out.println(StudentList);
		return StudentList;

	}

	@PostMapping(value = "/register-student", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer registerStudent(@RequestBody User student) {
		System.out.println("registerStudent in controller");
		Integer studentId = studentService.registerStudent(student);
		if (studentId == null)
			return 0;
		return studentId;

	}

	@PostMapping(value = "/login-student", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response loginStudent(@RequestBody User student) {
		System.out.println("registerStudent in controller");
		User dbStudent = studentService.getStudentByUserName(student.getUsername());
		Response response = applicationContext.getBean(Response.class);
		response.setError(true);
		response.setMessage("user name does not exist");
		response.setStatus(401);

		if (dbStudent == null) {
			return response;
		} else if (dbStudent.getPassword().equals(student.getPassword())) {
			response.setError(false);
			response.setMessage("success");
			response.setStatus(200);
			response.setObject(student);
			return response;
		}
		response.setMessage("password does not match");
		
		return response;
	}*/
}
