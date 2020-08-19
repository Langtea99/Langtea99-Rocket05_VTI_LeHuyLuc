package Quesion.Backend.Datalayer;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Quesion.Entity.User;
import Utils.JdbcUtils;
import Utils.ScannerUtils;

public class UserReponsitory implements IUserReponsitory{

	private JdbcUtils jdbcUtils;
	
	public UserReponsitory() {
		jdbcUtils = new JdbcUtils();
	}
	@Override
	public void registerManager(String firstName, String lastName, String phone, String email, String password,int expInYear) throws SQLException {
		
		Connection con = jdbcUtils.getConnection();
		String query = "insert into `users` (firstName, lastName, phone, email, pass, expInYear) values(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		preparedStatement.setString(3,phone);
		preparedStatement.setString(4,email);
		preparedStatement.setString(5,password);
		preparedStatement.setInt(6,expInYear);
		
		int row = preparedStatement.executeUpdate();
		if(row==1){
			System.out.println("Tài khoản manager mới tạo thành công!!");
		}
		jdbcUtils.disconnect();
	}

	@Override
	public void registerEmployee(String firstName, String lastName, String phone, String email, String password,String projectName, String proSkill) throws SQLException {
		Connection con = jdbcUtils.getConnection();
		String query = "insert into `users` (firstName, lastName, phone, email, pass, projectName, proSkill) values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		preparedStatement.setString(3,phone);
		preparedStatement.setString(4,email);
		preparedStatement.setString(5,password);
		preparedStatement.setString(6,projectName);
		preparedStatement.setString(7,proSkill);
		
		int row = preparedStatement.executeUpdate();
		if(row==1){
			System.out.println("Tài khoản employee mới tạo thành công!");
		jdbcUtils.disconnect();
		}
	}
	@Override
	public boolean isUserExists(String email, String password) throws SQLException  {
		Connection con = jdbcUtils.getConnection();
		String query = "select * from `users` where email = ? and pass = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,password);
		
		boolean check = false;
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next()){
			check = true;
			}
		jdbcUtils.disconnect();
		return check;
	}
}
