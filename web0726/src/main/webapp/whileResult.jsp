<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String txt = request.getParameter("txt");
String roop = request.getParameter("roop");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int roop1 = Integer.parseInt(roop);
for(int i=0; i<roop1; i++){
	out.println(txt);
	%><br><%
}
%>

</body>
</html>