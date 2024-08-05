<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	try(
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/spring5fs", "root", "mysql");
		Statement stmt = conn.createStatement();
	
		ResultSet rs = stmt.executeQuery(String.format("select * from member where id='%s' and pw='%s'", request.getParameter("id"), request.getParameter("pw")));
	){
		if(rs.next()){
			session.setAttribute("id", rs.getString("id"));
			session.setAttribute("name", rs.getString("name"));
			
			response.sendRedirect("index.jsp");
			return;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert('아이디가 또는 비밀번호가 틀립니다.');
	history.back();
</script>
</body>
</html>