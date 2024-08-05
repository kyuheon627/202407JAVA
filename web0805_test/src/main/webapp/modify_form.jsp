<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기업형 웹 페이지</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
    <title>회원 정보 수정</title>
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

<%
    request.setCharacterEncoding("utf-8");

    Class.forName("com.mysql.cj.jdbc.Driver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/spring5fs", "root", "mysql");
        Statement stmt = conn.createStatement();
            
        // 현재 로그인한 사용자 정보를 읽어옴
        ResultSet rs = stmt.executeQuery(String.format(         
                    "select * from member where id='%s'", 
                    (String)session.getAttribute("id")));
    ) {
        rs.next();
%>
        <form action="modify.jsp" method="post">
            <table>
                <tr>
                    <td>아이디 : </td>
                    <td><input type="text" name="id" readonly
                               value="<%=rs.getString("id")%>"></td>
                </tr>
                <tr>
                    <td>비밀번호 : </td>
                    <td><input type="password" name="pw" 
                               value="<%=rs.getString("pw")%>"></td>
                </tr>
                <tr>
                    <td>이름 : </td>
                    <td><input type="text" name="name" 
                               value="<%=rs.getString("name")%>"></td>
                </tr>
            </table>    
            <input type="submit" value="저장"> 
        </form>
<%       
    } catch(Exception e) {
        e.printStackTrace();
    }
%>

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