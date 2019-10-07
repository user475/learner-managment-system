package com.jpmc.learner.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.jpmc.learner.models.Course;
import com.jpmc.learner.models.TeacherStudentMapping;
import com.jpmc.learner.repository.CourseRepository;
import com.jpmc.learner.repository.TeacherMappingRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	TeacherMappingRepository teacherMappingRepository;
	@Autowired
	ApplicationContext context;

	@Override
	public List<Course> getAllCourses(Integer sid) {
		List<Course> courseList = courseRepository.getAllUnRegisterdCourses(sid);
		return courseList;
	}

	@Override
	public List<TeacherStudentMapping> getAllrequests(Integer teacherId) {
		List<TeacherStudentMapping> list = teacherMappingRepository.getAllRequestsOfTeacher(teacherId);
		list.stream().forEach(System.out::println);
		return list;
	}

	@Override
	public List<Course> getAllAcceptedCourses(Integer studentId) {
		List<Course> listAcceptedCourses = new ArrayList<>();
		/*
		 * courseRepository.getAllAcceptedCourses(studentId).stream().forEach(object ->
		 * { System.out.println((Course)object);
		 * //listAcceptedCourses.add((Course)object); } );
		 */
		List<Object> allAcceptedCourses = courseRepository.getAllAcceptedCourses(studentId);

		Iterator itr = allAcceptedCourses.iterator();
		while (itr.hasNext()) {
			Course bean = context.getBean(Course.class);
			Object[] obj = (Object[]) itr.next();
			// now you have one array of Object for each row
			// c.course_id,c.teacher_id,c.course_name,c.description,c.start_date,
			// c.end_date,c.timing,c.teacher_name, m.is_accepted
			bean.setCourseId((Integer) obj[0]);
			bean.setTeacherId((Integer) obj[1]);
			bean.setCourseName((String) obj[2]);
			bean.setDescription((String) obj[3]);
			bean.setStartDate((Date) obj[4]);
			bean.setEndDate((Date) obj[5]);
			bean.setTiming((String) obj[6]);
			bean.setTeacherName((String) obj[7]);
			bean.setIsAccepted((Boolean) obj[8]);
			System.out.println(obj[8]);
			listAcceptedCourses.add(bean);
		}

		return listAcceptedCourses;
	}

	@Override
	public Course saveCourse(Course course) {
		Course dbCourse = courseRepository.save(course);

		return dbCourse;
	}

	@Override
	public List<Course> allCoursesByTeacherId(Integer teacherId) {
		List<Course> listCourses = courseRepository.findByTeacherId(teacherId);

		return listCourses;
	}

}
