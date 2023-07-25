package in.kishoresugumar.vanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import in.kishoresugumar.vanha.interfacePackage.TaskInterface;
import in.kishoresugumar.vanha.model.TaskEntity;
import in.kishoresugumar.vanha.model.Task;
import in.kishoresugumar.vanha.util.ConnectionUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TaskDAO implements TaskInterface {

	private Set<TaskEntity> taskSet = new HashSet<>();

	@Override
	public Set<TaskEntity> findAll() {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;

		Set<TaskEntity> taskArray = new HashSet<>();

		try {

			String query = "Select * From tasks Where is_active = 1";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			rs = pre.executeQuery();
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDueDate(rs.getString("due_date"));
				task.setActive(rs.getBoolean("is_active"));
				taskArray.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, pre, rs);
		}
		return taskSet;
	}

	@Override
	public TaskEntity findById(int id) {
		TaskEntity task = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;

		try {

			String query = "Select * From tasks Where is_active = 1 And id = ?";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			if (rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDueDate(rs.getString("due_date"));
				task.setActive(rs.getBoolean("is_active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, pre, rs);
		}
		return task;
	}

	@Override
	public void create(TaskEntity newTask) {
		Connection conn = null;
		PreparedStatement pre = null;
		
        String originalDate = newTask.getDueDate();
        String newDateFormat = "yyyy-MM-dd";

		try {
			SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat targetFormat = new SimpleDateFormat(newDateFormat);
            Date date = originalFormat.parse(originalDate);
            String formattedDate = targetFormat.format(date);
            
			String query = "Insert Into tasks (name, due_date) Values(?, ?)";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			pre.setString(1, newTask.getName());
			pre.setString(2, formattedDate);
			pre.executeUpdate();

		} catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(conn, pre);

		}
	}

	@Override
	public void update(TaskEntity updateTask) {
		Connection conn = null;
		PreparedStatement pre = null;
		
		
        String originalDate = updateTask.getDueDate();
        String newDateFormat = "yyyy-MM-dd";

		try {
			SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat targetFormat = new SimpleDateFormat(newDateFormat);
            Date date = originalFormat.parse(originalDate);
            String formattedDate = targetFormat.format(date);
            
			String query = "UPDATE tasks SET name=?, due_date=? WHERE id=?";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			pre.setString(1, updateTask.getName());
			pre.setString(2, formattedDate);
			pre.setInt(3, updateTask.getId());
			pre.executeUpdate();

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(conn, pre);
		}
	}

	@Override
	public void delete(TaskEntity deleteTask) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;

		try {
			
			String query = "UPDATE tasks SET is_active=0 WHERE id=?";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			pre.setInt(1, deleteTask.getId());
			pre.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(conn, pre);
		}
	}
}
