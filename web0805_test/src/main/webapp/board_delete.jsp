<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");

String num = request.getParameter("num");
String str = (String)session.getAttribute("name");

BoardDAO dao = new BoardDAO();
BoardDTO dto = dao.getOne(Integer.parseInt(num));
String name = dto.getWriter();

if(name.equals(str) || name.equals("관리자")){
	
	BoardDTO dto2 = new BoardDTO(Integer.parseInt(num), "", "", "", "", 0);
	dao.deleteBoard(dto2);
	response.sendRedirect("board_home.jsp");
}else{
	%>
	<script>
		alert('게시글을 삭제할 권한이 없습니다.');
		history.back();
	</script>
	<%
}

%>
