<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<form action="write.do" method="post">
		제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer"><br>
		내용 : <textarea name="body"></textarea><br>
		<button>등록</button>
	</form>
	<!-- 
		게시글 목록 페이지에서 '게시글 등록하러 가기' 링크 클릭시 해당 화면을 포워드 합니다.
		그 후 게시글을 입력 후 등록 버튼을 누르면 콘솔화면에 입력한 값들을 출력 후 
		다시 게시글 목록 페이지로 이동합니다.
		
	 -->
</body>
</html>