<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>색깔을 선택하세요</title>
</head>
<body>
<h1>If-else Example</h1>
<form action="colorResult.jsp">
이름 : <input type="text" name="name"><br>
좋아하는 색깔 : <select name="color">
	<option value="blue">blue</option>
	<option value="red">red</option>
	<option value="yellow">yellow</option>
</select><br>
<input type="submit" value="보내기">
</form>
</body>
</html>