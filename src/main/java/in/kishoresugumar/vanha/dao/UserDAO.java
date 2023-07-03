package in.kishoresugumar.vanha.dao;

import in.kishoresugumar.vanha.model.User;

public class UserDAO {
	// TODO Auto-generated method stub
	public User[] findAll() {
		User[] userList = UserList.listOfUsers;
		return userList;
	}

	/**
	 *
	 * @param newUser
	 */
	public void create(User newUser) {
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				arr[i] = newUser;
				break;
			}
		}
	}

	public void update(User updatedUser) {
		User[] array = UserList.listOfUsers;
		for (int i = 0; i < array.length; i++) {
			User user = array[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == updatedUser.getId()) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setPassword(updatedUser.getPassword());
				break;
			}
		}
	}

	public void delete(int id) {
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == id) {
				arr[i].setActive(false);
				break;
			}
		}
	}

	// Find by id
	public User findById(int userId) {
		User[] arr = UserList.listOfUsers;
		User userMatch = null;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

}
