package com.onlineExam.onlineExamserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.onlineExam.onlineExamserver.model.Role;
import com.onlineExam.onlineExamserver.model.User;
import com.onlineExam.onlineExamserver.model.UserRole;
import com.onlineExam.onlineExamserver.repo.RoleRepository;
import com.onlineExam.onlineExamserver.service.UserService;

@SpringBootApplication
public class OnlineExamserverApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting code");
//		User user= new User();
//		user.setFirstName("Ashraful");
//		user.setLastName("Alam");
//		user.setUsername("Emon1229");
//		user.setPassword("1234");
//		user.setEmai("abc@gmail.com");
//		
//		Role role= new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet= new HashSet<>();
//		UserRole userRole= new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		
//		User user2= this.userService.CreateUser(user, userRoleSet);
//		System.out.println(user2.getUsername());
		
	}

}
