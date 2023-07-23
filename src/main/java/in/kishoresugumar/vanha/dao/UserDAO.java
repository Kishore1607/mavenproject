package in.kishoresugumar.vanha.dao;

import java.util.Set;
import java.util.HashSet;
import in.kishoresugumar.vanha.interfacePackage.UserInterface;
import in.kishoresugumar.vanha.model.UserEntity;

public class UserDAO implements UserInterface {

	private Set<UserEntity> userSet = new HashSet<>();

	@Override
	public Set<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userSet;
	}

	@Override
	public UserEntity findById(int id) {
		for (UserEntity user : userSet) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void create(UserEntity newUser) {
		if (!userSet.contains(newUser)) {
			userSet.add(newUser);
		}
	}

	@Override
	public void update(UserEntity updateUser) {
		// TODO Auto-generated method stub
		for (UserEntity user : userSet) {
			if (user.getId() == updateUser.getId()) {
				user.setFirstName(updateUser.getFirstName());
				user.setLastName(updateUser.getLastName());
				user.setEmail(updateUser.getEmail());
				user.setPassword(updateUser.getPassword());
				user.setActive(updateUser.isActive());
				break;
			}
		}
	}

	@Override
	public void delete(UserEntity deleteUser) {
		// TODO Auto-generated method stub
		UserEntity userToRemove = null;
		for (UserEntity user : userSet) {
			if (user.getId() == deleteUser.getId()) {
				userToRemove = user;
				break;
			}
		}

		if (userToRemove != null) {
			userSet.remove(userToRemove);
		}
	}

	@Override
	public UserEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		UserEntity userMatch = null;
		for (UserEntity user : userSet) {
			if (email.equals(user.getEmail())) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

}
