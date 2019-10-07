package com.jpmc.learner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.learner.models.Course;
import com.jpmc.learner.models.TeacherStudentMapping;
import com.jpmc.learner.repository.TeacherMappingRepository;

@Service
public class TeacherMappingServiceImpl  {

	public TeacherMappingServiceImpl() {
		System.out.println("CourseServiceImpl");
	}

	
	/*
	 * @Autowired TeacherMappingRepository teacherMappingRepository;
	 * 
	 * 
	 * 
	 * @Override public List<Course> getAllCourses() { List<Course> courseList =
	 * courseRepository.findAll(); return courseList; }
	 * 
	 * 
	 * @Override public List<TeacherStudentMapping> getAllrequests(Integer
	 * teacherId) { List<TeacherStudentMapping> list =
	 * teacherMappingRepository.getAllRequestsOfTeacher(teacherId); return list; }
	 */

}
