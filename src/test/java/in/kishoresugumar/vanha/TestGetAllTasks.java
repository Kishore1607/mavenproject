package in.kishoresugumar.vanha;

import org.junit.jupiter.api.Test;

import in.kishoresugumar.vanha.service.TaskService;

public class TestGetAllTasks {
	@Test
	public void getAllTask() {
		TaskService ts = new TaskService();
		System.out.println(ts.getAllTasksAsArray());
	}
	
	@Test
	public void getTaskById() {
		TaskService ts = new TaskService();
		System.out.println(ts.findById(1));
	}
}
