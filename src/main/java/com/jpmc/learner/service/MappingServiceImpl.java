package com.jpmc.learner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.learner.models.Mapping;
import com.jpmc.learner.repository.MappingRepository;

@Service
public class MappingServiceImpl implements MappingService {

	public MappingServiceImpl() {
		System.out.println("MappingServiceImpl");
	}

	@Autowired
	MappingRepository mappingRepository;
	

	@Override
	public Integer saveMapping(Mapping mapping) {
		//mappingRepository.f
		Mapping dbMapping = mappingRepository.save(mapping);		
		return dbMapping.getMappingId();
	}


	@Override
	public Mapping getMapingByCourseIdAndStudentID(Integer studentId, Integer courseId) {
		
		Mapping dbMap = mappingRepository.findByStudentIdAndCourseId(studentId, courseId);
		
		return dbMap;
	}


	@Override
	public Integer updateMapping(Integer mappingId) {
		Mapping dbMapping = mappingRepository.findById(mappingId).get();
		if(dbMapping != null) {
		dbMapping.setAccepted(true);
		 Integer reqId = saveMapping(dbMapping);
		return reqId;
		}
	return 0;
	}

	

}
