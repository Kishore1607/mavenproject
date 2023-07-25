package in.kishoresugumar.vanha.validation;

import in.kishoresugumar.vanha.util.StringUtil;
import in.kishoresugumar.vanha.exception.ValidationException;
import in.kishoresugumar.vanha.model.User;

public class UserValidator {

	public static void validate(User user) throws Exception {
		if (user == null) {
			throw new ValidationException("Invalid user input");
		}

		StringUtil.RegectIfInvalidString(user.getEmail(), "Email");

		StringUtil.RegectIfInvalidString(user.getPassword(), "Password");

		StringUtil.RegectIfInvalidString(user.getFirstName(), "FirstName");

	}
}