<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List;"%>
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
	게시글 목록 화면입니다.
	<br>
	나중에 실제 목록을 뿌려볼거에요
	<br>
	<table border=1px">
	<% for(int i=0; i<list.size(); i++){
		String board = list.get(i);
	%>
	<tr>
		<td><%=board %></td>
	</tr>
	<%
	}
	%>
	</table>
	
	<table border="1">
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${board}</td>
		</tr>
	</c:forEach>
	</table>
	<a href="view.do">게시글 상세페이지로 이동</a>
</body>
</html>