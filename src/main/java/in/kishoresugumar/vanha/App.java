package in.kishoresugumar.vanha;

import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.dao.UserDAO;
import in.kishoresugumar.vanha.service.UserService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UserService userService = new UserService();
			User newUser = new User();
			newUser.setId(5555);
			newUser.setFirstName("Kishore");
			newUser.setLastName("Sugumar");
			newUser.setEmail("kishore@gmail.com");
			newUser.setPassword("K1i6s0h7");
			newUser.setActive(true);
			userService.create(newUser);
			userService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
