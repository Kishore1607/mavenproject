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

		StringUtil.RegectIfInvalidString(newTask.getName(), "Name");
		
		StringUtil.RegectIfInvalidString(newTask.getDueDate(), "Date");

	}
}
