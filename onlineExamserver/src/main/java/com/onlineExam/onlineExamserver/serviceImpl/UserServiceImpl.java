package com.onlineExam.onlineExamserver.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineExam.onlineExamserver.model.User;
import com.onlineExam.onlineExamserver.model.UserRole;
import com.onlineExam.onlineExamserver.repo.RoleRepository;
import com.onlineExam.onlineExamserver.repo.UserRepository;
import com.onlineExam.onlineExamserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User CreateUser(User user, Set<UserRole> userRoles) throws Exception {
		
	User local=	this.userRepository. findByUsername(user.getUsername());
	
	if(local!=null)
	{
		System.out.println("user is already there");
		throw new Exception("u ser already present");
	}
	else
	{
		
		for(UserRole  ur:userRoles)
		{
			roleRepository.save(ur.getRole());
		}
		user.getUserRole().addAll(userRoles);
		local=userRepository.save(user);
	}
		
		return local ;
	}

	//gating user by user name
	@Override
	public User getUser(String user) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(user);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
		
	}
	

}
