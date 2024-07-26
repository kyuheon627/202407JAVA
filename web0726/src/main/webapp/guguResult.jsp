<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int gugu = Integer.parseInt(request.getParameter("gugu"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=gugu %>단 출력</h1>
<table border=1>
	<tr>
		<td colspan=5><%=gugu %>단</td>
	</tr>
	<%
	for(int i=1; i<=9; i++){
		%>
		<tr>
			<td><%=gugu %></td>
			<td>x</td>
			<td><%=i %></td>
			<td>=</td>
			<td><%=gugu*i%></td>
		</tr>
		<%
	}
	%>
</table>
</body>
</html>