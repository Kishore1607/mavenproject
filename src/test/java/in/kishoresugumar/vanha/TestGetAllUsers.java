package in.kishoresugumar.vanha;


import org.junit.jupiter.api.Test;

import in.kishoresugumar.vanha.service.UserService;

public class TestGetAllUsers {
	// TODO Auto-generated method stub
	@Test
	public void getAllUsers() {
		UserService us = new UserService();
		System.out.println(us.getAllUsersAsArray());
	}
	
	@Test
	public void getUserById() {
		UserService us = new UserService();
		System.out.println(us.findById(1));
	}
	
}
