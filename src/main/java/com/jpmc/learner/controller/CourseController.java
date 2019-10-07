package com.jpmc.learner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpmc.learner.models.Course;
import com.jpmc.learner.models.TeacherStudentMapping;
import com.jpmc.learner.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private ApplicationContext applicationContext;
	
	/*
	 * Take the user Id and return the List of Available courses
	 */
	@GetMapping("/student/home")
	public String getCourseList(Model model, @CookieValue("userName") String userName,
			@CookieValue("userId") Integer sid) {
		model.addAttribute("userName", userName);
		List<Course> allCourses = courseService.getAllCourses(sid);
		model.addAttribute("course", allCourses);
		return "courseList.html";

	}

	/*
	 * Take the user Id and return
	 *  the List of requests of student for different courses
	 */
	@GetMapping("/teacher/home")
	public String getRequestList(Model model, @CookieValue("userId") Integer teacherId,
			@CookieValue("userName") String userName) {
		model.addAttribute("userName", userName);
		List<TeacherStudentMapping> listOfRqs = courseService.getAllrequests(teacherId);
		// listOfRqs.stream().forEach(System.out::println);
		model.addAttribute("list", listOfRqs);
		return "teacher-home.html";

	}

	/*
	 * return the List of current student courses and status of it
	 */
	@GetMapping("/student/status")
	public String checkStatus(Model model, @CookieValue("userId") Integer userId,
			@CookieValue("userName") String userName) {
		model.addAttribute("userName", userName);
		List<Course> list = courseService.getAllAcceptedCourses(userId);
		list.stream().forEach(System.out::println);
		model.addAttribute("course", list);
		return "myCources.html";

	}

	/*
	 * return the page to Add course
	 */
	@GetMapping("/teacher/add-course")
	public String addCourse(Model model, @CookieValue("userId") Integer userId,
			@CookieValue("userName") String userName) {
		model.addAttribute("userName", userName);
		Course bean = applicationContext.getBean(Course.class);

		model.addAttribute("course", bean);

		return "add_course.html";

	}

	/*
	 * Accepts Course details and store it
	 */
	@PostMapping("/teacher/add-course")

	public String addCourse(@ModelAttribute Course course, @CookieValue("userId") Integer userId,
			@CookieValue("userName") String userName) {
		System.out.println("userName" + userName);
		course.setTeacherId(userId);
		course.setTeacherName(userName);
		Course saveCourse = courseService.saveCourse(course);
		System.out.println("saveCourse" + saveCourse.toString());
		return "redirect:/teacher/courses";
	}

	/*
	 *  return the List of Teacher's all courses
	 */
	@GetMapping("/teacher/courses")
	public String teacherCourseList(@CookieValue("userId") Integer userId, Model model,
			@CookieValue("userName") String userName) {
		List<Course> allCoursesByTeacherId = courseService.allCoursesByTeacherId(userId);

		model.addAttribute("courseList", allCoursesByTeacherId);
		model.addAttribute("userName", userName);
		return "teacher-course-list.html";
	}

}
