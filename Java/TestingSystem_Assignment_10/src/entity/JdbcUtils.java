package entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/javademo";
	private static final String username = "root";
	private static final String password = "999184";
	private Connection connection;
	
	public boolean isconnectForTesting()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {
		boolean test = true;
		DriverManager.getConnection(dbUrl, username, password);
		test = true;
		return test;
	}
	
	public Connection connect() throws SQLException{
		
		Connection connection = DriverManager.getConnection(dbUrl, username, password);	
		return connection;
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}

}
