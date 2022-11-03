<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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
			
				<div class="join_title">내정보 수정</div>
				<div class="join_box">
		<form action="/member/modify" method="post">
			
				<tr>
					<td> * 아이디</td>
					<td>
						<input type="text" id="memberId" name="memberId" value="${member.memberId }"  readonly>
					</td>
				</tr>
				<tr>
					<td> * 비밀번호</td>
					<td>
						<input type="password" name="memberPwd">
					</td>
				</tr>
				<tr>
					<td> * 이메일</td>
					<td>
						<input type="text" name="memberEmail" value="${member.memberEmail }">
					</td>
				</tr>	
				<tr>
					<td> * 이름</td>
					<td>
						<input type="text" name="memberName" value="${member.memberName }" readonly>
					</td>
				</tr>				
				<tr>
					<td> * 전화번호</td>
					<td>
						<input type="text" name="memberPhone" value="${member.memberPhone }">
					</td>
				</tr>
				<tr>
					<td> 우편번호</td>
					<td>
						<input type="text" name="post" class="postcodify_postcode5" value="${addrInfos[0] }">
						<button type="button" id="postcodify_search_button">검색</button>
					</td>
				</tr>
				<tr>
					<td> 도로명 주소</td>
					<td>
						<input type="text" name="address" class="postcodify_address" value="${addrInfos[1] }">
					</td>
				</tr>
				<tr>
					<td> 상세 주소</td>
					<td>
						<input type="text" name="address" class="postcodify_details" value="${addrInfos[2] }">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기">
						<button type="button" onclick="removeMember();">탈퇴하기</button>
					</td>
				</tr>
			
		</form>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
		function removeMember() {
			if(confirm("정말 탈퇴하시겠습니까?")) {
				location.href = "/member/remove";
			}
		}
		$("#postcodify_search_button").postcodifyPopUp();
	</script>
</body>
</html>