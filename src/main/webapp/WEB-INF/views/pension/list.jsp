<%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>펜션 목록</title>
   <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
   <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
   <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
   <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
   <link rel="stylesheet" href="/resources/assets/css/all.min.css">
   <link rel="stylesheet" href="/resources/assets/css/animate.css">
   <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <style>
      #margin_test {
         margin-bottom: 1px;
         position : relative;
         bottom : 25px;
      }

      .test2 {
         margin-bottom: 20px;
      }

      .modify {
         text-align: left ;
      }

      .test3 {
         margin-top: 50px;
      }

      .test4 {
         margin-bottom: 12px;
      }
      #test5 {
         margin-top: -90px;
      }

      #test6 {
         margin-top: 20px;
      }

      #test9 {
         color: white;
      }
   </style>
</head>

<body>

<header class="container-flui">
   <div class="header-top">
      <div class="container">
         <div class="row">
            <div class="col-md-4 d-none d-md-block mail-detail">

            </div>
            <div class="col-md-4 logo">
               <img src="" alt="">
               <a data-toggle="collapse" data-target="#menu-jk" href="#menu-jk"><i class="fas d-block d-sm-block d-md-none small-menu fa-bars"></i></a>
            </div>

         </div>
      </div>
   </div>
   <div id="menu-jk" class="header-nav d-none d-md-block">
      <div class="container">
         <div class="row nav-row">
            <ul>
               <li><a href="/home">홈</a></li>
               <li><a href="/pension/list">숙소 리스트</a></li>
               <li><a href="#">커뮤니티</a></li>
               <li><a href="/mypage/myPage">마이페이지</a></li>
            </ul>
         </div>
      </div>
   </div>

</header>

<div class="page-nav no-margin row">
   <div class="container">
      <div class="row">
         <div class="col-12">
            <form class="form mt-1" action="/pension/dateSearch" name="filterFrm" method="post">
               <div class="row">
                  <div class="col-sm-12 col-md-12 col-lg-3 py-2">
                     <h5 class="my-2 pl-2" id="test9">
                        <i class="far fa-calendar-alt"></i>
                        예약날짜 선택 :
                     </h5>
                  </div>
                  <!--                      <div class="col-sm-12 col-md-6 col-lg-5"> -->
                  <!--                         <input type="text" class="form-control my-2 text-center" id="daterange" readonly> -->
                  <%--                         <input type="hidden" class="form-control my-2" name="startDate" value="${startDate}" readonly> --%>
                  <%--                         <input type="hidden" class="form-control my-2" name="endDate" value="${endDate}" readonly> --%>
                  <!--                      </div> -->
                  <div class="col-sm-3" style="position : relative; top:12px; right : 40px;" >
                     <div class="input-group">
                        <input type="text" id="datepicker" class="form-control col-xs-12" name="startDate" value="${startDate }"/>
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-calendar-check" viewBox="0 0 16 16" style="margin-left : 10px;">
                           <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                           <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                        </svg>
                     </div>
                  </div>
                  <div class="col-sm-3">
                     <div class="input-group" style="position : relative; top:12px; right : 40px;">
                        <input type="text" id="datepicker1" class="form-control col-xs-12" name="endDate" value="${endDate }" />
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-calendar-check" viewBox="0 0 16 16" style="margin-left : 10px;">
                           <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                           <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                        </svg>
                     </div>
                  </div>
                  <div class="col-sm-8 col-md-4 col-lg-3" style="position : relative; right:30px; top : 2px;">
                     <input type="submit" class="btn btn-info btn-block my-2" value="Search" id="Search">

                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</div>

<!--*************** About Us Starts Here ***************-->

