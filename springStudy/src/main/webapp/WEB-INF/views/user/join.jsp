<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="join.do" method="post">
		<table>
			<tr>
				<th align="right">id : </th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th align="right">password : </th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th align="right">이름 : </th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th align="right">나이 : </th>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<th align="right">성별 : </th>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<th align="right">주소 : </th>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<th align="right">전화번호 : </th>
				<td><input type="text" name="phone"></td>
			</tr>
		</table>
		<button>로그인</button>
	</form>
</body>
</html>