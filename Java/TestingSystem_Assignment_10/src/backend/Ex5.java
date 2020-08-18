package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex5 {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/testingsystem";
	private static final String username = "root";
	private static final String pass = "123456";
	private static Connection myConn;
	private static boolean isConnect = false;
	
	public static boolean isConnectedForTesting() throws SQLException {
		boolean test = false;
		
		DriverManager.getConnection(dbUrl, username, pass);
		System.out.println("Connect success!");
		test = true;
		
		return test;
	}
	
	public static Connection connect() throws SQLException {
		if (!isConnect) {
			isConnect = true;
			myConn = DriverManager.getConnection(dbUrl, username, pass);
		}
		
		return myConn;
	}
	
	public void disconnect() throws SQLException {
		if(!myConn.isClosed()) {
			isConnect = false;
			myConn.close();
		}
	}
}
