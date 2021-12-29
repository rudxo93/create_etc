<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<label>제목</label>
		<input type="text" name="title" value="${view.title }"><br>
		<label>작성자</label>
		<input type="text" name="writer" value="${view.writer }"><br>
		<label>내용</label>
		<textarea rows="5" cols="50" name="content">${view.content }</textarea><br>
	</form>
</body>
</html>