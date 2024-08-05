<%@page import="account.AccountDTO"%>
<%@page import="account.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = new AccountDTO(0, username, password);
	
	dao.getRegister(dto);

	out.println("<script type='text/javascript'>");
	out.println("alert('로그인이 완료되었습니다," + username + "!');");
	out.println("window.location.href = 'index.jsp';");
	out.println("</script>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Process</title>
</head>
<body>

</body>
</html>