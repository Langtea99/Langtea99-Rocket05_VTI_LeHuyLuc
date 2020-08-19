package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/user";
	private static final String username = "root";
	private static final String password = "999184";
	private Connection con;
	
	public static boolean isConnectedForTesting() throws SQLException {
		boolean test = false;
		
		DriverManager.getConnection(dbUrl, username, password);
		System.out.println("Connect success!");
		test = true;
		
		return test;
	}
	
	public Connection connect() throws SQLException {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(dbUrl, username, password);
		}
		
		return con;
	}
	
	public void disconnect() throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
}
