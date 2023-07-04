package in.kishoresugumar.vanha.validation;

import java.time.LocalDate;

import in.kishoresugumar.vanha.exception.ValidationException;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.util.StringUtil;

public class TaskValidator {

	public static void validate(Task newTask) throws Exception {
		if (newTask == null) {
			throw new ValidationException("Invalid user input");
		}
		
		if (newTask.getDueDate() == null) {
			throw new ValidationException("Input date cannot be empty");
		}

		StringUtil.RegectIfInvalidString(newTask.getName(), "Name");

		LocalDate currentDate = LocalDate.now();
		LocalDate inputDate = newTask.getDueDate();
		System.out.println(currentDate);
		System.out.println(inputDate);
		boolean isInputDateBeforeCurrentDate = inputDate.isBefore(currentDate);

		if (isInputDateBeforeCurrentDate) {
			throw new ValidationException("Input date is before the current date");
		}

	}
}
