package in.kishoresugumar.vanha;

import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.dao.UserDAO;
import in.kishoresugumar.vanha.service.UserService;
import in.kishoresugumar.vanha.model.Task;

import java.time.LocalDate;

import in.kishoresugumar.vanha.dao.TaskDAO;
import in.kishoresugumar.vanha.service.TaskService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// User
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
			
			// Task
			
			TaskService taskService = new TaskService();
			Task newTask = new Task();
			newTask.setId(5555);
			newTask.setName("Kishore");
			newTask.setDueDate("20/20/3023");
			newTask.setActive(true);
			taskService.create(newTask);
			taskService.getAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
