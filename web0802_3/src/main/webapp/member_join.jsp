<%@page import="account.AccountDTO"%>
<%@page import="account.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = new AccountDTO(id, pw, name);
	
	int check = dao.checkRegister(dto);

    if (check == 0) {   
    	// 새로운 회원정보를 DB에 추가하는 쿼리
        dao.getRegister(dto);
%>
        <script>
        	alert('가입이 완료되었습니다.<%=check %>');
        	window.close();
        </script>
<%          
	} else if(check == 0){
		// 이미 있는 아이디이면 오류 표시
%>
        <script>
        	alert('이미 등록된 아이디입니다.');
            history.back()
        </script>
<%
    }
%>

</body>
</html>