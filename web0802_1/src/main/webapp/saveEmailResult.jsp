<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String remember = request.getParameter("remember");

	if("on".equals(remember)){
		response.addCookie(Cookies.createCookie("email", email, "/", -1));
	}else {
		response.addCookie(Cookies.createCookie("email", "", "/", -1));
	}
	response.sendRedirect("saveEmail.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키에 이메일 저장 완료</title>
</head>
<body>
저장 완료!
</body>
</html>