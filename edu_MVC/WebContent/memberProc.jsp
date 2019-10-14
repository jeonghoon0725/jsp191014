<%@page import="com.edu.beans.Member"%>
<%@page import="com.edu.biz.MemberService"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	
	// 1. parameter 추출
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	// 1-1 VO객체에 데이터 바인딩
	Member member = new Member();
	member.setId(id);
	member.setPasswd(passwd);
	member.setName(name);
	member.setMail(mail);
	
	// 2,유효성 체크
	// 3. 서비스 메소드 호출
	MemberService biz = new MemberService();
	biz.memberInsert(member);
	// 4. 풀력뷰페이지로 이동
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
%>