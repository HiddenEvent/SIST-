package com.demoweb.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoweb.mapper.MemberMapper;
import com.demoweb.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	private MemberMapper memberMapper;

	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}
	
	public Member selectMemberByIdAndPasswd(String memberId, String passwd) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", memberId);
		params.put("passwd", passwd);
		
		Member member = memberMapper.selectMemberByIdAndPasswd(params);
		return member; //조회된 데이터를 저장항 Member 객체 반환
	}
	
	public void updateMember(Member member) {
		memberMapper.updateMember(member);
	}
	
	
}







