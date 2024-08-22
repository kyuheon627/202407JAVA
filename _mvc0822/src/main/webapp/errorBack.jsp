<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('${errorMessage}게시글을 수정/삭제 할 권한이 없습니다.');
    history.back();
</script>

</body>
</html>