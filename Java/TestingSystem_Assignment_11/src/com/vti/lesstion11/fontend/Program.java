package com.vti.lesstion11.fontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.lesstion11.backend.presentationlayer.AccountController;
import com.vti.lesstion11.entity.Account;

public class Program {

	public static void main(String[] args) throws SQLException {
		AccountController accountController = new AccountController();
		List<Account> accountList = accountController.getListAccounts();
		for (Account account : accountList) {
			System.out.println(account.getUsername() +" "+account.getEmail());
		}
		accountController.updateEmailByUserName("dangblackkk","dangblack@gmial.com");
	}
}