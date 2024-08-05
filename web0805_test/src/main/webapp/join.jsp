<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

Class.forName("com.mysql.cj.jdbc.Driver");
try(
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/spring5fs", "root", "mysql");
	Statement stmt = conn.createStatement();

	ResultSet rs = stmt.executeQuery(String.format("select * from member where id='%s'", request.getParameter("id")));
){
	if (rs.next()) {   
        // 이미 있는 아이디이면 오류 표시
%>
        <script>
            alert('이미 등록된 아이디입니다.');
            history.back()
        </script>
<%          
    } else {           
        
    // 새로운 회원정보를 DB에 추가하는 쿼리
        stmt.executeUpdate(String.format(
                "insert into member values('%s', '%s', '%s')",
                request.getParameter("id"  ),
                request.getParameter("pw"  ),
                request.getParameter("name")));
        response.sendRedirect("index.jsp");
%>
        <script>
            alert('가입이 완료되었습니다.');
            window.close();
            
        </script>
<%          
    }
} catch(Exception e) {
    e.printStackTrace();
}
%>
</body>
</html>