<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>회원가입</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/422d96f707.js"
   crossorigin="anonymous"></script>


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
   width: 50%;
   background-color: #FFF;
   text-align: center;
   border-top: 1px solid #F18C7E;
}
.chat_wrap .input-div>textarea {
   width: 50%;
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
     <header class="container-fluid">
           <div class="header-top">
               <div class="container">
                    <div class="row">
                        <div class="col-md-4 d-none d-md-block mail-detail"></div>
                        <div class="col-md-4 logo">
<!--                             <h1 id="logo">제주어때 </h1> -->
                            <a data-toggle="collapse" data-target="#menu-jk" href="#menu-jk"><i class="fas d-block d-sm-block d-md-none small-menu fa-bars"></i></a>
                        </div>
                        <div class="col-md-4 d-none d-md-block social-link ">
                        <c:if test="${not empty sessionScope.loginUser }">
                           <table align="right">
                              <tr>
                                 <td style="color : black;">
                                    ${sessionScope.loginUser.memberId } 님 환영합니다
                                   <a href="#"><img onclick="location.href='/chat/login2.do'"
                              src="/resources/images/consultimg.png"style="width:60px; height:60px;">
                                      </a>
                                 </td>
                              </tr>
                              <tr>
                                 <td><a href="/member/logout.kh"style="width:30px; height:30px; color : black;"  >로그아웃</a></td>
                              </tr>
                           </table>
                        </c:if>
                        </div>
                    </div>
                </div>
           </div>
           <div id="menu-jk" class="header-nav d-none d-md-block">
               <div class="container">
                   <div class="row nav-row">
                       <ul>

                           <li><a href="/mypage/myPage" style="color : black;">1:1 문의</a></li>
                           <c:if test="${sessionScope.loginUser.memberId eq 'admin' }">
                                 <li><a href="/admin/adminPage">관리자페이지</a></li>
                           </c:if>
                       </ul>
                   </div>
               </div>
           </div>
        </header>
   <div style="width : 50%; margin : 0 auto; position:relative; top : 250px;">
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
</div>
<div id="messages"  style="width : 50%; margin : 0 auto; position:relative; top : 250px;"></div>
   <div class="chat_wrap" style="position : relative; left : 500px;">
      <div class="input-div"><br>
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

</body>
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
<script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
<script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
<script src="/resources/assets/js/script.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
</html>