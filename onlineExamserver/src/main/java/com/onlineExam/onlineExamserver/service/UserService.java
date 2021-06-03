package com.onlineExam.onlineExamserver.service;

import java.util.Set;

import com.onlineExam.onlineExamserver.model.User;
import com.onlineExam.onlineExamserver.model.UserRole;

public interface UserService {
	//create user
	public User CreateUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by user name
	public User getUser(String user);
	
	//delete user by id
	public void deleteUser(Long userId);

}
