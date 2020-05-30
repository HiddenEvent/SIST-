package com.demoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demoweb.vo.Member;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void insertMember(Member member) {
		sqlSessionTemplate.insert("com.demoweb.mapper.MemberMapper.insertMember", member);
		
	}
	
	public Member selectMemberByIdAndPasswd(String memberId, String passwd) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", memberId);
		params.put("passwd", passwd);
		
		Member member = sqlSessionTemplate.selectOne("com.demoweb.mapper.MemberMapper.selectMemberByIdAndPasswd", params);
		return member; //조회된 데이터를 저장항 Member 객체 반환
	}
	
	public void updateMember(Member member) {
		sqlSessionTemplate.update("com.demoweb.mapper.MemberMapper.updateMember", member);
	}

	
	
}







