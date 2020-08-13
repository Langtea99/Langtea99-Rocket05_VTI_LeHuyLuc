package entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private Properties properties;
	private Connection connection;
	
	public void isconnectForTesting()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {
		properties = new Properties();
		properties.load(new FileInputStream("src/config.properties"));
		
		String dbUrl = properties.getProperty("dbUrl");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName(properties.getProperty("driver"));
		connection = DriverManager.getConnection(dbUrl, username, password);

		System.out.println("Connect success!");
	}
	
	public Connection connect()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {
		properties = new Properties();
		properties.load(new FileInputStream("src/config.properties"));
		
		String dbUrl = properties.getProperty("dbUrl");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(dbUrl, username, password);	
		return connection;
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}

}