<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실시간채팅</title>
<style>
	  *{ margin: 0; padding: 0; }
 
.chat_wrap .header { font-size: 14px; padding: 15px 0; background: #F18C7E; color: white; text-align: center;  }
 
.chat_wrap .chat { padding-bottom: 80px; }
.chat_wrap .chat ul { width: 100%; list-style: none; }
.chat_wrap .chat ul li { width: 100%; }
.chat_wrap .chat ul li.left { text-align: left; }
.chat_wrap .chat ul li.right { text-align: right; }
 
.chat_wrap .chat ul li > div { font-size: 13px;  }
.chat_wrap .chat ul li > div.sender { margin: 10px 20px 0 20px; font-weight: bold; }
.chat_wrap .chat ul li > div.message { display: inline-block; word-break:break-all; margin: 5px 20px; max-width: 75%; border: 1px solid #888; padding: 10px; border-radius: 5px; background-color: #FCFCFC; color: #555; text-align: left; }
 
.chat_wrap .input-div { position: fixed; bottom: 0; width: 100%; background-color: #FFF; text-align: center; border-top: 1px solid #F18C7E; }
.chat_wrap .input-div > textarea { width: 100%; height: 80px; border: none; padding: 10px; }
 
.format { display: none; }

	
	</style>
</head>
<body>
<div class="chat_wrap">
    <div class="header">
        CHAT
    </div>
    <div class="chat">
        <ul>
            <!-- 동적 생성 -->
        </ul>
    </div>
<!--     <div class="input-div"> -->
<!--         <textarea placeholder="Press Enter for send message."></textarea> -->
<!--     </div> -->
 
    <!-- format -->
 
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
        <button type="button" onclick="openSocket();">대화방 참여</button>
        <button type="button" onclick="closeSocket();">대회방 나가기</button>
    	<br/><br/><br/>
    	
  		메세지 입력 : 
        <input type="text" id="sender" value="${sessionScope.id}" style="display: none;">
        <input type="text" id="messageinput">
        </textarea>
        <button type="button" onclick="send();">메세지 전송</button>
        <button type="button" onclick="javascript:clearText();">대화내용 지우기</button>
    </div>
    </div>
    <!-- Server responses get written here -->
    <div id="messages">
    </div>
    <!-- websocket javascript -->
    <script type="text/javascript">
        var ws;
        var messages = document.getElementById("messages");
        
        function openSocket(){
            if(ws !== undefined && ws.readyState !== WebSocket.CLOSED ){
                writeResponse("WebSocket is already opened.");
                return;
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
           // var text=document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            var text = document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            ws.send(text);
            text = "";
        }
        
        function closeSocket(){
            ws.close();
        }
        
        function writeResponse(text){
            messages.innerHTML += "<br/>"+text;
        }
        function clearText(){
            console.log(messages.parentNode);
            messages.parentNode.removeChild(messages)
      	}
        
  </script>
</body>
</html>