package com.edu.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.beans.Member;
import com.edu.biz.MemberService;
@WebServlet("/Controller1")
public class Controller1 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// 1-1 VO객체에 데이터 바인딩
		Member member = new Member();
		member.setId(id);
		member.setPasswd(pwd);
		
		// 2,유효성 체크
		// 3. 서비스 메소드 호출
		MemberService biz = new MemberService();
		Member member2 = biz.memberSearch(member);
		
		req.setAttribute("member", member2);
		
		// 4. 풀력뷰페이지로 이동
		RequestDispatcher rd = req.getRequestDispatcher("SearchOutput.jsp");
		rd.forward(req, resp);
	}

}
