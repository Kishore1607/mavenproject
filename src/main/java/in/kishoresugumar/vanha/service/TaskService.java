package in.kishoresugumar.vanha.service;

import in.kishoresugumar.vanha.dao.TaskDAO;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.validation.TaskValidator;

import java.time.LocalDate;

public class TaskService {
	
	public Task[] getAll() {
		TaskDAO taskDao = new TaskDAO();
		Task[] userList = taskDao.findAll();
		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}
		return userList;
	}
	public void create(Task newTask)throws Exception {
		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(newTask);
	}
	public void update() {
		Task updatedTask = new Task();
		
		updatedTask.setId(5555);
		updatedTask.setName("Kishore");
		updatedTask.setDueDate("16/07/2023");
		updatedTask.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(updatedTask);
	}
	
	public void delete() {
		Task deleteTask = new Task();
		
		deleteTask.setId(5555);
		deleteTask.setName("Kishore");
		deleteTask.setDueDate("16/07/2023");
		deleteTask.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(deleteTask);
	}
	
	public void findById() {
		Task findById = new Task();
		
		findById.setId(5555);
		findById.setName("Kishore");
		findById.setDueDate("16/07/2023");
		findById.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(findById);
	}
}
