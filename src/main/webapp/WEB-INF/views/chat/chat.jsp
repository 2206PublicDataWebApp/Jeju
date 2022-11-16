<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실시간채팅</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="shortcut icon" href="/resources/assets/images/fav.png"
	type="image/x-icon">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap"
	rel="stylesheet">
<link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
<link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/assets/css/all.min.css">
<link rel="stylesheet" href="/resources/assets/css/animate.css">
<link rel="stylesheet" type="text/css"
	href="/resources/assets/css/style.css" />
<style>
* {
	margin: 0;
	padding: 0;
}
.chat_wrap .header {
	font-size: 14px;
	padding: 15px 0;
	background: #F18C7E;
	color: white;
	text-align: center;
}
.chat_wrap .chat {
	padding-bottom: 80px;
}
.chat_wrap .chat ul {
	width: 100%;
	list-style: none;
}
.chat_wrap .chat ul li {
	width: 100%;
}
.chat_wrap .chat ul li.left {
	text-align: left;
}
.chat_wrap .chat ul li.right {
	text-align: right;
}
.chat_wrap .chat ul li>div {
	font-size: 13px;
}
.chat_wrap .chat ul li>div.sender {
	margin: 10px 20px 0 20px;
	font-weight: bold;
}
.chat_wrap .chat ul li>div.message {
	display: inline-block;
	word-break: break-all;
	margin: 5px 20px;
	max-width: 75%;
	border: 1px solid #888;
	padding: 10px;
	border-radius: 5px;
	background-color: #FCFCFC;
	color: #555;
	text-align: left;
}
.chat_wrap .input-div {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #FFF;
	text-align: center;
	border-top: 1px solid #F18C7E;
}
.chat_wrap .input-div>textarea {
	width: 100%;
	height: 80px;
	border: none;
	padding: 10px;
}
.format {
	display: none;
}
</style>

</head>
<body>
	<div class="chat_wrap">
		<div class="header">CHAT</div>
		<div class="chat">
			<ul>
				<!-- 동적 생성 -->
			</ul>
		</div>
		<!--     <div class="input-div"> -->
		<!--         <textarea placeholder="Press Enter for send message."></textarea> -->
		<!--     </div> -->

		<!-- format -->
		<c:if test="${member ne 'admin' }">
			<h4>상담 시작을 누르시고 기다리시면 최대한 빠르게 응답 하겠습니다.</h4>
		</c:if>
		<c:if test="${member eq 'admin' }">
			<h4>관리자로 접속!</h4>
		</c:if>
		<div class="chat format">
			<ul>
				<li>
					<div class="sender">
						<span></span>
					</div>
					<div class="message">
						<span></span>
					</div>
				</li>
			</ul>
		</div>
	</div>


	<div class="chat_wrap">
		<div class="input-div">
			<button class="btn btn-info btn-md-2" onclick="openSocket();">상담
				시작</button>
			<button class="btn btn-info btn-md-2" onclick="location.href='/home'">대회방
				나가기</button>
			
			<br />
			<br />
			<br />
			<div class="form-group input-group">
				<span class="input-group-addon">메세지 입력 :</span> <input type="text"
					id="sender" value="${member}" style="display: none;"> <input
					type="text" class="form-control" id="messageinput">
				<!--     <button type="button" onclick="send();">메세지 전송</butㄴton> -->
				<button class="btn btn-info btn-md-4" onclick="send();"
					style="margin-left: 10px;">전송</button>
				<button class="btn btn-info btn-md-4"
					onclick="javascript:clearText();" style="margin-left: 10px;">지우기</button>

			</div>
		</div>
	</div>
	<!-- Server responses get written here -->
	<div id="messages"></div>
	<!-- websocket javascript -->
	<script type="text/javascript">
        var ws;
        var messages = document.getElementById("messages");
	    var count = 0;
	    var 웰컴;
        
        function openSocket(){
        	var memberId = $("#sender").val();
        	writeResponse(memberId+"님이 입장하였습니다.");
           
            if(ws !== undefined && ws.readyState !== WebSocket.CLOSED ){
                writeResponse("WebSocket is already opened. ");
				
            }
            //웹소켓 객체 만드는 코드
            ws = new WebSocket("ws://localhost:8989/echo.do");
            
            ws.onopen = function(event){
                if(event.data === undefined){
              		return;
                }
                writeResponse(event.data);
            };
            
            ws.onmessage = function(event){
                console.log('writeResponse');
                console.log(event.data)
                writeResponse(event.data);
            };
            
            ws.onclose = function(event){
                writeResponse("대화 종료");
            }
			
            
        }
        
        function send(){
            var text = document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            ws.send(text);
            text = "";
            $("#messageinput").val("");          
        }
    
        
        function closeSocket(){
            ws.close();
        }
        
        function writeResponse(text){
            messages.innerHTML += "<br/>"+text;
        }
        function clearText(){
            console.log(messages.parentNode);
            messages.innerHTML = "";
      	}
        
  </script>
	<script src="/resources/assets/js/popper.min.js"></script>
	<script src="/resources/assets/js/bootstrap.min.js"></script>
	<script
		src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
	<script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
	<script src="/resources/assets/js/script.js"></script>
</body>
</html>