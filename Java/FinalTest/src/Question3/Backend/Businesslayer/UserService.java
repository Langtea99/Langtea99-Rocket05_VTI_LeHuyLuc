package Question3.Backend.Businesslayer;

import java.sql.SQLException;

import Question3.Backend.Datalayer.UserReponsitory;

public class UserService implements IUserService{
	private UserReponsitory userReponsitory;
	
	public UserService() {
		userReponsitory = new UserReponsitory();
	}

	@Override
	public boolean isUserExists(String username) throws SQLException {
		return userReponsitory.isUserExists(username);
	}

	@Override
	public double getTotalPriceOfUserType(String username, int type) throws SQLException {
		return userReponsitory.getTotalPriceOfUserType(username, type);
	}

	@Override
	public void insertHistoryTransaction(String fullname, int type, double amout, String createDate)
			throws SQLException {
		userReponsitory.insertHistoryTransaction(fullname, type, amout, createDate);
	}
}
