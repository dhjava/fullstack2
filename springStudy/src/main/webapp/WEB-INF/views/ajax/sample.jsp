<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.3.min.js"></script>
<script>
	$(document).ready(function(){
		alert("제이쿼리 동작!");
	});
	
	$(function(){
		alert("제이쿼리 동작!");
	});
	
	function ajaxCallFn1(){
		$.ajax({
			url:"stringCall.do",
			type:"get",
			success:function(data){
				$("#result").text(data);
			},
			error:function(){
				alert("예외발생!!");
			}
			
		});
	}
	
	function ajaxCallJSON(){
		$.ajax({
			url:"jsonCall.do",
			type:"post",
			data:"bidx=1",
			success:function(data){
				console.log(data.title);
				console.log(data.id);
			},
			error:function(){
				alert("예외발생!");
			}
		});
	}
</script>
</head>
<body>
	<h2>ajax 샘플 페이지</h2>
	<button onclick="ajaxCallFn1()">click</button>
	<button onclick="ajaxCallJSON()">click2</button>
	<hr>
	
	<input type="number" id="bidx"><button onclick="findBoardFn()">find board</button>
	<!-- 
		위 입력양식에 입력한 값과 일치하는 게시글을 find board 버튼 클릭시 
		ajax로 찾아 id = result 요소에 title,id,wdate,hit,body 정보를 출력하세요
	 -->
	 <script>
	 	function findBoardFn(){
	 		var bidx = $("#bidx").val();
	 		
	 		$.ajax({
	 			url:"findBoard.do",
	 			type:"get",
	 			data:"bidx="+bidx,//{bidx:bidx}
	 			success:function(data){
	 				if(data != ''){
		 				var html = data.title+"<br>"
		 				          +data.id+"<br>"
		 				          +data.wdate+"<br>"
		 				          +data.hit+"<br>"
		 				          +data.body;
		 				$("#result").html(html);
	 				}else{
	 					$("#result").html("");
	 				}
	 			},
	 			error:function(){
	 				alert("예외발생");
	 			}
	 		});
	 	}
	 	
	 </script>
	<div id="result"></div>
	
	<hr>
	<input type="text" id="id">
	<div id="idCheck"></div>
	<!-- 
		위 id가 id인 입력양식에서 커서가 벗어나는 경우 입력된 값을 이용해서
		데이터베이스에 일치하는 값이 있는 경우 idCheck요소에 '이미 존재하는 아이디 입니다' 출력
		일치하는 값이없는 경우 '사용할 수 있는 아이디입니다. '출력하세요.
		*ajax를 활용해야 합니다.
	 -->
	
</body>
</html>