<section id="about" class="contianer-fluid about-us" style="position : relative; left : 50px;">
   <div class="container" id="test5">
      <div class="row">
         <div class="col-md-7 center image" >
            <div class="gallery-filter d-none d-sm-block" id="test_second">    
           			<button class="btn btn-default filter-button" data-filter="all" value="popular" onclick="searchPopular(this);">인기순</button>    
           		<button class="btn btn-default filter-button" data-filter="hdpe" value="asc" onclick="searchPopular(this);">낮은 가격 순</button>
               <button class="btn btn-default filter-button" value="desc" data-filter="sprinkle" onclick="searchPopular(this);">높은 가격 순</button>       		         		             
            </div>
            <hr id="margin_test">
            <div class="row g-0 position-relative test2" id="test_first">
               <div id="testtest">

               </div>
               <c:if test="${!empty pList }">
                  <c:forEach items="${pList }" var="pension" >
                     <div class="col-md-4 mb-md-0 p-md-2" id="tableBody1">
                        <img src="${pension.filePath}" alt="Image" class="img-fluid" style="height : 190px; border-radius: 15px;">
                     </div>
                     <div class="col-md-6 p-4 ps-md-0" id="tableBody2">
                        <ul class="modify">
                           <li class="test4"><h2 style="font-size : 22px;"><a href="/pension/detailView?pensionNo=${pension.pensionNo }&startDate=${startDate}&endDate=${endDate}">${pension.pensionName }</a></h2></li>
                           <li class="test4">${pension.pensionAddr }</li>
                           <li class="test4">${pension.pensionPrice }</li>
                           <li class="test4">${pension.reviewCount }개</li>
                        </ul>
                     </div>
                  </c:forEach>
               </c:if>
               <c:if test="${!empty prList }">
                  <c:forEach items="${prList }" var="dateSearch" >
                     <div class="col-md-4 mb-md-0 p-md-2" id="tableBody1">
                        <img src="${dateSearch.filePath}" alt="Image" class="img-fluid" style="height : 190px;">
                     </div>
                     <div class="col-md-6 p-4 ps-md-0" id="tableBody2">
                        <ul class="modify">
                           <li class="test4"><h2 style="font-size : 22px;"><a href="/pension/detailView?pensionNo=${dateSearch.pensionNo }&startDate=${startDate}&endDate=${endDate}">${dateSearch.pensionName }</a></h2></li>
                           <li class="test4">${dateSearch.pensionAddr }</li>
                           <c:if test="${dateSearch.pensionPrice == '판매완료' }">
                              <li class="test4">${dateSearch.pensionPrice }</li>
                           </c:if>
                           <c:if test="${dateSearch.pensionPrice != '판매완료' }">
                              <li class="test4">${dateSearch.pensionPrice }원</li>
                           </c:if>
                           <li class="test4">${dateSearch.reviewCount }개</li>
                        </ul>
                     </div>
                  </c:forEach>
               </c:if>
            </div>
         </div>

         <div class="col-md-5 text" id="test3">
            <div class="col-lg-10 sidebar">
               <!--  END sidebar-box-->
               <div class="sidebar-box">
                  <br>
                  <br>
                  <h3 class="heading" style="font-size : 20px; font-weight : bold;">상세조건</h3>
                  <hr>
                  <div class="filter" >
                     <div class="public px-1">
                        <p class="mb-3 font-weight-bold">공용 시설</p>
                        <div class="px-3">
                           <input type="checkbox" id="swimming" name="cate" class="mr-1 all" value="swimming"><label for="swimming">수영장</label>
                           <input type="checkbox" id="sing" name="cate" class="ml-1 mr-1 all" value="sing"><label for="sing">노래방</label>
                           <input type="checkbox" id="convenienceStore" name="cate" class="ml-1 mr-1 all" value="convenienceStore" ><label for="convenienceStore">편의점</label>
                           <input type="checkbox" id="park" name="cate" class="mr-1 all" value="park"><label for="park">주차장</label>
                        </div>
                     </div>
                     <hr>
                     <div class="internal px-1">
                        <p class="mb-3 font-weight-bold">내부 시설</p>
                        <div class="px-3">
                           <input type="checkbox"  id="aircon" name="cate" class="mr-1 all" value="aircon"> <label for="aircon">에어컨</label>
                           <input type="checkbox"  id="wifi" name="cate" class="ml-1 mr-1 all" value="wifi"><label for="wifi">와이파이</label>
                           <input type="checkbox"  id="bathTub" name="cate" class="ml-1 mr-1 all" value="bathTub"><label for="bathTub">욕조</label><br>
                           <input type="checkbox"  id="tv" name="cate" class="mr-1 all" value="tv"><label for="tv">TV</label>
                           <input type="checkbox"  id="refrigerator" name="cate" class="ml-1 mr-1 all" value="refrigerator"><label for="refrigerator">냉장고</label>
                           <input type="checkbox"  id="dry" name="cate" class="ml-1 mr-1 all" value="dry"><label for="dry">드라이기</label>
                        </div>
                     </div>
                     <hr>
                     <div class="other px-4">
                        <p class="mb-3 font-weight-bold">기타</p>
                        <div class="">
                           <ul>
                              <li><input type="checkbox" id="breakfast" name="cate" class="mr-1 all" value="breakfast"><label for="breakfast">조식</label></li>
                              <li><input type="checkbox" id="barbecue" name="cate" class="mr-1 all" value="barbecue"><label for="barbecue">바베큐</label></li>
                              <li><input type="checkbox" id="cook" name="cate" class="mr-1 all" value="cook"><label for="cook">취사가능</label></li>
                              <li><input type="checkbox" id="handicapPerson" name="cate" class="mr-1 all" value="handicapPerson"><label for="handicapPerson">장애인 편의시설</label></li>
                              <li><input type="checkbox" id="dog" name="cate" class="mr-1 all" value="dog"><label for="dog">애완견 출입</label></li>
                              <li><input type="checkbox" id="smokingRoom" name="cate" class="mr-1 all" value="smokingRoom"><label for="smokingRoom">흡연 가능</label></li>
                           </ul>
                        </div>
                     </div>
                     <hr>
                     <!--  END sidebar-box-->
                     <input type="submit" class="btn btn-info btn-block btnSearch" value="적용" onclick="btnSearchFilter();" style="margin-bottom: 30px;">
                  </div>

                  <div class="sidebar-box">
                     <h3 class="heading" style="margin-bottom: 25px; font-size : 20px; font-weight : bold;">예약 순위 TOP5</h3>
                     <div class="post-entry-sidebar">
                        <ul>
                           <c:forEach items="${rList }" var="rank" varStatus="i">
                              <li style="margin-bottom: 25px;"><img
                                    src="${rank.filePath }"
                                    alt="Image placeholder" class="me-4 rounded"
                                    style="width: 160px; height: 130px;">
                                 <div class="text"
                                     style="display: inline-block; margin-left: 20px;">
                                    <h5>${rank.pensionName }</h5>
                                    <div class="post-meta">
                                    <span class="mr-2"><fmt:formatNumber type="number"
                                                                maxFractionDigits="3" value="${rank.pensionPrice}" />${rank.pensionPrice }</span>
                                    </div>
                                 </div></li>
                           </c:forEach>
                        </ul>

                     </div>
                  </div>

               </div>
            </div>
         </div>

      </div>
   </div>
