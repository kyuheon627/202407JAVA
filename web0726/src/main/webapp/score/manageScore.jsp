<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3. 문제1과 문제2를 하나의 JSP 프로그램으로 만들어보세요.</title>
</head>
<body>
<form>
	학번 : <input type="text" name="num"><br>
	이름 : <input type="text" name="name"><br>
	국어 : <input type="text" name="kor"><br>
	영어 : <input type="text" name="eng"><br>
	수학 : <input type="text" name="math"><br>
	<input type="submit" value="입력">
</form><br>
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

if(num!=null){
	pstmt.executeUpdate();
}

String sql2 = "select * from score";
pstmt = conn.prepareStatement(sql2);

ResultSet rs = pstmt.executeQuery();
%>

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
		String strNum = rs.getString("num");
		String strName = rs.getString("name");
		String strKor = rs.getString("kor");
		String strEng = rs.getString("eng");
		String strMath = rs.getString("math");
		int sum = Integer.parseInt(strKor) + Integer.parseInt(strEng) + Integer.parseInt(strMath);
		double total = sum/3.0;
		%>
		<tr>
			<td><%=strNum %></td>
			<td><%=strName %></td>
			<td><%=strKor %></td>
			<td><%=strEng %></td>
			<td><%=strMath %></td>
			<td><%=sum %></td>
			<td><%=total %></td>
		</tr>
		<%
	}
	%>
</table>
</body>
</html>