package com.jpmc.learner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpmc.learner.models.TeacherStudentMapping;

public interface TeacherMappingRepository extends JpaRepository<TeacherStudentMapping, Integer> {
	
	@Query(value="select c.course_id, c.course_name,c.description,c.timing,c.start_date,c.end_date,u.user_id,u.full_name,m.mapping_id from lernerjpmc.user u join lernerjpmc.mapping m on m.student_id=u.user_id \n" + 
			" join lernerjpmc.course c on m.course_id = c.course_id\n" + 
			"			where m.teacher_id = ?1 and is_accepted <> 1",nativeQuery = true)
	public List<TeacherStudentMapping> getAllRequestsOfTeacher (Integer teacherid);

}
