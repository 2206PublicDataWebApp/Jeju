<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>숙소 등록</title>
<link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
<link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
<link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/assets/css/all.min.css">
<link rel="stylesheet" href="/resources/assets/css/animate.css">
<link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
<style>
	span.guide {
		display : none;
		font-size : 12px;
		top : 12px;
		right : 10px;
	}
	span.ok { color : green}
	span.error {color : red}
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
                <h2>숙소 등록</h2>
                <ul>
                    <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                    <li><i class="fas fa-angle-double-right"></i> 숙소 등록</li>
                </ul>
            </div>
        </div>
    </div>

          <!--*************** About Us Starts Here ***************-->
   <form action="/pension/regist" method="post" enctype="multipart/form-data">
   <input type="hidden" name="memberId" value="${sessionScope.loginUser.memberId }">
   <section id="about" class="contianer-fluid about-us">
       <div class="container">
            <div class="row">
                <div class="col-md-5 center image">
                    <img src="/resources/images/PhotoAdd1.png" alt="펜션 사진"><br>
                    <input type="file" class="form-control" name="uploadFile">
                </div>
                <div class="col-md-7 text">
                	<h5>숙소 이름</h4>
                    <input class="form-control form-control-lg" type="text" name="pensionName" placeholder="숙소 이름을 입력해주세요." id="pensionName" oninput="checkName()" required>
                    <span class="guide ok">사용 가능한 숙소 이름입니다.</span>
                    <span class="guide error">이미 사용중인 숙소 이름입니다.</span>
                    <br><br>
                    <h5>숙소 소개</h4>
                    <textarea class="form-control" name="pensionComments" rows="10" cols="50" style="resize:none" placeholder="숙소 소개를 입력해주세요." required></textarea>
                    <br><br>
                    <h5>편의시설</h4>
                    <p>
	                    수영장 <input type="checkbox" name="swimming" value="1"> 
	                    바베큐 <input type="checkbox" name="barbecue" value="1">
	                    노래방 <input type="checkbox" name="sing" value="1">
	                    주차장 <input type="checkbox" name="park" value="1">
                    </p>
                    <p>
	                    편의점 <input type="checkbox" name="convenienceStore" value="1"> 
	                    흡연 <input type="checkbox" name="smokingRoom" value="1">
	                    애완동물 동반 <input type="checkbox" name="dog" value="1">
	                    장애인 편의시설 <input type="checkbox" name="handicapPerson" value="1">
                    </p>
                    <p>
	                    객실 내 취사 <input type="checkbox" name="cook" value="1"> 
	                    조식 <input type="checkbox" name="breakfast" value="1">
	                    와이파이 <input type="checkbox" name="wifi" value="1">
	                    에어컨 <input type="checkbox" name="aircon" value="1">
                    </p>
                    <p>
	                    냉장고 <input type="checkbox" name="refrigerator" value="1"> 
	                    욕조 <input type="checkbox" name="bathtub" value="1">
	                    드라이기 <input type="checkbox" name="dry" value="1">
	                    TV <input type="checkbox" name="tv" value="1">
                    </p>
                    <br>
                    <h5>이용 규칙</h4>
                    <div class="form-floating">
                        <label for="floatingSelect">체크인</label>
                        <select class="form-select" id="checkIn" aria-label="Floating label select example" name="pensionCheckin">                              
                          <option selected value="9">09시</option> <option value="10">10시</option>                           
                          <option value="11">11시</option> <option value="12">12시</option>
                          <option value="13">13시</option> <option value="14">14시</option>
                          <option value="15">15시</option> <option value="16">16시</option>
                          <option value="17">17시</option> <option value="18">18시</option>
                          <option value="19">19시</option> <option value="20">20시</option>
                          <option value="21">21시</option>
                        </select>                           
                    </div>
                    <div class="form-floating">
                        <label for="floatingSelect">체크아웃</label>
                        <select class="form-select" id="checkOut" aria-label="Floating label select example" name="pensionCheckout">
                            <option selected value="9">09시</option> <option value="10">10시</option>                           
                            <option value="11">11시</option> <option value="12">12시</option>
                            <option value="13">13시</option> <option value="14">14시</option>
                            <option value="15">15시</option> <option value="16">16시</option>
                            <option value="17">17시</option> <option value="18">18시</option>
                            <option value="19">19시</option> <option value="20">20시</option>
                            <option value="21">21시</option>
                        </select>                           
                    </div>
                </div>
            </div>
       </div><br><br>
       <hr>
   </section>
        <div class="destinations container-fluid">
        <div class="row session-title"><h2>주소</h2></div>
   		<div>
	   		<input class="form-control form-control-lg" type="text" id="sample5_address" placeholder="주소를 입력해주세요." name="pensionAddr" required>
	   		위도<input class="form-control form-control-lg" type="text" placeholder="위도를 입력해주세요." name="hardness" required>
	   		경도<input class="form-control form-control-lg" type="text" placeholder="경도를 입력해주세요." name="latitude" required>
   		</div>
   		<div style="text-align: center;">
			<input class="btn btn-outline-success" type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br><br><br>
   		</div>
		<div id="map" style="width:1420px;height:400px;margin-top:10px;display:none"></div><br><br><br><br><hr>
            <div class="container">               
                <div class="row session-title"><h2>객실</h2></div>   
                <div style="text-align: center; margin-bottom: 100px;">
                    <input type="button" class="btn btn-outline-success roomAdd" value="객실 추가">
                </div>
                 <div class="dest-row row roomPlus">
                     <div class="col-lg-4 col-md-6">
                         <div class="dest-col ">
                             <div class="dest-img ">
                                 <img src="/resources/images/PhotoAdd1.png" alt="객실 사진">
                             </div>
                                 <input type="file" class="form-control" name="uploadRoomFile">
                             <input class="form-control form-control-lg" type="text" placeholder="객실명을 입력해주세요." name="roomName" required>
                             <div class="form-floating">
                                <label for="floatingSelect">최대인원</label>
                                <select class="form-select" id="maxPersonnel" aria-label="Floating label select example" name="maxPersonnel">                              
                                  <option selected value="1">1명</option> <option value="2">2명</option>                           
                                  <option value="3">3명</option> <option value="4">4명</option>
                                  <option value="5">5명</option> <option value="6">6명</option>
                                  <option value="7">7명</option> <option value="8">8명</option>
                                  <option value="9">9명</option> <option value="10">10명</option>
                                  <option value="11">11명</option> <option value="12">12명</option>
                                  <option value="13">13명</option> <option value="14">14명</option>
                                  <option value="15">15명</option>
                                </select>                           
                            </div>
                             <p>₩ <input type="text" placeholder="숫자만 입력해주세요." name="price" required> x 박</p>
                         </div>
                     </div>
                 </div>
            </div>
        </div>
        </div>
        </div>
        <div>
            <div style="text-align: center; margin-bottom: 100px;">
            <input type="submit" class="btn btn-outline-success" value="등록">
            </div>
        </div>
        </form>
        
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
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ce0b65b35053a74c5f16b289cf432142&libraries=services"></script>
    <script>
        $(function() {
            $(".roomAdd").click(function() {
                $(".roomPlus").
                append("<div class='col-lg-4 col-md-6'> <div class='dest-col '> <div class='dest-img '> <img src='/resources/images/PhotoAdd1.png'></div><br><input type='text' placeholder='객실명을 입력해주세요.' name='roomName'><br><br><div class='form-floating'><label for='floatingSelect'>최대인원</label><select class='form-select' id='maxPersonnel'name='maxPersonnel' aria-label='Floating label select example'><option selected value='1'>1명</option> <option value='2'>2명</option><option value='3'>3명</option> <option value='4'>4명</option><option value='5'>5명</option> <option value='6'>6명</option><option value='7'>7명</option> <option value='8'>8명</option><option value='9'>9명</option> <option value='10'>10명</option><option value='11'>11명</option> <option value='12'>12명</option><option value='13'>13명</option> <option value='14'>14명</option><option value='15'>15명</option></select></div><p>₩ <input type='text' placeholder='숫자만 입력해주세요.' name='price'> x 박</p></div></div>");
            })
        })
        
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
    
    function checkName() {
    	var pensionName = $("#pensionName").val();
    	$.ajax({
    		url : "/pension/checkPensionName",
    		data : {"pensionName" : pensionName},
    		type : "get",
    		success : function(result){
    			if(result != 1 && pensionName.length > 0) {
    				$(".ok").css("display", "inline-block");
    				$(".error").css("display", "none");
    			}else if(result == 1 && pensionName.length > 0){
    				$(".error").css("display", "inline-block");
    				$(".ok").css("display", "none");
    			}else{
    				$(".error").css("display", "none");
    				$(".ok").css("display", "none");
    			}
    		},
    		error : function() {
    			alert("오류입니다.");
    		}
    	})
    }
    </script>
</html>
