package Quesion.Fontend;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Quesion.Backend.Presentationlayer.UserController;
import Quesion.Entity.Employee;
import Quesion.Entity.Manager;
import Quesion.Entity.User;
import Utils.ScannerUtils;

public class Main {
	 private static UserController userController;
	public static void main(String[] args) throws SQLException {
		userController = new UserController();
		register();
		login();
	}

	private static void login() throws SQLException {
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Password:");
		String password = ScannerUtils.inputString("Nhap lai!");
		if(userController.isUserExists(email, password))
			System.out.println("Đăng nhập thành công!");
		else
			System.out.println("Email hoặc password không đúng. Kiểm tra lại!");	
	}

	private static void register() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		System.out.println("Nhap loai user muon tao (1.Manager, 2.Employee): ");
		int choose = scanner.nextInt();
		switch(choose){
		case 1 :
			user = new Manager();
			user.register();
			break;
		case 2 :
			user = new Employee();
			user.register();
			break;
		default :
			System.out.println("Nhập sai !");
			break;
		}
	}
}
