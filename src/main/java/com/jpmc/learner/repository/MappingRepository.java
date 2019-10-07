package com.jpmc.learner.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpmc.learner.models.Mapping;

/**
 * @author cmankala
 *
 */
@Repository
public interface MappingRepository extends JpaRepository<Mapping, Integer>{
	
	public Mapping findByStudentIdAndCourseId(Integer studentId,Integer courseId);
	
}
