<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>숙소 목록</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <style>
        #margin_test {
            margin-bottom: 50px;
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
            margin-bottom: 15px;
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
                            <img src="/resources/assets/images/logo.png" alt="">
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
                           <li><a href="/notice/list">공지사항</a></li>
                           <li><a href="/pension/list">숙소 리스트</a></li>
                           <li><a href="#">커뮤니티</a></li>
                           <li><a href="/myPage/myPage">마이페이지</a></li>
                       </ul>
                   </div>
               </div>
           </div>
            
        </header>   
        
        
 <!--  ************************* Page Title Starts Here ************************** -->
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
				<div class="col-12">
					<form class="form mt-1" action="/pension/list" name="filterFrm">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-3 py-2">
								<h5 class="my-2 pl-2" id="test9">
									<i class="far fa-calendar-alt"></i>
									예약날짜 선택 :
								</h5>
							</div>
							<div class="col-sm-12 col-md-6 col-lg-5">
								<input type="text" class="form-control my-2 text-center" id="daterange" readonly>
								<input type="hidden" class="form-control my-2" name="startDate" value="${startDate}" readonly>
								<input type="hidden" class="form-control my-2" name="endDate" value="${endDate}" readonly>
							</div>
							<div class="col-sm-12 col-md-6 col-lg-4">
								<input type="submit" class="btn btn-info btn-block my-2" value="Search">
							</div>
						</div>
					</form>
				</div>
			</div>
        </div>
    </div>
       
          <!--*************** About Us Starts Here ***************-->
   
   <section id="about" class="contianer-fluid about-us">
       <div class="container" id="test5">
            <div class="row">
				<div class="col-md-8 center image">
					<hr id="margin_test">
					<div class="row g-0 position-relative test2" id="test_first">
					
					<c:if test="${!empty pList }">
						<c:forEach items="${pList }" var="pension" >				
									<div class="col-md-4 mb-md-0 p-md-2" id="tableBody1">
										<img src="${pension.filePath}" alt="Image" class="img-fluid">
									</div>
									<div class="col-md-6 p-4 ps-md-0" id="tableBody2">
										<ul class="modify">
											<li class="test4"><h2 style="font-size : 25px;"><a href="/pension/detailView?pensionNo=${pension.pensionNo }">${pension.pensionName }</a></h2></li>
											<li class="test4">${pension.pensionAddr }</li>
											<li class="test4">${pension.pensionPrice }</li>
											<li class="test4">리뷰 364</li>
										</ul>
									</div>
							</c:forEach>
						</c:if>
					</div>
				</div>

				<div class="col-md-4 text" id="test3">
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
						<h3 class="heading" style="margin-bottom: 25px;">Popular Posts</h3>
						<div class="post-entry-sidebar" >
                            <ul>${rList }
								<c:forEach items="${rList }" var="rank" varStatus="i">
									<li style="margin-bottom: 25px;"><img
										src="${rank.filePath }"
										alt="Image placeholder" class="me-4 rounded"
										style="width: 130px; height: 130px;">
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
    	function getPensionList() {
    		$.ajax({
    			url : "/pension/list",
    			type : "get",
    			success : function(success) {
    				
    			}
    		});
    	}
    
   	
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
    		console.log(all);
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
    					"tv" : tv
        			},
        			type : "post",
        			success : function(cList) {
        				var $body = $("#test_first");
        				var $body1 = $("#tableBody1");
        				var $body2 = $("#tableBody2");
        				$body.html("");
        				if(cList != null) {
        					for(var i in cList) {
    	    					var $divImg1 = $("<div class='col-md-4 mb-md-0 p-md-2' id='tableBody1'>");
    	    					var $divImg2 = $("<div class='col-md-6 p-4 ps-md-0' id='tableBody2'>");
    							var $img = $("<img alt='Image' class='img-fluid'>");
    							$img.attr("src", cList[i].filePath);
    	    					var $ul = $("<ul class='modify'>");
    							var $liName = $("<li class='test4'>").append("<h2>").text(cList[i].pensionName);
    							var $liAddr = $("<li class='test4'>").text(cList[i].pensionAddr);
    							var $liPrice = $("<li class='test4'>").text(cList[i].pensionPrice);
    							var $liName = $("<li class='test4'>").text("리뷰 364");				
    							$divImg1.append($img);
    							$ul.append($liName);
    							$ul.append($liAddr);
    							$ul.append($liPrice);
    							$ul.append($liName);
    							$divImg2.append($ul);
    							$body.append($divImg1);
    							$body.append($divImg2);    							
        					}
        				}
        			},
        			error : function() {
        				alert("서버 요청 실패!");
        			}
        		});
    	    	
    	}

    </script>

    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>

