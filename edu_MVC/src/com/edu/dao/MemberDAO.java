package com.edu.dao;

import java.sql.*;

import com.edu.beans.Member;

public class MemberDAO {

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void insertMember(Member member) {
		try {
				Connection con = this.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?,?)");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPasswd());
				pstmt.setString(4, member.getMail());
				
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member selectMember(Member member) {Member member2 = null;
		try {
			Connection con = this.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, member.getId());
			
			ResultSet rs = pstmt.executeQuery();
			
        	if(rs.next()) {
        		member2 = new Member();
        		member2.setId(rs.getString("id"));
        		member2.setPasswd(rs.getString("passwd"));
        		member2.setName(rs.getString("name"));
        		member2.setMail(rs.getString("mail"));
        		/*
        		System.out.println(rs.getString("id"));
        		System.out.println(rs.getString("id"));
        		System.out.println(rs.getString("id"));
        		System.out.println(rs.getString("id"));
        		*/
        	}
        	else{
        		System.out.println("실패");
        	}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return member2;
		
	}

}
