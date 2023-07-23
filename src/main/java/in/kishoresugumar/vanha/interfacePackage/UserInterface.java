package in.kishoresugumar.vanha.interfacePackage;

import in.kishoresugumar.vanha.model.UserEntity;

public interface UserInterface extends Base<UserEntity> {
	public abstract UserEntity findByEmail(String email);
}
