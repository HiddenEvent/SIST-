package com.demoweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.vo.Member;

@Service("memberService")
public class MemberService {
	
	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;

	public void registerMember(Member member) {
		
		// 패스워드 암호화
		String plainPasswd = member.getPasswd();
		String hashedPasswd = Util.getHashedString(plainPasswd, "SHA-256");
		member.setPasswd(hashedPasswd);
		
		memberDao.insertMember(member);
		
	}
	
	public Member login(String memberId, String passwd) {
		
		// 패스워드 암호화
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		Member member = 
				memberDao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
	}

	public void updateMember(Member member) {
		
		// 패스워드 암호화
		String plainPasswd = member.getPasswd();
		String hashedPasswd = Util.getHashedString(plainPasswd, "SHA-256");
		member.setPasswd(hashedPasswd);
		
		memberDao.updateMember(member);
		
	}

}











