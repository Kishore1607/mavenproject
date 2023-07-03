package in.kishoresugumar.vanha.service;

import in.kishoresugumar.vanha.dao.UserDAO;
import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.validation.UserValidator;
import in.kishoresugumar.vanha.exception.ValidationException;

public class UserService {
	public User[] getAll() {
		UserDAO userDao = new UserDAO();
		User[] userList = userDao.findAll();
		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}
		return userList;
	}
	public void create(User newUser)throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}
	public void update() {
		User updatedUser = new User();
		
		updatedUser.setId(5555);
		updatedUser.setFirstName("Kishore");
		updatedUser.setLastName("Sugumar");
		updatedUser.setEmail("kishore@gmail.com");
		updatedUser.setPassword("K1i6s0h7");
		updatedUser.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.update(updatedUser);
	}
	
	public void delete() {
		User deleteUser = new User();
		
		deleteUser.setId(5555);
		deleteUser.setFirstName("Kishore");
		deleteUser.setLastName("Sugumar");
		deleteUser.setEmail("kishore@gmail.com");
		deleteUser.setPassword("K1i6s0h7");
		deleteUser.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.update(deleteUser);
	}
	
	public void findById() {
		User findById = new User();
		
		findById.setId(5555);
		findById.setFirstName("Kishore");
		findById.setLastName("Sugumar");
		findById.setEmail("kishore@gmail.com");
		findById.setPassword("K1i6s0h7");
		findById.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.update(findById);
	}







}
