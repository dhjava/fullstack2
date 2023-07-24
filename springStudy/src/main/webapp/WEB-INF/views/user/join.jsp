<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="<%=request.getContextPath()%>/js/jquery-3.6.3.min.js"></script>
	<script>
		var checkIdFlag = false; // id 입력양식에 대한 입력여부 값을 가지는 변수
		var checkPasswordFlag = false;
		var checkNameFlag = false;
		var checkPhoneFlag = false;
		function checkFn(obj){
			if(obj.value == ""){
				$(obj).next(".msg").text("필수입력입니다.").css("color","red");
				if($(obj).attr("name") == "id"){
					checkIdFlag = false;
				}else if($(obj).attr("name") == "password"){
					checkPasswordFlag = false;
				}else if($(obj).attr("name") == "name"){
					checkNameFlag = false;
				}else if($(obj).attr("name") == "phone"){
					checkPhoneFlag = false;
				}
				
			}else{
				if($(obj).attr("name") == "id"){
					// id가 존재하는 경우 아이디 중복체크
					$.ajax({
						url:"checkId.do",
						type:"post",
						data:{id:$(obj).val()},
						success:function(data){
							if(data == "0"){
								// 사용할 수 있는 id
								$(obj).next(".msg").text("사용할 수 있는 id 입니다.").css("color","green");
								checkIdFlag = true;
							}else{
								// 중복 id
								$(obj).next(".msg").text("사용할 수 없는 id 입니다.").css("color","red");
								checkIdFlag = false;
							}
						}
					});
				}else{
					// id의 값이 존재하는 경우
					$(obj).next(".msg").text("");
					
					if($(obj).attr("name") == "password"){
						checkPasswordFlag = false;
					}else if($(obj).attr("name") == "name"){
						checkNameFlag = false;
					}else if($(obj).attr("name") == "phone"){
						checkPhoneFlag = false;
					}
				}
			}
		}
		function submitFn(){
			if(checkIdFlag && checkPasswordFlag && checkNameFlag && checkPhoneFlag){
				$("form").submit();
			}
		}
	</script>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="join.do" method="post">
		<table>
			<tr>
				<th align="right">id <span>*</span> : </th>
				<td>
				<input type="text" name="id" id="id" onblur="checkFn(this)">
				<div class="msg"></div>
				</td>
			</tr>
			
			<tr>
				<th align="right">password <span>*</span> : </th>
				<td>
				<input type="password" name="password" id="password" onblur="checkFn(this)">
				<div class="msg"></div>
				</td>
			</tr>
			<tr>
				<th align="right">이름 <span>*</span> : </th>
				<td>
				<input type="text" name="name" id="name" onblur="checkFn(this)">
				<div class="msg"></div>
				</td>
			</tr>
			<tr>
				<th align="right">나이 : </th>
				<td><input type="number" name="ageStr" id="ageStr"></td>
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
				<th align="right">연락처 <span>*</span> : </th>
				<td>
				<input type="text" name="phone" id="phone" onblur="checkFn(this)">
				<div class="msg"></div>
				</td>
			</tr>
		</table>
		<button type="button" onclick="submitFn()">회원가입하기</button>
	</form>
	
</body>
</html>