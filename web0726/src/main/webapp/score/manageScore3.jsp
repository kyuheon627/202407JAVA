<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String subNum = "";
String subName = "";
String subKor = "";
String subEng = "";
String subMath = "";

String num = request.getParameter("num");
String name = request.getParameter("name");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");

String find =request.getParameter("find");

String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
String sql = "";


if(num!=null){
	sql = "insert into score(num, name, kor, eng, math) values(?, ?, ?, ?, ?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.executeUpdate();
	pstmt.setString(1, num);
	pstmt.setString(2, name);
	pstmt.setString(3, kor);
	pstmt.setString(4, eng);
	pstmt.setString(5, math);
}

if (find != null) {
	sql = "select * from score where num = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		subNum = rs.getString("num");
		subName = rs.getString("name");
		subKor = rs.getString("kor");
		subEng = rs.getString("eng");
		subMath = rs.getString("math");
	}
}

String sql2 = "select * from score";
pstmt = conn.prepareStatement(sql2);

ResultSet rs = pstmt.executeQuery();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제6. updata가 되도록 JSP 프로그램을 수정해보세요.</title>
</head>
<body>
<form>
	학번 : <input type="text" name="num" value="<%=subNum %>"><br>
	이름 : <input type="text" name="name" value="<%=subName %>"><br>
	국어 : <input type="text" name="kor" value="<%=subKor %>"><br>
	영어 : <input type="text" name="eng" value="<%=subEng %>"><br>
	수학 : <input type="text" name="math" value="<%=subMath %>"><br>
	<input type="submit" value="입력">
</form><br>


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
			<td><a href="?find=<%=strNum%>"><%=strNum %></a></td>
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