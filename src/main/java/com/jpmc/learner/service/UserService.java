package com.jpmc.learner.service;
import java.util.List;

import com.jpmc.learner.models.User;



public interface UserService {

	public List<User> getAllUsers();
	
	public Integer registerUser(User user);
	
	public User getUserByUserName(String userName);
	

}
