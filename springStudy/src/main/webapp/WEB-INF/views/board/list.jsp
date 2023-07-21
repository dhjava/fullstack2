<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%
	List<String> list = (List<String>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.3.min.js"></script>
</head>
<body>
	<h2>게시글 목록</h2>
	<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.bidx }</td>
			<td><a href="view.do?bidx=${board.bidx}">${board.title }</a></td>
			<td>${board.wdate }</td>
			<td>${board.hit }</td>
		</tr>
	</c:forEach>
	</table>
	
	<%-- 게시글 목록 화면입니다. 
	<br>
	나중에 실제 목록을 뿌려볼거에요
	<br>
	<table border="1">
		<% for(int i=0 ;i<list.size();i++){
			String board =  list.get(i);
		%>
		<tr>
			<td><%=board %></td>
		</tr>
		<% 	
		}	
		%>
	</table>
	<table border="1">
	<!-- 
		for(String board : list){
		
		}
	 -->
	<c:forEach items="${list}" var="board">
		<tr>	
			<td>${board}</td>
		</tr>
	</c:forEach>
	</table> --%>
	
	<a href="view.do">게시글 상세페이지로 이동</a><!-- /board/view.do -->
	<br>
	<c:if test="${not empty login }">
		<a href="write.do">게시글 등록페이지로 이동</a><!-- /board/write.do -->
	</c:if>
</body>
</html>








