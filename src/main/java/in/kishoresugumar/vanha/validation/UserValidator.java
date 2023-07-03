package in.kishoresugumar.vanha.validation;

import in.kishoresugumar.vanha.util.StringUtil;
import in.kishoresugumar.vanha.exception.ValidationException;
import in.kishoresugumar.vanha.model.User;

public class UserValidator {

	public static void validate(User user) throws Exception {
		if (user == null) {
			throw new ValidationException("Invalid user input");
		}

//	if(user.getEmail() == null || ("").equals(user.getEmail().trim())) {
//		throw new ValidationException("Email cannot be null or empty");
//	}

		StringUtil.RegectIfInvalidString(user.getEmail(), "Email");

//	if(user.getPassword() == null || ("").equals(user.getPassword().trim())) {
//		throw new ValidationException("Password cannot be null or empty");
//	
//    }

		StringUtil.RegectIfInvalidString(user.getPassword(), "Password");

//	if(user.getFirstName() == null || ("").equals(user.getFirstName().trim())) {
//		throw new ValidationException("FirstName cannot be null or empty");
//	
//    }

		StringUtil.RegectIfInvalidString(user.getFirstName(), "FirstName");

	}
}