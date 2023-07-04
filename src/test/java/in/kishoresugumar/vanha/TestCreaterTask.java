package in.kishoresugumar.vanha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import in.kishoresugumar.vanha.exception.ValidationException;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.service.TaskService;

public class TestCreaterTask {
	@Test
	public void testCreateTaskWithValidData() {

		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		
		newTask.setId(5555);
		newTask.setName("Kishore");
		newTask.setDueDate("16/07/2023");
		newTask.setActive(true);
		
		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});
	}
	
	@Test
	public void testCreateTaskWithInvalidData() {

		TaskService taskService = new TaskService();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	@Test
	public void testTaskNameNull() {

		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		
		newTask.setId(5555);
		newTask.setName(null);
		newTask.setDueDate("2023/07/16");
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});

		String exceptedMessage = "Name cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testTaskNameEmpty() {

		TaskService taskService = new TaskService();
		
	    Task newTask = new Task();
		
	    newTask.setId(5555);
	    newTask.setName(" ");
		newTask.setDueDate("16/07/2023");
	    newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});

		String exceptedMessage = "Name cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	@Test
	public void testTaskDueDateNull() {

		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		
		newTask.setId(5555);
		newTask.setName("Kishore");
		newTask.setDueDate(null);
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});

		String exceptedMessage = "Date cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	@Test
	public void testTaskDueDateEmpty() {

		TaskService taskService = new TaskService();
		
	    Task newTask = new Task();
		
	    newTask.setId(5555);
	    newTask.setName("Kishore");
		newTask.setDueDate(" ");
	    newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});

		String exceptedMessage = "Date cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
}
