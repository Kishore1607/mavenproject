package in.kishoresugumar.vanha.dao;

import java.util.HashSet;
import java.util.Set;
import in.kishoresugumar.vanha.interfacePackage.TaskInterface;
import in.kishoresugumar.vanha.model.TaskEntity;

public class TaskDAO implements TaskInterface{
	
	private Set<TaskEntity> taskSet = new HashSet<>();

	@Override
	public Set<TaskEntity> findAll() {
		// TODO Auto-generated method stub
		return taskSet;
	}

	@Override
	public TaskEntity findById(int id) {
		// TODO Auto-generated method stub
		for (TaskEntity task : taskSet) {
			if (task.getId() == id) {
				return task;
			}
		}
		return null;
	}

	@Override
	public void create(TaskEntity newTask) {
		// TODO Auto-generated method stub
		if (!taskSet.contains(newTask)) {
			taskSet.add(newTask);
		}
	}

	@Override
	public void update(TaskEntity updateTask) {
		// TODO Auto-generated method stub
		for (TaskEntity task : taskSet) {
			if (task.getId() == updateTask.getId()) {
				task.setName(updateTask.getName());
				task.setDueDate(updateTask.getDueDate());
				task.setActive(updateTask.isActive());
				break;
			}
		}
	}

	@Override
	public void delete(TaskEntity deleteTask) {
		// TODO Auto-generated method stub
		TaskEntity taskToRemove = null;
		for (TaskEntity task : taskSet) {
			if (task.getId() == deleteTask.getId()) {
				taskToRemove = task;
				break;
			}
		}

		if (taskToRemove != null) {
			taskSet.remove(taskToRemove);
		}
	}
}
