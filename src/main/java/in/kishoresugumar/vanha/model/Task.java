package in.kishoresugumar.vanha.model;

public class Task {
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String string) {
		this.dueDate = string;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", dueDate=" + dueDate + ", isActive=" + isActive + "]";
	}
	
	int id;
	String name;
	String dueDate;
	boolean isActive = true;

}
