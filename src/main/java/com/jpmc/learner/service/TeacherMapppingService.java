package com.jpmc.learner.service;

import java.util.List;

import com.jpmc.learner.models.TeacherStudentMapping;

public interface TeacherMapppingService {



	public List<TeacherStudentMapping> getAllrequests(Integer teacherId);

}
