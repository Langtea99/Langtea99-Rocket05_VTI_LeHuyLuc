package Question3.Backend.Presentationlayer;

import java.sql.SQLException;

import Question3.Backend.Businesslayer.IUserService;
import Question3.Backend.Businesslayer.UserService;

public class UserController {
private IUserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public boolean isUserExists(String username) throws SQLException {
		return userService.isUserExists(username);
	}
	
	public double getTotalPriceOfUserType(String username, int type) throws SQLException {
		return userService.getTotalPriceOfUserType(username, type);
	}
	
	public void insertHistoryTransaction(String fullname, int type, double amout, String createDate) throws SQLException {
		userService.insertHistoryTransaction(fullname, type, amout, createDate);
	}
}
