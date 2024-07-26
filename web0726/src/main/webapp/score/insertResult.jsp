<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
String name = request.getParameter("name");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");

String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
//out.println("드라이브 로딩!<br>");
conn = DriverManager.getConnection(URL, "root", "mysql");
//out.println("Mysql 접속 성공!<br>");
String sql = "insert into score(num, name, kor, eng, math) values(?, ?, ?, ?, ?)";
pstmt = conn.prepareStatement(sql);

pstmt.setString(1, num);
pstmt.setString(2, name);
pstmt.setString(3, kor);
pstmt.setString(4, eng);
pstmt.setString(5, math);

out.println(pstmt.executeUpdate() + "건 insert 완료");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1. score 테이블에 insert하는 JSP 프로그램을 만드세요.</title>
</head>
<body>

</body>
</html>