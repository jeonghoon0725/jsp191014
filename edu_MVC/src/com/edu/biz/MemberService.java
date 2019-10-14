package com.edu.biz;

import com.edu.beans.Member;
import com.edu.dao.MemberDAO;
//Model : 회원에 관련된 서비스 처리 객체
public class MemberService {

	MemberDAO dao = new MemberDAO();
	
	//회원가입 서비스 처리 메소드
	public void memberInsert(Member member){
		dao.insertMember(member);
	}
	//회원 정보 조회
	public Member memberSearch(Member member) {
		Member member2 = dao.selectMember(member);
		return member2;
		
	}
	
}
