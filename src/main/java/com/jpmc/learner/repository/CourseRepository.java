package com.jpmc.learner.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpmc.learner.models.Course;

/**
 * @author cmankala
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	/*
	 * @Query(
	 * value="SELECT c.course_id,c.teacher_id,c.course_name,c.description,c.start_date,c.end_date,c.timing,c.teacher_name "
	 * +
	 * "FROM lernerjpmc.course c join lernerjpmc.mapping m on m.course_id = c.course_id where m.student_id=?1 and m.is_accepted <> 1"
	 * ,nativeQuery = true)
	 */
	
	@Query(value="  SELECT c.course_id,c.teacher_id,c.course_name,c.description,c.start_date,c.end_date,c.timing,c.teacher_name \n" + 
			"	FROM lernerjpmc.course c where c.course_id  NOT IN(    SELECT c.course_id\n" + 
			"	FROM lernerjpmc.course c left join lernerjpmc.mapping m\n" + 
			"    on c.course_id =m.course_id\n" + 
			"    where m.student_id =?1)",nativeQuery = true)
	public List<Course> getAllUnRegisterdCourses(Integer studentId);
	
	
	@Query(value="SELECT c.course_id,c.teacher_id,c.course_name,c.description,c.start_date,c.end_date,c.timing,c.teacher_name, m.is_accepted "
			+ "FROM lernerjpmc.course c join lernerjpmc.mapping m on m.course_id = c.course_id where m.student_id=?1 ",nativeQuery = true)
	 public List<Object> getAllAcceptedCourses(Integer studentId);
	
	public List<Course> findByTeacherId(Integer teacherId);
}
