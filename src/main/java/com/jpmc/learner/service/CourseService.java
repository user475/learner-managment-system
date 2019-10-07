package com.jpmc.learner.service;

import java.util.List;

import com.jpmc.learner.models.Course;
import com.jpmc.learner.models.TeacherStudentMapping;

public interface CourseService {

	public List<Course> getAllCourses(Integer studentId);

	public List<TeacherStudentMapping> getAllrequests(Integer teacherId);
	
	public List<Course> getAllAcceptedCourses(Integer studentId);

	public Course saveCourse(Course course);
	
	public List<Course> allCoursesByTeacherId(Integer teacherId);
}
