package com.edu.biz;

import com.edu.beans.Member;
import com.edu.dao.MemberDAO;
//Model : ȸ���� ���õ� ���� ó�� ��ü
public class MemberService {

	MemberDAO dao = new MemberDAO();
	
	//ȸ������ ���� ó�� �޼ҵ�
	public void memberInsert(Member member){
		dao.insertMember(member);
	}
	//ȸ�� ���� ��ȸ
	public Member memberSearch(Member member) {
		Member member2 = dao.selectMember(member);
		return member2;
		
	}
	
}
