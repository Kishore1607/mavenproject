package in.kishoresugumar.vanha.interfacePackage;

import java.util.Set;

public interface Base <T> {
	public abstract Set<T> findAll();
	public abstract T findById(int id);
	public abstract void create(T item);
	public abstract void update(T item);
	public abstract void delete(T item);
}
