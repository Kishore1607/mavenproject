package in.kishoresugumar.vanha.service;

import java.util.Set;

import in.kishoresugumar.vanha.dao.UserDAO;
import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.model.UserEntity;
import in.kishoresugumar.vanha.validation.UserValidator;

public class UserService {
	UserDAO userDao = new UserDAO();
	
	public void create(User newUser)throws Exception {
		UserValidator.validate(newUser);
		userDao.create(newUser);
	}
	
	public void update(UserEntity updatedUser) {
	    userDao.update(updatedUser);
	}

	public void delete(UserEntity deleteUser) {
	    userDao.delete(deleteUser);
	}

	public UserEntity findById(int id) {
        return userDao.findById(id);
    }
	
    public UserEntity[] getAllUsersAsArray() {
        Set<UserEntity> userSet = userDao.findAll();
        return userSet.toArray(new UserEntity[0]);
    }
    
    public void printAllUsers() {
        UserEntity[] allUsersArray = getAllUsersAsArray();
        for (UserEntity user : allUsersArray) {
            System.out.println(user);
        }
    }


}
