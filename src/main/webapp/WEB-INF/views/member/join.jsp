<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	#container {width: 100%; height: 100%; position: relative;}
span.guide {
		display : none;
		font-size : 12px;
		top : 12px;
		right : 10px;
	}
	span.ok { color : green }
	span.error { color : red }

.dpn {display: none !important;}
.join_wrap {width:550px; margin: 0 auto; border: 1px solid #dadada; padding: 24px; border-radius: 5px;}
.join_title {width:100%; height:35px; font-size: 19px; font-weight: bold; padding-left: 10px; padding: 0 0 10px 10px;}

.join_box {width: 100%;}
.join_box input {width: 100%; height: 50px; border: 1px solid #dadada;padding: 17px; border-radius: 5px; margin-top: 20px;}
.join_box span {display: inline-block; color: red; font-size: 12px; padding-left: 1px; padding-top: 8px;}

.email_auth {width: 100%; margin-top: 10px;}
.email_auth input {display:inline-block; width: calc(100% - 121px); vertical-align: top; margin: 0;}
.email_auth_btn{
	display: inline-block;
    width: 115px;
    height: 50px;
    padding: 17px 0 15px;
    border-radius: 6px;
    border: solid 1px rgba(0,0,0,.15);
    background-color: #03c75a;
    color: white;
    font-size: 17px;
    font-weight: bold;
    line-height: 1;
}

.join_btn {    
	display: block;
    width: 100%;
    padding: 17px 0 15px;
    border-radius: 6px;
    border: solid 1px rgba(0,0,0,.15);
    background-color: #03c75a;
    color: white;
    font-size: 19px;
    font-weight: bold;
    margin-top: 20px;
}

</style>
</head>
<body>
<div id="container" class="container">
	<div class="content">
		<div class="join_wrap">
			
				<div class="join_title">회원가입</div>
				<div class="join_box">
				<form action="/member/register.kh" method="post">
				아이디 
				<input type="text" id="memberId" name="memberId">
<!-- 					<span class="guide ok">이 아이디는 사용 가능합니다.</span> -->
<!-- 						<span class="guide error">이 아이디는 사용할 수 없습니다.</span> -->

			비밀번호					
			<input type="password" placeholder="비밀번호" name="memberPwd" id="password">
			
					<div class="email_auth">
						<input type="text" placeholder="이메일" name="email" id="email" class="email">
 						<button type="button" id="email_auth_btn" class="email_auth_btn">인증번호 받기</button>
					</div>
				<input type="text" placeholder="인증번호 입력" id="email_auth_key"> 
				<tr>
					<td> * 이름</td>
					<td>
						<input type="text" name="memberName">
					</td>
				</tr>
				<tr>
					<td> * 전화번호</td>
					<td>
						<input type="text" name="memberPhone">
					</td>
				</tr>
				<tr>
					<td> 우편번호</td>
					<td>
						<input type="text" name="post" class="postcodify_postcode5">
						<button type="button" id="postcodify_search_button">검색</button>
					</td>
				</tr>
				<tr>
					<td> 도로명 주소</td>
					<td>
						<input type="text" name="address1" class="postcodify_address">
					</td>
				</tr>
				<tr>
					<td> 상세 주소</td>
					<td>
						<input type="text" name="address2" class="postcodify_details">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="가입하기">
					</td>
				</tr>
			</table>
			</form>
		
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
	$("#postcodify_search_button").postcodifyPopUp();
	/**
	 *  회원가입 관련 처리
	 */
	 
	 function fn_join(){
		var f = $('#join_frm');
		var formData = f.serialize();
			
		$.ajax({
			type : "POST",
			url : "/join",
			data : formData,
			success: function(data){
				if(data == "Y"){
					alert("회원가입이 완료되었습니다.");	
					location.href="/"
				}else{
					alert("회원가입에 실패하였습니다.");
				}
			},
			error: function(data){
				alert("회원가입 에러 발생!");
				console.log(data);
			}
		});
	 }
	 
	 $(function() { 
	 	
	 	var email_auth_cd = '';
	 
		$('#join').click(function(){
			
			if($('#id').val() == ""){
				alert("아이디를 입력해주세요.");
				return false;
			}
			
			
			if($('#password').val() == ""){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			if($('#password').val() != $('#password_ck').val()){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			if($('#email_auth_key').val() != email_auth_cd){
				alert("인증번호가 일치하지 않습니다.");
				return false;
			}
		
			fn_join();
		});
		
		$(".email_auth_btn").click(function(){	     	 
	    	 var email = $('#email').val();
	    	 
	    	 if(email == ''){
	    	 	alert("이메일을 입력해주세요.");
	    	 	return false;
	    	 }
	    	 
	    	 $.ajax({
				type : "POST",
				url : "/emailAuth",
				data : {email : email},
				success: function(data){
					alert("인증번호가 발송되었습니다.");
					email_auth_cd = data;
				},
				error: function(data){
					alert("메일 발송에 실패했습니다.");
				}
			}); 
		});
		
		$('#id').focusout(function(){
			var id = $('#id').val();
		
			$.ajax({
				type : "POST",
				url : "/idCheck",
				data : {id : id},
				success: function(data){
					console.log(data);
					if(data == "Y"){
						$('#id_ck').removeClass("dpn");
					}else{
						$('#id_ck').addClass("dpn");
					}
				},
				error: function(data){
				}
			}); 
		});
		
		$('#nickname').focusout(function(){
			var nickname = $('#nickname').val();
		
			$.ajax({
				type : "POST",
				url : "/nicknameCheck",
				data : {nickname : nickname},
				success: function(data){
					if(data == "Y"){
						$('#nickname_ck').removeClass("dpn");
					}else{
						$('#nickname_ck').addClass("dpn");
					}
				},
				error: function(data){
				}
			}); 
		});
	 });
	</script>
</body>
</html>

