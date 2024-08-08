<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${gugu }단</h1>

<ul>
<c:forEach var="i" begin="1" end="9" step="1">
	<li>${gugu } x ${i} = ${i*gugu }
</c:forEach>
</ul>
<br><br>
</body>
</html>