package com.vti.lesstion11.backend.businesslayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.lesstion11.backend.datalayer.AccountRepository;
import com.vti.lesstion11.entity.Account;

public class AccountService {
	private AccountRepository accountRepository;
	public AccountService(){
		accountRepository = new AccountRepository();
	}
	public List<Account> getListAccounts() throws SQLException{
		return accountRepository.getListAccounts();		
	}
	public void updateEmailByUserName(String userName) {
		accountRepository.updateEmailByUserName(userName);
	}
	public boolean updateEmailByUserName(String userName, String email) {
		boolean so = true;
		if(userName.charAt(0) )
		accountRepository.updateEmailByUserName(userName,email);
		else {
			System.out.println("Du lieu khong hop le");
		}
	}
}
