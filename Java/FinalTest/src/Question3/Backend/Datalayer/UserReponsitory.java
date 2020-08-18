package Question3.Backend.Datalayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Question3.Backend.Businesslayer.IUserService;
import Utils.JdbcUtils;
import Utils.ScannerUtils;

public class UserReponsitory implements IUserService{

	private JdbcUtils jdbcUtils;
	
	public UserReponsitory() {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean isUserExists(String username) throws SQLException {
		
		Connection con = jdbcUtils.getConnection();
		String query = "select * from `users` where full_name = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,username);
		ResultSet set = preparedStatement.executeQuery();
		
		boolean check = false;
		if(set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}

	@Override
	public double getTotalPriceOfUserType(String username, int type) throws SQLException {
		Connection con = jdbcUtils.getConnection();
		String query = "SELECT um.total_price FROM `user_money` um JOIN `users` u ON um.user_id = u.user_id" +
						" WHERE u.full_name = ? AND `type` = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,username);
		preparedStatement.setInt(2, type);
		
		ResultSet set = preparedStatement.executeQuery();
		double totalPrice = 0;
		if(set.next()) {
			totalPrice = set.getDouble("total_price");
			jdbcUtils.disconnect();
		}
		else {
			jdbcUtils.disconnect();
			throw new SQLException("Không có loại tiền này!");
		}
		
		return totalPrice;
	}

	@Override
	public void insertHistoryTransaction(String fullname, int type, double amout, String createDate) throws SQLException {
		Connection con = jdbcUtils.getConnection();
		String query = "{CALL InsertHistoryTransaction (?,?,?,?)}";
		CallableStatement callableStatement = con.prepareCall(query);
		callableStatement.setString(1, fullname);
		callableStatement.setInt(2, type);
		callableStatement.setDouble(3, amout);
		callableStatement.setString(4, createDate);
		callableStatement.execute();
		System.out.println("--Giao dịch thành công. Nhận biên lai!--");
		ResultSet set = callableStatement.getResultSet();
		while(set.next()) {
			System.out.println("\n   >>Thông tin giao dich<<");
			
			int typee = set.getInt("type");
			if (typee == 0)
				System.out.println("Loại tiền rút:          Tiền gửi");
			else if (typee == 1)
				System.out.println("Loại tiền rút:          Tiền tiết kiệm");
			System.out.println("Số tiền rút:            " + ScannerUtils.convertDoubleToMoneyVND(set.getDouble("amount")));
			System.out.println("Bắt đầu giao dịch:      " + set.getDate("create_at") +" "+ set.getTime("create_at"));
			System.out.println("Hoàn thành giao dịch:   " + set.getDate("updated_at") +" "+ set.getTime("updated_at"));
			System.out.println("-----------------------------------------");
		}
		jdbcUtils.disconnect();
		
	}
}
