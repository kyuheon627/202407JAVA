<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("vv", "홍길동");
String ss = (String)session.getAttribute("vv");
request.setAttribute("kk", "김하나");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${vv}
<%=ss %>
${kk }
${vv == '홍길동' }
${1+100 }
</body>
</html>