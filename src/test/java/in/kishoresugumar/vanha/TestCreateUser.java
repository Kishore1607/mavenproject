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

		UserService us = new UserService();
		User newUser = new User();
		
		newUser.setFirstName("Eren");
		newUser.setLastName("Micky");
		newUser.setEmail("ErenMicky@gmail.com");
		newUser.setPassword("EM#123");
		
		assertDoesNotThrow(()-> {
			us.create(newUser);
		});
	}
	
	@Test
	public void testCreateUserWithInvalidData() throws Exception {

		UserService userService = new UserService();
		User invalidNewUser = new User();
		
		invalidNewUser.setFirstName("Eren");
		invalidNewUser.setLastName("Micky");
		invalidNewUser.setEmail("ErenMicky@gmail.com");
		invalidNewUser.setPassword("EM#123");
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	
	@Test
	public void testUpdateUserWithvalidData() throws Exception {

		UserService userService = new UserService();
		User userUpdate = new User();
		
		userUpdate.setFirstName("Formido");
		userUpdate.setLastName("Praveen");
		userUpdate.setId(1);
		
		assertDoesNotThrow(()-> {
			userService.update(userUpdate);
			});
		
	}
	
	@Test
	public void testDeleteUser() throws Exception {

		UserService userService = new UserService();
		User userDelete = new User();
		userDelete.setId(1);
		
		assertDoesNotThrow(()-> {
			userService.delete(userDelete);
			});
		
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