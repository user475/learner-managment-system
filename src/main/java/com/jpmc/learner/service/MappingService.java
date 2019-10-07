package com.jpmc.learner.service;

import com.jpmc.learner.models.Mapping;

public interface MappingService {

	public Mapping getMapingByCourseIdAndStudentID(Integer studentId, Integer courseId);

	public Integer saveMapping(Mapping mapping);

	public Integer updateMapping(Integer mappingId);

}
