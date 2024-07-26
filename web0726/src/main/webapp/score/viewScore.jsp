<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");

conn = DriverManager.getConnection(URL, "root", "mysql");

String sql = "select * from score";
pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2. table 태그를 이용해서 score 테이블의 내용이 전부 나오는 JSP 프로그램을 만드세요.</title>
</head>
<body>
<table border=1>
	<tr>
		<td>학번</td>
		<td>이름</td>
		<td>국어</td>
		<td>영어</td>
		<td>수학</td>
		<td>총점</td>
		<td>평균</td>
	</tr>
	<%
	while(rs.next()){
		String num = rs.getString("num");
		String name = rs.getString("name");
		String kor = rs.getString("kor");
		String eng = rs.getString("eng");
		String math = rs.getString("math");
		int sum = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
		double total = sum/3.0;
		%>
		<tr>
			<td><%=num %></td>
			<td><%=name %></td>
			<td><%=kor %></td>
			<td><%=eng %></td>
			<td><%=math %></td>
			<td><%=sum %></td>
			<td><%=total %></td>
		</tr>
		<%
	}
	%>
</table>
</body>
</html>