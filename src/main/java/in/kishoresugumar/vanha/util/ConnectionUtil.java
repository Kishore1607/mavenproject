package in.kishoresugumar.vanha.util;
import java.sql.*;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection conn = null;
		String url = null;
		String userName = null;
		String password = null;
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Drivers");
//			connection = DriverManager.getConnection(url, userName, password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
			  "jdbc:mysql://aws.connect.psdb.cloud/kishore_vanha?sslMode=VERIFY_IDENTITY",
			  "ckmq25qtilxyi15yfnin",
			  "pscale_pw_iXBKWuNrR47zzAaAwgKZ1SypM0TTiLeTeV4WBm5o94q");

		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("e");
		}
		return conn;
	}
	
	public static void close(Connection connection, PreparedStatement presta) {
		 
		try {
			if(presta!=null) {
				presta.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, PreparedStatement presta, ResultSet reset) {
		 
		try {
			if(presta!=null) {
				presta.close();
			}
			if(connection!=null) {
				connection.close();
			}
			if(reset!=null) {
				reset.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
