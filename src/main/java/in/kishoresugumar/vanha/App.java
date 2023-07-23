package in.kishoresugumar.vanha;

import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.model.UserEntity;
import in.kishoresugumar.vanha.service.UserService;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.service.TaskService;

public class App {

	public static void main(String[] args) {
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
	        userService.printAllUsers();

	        // Call the update method with the updated user details
	        User updatedUser = new User();
	        updatedUser.setId(5555);
	        updatedUser.setFirstName("Micky");
	        updatedUser.setLastName("Eren");
	        updatedUser.setEmail("eren.micky@example.com");
	        updatedUser.setPassword("E1n2M3y4");
	        updatedUser.setActive(true);
	        userService.update(updatedUser);
	        userService.printAllUsers();
	        
	        // Call the findById method with the user id
	        userService.findById(5555);
	        userService.printAllUsers();

	        // Call the delete method with the user to delete
	        User deleteUser = new User();
	        deleteUser.setId(5555);
	        userService.delete(deleteUser);
	        userService.printAllUsers();
	        
	     // Task
	        TaskService taskService = new TaskService();
	        Task newTask = new Task();
	        newTask.setId(01);
	        newTask.setName("Task 1");
	        newTask.setDueDate("01/01/2025");
	        newTask.setActive(true);
	        taskService.create(newTask);
	        taskService.printAllTasks();
	        
	     // Call the update method with the updated task details
	        Task updatedTask = new Task();
	        updatedTask.setId(01);
	        updatedTask.setName("Task 01");
	        updatedTask.setDueDate("01/01/2024");
	        updatedTask.setActive(true);
	        taskService.update(updatedTask);
	        taskService.printAllTasks();
	        
	        // Call the findById method with the user id
	        taskService.findById(5555);
	        taskService.printAllTasks();

	        // Call the delete method with the user to delete
	        Task deleteTask = new Task();
	        deleteTask.setId(01);
	        taskService.delete(deleteTask);
	        taskService.printAllTasks();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
