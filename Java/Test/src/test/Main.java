package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws SQLException {
		String Url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String passWord = "999184";
		
		Connection con = DriverManager.getConnection(Url, userName, passWord);		
		Statement statement = con.createStatement();
	}
}
