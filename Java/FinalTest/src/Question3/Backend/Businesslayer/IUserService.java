package Question3.Backend.Businesslayer;

import java.sql.SQLException;

public interface IUserService {
	public boolean isUserExists(String username) throws SQLException;
	
	public double getTotalPriceOfUserType(String username, int type) throws SQLException;
	
	public void insertHistoryTransaction(String fullname, int type, double amout, String createDate) throws SQLException;
}
