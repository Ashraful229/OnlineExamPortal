package com.onlineExam.onlineExamserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineExam.onlineExamserver.model.User;

public interface   UserRepository extends JpaRepository<User, Long> {
 
	public User  findByUsername(String username);
}
