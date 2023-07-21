<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 수정페이지</h2>
	<!-- 
		view 페이지에서 '수정하기'버튼 클릭시 해당 화면을 포워드 합니다.
		포워드된 해당 화면에서는 게시글을 수정할수 있는 화면을 만듭니다.
		수정 대상 : 제목, 내용
	 -->
	 <form action="modify.do" method="post">
	 	<input type="hidden" name="bidx" value="${vo.bidx}">
	 	<table border="1">
	 		<tr>
	 			<th align="right">제목</th>
	 			<td><input type="text" name="title" size="30" value="${vo.title}"></td>
	 		</tr>
	 		<tr>
	 			<th align="right">내용</th>
	 			<td><textarea rows="10" cols="30" name="body">${vo.body}</textarea></td>
	 		</tr>
	 	</table>
	 	<button>저장</button>
	 </form>
</body>
</html>










