<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 상세</h2>
	<table>
		<tr>
			<th align="right">제목 : </th>
			<td>${vo.title}</td>
		</tr>
		<tr>
			<th align="right">작성자 id : </th>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<th align="right">작성일 : </th>
			<td>${vo.wdate}</td>
		</tr>
		<tr>
			<th align="right">조회수 : </th>
			<td>${vo.hit}</td>
		</tr>
		<tr height="100px">
			<th align="right">내용 : </th>
			<td>${vo.body}</td>
		</tr>
	</table>
	<button onclick="location.href='modify.do?bidx=${vo.bidx}'">수정하기</button>
	<button onclick="delFn(${vo.bidx })">삭제하기</button>
	<form name="frm" action="delete.do" method="post">
		<input type="hidden" name="bidx" value="${vo.bidx}">
	</form>
	<script>
		function delFn(){
			document.frm.submit();
		}
	</script>
	<!-- 삭제하기 버튼 클릭시 해당 게시글 삭제 후 list 페이지로 이동 가능 구현하세요 -->
	
</body>
</html>