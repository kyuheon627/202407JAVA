<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String num = request.getParameter("num");
BoardDAO dao = new BoardDAO();
dao.hitsUp(Integer.parseInt(num));
BoardDTO dto = dao.getOne(Integer.parseInt(num));
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기업형 웹 페이지</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

	<header>
        <div class="inner">
            <h1><a href="index.jsp">DCODLAB</a></h1>

            <ul id="gnb">
                <li><a href="board_home.jsp">BOARD</a></li>
                <li><a href="board_my_list.jsp">MY BOARD</a></li>
                <li><a href="board_rank_list.jsp">BOARD RNAK</a></li>
                
            </ul>

            <ul class="util">
               
                <%
                	if((String)session.getAttribute("id") == null){
                %>
                <li><a href="login_form.jsp">Login</a></li>
                <li><a href="join_form.jsp">Join</a></li>
                <%
                	} else{
                %>
                <%=(String)session.getAttribute("name") %>
                <li><a href="logout.jsp">Logout</a></li>
                <li><a href="modify_form.jsp">Modify</a></li>
                <%
                	}
                %>
            </ul>
        </div>
    </header>

<table>
    <tr>
        <th>제목</th>
        <td><%=dto.getTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=dto.getWriter() %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=dto.getRegtime() %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=dto.getHits() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=dto.getContent() %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='board_home.jsp'">
<input type="button" value="수정"
       onclick="location.href='board_write2.jsp?num=<%=dto.getNum() %>'">
<input type="button" value="삭제"
       onclick="location.href='board_delete.jsp?num=<%=dto.getNum() %>'">

	<footer>
        <div class="inner">
            <div class="upper">
                <h1>DCODELAB</h1>
                <ul>
                    <li><a href="#">Policy</a></li>
                    <li><a href="#">Terms</a></li>
                    <li><a href="#">Family Site</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas, facere.<br>
                    TEL : 031-111-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2020 DOCDELAB &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>

</body>
</html>
