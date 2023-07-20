<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%
	String serverTime = (String)request.getAttribute("serverTime");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! Spring <%= serverTime %>
</h1>
<c:if test="${empty login }">
<a href="<%=request.getContextPath()%>/user/login.do">로그인</a>

<a href="<%=request.getContextPath()%>/user/join.do">회원가입</a>

</c:if>

<c:if test="${not empty login }">
${login.name }님 환영합니다!
<a href="<%=request.getContextPath() %>/user/logout.do">로그아웃</a>
</c:if>

<P>  The time on the server is ${serverTime}. </P>
<p>
	<a href="<%=request.getContextPath() %>/sample.do">sample.do 로 이동</a>
	<!-- 위 링크 클릭시 ex01.jsp를 포워드 해보세요. -->
</p>
<p>
	<a href="<%= request.getContextPath() %>/board/list.do">board/list.do로 이동</a>
</p>
<p>
	<a href="<%= request.getContextPath() %>/user/list.do">회원 목록으로 이동</a>
</p>






</body>
</html>
