package in.kishoresugumar.vanha;

import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.service.UserService;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.service.TaskService;

public class App {

	public static void main(String[] args) {
	    try {
	    	UserService userService = new UserService();
	    	// User
	        User updatedUser = new User();
	        updatedUser.setId(5555);
	        updatedUser.setFirstName("Micky");
	        updatedUser.setLastName("Eren");
	        updatedUser.setEmail("eren.micky@example.com");
	        updatedUser.setPassword("E1n2M3y4");
	        updatedUser.setActive(true);
	        userService.update(updatedUser);
	        userService.printAllUsers();
	        
	     // Task
	        TaskService taskService = new TaskService();
	        Task newTask = new Task();
	        newTask.setId(01);
	        newTask.setName("Task 5");
	        newTask.setDueDate("01/12/2025");
	        newTask.setActive(true);
	        taskService.create(newTask);
	        taskService.printAllTasks();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
