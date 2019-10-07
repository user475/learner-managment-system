package com.jpmc.learner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpmc.learner.models.Mapping;
import com.jpmc.learner.service.MappingService;

/**
 * @author cmankala
 *
 */
@Controller
public class MappingController {

	@Autowired
	private MappingService mappingService;

	@Autowired
	private ApplicationContext applicationContext;

	
	
	
	/**
	 * 
	 * @param teacherId
	 * @param courseId
	 * @param userId
	 * @return
	 */
	@PostMapping("/student/request")
	@ResponseBody
	public Integer courseRequest(@RequestParam("teacherId") Integer teacherId,
			@RequestParam("courseId") Integer courseId, @CookieValue("userId") Integer userId) {

		Mapping mapping = applicationContext.getBean(Mapping.class);
		
		Integer isMappingExists = getMapingByCourseIdAndStudentID(userId, courseId);
		if(isMappingExists == 0) {
			mapping.setTeacherId(teacherId);
			mapping.setCourseId(courseId);
			mapping.setStudentId(userId);

			Integer requestId = mappingService.saveMapping(mapping);

			if (requestId != null) {
				return requestId;
			}
		}		
		return 0;
	}

	@PostMapping("/teacher/response")
	@ResponseBody
	public Integer acceptRequest(@RequestParam("mappingId") Integer mappingId,
			@CookieValue("userId") Integer userId) {
		Integer  reqId= mappingService.updateMapping(mappingId);
		if(reqId==0)
			return 0;
		return reqId;
		
	}
	
	
	public Integer getMapingByCourseIdAndStudentID(Integer sid,Integer cid ) {
		
		if(sid != null && cid!=null) {
			Mapping dbMap= mappingService.getMapingByCourseIdAndStudentID(sid, cid);
			if(dbMap != null )
				return dbMap.getMappingId();
		}
		return 0;
	}
}
