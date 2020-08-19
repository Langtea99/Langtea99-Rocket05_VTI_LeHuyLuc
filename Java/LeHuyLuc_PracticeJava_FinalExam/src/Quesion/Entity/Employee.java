package Quesion.Entity;

import java.sql.SQLException;
import java.util.Scanner;

import Quesion.Backend.Presentationlayer.UserController;
import Utils.ScannerUtils;

public class Employee extends User{

	private String projectName;
	private String proSkill;
	
	private static UserController userController;
	public Employee(){
		userController = new UserController();
	}
	
	public Employee(String firstName, String lastName, String phone, String email) {
		super(firstName, lastName, phone, email);
		this.proSkill = proSkill;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		if(projectName == "Testing System" || projectName == "CRM" || projectName == "TimeSheet"){
		this.projectName = projectName;
		}
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}	
	@Override
	public void register() throws SQLException{
		super.register();
		System.out.println("Nhap projectName:");
		projectName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap ProSkill:");
		proSkill = ScannerUtils.inputString("Nhap lai!");
		userController.registerEmployee(firstName, lastName, phone, email, password, projectName, proSkill);
	}
}
