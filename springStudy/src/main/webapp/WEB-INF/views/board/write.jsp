<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�Խñ� ���</h2>
	<form action="write.do" method="post">
		���� : <input type="text" name="title"><br>
		�ۼ��� : <input type="text" name="writer"><br>
		���� : <textarea name="body"></textarea><br>
		<button>���</button>
	</form>
	
	<!-- 
		�Խñ� ��� ���������� '�Խñ� ����Ϸ� ����' ��ũ Ŭ�� �� �ش�ȭ���� ������ �մϴ�.
		�� �� �Խñ��� �Է� �� ��� ��ư�� ������ �ܼ�ȭ�鿡 �Է��� ������ ��� ��
		�ٽ� �Խñ� ��� �������� �̵��մϴ�.
		
	 -->
</body>
</html>