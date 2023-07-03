package in.kishoresugumar.vanha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.kishoresugumar.vanha.exception.ValidationException;
import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidData() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName("Kishore");
		newUser.setLastName("Sugumar");
		newUser.setEmail("kishore@gmail.com");
		newUser.setPassword("K1i6s0h7");
		newUser.setActive(true);
		
		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});
	}
	
	@Test
	public void testCreateUserWithInvalidData() {

		UserService userService = new UserService();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserEmailNull() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName("Kishore");
		newUser.setLastName("Sugumar");
		newUser.setEmail(null);
		newUser.setPassword("K1i6s0h7");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserEmailEmpty() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName("Kishore");
		newUser.setLastName("Sugumar");
		newUser.setEmail(" ");
		newUser.setPassword("K1i6s0h7");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserPasswordEmpty() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName("Kishore");
		newUser.setLastName("Sugumar");
		newUser.setEmail("kishore@gmail.com");
		newUser.setPassword("");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserPasswordNull() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName("Kishore");
		newUser.setLastName("Sugumar");
		newUser.setEmail("kishore@gmail.com");
		newUser.setPassword(null);
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserFirstNameEmpty() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName("");
		newUser.setLastName("Sugumar");
		newUser.setEmail("kishore@gmail.com");
		newUser.setPassword("");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserFirstNameNull() {

		UserService userService = new UserService();
		
		User newUser = new User();
		
		newUser.setId(5555);
		newUser.setFirstName(null);
		newUser.setLastName("Sugumar");
		newUser.setEmail("kishore@gmail.com");
		newUser.setPassword(null);
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
}