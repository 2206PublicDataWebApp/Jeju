<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>마이페이지 이용내역</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
 <!--  ************************* Page Title Starts Here ************************** -->
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>About Traveler</h2>
                <ul>
                    <li> <a href="#"><i class="fas fa-home"></i> Home</a></li>
                    <li><i class="fas fa-angle-double-right"></i> About Us</li>
                </ul>
            </div>
        </div>
    </div>

       
         <!--*************** Blog Starts Here ***************-->
                     
    <div class="container-fluid blog">
        <div class="container">
            <hr>
             <div class="session-title">
                <h5 style="font-size: 20px; font-weight : bold;">예약 내역</h5>     
            </div>
            <hr>
           <div style="font-size: 16px; color : red; font-weight : bold; margin-bottom: 15px;">결제 대기</div>
                <div class="blog-row row">     
                    <c:if test="${!empty wList}">
                    	<c:forEach items="${wList }" var="wait">
	                    	<div class="col-lg-4 col-md-6 ">
		                    	<div class="blog-col">
		                            <img src="${wait.reFilePath}">
		                            <span>${wait.rePayDate} 결제</span>
<!-- 		                            <br> -->
<!-- 		                           	 남은 시간: -->
<!--  									<input id="Timer" type="text" value="" style="border:none; border-right:0px; border-top:0px; border-left:0px; border-bottom:0px; color : red; font-wieght : bold;" readonly/> -->
		                            <a href="/reservation/cancel?reservationNo=${wait.reservationNo }"><div style="text-align: center;"><button class="btn btn-info btn-sm" style="font-size: 8px;">결제 대기</button></div></a>
		                            <div style="text-align: center; font-size: 20px; font-weight: bold; margin-bottom: 5px; margin-top: 5px;">${wait.rePensionName }</div>
		                            <div style="text-align: center;">${wait.reStartDate } ~ ${wait.reEndDate }</div>
		                            <div style="text-align: center; font-size: 15px; font-weight: bold; margin-top: 10px;">결제 금액 <span style="font-size: 15px; color: red;">${wait.rePrice }원</span></div>
		                        </div>
		                     </div>  
                    	</c:forEach>                  
                    </c:if>  
            </div>
        </div>

        
        <div class="container">
            <hr>
          <div style="font-size: 16px; font-weight : bold; margin-bottom: 15px;">예약 내역</div>
               <div class="blog-row row">
                <c:if test="${!empty rList}">
                   	<c:forEach items="${rList }" var="success">
                    	<div class="col-lg-4 col-md-6 ">
	                    	<div class="blog-col">
	                            <img src="${success.reFilePath}">
	                            <span>${success.rePayDate} 결제</span>	                     
	                            <div style="text-align: center;"><button class="btn btn-info btn-sm" style="font-size: 8px;">예약 완료</button></div>
	                            <div style="text-align: center; font-size: 20px; font-weight: bold; margin-bottom: 5px; margin-top: 5px;">${success.rePensionName }</div>
	                            <div style="text-align: center;">${success.reStartDate } ~ ${success.reEndDate }</div>
	                            <div style="text-align: center; font-size: 15px; font-weight: bold; margin-top: 10px;">결제 금액 <span style="font-size: 15px; color: red;">${success.rePrice }원</span></div>
	                        </div>
	                     </div>  
                   	</c:forEach>                  
                 </c:if>           
           </div>
       </div>

       <div class="container">
       <hr>
       <div style="font-size: 16px; font-weight : bold; margin-bottom: 15px;">이용 내역</div>
           <div class="blog-row row">
            	<c:if test="${!empty sList}">
                   	<c:forEach items="${sList }" var="end" varStatus="vs">
                    	<div class="col-lg-4 col-md-6 ">
	                    	<div class="blog-col">
	                            <img src="${end.reFilePath}">
	                            <span>${end.rePayDate} 결제</span>	                     
	                            <div style="text-align: center; font-size: 20px; font-weight: bold; margin-bottom: 5px; margin-top: 5px;">${end.rePensionName }</div>
	                            <div style="text-align: center;">${end.reStartDate } ~ ${end.reEndDate }</div>
	                            <div style="text-align: center; font-size: 15px; font-weight: bold; margin-top: 10px;">결제 금액 <span style="font-size: 15px; color: red;">${end.rePrice }원</span></div><br>
	                            <c:if test="${end.reviewCheck == 0 }">
	                            	<div style="text-align: center;"><button class="btn btn-outline-success" data-toggle='modal' data-target='#registModal${vs.index }'>${end.rePensionNo }후기 작성</button></div><br>
	                        	</c:if>
	                        	<c:if test="${end.reviewCheck == 1 }">
	                        		<div style="text-align: center; font-weight: bold; color: green">후기작성완료</div>
	                        	</c:if>
	                        </div>
	                     </div>
	                     	<form action="/review/regist" method="post">
	                    	 <input type="hidden" name="pensionNo" value="${end.rePensionNo }">
	                    	 <input type="hidden" name="memberId" value="${end.memberId }">
			                     <div class="modal fade" id="registModal${vs.index }" role="dialog">
									  	<div class="modal-dialog">
									      <div class="modal-content">
									          <div class="modal-header">
									              <h4 class="modal-title">후기 작성</h4>
									              <button type="button" class="close" data-dismiss="modal">&times;</button>
									          </div>
									          <div class="modal-body">
									              <div class="form-group">
									                  <label for="replyText">${end.rePensionName } </label>
									                  <textarea class="form-control" name="reviewContents" rows="18" cols="20" placeholder="후기를 입력해주세요." style="resize:none" required></textarea>
									              </div>
									          </div>
									          <div class="modal-footer">
									              <input type="submit" value="등록" class="btn btn-success modalModBtn" >
									              <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
									          </div>
									      </div>
									  </div>
								</div>
							</form> 
	                     </c:forEach>
                 </c:if>
       		</div>
   		</div>
    </div>  
   <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<div class="copy">
            <div class="container">
                <a href="https://www.smarteyeapps.com/">2015 &copy; All Rights Reserved | Designed and Developed by Smarteyeapps</a>
                
                <span>
                <a><i class="fab fa-github"></i></a>
                <a><i class="fab fa-google-plus-g"></i></a>
                <a><i class="fab fa-pinterest-p"></i></a>
                <a><i class="fab fa-twitter"></i></a>
                <a><i class="fab fa-facebook-f"></i></a>
        </span>
            </div>

        </div>
		<input id="set_btn" type="button" value="data set"/>
		<input id="get_btn" type="button" value="data get"/>
		<div id="result"></div>
    </body>
    
    <script>
    
	    const Timer=document.getElementById('Timer'); //스코어 기록창-분
