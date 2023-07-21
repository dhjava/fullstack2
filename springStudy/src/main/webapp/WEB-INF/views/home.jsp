<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%
	String serverTime = (String)request.getAttribute("serverTime");
%>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
</head>
<body>
<h1>
	Hello world! Spring <%= serverTime %>
</h1>
<c:if test="${empty login}">
<a href="<%=request.getContextPath()%>/user/login.do">로그인</a>
|
<a href="<%=request.getContextPath()%>/user/join.do">회원가입</a>
<!-- 위 링크 클릭시 회원가입 기능을 구현 합니다.
	사용자로부터 입력받는 정보는 id,password,name,age,gender,addr,phone
	이때 id,password,name,phone 는 필수 입력입니다.
	grace는 기본 C 입니다.
 -->
</c:if>

<c:if test="${ not empty login}">
${login.name }님 환영합니다!
<a href="<%=request.getContextPath()%>/user/logout.do">로그아웃</a>
</c:if>


<P>  The time on the server is ${serverTime}. </P>
<p> 
	<a href="<%=request.getContextPath() %>/sample.do">sample.do 로 이동</a>
	<!-- 
		위 링크 클릭시 ex01.jsp 를 포워드 해보세요.
	 -->
</p>
<p>
	<%--
		<%= request.getContextPath() %> => /controller
	 --%>
	<a href="<%= request.getContextPath() %>/board/list.do">board/list.do로 이동</a>
</p>
<p>
	<a href="<%= request.getContextPath() %>/user/list.do">회원 목록으로 이동</a>
</p>





</body>
</html>
