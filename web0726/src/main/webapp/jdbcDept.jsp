<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str = request.getParameter("loc");
if("".equals(str)){
	str = "%";
}

String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
out.println("드라이브 로딩!<br>");
conn = DriverManager.getConnection(URL, "root", "mysql");
out.println("Mysql 접속 성공!<br>");
String sql = "select * from dept where loc = ?";
pstmt = conn.prepareStatement(sql);


pstmt.setString(1, str);

ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
	지역 : <input type="text" name="loc">
	<input type="submit">
</form>

<table border=1>
<%
while(rs.next()){
	String deptno = rs.getString("deptno");
	String dname = rs.getString("dname");
	String loc = rs.getString("loc");
	//out.println(deptno);
	%>
	<tr>
		<td><%=deptno %></td>
		<td><%=dname %></td>
		<td><%=loc %></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>