package com.jpmc.learner.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.learner.models.User;
import com.jpmc.learner.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
	System.out.println("StudentServiceImpl");
	}
	
	@Autowired
	UserRepository studentRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> studentList=new ArrayList<>();		
		studentRepository.findAll().stream().forEach(studentList::add);
		return studentList;
	}

	@Override
	public Integer registerUser(User user) {
		 User save = studentRepository.save(user);
		return save.getUserId();
	
	}

	@Override
	public User getUserByUserName(String userName) {
		User user = studentRepository.findByUsername(userName);
		return user;
	}
	
	

}
