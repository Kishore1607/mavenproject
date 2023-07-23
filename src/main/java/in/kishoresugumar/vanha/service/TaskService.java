package in.kishoresugumar.vanha.service;

import java.util.Set;

import in.kishoresugumar.vanha.dao.TaskDAO;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.model.TaskEntity;
import in.kishoresugumar.vanha.validation.TaskValidator;

public class TaskService {
	TaskDAO taskDao = new TaskDAO();

	public void create(Task newTask) throws Exception {
		TaskValidator.validate(newTask);
		taskDao.create(newTask);
	}

	public void update(TaskEntity updatedTask) {
		taskDao.update(updatedTask);
	}

	public void delete(TaskEntity deleteTask) {
		taskDao.delete(deleteTask);
	}

	public TaskEntity findById(int id) {
		return taskDao.findById(id);

	}
    public TaskEntity[] getAllTasksAsArray() {
        Set<TaskEntity> taskSet = taskDao.findAll();
        return taskSet.toArray(new TaskEntity[0]);
    }
    
    public void printAllTasks() {
        TaskEntity[] allTasksArray = getAllTasksAsArray();
        for (TaskEntity task : allTasksArray) {
            System.out.println(task);
        }
    }
}