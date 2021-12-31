<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
</head>
<body>

	<div id="nav">
		<%@include file="../include/nav.jsp" %>
	</div>

	<h2>${view.title}</h2>

	<hr />
	<div class="writer">
		<span>작성자 : </span>${view.writer}
	</div>

	<hr />

	<div class="content">
		${view.content}
	</div>

	<hr />
 
	<div>
		<a href="/board/modify?bno=${view.bno}">게시물 수정</a>, <a href="/board/delete?bno=${view.bno}">게시물 삭제</a>
	</div>

	<!-- 댓글 시작 -->
	<ul>
		<c:forEach items="${reply}" var="reply">
			<li>
				<div>
					<p>${reply.writer} / <fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd" /></p>
				<p>${reply.content }</p>
				</div>
			</li>	
		</c:forEach>
	</ul>
	<div>
		<form method="post" action="/reply/write">
			<p>
				<label>댓글 작성자</label> <input type="text" name="writer">
			</p>
			<p>
				<textarea rows="5" cols="50" name="content"></textarea>
			</p>
			<p>
				<input type="hidden" name="bno" value="${view.bno}">
				<button type="submit">댓글 작성</button>
			</p>
		</form>
	</div>
	<!-- 댓글 끝 -->

<hr />
</body>
</html>