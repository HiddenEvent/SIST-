package com.demoweb.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.demoweb.common.Util;
import com.demoweb.dao.AccountDao;
import com.demoweb.vo.Member;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void registerMemberTx(Member member) {

		String passwd = member.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256");
		member.setPasswd(passwd);	
		accountDao.insertMember(member);
		//int x = 10 / 0; // throw new ArithmaticException("/ by zero")

	}

	@Override
	public Member findMemberByIdAndPasswd(Member member) {
		
		String passwd = member.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256");
		member.setPasswd(passwd);

		Member member2 = accountDao.selectMemberByIdAndPasswd(member);

		return member2;
	}

}
