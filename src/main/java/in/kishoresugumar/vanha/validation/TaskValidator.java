package in.kishoresugumar.vanha.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import in.kishoresugumar.vanha.exception.ValidationException;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.util.StringUtil;

public class TaskValidator {

	public static void validate(Task newTask) throws ValidationException {
		if (newTask == null) {
			throw new ValidationException("Invalid user input");
		}

		StringUtil.RegectIfInvalidString(newTask.getName(), "Name");

		StringUtil.RegectIfInvalidString(newTask.getDueDate(), "Date");

		String date = newTask.getDueDate();

		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
		}catch(DateTimeParseException e) {
			throw new ValidationException("Invalid date");
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dueDate = LocalDate.parse(date, formatter);
		LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
		LocalDate currentDate = LocalDate.now();
		if (dueDate.equals(currentDate) || dueDate.isBefore(currentDate)) {
			throw new ValidationException("Due date should be in future");
		}

	}
}
