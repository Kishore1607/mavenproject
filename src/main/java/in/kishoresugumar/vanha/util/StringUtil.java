package in.kishoresugumar.vanha.util;

import in.kishoresugumar.vanha.exception.ValidationException;

public class StringUtil {
	public static void RegectIfInvalidString(String input, String name)throws ValidationException{
		if(input == null || ("").equals(input.trim())) {
			throw new ValidationException(name.concat(" cannot be null or empty"));
		}
	}
	public static boolean IsvalidString(String input, String name) {
		if(input == null || ("").equals(input.trim())) {
			return false;
		}
		return true;
	}
	public static boolean IsInvalidString(String input, String name) {
		if(input == null || ("").equals(input.trim())) {
			return true;
		}
		return false;
	}
}
