package in.kishoresugumar.vanha.dao;

import java.util.Set;
import java.sql.*;
import java.util.HashSet;
import in.kishoresugumar.vanha.interfacePackage.UserInterface;
import in.kishoresugumar.vanha.model.User;
import in.kishoresugumar.vanha.model.UserEntity;
import in.kishoresugumar.vanha.util.ConnectionUtil;

public class UserDAO implements UserInterface {

	private Set<UserEntity> userSet = new HashSet<>();

	@Override
	public Set<UserEntity> findAll() throws RuntimeException{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		
	    Set<UserEntity> userArray = new HashSet<>();
		
		try {
			
			String query ="Select * From users Where is_active = 1";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			rs = pre.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
				userArray.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}finally {
			ConnectionUtil.close(conn, pre, rs);
		}
		return userArray;
	}

	@Override
	public UserEntity findById(int id) {
		UserEntity user = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		
		try {
			
			String query ="Select * From users Where is_active = 1 And id = ?";
			conn = ConnectionUtil.getConnection();
			pre = conn.prepareStatement(query);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}finally {
			ConnectionUtil.close(conn, pre, rs);
		}
		return user;
	}

	@Override
	public void create(UserEntity newUser) {
		    Connection conn = null;
		    PreparedStatement pre = null;

		    try {
		        String query = "Insert Into users (firstname, lastname, email, password) Values(?, ?, ?, ?)";
		        conn = ConnectionUtil.getConnection();
		        pre = conn.prepareStatement(query);
		        pre.setString(1, newUser.getFirstName());
		        pre.setString(2, newUser.getLastName());
		        pre.setString(3, newUser.getEmail());
		        pre.setString(4, newUser.getPassword());
		        pre.executeUpdate();
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        throw new RuntimeException(e);
		    } finally {
		        ConnectionUtil.close(conn, pre);
		    }
	}

	@Override
	public void update(UserEntity updateUser) {
	    Connection conn = null;
	    PreparedStatement pre = null;

	    try {
	        String query = "UPDATE users SET firstname=?, lastname=? WHERE id=?";
	        conn = ConnectionUtil.getConnection();
	        pre = conn.prepareStatement(query);
	        pre.setString(1, updateUser.getFirstName());
	        pre.setString(2, updateUser.getLastName());
	        pre.setInt(3, updateUser.getId());
	        pre.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    } finally {
	        ConnectionUtil.close(conn, pre);
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
