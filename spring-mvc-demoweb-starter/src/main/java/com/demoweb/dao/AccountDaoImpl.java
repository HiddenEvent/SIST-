package com.demoweb.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.demoweb.mapper.MemberMapper;
import com.demoweb.vo.Member;

public class AccountDaoImpl implements AccountDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	private MemberMapper memberMapper;	
	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
		
	@Override
	public void insertMember(Member member) {
		sqlSessionTemplate.insert("com.demoweb.mapper.MemberMapper.insertMember", member);
		//memberMapper.insertMember(member);
	}

	@Override
	public Member selectMemberByIdAndPasswd(Member member) {

		HashMap<String, Object> params = new HashMap<>();
		params.put("memberId", member.getMemberId());
		params.put("passwd", member.getPasswd());
		
		Member member2 = sqlSessionTemplate.selectOne("selectMemberByIdAndPasswd", params);
		//Member member2 = memberMapper.selectMemberByIdAndPasswd(params);
		
		return member2;
	}




}




