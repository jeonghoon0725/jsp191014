<%@page import="com.edu.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%
		Member mem = (Member)request.getAttribute("member");
	%>
	<%= mem.getId() %><br>
	<%= mem.getPasswd() %><br>
	<%= mem.getName() %><br>
	<%= mem.getMail() %><br>
		
	
