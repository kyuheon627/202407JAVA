<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String writer = request.getParameter("writer");
String title = request.getParameter("title"); 
String content = request.getParameter("content");
String find = request.getParameter("num");

String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

String sql = "update board set writer = ?, title = ?, content = ?, regtime = now() where num = ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, writer);
pstmt.setString(2, title);
pstmt.setString(3, content);
pstmt.setString(4, find);
pstmt.executeUpdate();
response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 성공!</h1>
</body>
</html>