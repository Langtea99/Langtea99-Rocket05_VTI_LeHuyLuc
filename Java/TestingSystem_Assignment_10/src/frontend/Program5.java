package frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.DepartmentDao;
import entity.Department;

public class Program5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		question1_2();
	}
	public static void question1_2() throws SQLException, IOException, ClassNotFoundException {
		List<Department> departments = new DepartmentDao().getDepartments();
		for (Department department : departments) {
			System.out.println(department);
		}
	}
}
