package in.kishoresugumar.vanha.dao;

import in.kishoresugumar.vanha.dao.TaskDAO.TaskList;
import in.kishoresugumar.vanha.model.Task;

public class TaskDAO {

	public static class TaskList {
		public static Task[] listOfTasks = new Task[10];
	}

	private static final String taskList = null;

	public Task[] findAll() {
		TaskList taskList = new TaskList();
		Task[] userList = taskList.listOfTasks;
		return userList;
	}

	/**
	 *
	 * @param newUser
	 */
	public void create(Task newTask) {
		Task[] arr = TaskList.listOfTasks;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
			if (task == null) {
				arr[i] = newTask;
				break;
			}
		}
	}

	public void update(Task updatedTask) {
		Task[] array = TaskList.listOfTasks;
		for (int i = 0; i < array.length; i++) {
			Task task = array[i];
			if (task == null) {
				continue;
			}
			if (task.getId() == updatedTask.getId()) {
				task.setName(updatedTask.getName());
				task.setDueDate(updatedTask.getDueDate());
				break;
			}
		}
	}

	public void delete(int id) {
		Task[] arr = TaskList.listOfTasks;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
			if (task == null) {
				continue;
			}
			if (task.getId() == id) {
				arr[i].setActive(false);
				break;
			}
		}
	}

	// Find by id
	public Task findById(int taskId) {
		Task[] arr = TaskDAO.TaskList.listOfTasks;
		Task taskMatch = null;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
			if (task == null) {
				continue;
			}
			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}
}
