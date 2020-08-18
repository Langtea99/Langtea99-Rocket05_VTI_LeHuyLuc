package com.vti.lesstion11.backend.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.lesstion11.entity.Account;
import com.vti.lesstion11.utils.JDBCUtils;

public class AccountRepository {
	private JDBCUtils jdbcUtils;
	
	public AccountRepository(){
		jdbcUtils = new JDBCUtils();
	}
	
	public List<Account> getListAccounts() throws SQLException{
		List<Account> accounts = new ArrayList<>();
		Connection connection = jdbcUtils.getConnection();
		String sql = "Select username,email from `account`";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			Account account = new Account();
			account.setUsername(resultSet.getString("Username"));
			account.setEmail(resultSet.getString("Email"));
			accounts.add(account);
		}
		connection.close();
		return accounts;		
	}

	public void updateEmailByUserName(String userName) {
		
		
	}

	public void updateEmailByUserName(String userName, String email) {
		// TODO Auto-generated method stub
		
	}
	
}
