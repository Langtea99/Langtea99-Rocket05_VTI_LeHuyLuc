package backend;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.JdbcUtils;
import entity.MessageProperties;


public class Ex5 {
	private JdbcUtils jdbcUtils;

	private MessageProperties messagePoperties;
	
	public Ex5() throws IOException, SQLException, ClassNotFoundException {
		jdbcUtils = new JdbcUtils();

		messagePoperties = new MessageProperties();
	}
	public List<Department> getDepartments()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		List<Department> departments = new ArrayList<>();

		Connection connection = jdbcUtils.connect();

		Statement statement = connection.createStatement();

		String sql = "SELECT * FROM Department";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			departments.add(department);
		}
		jdbcUtils.disconnect();

		return departments;
	}

}