</section>

<!--  *************************Our Team Start Here ************************** -->

<!-- ######## Our Team End ####### -->

<!--*************** Footer  Starts Here *************** -->

<footer>
   <div class="container">
      <div class="row">
         <div class="col-md-3 fotblog">
            <p class="fab fa-instagram"></p>
            <a href="https://www.instagram.com/explore/tags/%EC%A0%9C%EC%A3%BC%EB%8F%84/?next=%2Fspecial_jejudo%2F" style="color: white;" target="_blank">Instagram</a> <br>
            <a href="https://www.instagram.com/explore/tags/%EC%A0%9C%EC%A3%BC%EB%8F%84%EB%A7%9B%EC%A7%91/?next=%2Fspecial_jejudo%2F" style="color: white;" target="_blank">Restaurant</a> <br>
            <a href="https://www.instagram.com/explore/tags/%EC%A0%9C%EC%A3%BC%EB%8F%84%EC%B9%B4%ED%8E%98/?next=%2Fspecial_jejudo%2F" style="color: white;" target="_blank">Cafe</a>
         </div>
         <div class="col-md-3 fotblog">
            <p class="fab fa-facebook-square"></p>
            <a href="https://www.facebook.com/happyjejudo" style="color: white;" target="_blank">Facebook</a>
         </div>
         <div class="col-md-3 glink">
            <p class="fab fa-twitter-square"></p>
            <a href="https://twitter.com/happyjejudo" style="color: white;" target="_blank">Twiter</a>
         </div>
         <div class="col-md-3 tags">
            <h2>Contect</h2>
            <p>email@email.com</p>
         </div>
      </div>
   </div>
