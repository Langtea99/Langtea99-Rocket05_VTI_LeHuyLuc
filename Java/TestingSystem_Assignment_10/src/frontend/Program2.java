package frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.DepartmentDao;
import entity.Department;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		question1();
	}
	public static void question1() throws SQLException, IOException, ClassNotFoundException {
		List<Department> departments = new DepartmentDao().getDepartments();
		for (Department department : departments) {
			System.out.println(department);
		}
	}
}