package com.onlineExam.onlineExamserver.helper;

public class UserNotFoundException extends Exception {
	public UserNotFoundException()
	{
		super("User with this Username not found in database !!");
	}

	public UserNotFoundException(String msg)
	{
		super(msg);
	}
}
