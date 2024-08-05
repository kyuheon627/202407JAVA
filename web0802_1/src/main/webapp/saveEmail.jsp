<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookies cookies = new Cookies(request);
	boolean remember = false;
	String email = cookies.getValue("email");
	
	if(cookies.exists("email")){
		email = cookies.getValue("email");
		remember = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일을 쿠키에 저장하는 폼</title>
</head>
<body>
<form action="saveEmailResult.jsp" method="post">
	<label for="email">Email:</label>
	<input type="email" id="email" name="email" value="<%=email %>" required><br>
	<input type="checkbox" id="remember" name="remember" <%=remember ? "checked" : "" %>>
	<label for="remember">이메일을 저장하시겠습니까?</label>
	<input type="submit" value="Submit">
</form>
</body>
</html>