<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("key1", "문자열");
	session.setAttribute("key2", Arrays.asList("홍길동", "김길동", "박길동", "이길동", "최길동"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
세션 저장
</body>
</html>