</footer>

</body>

<script>
   $("#Search").on("click", function() {
      console.log($("#datepicker1").val());
   });


   $("#datepicker").datepicker({
      dateFormat: 'yy-mm-dd',
      //날짜 표시 형식 설정
      showOtherMonths: true,
      //이전 달과 다음 달 날짜를 표시
      showMonthAfterYear:true,
      //연도 표시 후 달 표시
      changeYear: true,
      //연도 선택 콤보박스
      changeMonth: true,
      //월 선택 콤보박스

      //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
      yearSuffix: "년",
      //연도 뒤에 나오는 텍스트 지정
      monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
      monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
      dayNamesMin: ['일','월','화','수','목','금','토'],
      dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
      minDate: "-1M", // -1D:하루전, -1M:한달전, -1Y:일년전                maxDate: "+1M", // +1D:하루후, -1M:한달후, -1Y:일년후
      //디폴트 버튼 대신 이미지 띄워줌
      //버튼 마우스오버 시 보이는 텍스트
   });

   $("#datepicker1").datepicker({
      dateFormat: 'yy-mm-dd',
      //날짜 표시 형식 설정
      showOtherMonths: true,
      //이전 달과 다음 달 날짜를 표시
      showMonthAfterYear:true,
      //연도 표시 후 달 표시
      changeYear: true,
      //연도 선택 콤보박스
      changeMonth: true,
      //월 선택 콤보박스
      //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
      yearSuffix: "년",
      //연도 뒤에 나오는 텍스트 지정
      monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
      monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
      dayNamesMin: ['일','월','화','수','목','금','토'],
      dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
      minDate: "-1M", // -1D:하루전, -1M:한달전, -1Y:일년전                maxDate: "+1M", // +1D:하루후, -1M:한달후, -1Y:일년후
      //버튼에 띄워줄 이미지 경로
      //디폴트 버튼 대신 이미지 띄워줌
      //버튼 마우스오버 시 보이는 텍스트
   });

   $("#datepicker").datepicker();

   $("#datepicker1").datepicker();

   function btnSearchFilter() {
      var swimming = $("#swimming").is(":checked");
      var barbecue = $("#barbecue").is(":checked");
      var sing = $("#sing").is(":checked");
      var park = $("#park").is(":checked");
      var convenienceStore = $("#convenienceStore").is(":checked");
      var smokingRoom = $("#smokingRoom").is(":checked");
      var dog = $("#dog").is(":checked");
      var handicapPerson = $("#handicapPerson").is(":checked");
      var cook = $("#cook").is(":checked");
      var breakfast = $("#breakfast").is(":checked");
      var wifi = $("#wifi").is(":checked");
      var aircon = $("#aircon").is(":checked");
      var refrigerator = $("#refrigerator").is(":checked");
      var bathtub = $("#bathtub").is(":checked");
      var dry = $("#dry").is(":checked");
      var tv = $("#tv").is(":checked");
      var all = $('.all').is(':checked');
      var startDate = document.getElementById("datepicker").value;
      var endDate = document.getElementById("datepicker1").value;

//           jsp 코드가 스트링을 들어가고 list2코드들이 스트링으로 전부 변한다 그스트링이 div
      console.log(startDate);
      if(all == false) {
         alert("체크후 조회할 수 있습니다.");
         return false;
      }
      $.ajax({
         url : "/pension/category",
         data : {
            "swimming" : swimming,
            "barbecue" : barbecue,
            "sing" : sing,
            "park" : park,
            "convenienceStore" : convenienceStore,
            "smokingRoom" : smokingRoom,
            "dog" : dog,
            "handicapPerson" : handicapPerson,
            "cook" : cook,
            "breakfast" : breakfast,
            "wifi" : wifi,
            "aircon" : aircon,
            "refrigerator" : refrigerator,
            "bathtub" : bathtub,
            "dry" : dry,
            "tv" : tv,
            "startDate" : startDate,
            "endDate" : endDate
         },
         type : "post",
         success : function(result) {
            var $body = $("#test_first");
            $body.html("");
            $("#test_first").html(result);
         },
         error : function() {
            alert("서버 요청 실패!");
         }
      });

   }

   
   function searchPopular(elem) {
	   var swimming = $("#swimming").is(":checked");
	      var barbecue = $("#barbecue").is(":checked");
	      var sing = $("#sing").is(":checked");
	      var park = $("#park").is(":checked");
	      var convenienceStore = $("#convenienceStore").is(":checked");
	      var smokingRoom = $("#smokingRoom").is(":checked");
	      var dog = $("#dog").is(":checked");
	      var handicapPerson = $("#handicapPerson").is(":checked");
	      var cook = $("#cook").is(":checked");
	      var breakfast = $("#breakfast").is(":checked");
	      var wifi = $("#wifi").is(":checked");
	      var aircon = $("#aircon").is(":checked");
	      var refrigerator = $("#refrigerator").is(":checked");
	      var bathtub = $("#bathtub").is(":checked");
	      var dry = $("#dry").is(":checked");
	      var tv = $("#tv").is(":checked");
	      var all = $('.all').is(':checked');
	      var startDate = document.getElementById("datepicker").value;
	      var endDate = document.getElementById("datepicker1").value;
	      console.log("들어가기 전");   
	      if(elem.value == 'popular') {
	    	  if(all == false) {
		    	  console.log("들어왔다!");
		          $.ajax({
		        	  url : "/pension/dateSearchSort?startDate=${startDate}&endDate=${endDate}",
		        	  data : {
		        		  "startDate" : startDate,
		        		  "endDate" : endDate	  
		        	  } , 
		        	  type : "post",
		    		   success : function(result) {    			   
		    		   		var $body = $("#test_first");
		    	            $body.html("");
		    	            $("#test_first").html(result); 
		    		   }       	  
		          });
		       }else {
		    	   $.ajax({
		    		   url : "/pension/popular",
		    		   data : {
		    	            "swimming" : swimming,
		    	            "barbecue" : barbecue,
		    	            "sing" : sing,
		    	            "park" : park,
		    	            "convenienceStore" : convenienceStore,
		    	            "smokingRoom" : smokingRoom,
		    	            "dog" : dog,
		    	            "handicapPerson" : handicapPerson,
		    	            "cook" : cook,
		    	            "breakfast" : breakfast,
		    	            "wifi" : wifi,
		    	            "aircon" : aircon,
		    	            "refrigerator" : refrigerator,
		    	            "bathtub" : bathtub,
		    	            "dry" : dry,
		    	            "tv" : tv,
		    	            "startDate" : startDate,
		    	            "endDate" : endDate
		    	         },
		    		   type : "get",
		    		   success : function(result) {		   
		    		   		var $body = $("#test_first");
		    	            $body.html("");
		    	            $("#test_first").html(result); 
		    		   }
		    	   
		    	 });
		       }
	      }else if(elem.value == 'asc'){
	    	  if(all == false) {
	    		  $.ajax({
	 	    		 url : "/pension/datePriceSort?startDate=${startDate}&endDate=${endDate}",
	 	    		 data : {
	 	    			 "startDate" : startDate,
	 	        		  "endDate" : endDate	
	 	    		 },
	 	    		 type : "post",
	 	    			 success : function(result) {    			   
	 		    		   		var $body = $("#test_first");
	 		    	            $body.html("");
	 		    	            $("#test_first").html(result); 
	 		    		   }   
	 	    	  });
	    	  }else {
	    		  $.ajax({
		    		   url : "/pension/categoryPriceSort?startDate=${startDate}&endDate=${endDate}",
		    		   data : {
		    	            "swimming" : swimming,
		    	            "barbecue" : barbecue,
		    	            "sing" : sing,
		    	            "park" : park,
		    	            "convenienceStore" : convenienceStore,
		    	            "smokingRoom" : smokingRoom,
		    	            "dog" : dog,
		    	            "handicapPerson" : handicapPerson,
		    	            "cook" : cook,
		    	            "breakfast" : breakfast,
		    	            "wifi" : wifi,
		    	            "aircon" : aircon,
		    	            "refrigerator" : refrigerator,
		    	            "bathtub" : bathtub,
		    	            "dry" : dry,
		    	            "tv" : tv,
		    	            "startDate" : startDate,
		    	            "endDate" : endDate
		    	         },
		    		   type : "post",
		    		   success : function(result) {		
		    			   console.log("성공!");
		    			   console.log(result);
		    		   		var $body = $("#test_first");
		    	            $body.html("");
		    	            $("#test_first").html(result); 
		    		   }
		    	   
		    	 });
	    	  }
	    	  
	      }else if(elem.value == 'desc') {
	    	  if(all == false) {
	    		  $.ajax({
	 	    		 url : "/pension/dateDescPriceSort?startDate=${startDate}&endDate=${endDate}",
	 	    		 data : {
	 	    			 "startDate" : startDate,
	 	        		  "endDate" : endDate	
	 	    		 },
	 	    		 type : "post",
	 	    			 success : function(result) {    			   
	 		    		   		var $body = $("#test_first");
	 		    	            $body.html("");
	 		    	            $("#test_first").html(result); 
	 		    		   }   
	 	    	  });
	    	  }else {
	    		  $.ajax({
		    		   url : "/pension/categoryDescPriceSort?startDate=${startDate}&endDate=${endDate}",
		    		   data : {
		    	            "swimming" : swimming,
		    	            "barbecue" : barbecue,
		    	            "sing" : sing,
		    	            "park" : park,
		    	            "convenienceStore" : convenienceStore,
		    	            "smokingRoom" : smokingRoom,
		    	            "dog" : dog,
		    	            "handicapPerson" : handicapPerson,
		    	            "cook" : cook,
		    	            "breakfast" : breakfast,
		    	            "wifi" : wifi,
		    	            "aircon" : aircon,
		    	            "refrigerator" : refrigerator,
		    	            "bathtub" : bathtub,
		    	            "dry" : dry,
		    	            "tv" : tv,
		    	            "startDate" : startDate,
		    	            "endDate" : endDate
		    	         },
		    		   type : "post",
		    		   success : function(result) {		
		    			   console.log("성공!");
		    			   console.log(result);
		    		   		var $body = $("#test_first");
		    	            $body.html("");
		    	            $("#test_first").html(result); 
		    		   }
		    	   
		    	 });
	      }
	      
	      }
}
  



</script>

<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/assets/js/popper.min.js"></script>
<script src="/resources/assets/js/bootstrap.min.js"></script>
<script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
<script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
<script src="/resources/assets/js/script.js"></script>
</html>