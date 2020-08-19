package Quesion.Backend.Presentationlayer;

import java.sql.SQLException;

import Quesion.Backend.Bussinesslayer.IUserService;
import Quesion.Backend.Bussinesslayer.UserService;

public class UserController {
private IUserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public boolean isUserExists(String email,String password) throws SQLException {
		return userService.isUserExists(email,password);
	}

	public void registerManager(String firstName, String lastName, String phone, String email, String password,int expInYear) throws SQLException {
		userService.registerManager(firstName, lastName, phone, email, password, expInYear);	
	}

	public void registerEmployee(String firstName, String lastName, String phone, String email, String password,String projectName, String proSkill) throws SQLException {
		userService.registerEmployee(firstName, lastName, phone, email, password, projectName, proSkill);
		
	}
}