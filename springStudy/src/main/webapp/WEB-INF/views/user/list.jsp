<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%
	List<String> list = (List<String>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.bidx }</td>
			<td>${board.title }</td>
			<td>${board.wdate }</td>
			<td>${board.hit }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>