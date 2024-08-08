<%@page import="board.Board2DAO"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.List"%>
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
Board2DAO dao = new Board2DAO();
List<BoardDTO> list = dao.listBoard();
for(BoardDTO dto : list){
	out.println(dto+"<br>");
}
%>
</body>
</html>