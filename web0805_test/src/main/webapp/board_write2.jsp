<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String num = request.getParameter("num");

BoardDAO dao = new BoardDAO();

String str = (String)session.getAttribute("name");
BoardDTO dto = dao.getOne(Integer.parseInt(num));
String name = dto.getWriter();

if(name.equals(str)){
	BoardDTO dto2 = dao.getUpdate(Integer.parseInt(num));
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
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
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

<form method="post" action="board_update.jsp">
	<input type="hidden" name="num" value="<%=dto.getNum() %>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=dto.getTitle() %>">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=dto.getWriter() %>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"><%=dto2.getContent() %></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>

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
<%
} else{
	%>
	<script>
		alert('게시글을 수정할 권한이 없습니다.');
		history.back();
	</script>
	<%
}
%>