<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>숙소 상세 페이지</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ce0b65b35053a74c5f16b289cf432142"></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
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
                           <li><a href="destinations.html">커뮤니티</a></li>
                           <li><a href="/mypage/myPage">마이페이지</a></li>
                       </ul>
                   </div>
               </div>
           </div>
        </header>   
        
 <!--  ************************* Page Title Starts Here ************************** -->
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>숙소 상세 페이지</h2>
                <ul>
                    <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                    <li><i class="fas fa-angle-double-right"></i> 숙소 상세 페이지</li>
                </ul>
            </div>
        </div>
    </div>

    <!--*************** About Us Starts Here ***************-->
   
   <section id="about" class="contianer-fluid about-us">
       <div class="container">
            <div class="row">
                <div class="col-md-5 center image">
                    <img src="${pension.filePath }" alt=""><br><br><br>
                    <form action="/jjim/jjim" method="post" style="display: inline">
		            	<input type="hidden" name="memberId" value="${sessionScope.loginUser.memberId }"/>
		                <input type="hidden" name="pensionNo" value="${pension.pensionNo }"/>
		            	<button type="submit" class="btn btn-danger"><i class="fa-solid fa-heart fa-2x">찜 ${pension.jjimCount }</i></button>
		          	</form>
                </div>
                <div class="col-md-7 text">
                    <h1>${pension.pensionName }</h1>
                    <hr>
                    <br>
                    <h3>숙소 소개</h3><br>
                    <p>${pension.pensionComments } </p>
                    <br><hr>
                    <h3>편의시설</h3><br>
                    <c:forEach items="${category }" var="category">
                    	<c:if test="${category.swimming eq 1 }"><p>수영장</p></c:if>
                    	<c:if test="${category.barbecue eq 1 }"><p>바비큐</p></c:if>
                    	<c:if test="${category.sing eq 1 }"><p>노래방</p></c:if>
                    	<c:if test="${category.park eq 1 }"><p>주차장</p></c:if>
                    	<c:if test="${category.convenienceStore eq 1 }"><p>편의점</p></c:if>
                    	<c:if test="${category.smokingRoom eq 1 }"><p>흡연</p></c:if>
                    	<c:if test="${category.dog eq 1 }"><p>애견동반</p></c:if>
                    	<c:if test="${category.handicapPerson eq 1 }"><p>장애인 편의시설</p></c:if>
                    	<c:if test="${category.cook eq 1 }"><p>객실 내 취사</p></c:if>
                    	<c:if test="${category.breakfast eq 1 }"><p>조식</p></c:if>
                    	<c:if test="${category.wifi eq 1 }"><p>와이파이</p></c:if>
                    	<c:if test="${category.aircon eq 1 }"><p>에어컨</p></c:if>
                    	<c:if test="${category.refrigerator eq 1 }"><p>냉장고</p></c:if>
                    	<c:if test="${category.bathtub eq 1 }"><p>욕조</p></c:if>
                    	<c:if test="${category.dry eq 1 }"><p>드라이기</p></c:if>
                    	<c:if test="${category.tv eq 1 }"><p>TV</p></c:if>
                    </c:forEach>
                    <br><hr>
                    <h3>이용 규칙</h4><br>
                    <p>체크인 : ${pension.pensionCheckin }시 </p>
                    <p>체크아웃 : ${pension.pensionCheckout }시 </p>
                </div>
            </div>
       </div>
       <hr>
   </section>
      
        <!--  *************************Our Team Start Here ************************** -->
  <div class="destinations container-fluid">
  	<div class="row session-title"><h2>주소</h2></div>
  	<div style="text-align:center"><h4>${pension.pensionAddr }</h2></div>
	<div id="map" style="width:1420px;height:400px;margin-top:10px;display:block"></div><br><br><br><br><hr>
    <div class="container">               
    	<div class="row session-title">
        	<h2>객실 안내</h2>
        </div>  
        <div class="dest-row row">
        	<c:forEach items="${rList }" var="room">
            	<div class="col-lg-4 col-md-6">
                    <div class="dest-col">
                        <div class="dest-img">
                            <img src="${room.roomAttach.roomPath }" alt="객실 사진">
                        </div>
                        <h3>${room.roomName }</h3>
                        <p>최대인원 0명</p>
                        <p>₩ ${room.price } x 박</p>
                        <a class="btn btn-outline-success" href="/reservation/list?refPensionNo=${room.refPensionNo }&roomNo=${room.roomNo}&startDate=${startDate}&endDate=${endDate}&price=${room.price}">예약하기</a>
                    </div>
                </div>
          	</c:forEach>
           </div>
      </div>
   </div>
   <section class="customer-serv">
      <div class="container">
          <div class="row session-title">
              <h2>★ 후기 ${reviewList[0].reviewCount}개</h2>
          </div>
          <div class="row ro-clo">                    
              <div class="col-12  col-md-6 col-lg-4">
                  <div class="shado-2 card-b">
                      <p>${reviewList[0].reviewContents }</p>
                  </div>
                  <div class="cust-det row">
                      <div class="col-sm-3 col-3 img-circl">
                          <img alt="" src="/resources/assets/images/testimonial/member.jpg">
                      </div>
                      <div class="col-sm-5 col-5 an-mtc no-padding">
                          <b>작성일</b>
                          <p>${reviewList[0].regDate }</p>
                      </div>                
                  </div>
              </div>                    
              <div class="col-12  col-md-6 col-lg-4">
                  <div class="shado-2 card-b">
                  	<p>${reviewList[1].reviewContents }</p>
                  </div>
                  <div class="cust-det row">
                      <div class="col-sm-3 col-3 img-circl">
                          <img alt="" src="/resources/assets/images/testimonial/member.jpg">
                      </div>
                      <div class="col-sm-5 col-5 an-mtc no-padding">
                          <b>작성일</b>
                          <p>${reviewList[1].regDate }</p>
                      </div>                
                  </div>
              </div>
              <div class="col-12  col-md-6 col-lg-4">
                  <div class="shado-2 card-b">
                  	<p>${reviewList[2].reviewContents }</p>
                  </div>
                  <div class="cust-det row">
                      <div class="col-sm-3 col-3 img-circl">
                          <img alt="" src="/resources/assets/images/testimonial/member.jpg">
                      </div>
                      <div class="col-sm-5 col-5 an-mtc no-padding">
                          <b>작성일</b>
                          <p>${reviewList[2].regDate }</p>
                      </div>                
                  </div>
              </div>     
          </div>
          <button type='button' class='btn btn-xs btn-success' data-toggle='modal' data-target='#modifyModal'>
			  더 보기
		  </button>
		  <div class="modal fade" id="modifyModal" role="dialog">
				  <div class="modal-dialog">
				      <div class="modal-content">
				          <div class="modal-header">
				              <button type="button" class="close" data-dismiss="modal">&times;</button>
				              <h4 class="modal-title">후기 ${reviewList[0].reviewCount }개</h4>
				          </div>
				          <div class="modal-body">
				          <c:forEach items="${reviewList }" var="review">
				                  <div class="shado-2 card-b">
				                  <p>${review.reviewContents }</p>
				                  </div>
				                  <div class="cust-det row">
				                      <div class="col-sm-3 col-3 img-circl">
				                          <img alt="" src="/resources/assets/images/testimonial/member.jpg">
				                      </div>
				                      <div class="col-sm-5 col-5 an-mtc no-padding">
				                          <b>작성일</b>
				                          <p>${review.regDate }</p>
				                      </div>                
				                  </div><br><hr>
				          	</c:forEach>
				          </div>
				          <div class="modal-footer">
				              <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
				          </div>
				      </div>
				  </div>
			</div>             
      </div>
  </section>    
  </div>
  <div>
      <div style="text-align: center; margin-bottom: 100px;">
          <a class="btn btn-outline-success" href="/pension/list" >목록으로</a>
      </div>
  </div>
        
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
    <script src="/resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};
		var map = new kakao.maps.Map(container, options);
	</script>
</html>