// 	    let time= 1800000;
// 	    let min=30;
// 	    let sec=60;
	
// 	    Timer.value=min+":"+'00'; 
	
	   
// 	    function TIMER(){
// 	        PlAYTIME=setInterval(function(){
// 	            time=time-1000; //1초씩 줄어듦
// 	            min=time/(60*1000); 
	
// 	           if(sec>0){ //sec=60 에서 1씩 빼서 출력해준다.
// 	                sec=sec-1;
// 	                Timer.value=Math.floor(min)+':'+sec; //실수로 계산되기 때문에 소숫점 아래를 버리고 출력해준다.
	               
// 	            }
// 	            if(sec===0){
// 	             	// 0에서 -1을 하면 -59가 출력된다.
// 	                // 그래서 0이 되면 바로 sec을 60으로 돌려주고 value에는 0을 출력하도록 해준다.
// 	                sec=60;
// 	                Timer.value=Math.floor(min)+':'+'00'
// 	            }     
	       
// 	        },1000); //1초마다 
// 	    }
	    
// 	    TIMER();
// 	    setTimeout(function(){
// 	        clearInterval(PlAYTIME);
	        
// 	        //여기다 ajax로 예약내역 삭제하면 됨.
// 	    },1800000);//이 함수가 30분뒤에 실행될것이다.

		//로컬에서 가져오고싶은 아이템의 키를 파라미터로 입력받음
		$(document).ready(function getItemWithExpireTime(){
			$.ajax({
		    		url : "/reservation/checkSessionId",
		    		type : "post",
		    		success : function(result) {
		    				if(result != "") {
		    					const objString = window.localStorage.getItem(result);	//local에 저장된 time을 가져와 objString에 저장
		    					//로컬에서 가지고온 값이 존재하지 않으면 null 리턴
		    					if(!objString) {
		    						console.log("로컬값 없음!!!!!!!!");
		    						return null;
		    					}
		    					
		    					const obj = JSON.parse(objString);	//JSON으로 변환했던 문자열을 parse로 객체 변환
		    					
		    					console.log("parse로 변환된 객체 : " + obj);	
		    					
		    					//현재 시간과 (현재시간+30분)했던 것을 비교
		    					if(Date.now() > obj.expire){
		    						$.ajax({
		    							url : "/reservation/removeWait",
		    							data : {
		    								"reservationName" : obj.value
		    							},
		    							type : "post",
		    							success : function(result) {
		    								if(result == "삭제 성공!") {
		    									//만료시간이 지나면 결제대기상태 삭제
		    									window.localStorage.removeItem(keyName);
		    									console.log("삭제 완료!!");
		    									//삭제 ajax 코드 
		    									
		    									$.ajax({
		    										url : "/coupon/couponUseCheck",
		    										
		    									});
		    								}else {
		    									console.log(result);
		    								}
		    							}
		    		 				});			
		    		 				
		    						localStorage.removeItem(result);
		    						//null 리턴
		    						return null;
		    					}
		    					//만료기간이 남아있을땐 value값 리턴
		    					return obj.value;
		    				}		     		    				   	     		    				
		    			}
					});
			
		});
	
		
// 		$("#get_btn").click(function() {
// 			const value = getItemWithExpireTime("time");
			
// 			const resultDiv = document.getElementById("result");
// 			resultDiv.innerText = value + Date.now();
// 		});
		
	
	    
	    
    </script>

    
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>
