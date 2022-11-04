<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>제주어때 예약페이지</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
	<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<link rel="stylesheet" href="/resources/assets/css/reservationStyle.css">   
	<style>
		.modal-title{
 font-size: 17px;
 text-align:left;
 font-weight: bold;
}
.modal_table{
  width:100%;
}
#modal_userImg{
  width:170px;
  height:80px;
  margin-right : 180px;
/*   border-radius: 75%; */
}
#modal_userId{
  width:200px;
}
#modal_userFollow{
  margin:10px;
  text-align: right;
}

	</style>
</head>
    <body>
         <header class="container-flui">
		<div class="header-top">
			<div class="container">
				<div class="row">

					<div class="col-md-4 d-none d-md-block mail-detail"></div>
					<div class="col-md-4 logo">
						<img src="/resources/assets/images/logo.png" alt=""> <a
							data-toggle="collapse" data-target="#menu-jk" href="#menu-jk"><i
							class="fas d-block d-sm-block d-md-none small-menu fa-bars"></i></a>
					</div>
					
					<div class="col-md-4 d-none d-md-block social-link ">
						<c:if test="${empty sessionScope.loginUser  }">
							<div class="login-area">
								<table align="right">
									<tr>
										<td rowspan="2">
											<button onclick="location.href='/member/loginView.kh'"
												class="btn btn-primary">로그인</button>
											<button onclick="location.href='/member/joinView.kh'"
												class="btn btn-secondary">회원가입</button>
										</td>
									</tr>
								</table>
							</div>
						</c:if>
						<c:if test="${not empty sessionScope.loginUser }">
							<table align="right">
								<tr>
									<td><a href="/">${sessionScope.loginUser.memberId }</a>님
										환영합니다</td>
								</tr>
								<tr>
									<td><a href="/member/logout.kh">로그아웃</a></td>
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
                           <li><a href="/home">홈</a></li>
                           <li><a href="/notice/list">공지사항</a></li>
                           <li><a href="/pension/list">숙소 리스트</a></li>
                           <li><a href="/community/chat">커뮤니티</a></li>
                           <li><a href="/mypage/myPage">마이페이지</a></li>
                           <li><a href="/admin/adminPage">관리자페이지(임시)</a></li>
                       </ul>
                   </div>
               </div>
           </div>
        </header>      

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

    <div class="row contact-rooo no-margin">
        
        <div class="container">
        	<br>
            <hr>
            <div class="row">


                <div style="padding:20px; margin-bottom : -50px; height : " class="col-sm-9" >
                    <div id="reserveInfo">예약자 정보</div>
                    <div class="row cont-row info">
                        <div class="col-sm-3 reserve"><label>예약자 이름</label></div>
                    </div>
                    <div class="col-sm-8 inputInfo1" style="display: inline-block; ">
	                    <input type="text" placeholder="체크인시 필요한 정보입니다." name="memberName" class="form-control input-sm" id="nameChk"> 	                    
                    </div>
                      <span id="successNameChk" style="font-size : 13px;"></span>     
                    <div  class="row cont-row info" id="info2">
                        <div  class="col-sm-3 reserve"><label>휴대폰 번호 (비회원)</label></div>   
                    </div>
                    <div class="col-sm-8 inputInfo" style="display: inline-block; ">
                        <input type="text" id="phone" name="memberPhone" placeholder="전화번호를 입력해주세요." class="form-control input-sm"> 
                         
                    </div>
                    <button id="phoneChk" class="btn btn-info btn-md-4 doubleChk">인증번호 보내기</button>
                    <div class="col-sm-4 inputInfo" style="display: inline-block; ">
                        <input type="text" name="phone2" id="phone2" placeholder="인증번호를 입력해주세요." class="form-control input-sm" disabled required> 
                         
                    </div>
                    <button id="phoneChk2" class="btn btn-info btn-md-4 doubleChk" style="display : none">본인인증</button>
                    <span class="point successPhoneChk" style="color : red; font-size : 13px;">휴대폰 번호 입력후 인증번호 보내기를 눌러주세요.</span>
                    <div>
                     
                        
			<input type="hidden" id="phoneDoubleChk"/>
			</div>
			
                    <div  class="row cont-row info3">
                        <div  class="col-sm-3 reserve"><label>등급 할인</label></div>
                    </div>
                    <div class="myGrade">나의 등급(플래티넘)</div>
                    <div class="myGrade" style="display: inline-block;">할인할 수 있는 금액 : <span id="price1">-300,000원</span></div>
                    <button class="btn btn-info btn-sm" style="font-size: 8px;">할인 적용</button>
                    <br>
                    <div class="myGrade" style="display: inline-block;">쿠폰 적용 : <span id="price2">0</span></div>
                    <button class="btn btn-info btn-sm follower" style="font-size: 8px;">쿠폰 선택</button>


					<div class="modal fade" id="followModal" role="dialog">
						<div class="modal-dialog">
							<!-- 모달창-->
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title"></h4>
									<button type="button" class="close" id="modalClose"
										data-dismiss="modal">×</button>
								</div>
								<c:if test="${!empty cList}">
									<c:forEach items="${cList }" var="mycoupon" varStatus="i">
										<div class="modal-body">
											<table class="modal_table">
												<tr>
													<td style="width: 70px;"><img id="modal_userImg"
														src="${mycoupon.couponImage }"></td>
													<td id="modal_userID"
														style="font-weight: bold; font-size: 22px;">${mycoupon.couponTitle }</td>
													<td id="modal_userFollow">
														<button class="btn btn-outline-primary codeBtn"
															value="${mycoupon.salePrice}"
															onclick="applyCoupon(this, '${mycoupon.couponCode}');">
															적용</button>
													</td>
												</tr>
											</table>
										</div>
									</c:forEach>
								</c:if>
								<div id="count" value="1"></div>
							</div>
						</div>
					</div>



					<br>
                    
               		<c:if test="${sessionScope.loginUser eq null }">
					<div style="margin-top: 10px;" class="row">
						<div style="text-align: center; background-color: lightblue;"
							class="col-sm-9">
							<br>
							<div class="login">로그인 후 예약하시면</div>
							<div class="login">등급할인이 적용됩니다.</div>
							<a href="/member/loginView.kh"><div class="login" style="margin-top: 10px;">로그인</div></a>
							<br>
						</div>
					</div>
					</c:if>
					<c:if test="${not empty sessionScope.loginUser}">
					<div style="margin-top: 10px;" class="row">
						<div style="text-align: center; background-color: lightblue;"
							class="col-sm-9">
							<br>
							<div class="login">숙소를 예약하기전</div>
							<div class="login">등급할인 혜택을 누려보세요!</div>
 							<div class="login" style="margin-top: 10px;">나의 등급</div>
							<br>
						</div>
					</div>
					</c:if>					
                </div>
                
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                    <c:if test="${!empty p }">
                    	<h5 class="card-title">숙소이름</h5>
                      <p class="card-text">${p.pensionName }</p>
                      <br>
                       </c:if>  
                       <c:if test="${!empty r }">
                      <h5 class="card-title">객실 타입 / 기간</h5>
                      <p class="card-text">${r.roomName }</p>
                      <br>
                      <h5 class="card-title">체크인</h5>
                      <p class="card-text">${startDate1 }월 ${startDate2 }일 15:00시</p>
                      <br>
                      <h5 class="card-title">체크 아웃</h5>
                      <p class="card-text">${endDate1 }월 ${endDate2 }일 11:00시</p>
                      <hr>
                      <h5 class="card-title">총 결제 금액</h5>
                      <h5 class="card-title" id="price" value="${price }">${price }원</h5>
                      <ul>
                        <li class="test15">ㆍ결제완료 후 내 정보에서 예약 내</li>
                        <li style="margin-left: 16px;" class="test15">역을 확인해주세요.</li>
                      </ul>
					</c:if>
                    </div>
                    
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" id="button1" title="결제하기 버튼">결제하기</li>
                      <li class="list-group-item" id="button2">나중에 결제<div>(회원만 가능)</div></li>   
                    </ul>

                  </div>
<!--                   <div id="check1"></div> -->
	
		<ul style="position : relative; bottom : 30px;">
			<li id="check1">이용 약관</li>
			<li class="check6"><input type="checkbox" onclick="checkAll();" id="allCheck"><span
				class="check7"><label for="allCheck">전체동의</label></span></li>
			<li class="check6"><input id="agreement1" type="checkbox" name="agreement1" class="agree1"><span class="check7 closed"
				onclick="clickshow(this,'categories1');"><label for="agreement1">개인정보 수집/이용 동의</label></span><span
				class="test5">(필수)</span><span id="successChk1" style="font-size : 13px; margin-left : 5px;"></span></li>
			
			<div>
				<fieldset id="categories1" style="display: none;">
				<div>
					<div class="content">
					<p>
<textarea style="font-size: 4px; width : 600px; height : 100px;" >						
Ⅰ. 개인정보의 수집 및 이용 동의서
 - 이용자가 제공한 모든 정보는 다음의 목적을 위해 활용하며, 하기 목적 이외의 용도로는 사용되지 않습니다.
① 개인정보 수집 항목 및 수집·이용 목적
 가) 수집 항목 (필수항목)
- 성명(국문), 주민등록번호, 주소, 전화번호(자택, 휴대전화), 사진, 이메일, 나이, 재학정보, 병역사항,
외국어 점수, 가족관계, 재산정도, 수상내역, 사회활동, 타 장학금 수혜현황, 요식업 종사 현황 등 지원
신청서에 기재된 정보 또는 신청자가 제공한 정보
 나) 수집 및 이용 목적
- 하이트진로 장학생 선발 전형 진행
- 하이트진로 장학생과의 연락 및 자격확인
- 하이트진로 장학생 자원관리
 ② 개인정보 보유 및 이용기간
 - 수집·이용 동의일로부터 개인정보의 수집·이용목적을 달성할 때까지
 ③ 동의거부관리
 - 귀하께서는 본 안내에 따른 개인정보 수집, 이용에 대하여 동의를 거부하실 권리가 있습니다. 다만,
귀하가 개인정보의 수집/이용에 동의를 거부하시는 경우에 장학생 선발 과정에 있어 불이익이 발생할 수
있음을 알려드립니다

Ⅱ. 고유식별정보 처리 동의서
① 고유식별정보 수집 항목 및 수집·이용 목적
 가) 수집 항목 (필수항목)
- 주민등록번호
 나) 수집 및 이용 목적
- 하이트진로 장학생 선발 전형 진행
- 하이트진로 장학생과의 연락 및 자격확인
- 하이트진로 장학생 자원관리
 ② 개인정보 보유 및 이용기간
 - 수집·이용 동의일로부터 개인정보의 수집·이용목적을 달성할 때까지
 ③ 동의거부관리
 - 귀하께서는 본 안내에 따른 개인정보 수집, 이용에 대하여 동의를 거부하실 권리가 있습니다. 다만,
귀하가 개인정보의 수집/이용에 동의를 거부하시는 경우에 장학생 선발 과정에 있어 불이익이 발생할 수
있음을 알려드립니다.
</textarea>
						</p>
						</div>
				</div>
			</fieldset>
			</div>
			
			<li class="check6"><input id="agreement2" type="checkbox" name="agreement2"  class="agree2"><span class="check7 closed" onclick="clickshow(this,'categories2');" style="display : inline-block"><label for="agreement2">숙소 이용규칙 및 환불 규정</label></span><span
				class="test5">(필수)</span><span id="successChk2" style="font-size : 13px; margin-left : 5px;"></span></li>
			
			<div>
			<fieldset id="categories2" style="display: none;">
				<div>
					<div class="content">
					<p>
<textarea style="font-size: 4px; width : 600px; height : 100px;">				
표준 정책
표준 환불 정책은 단기 예약, 즉 숙박 기간이 28박 미만인 모든 예약에 적용됩니다.

유연 환불 정책: 게스트가 체크인 24시간 전까지 예약을 취소하면 전액 환불받을 수 있으며, 호스트에게는 대금이 지급되지 않습니다. 게스트가 체크인까지 24시간이 남지 않은 시점에 예약을 취소하고 숙소에 체크인하지 않으면, 호스트에게 첫 1박에 해당하는 대금이 지급됩니다. 체크인 시간이 지난 후에 예약을 취소하는 경우, 이미 숙박한 날짜의 숙박비 전액과 추가 1박 요금이 호스트에게 지급됩니다.
일반 환불 정책: 게스트가 체크인 5일 전까지 예약을 취소하면 전액 환불받을 수 있으며, 호스트에게는 대금이 지급되지 않습니다. 그 후에 취소하는 경우, 이미 숙박한 날짜의 숙박비 전액과 추가 1박 요금 및 남은 숙박 일수에 대한 숙박비 50%가 호스트에게 지급됩니다.
비교적 엄격 환불 정책: 게스트는 체크인까지 30일 이상 남은 시점에 예약을 취소해야 전액 환불을 받을 수 있습니다. 또한 체크인까지 14일 이상 남았다면, 예약 후 48시간 이내에 취소하는 경우 전액 환불받을 수 있습니다. 체크인까지 7~30일이 남은 시점에 예약을 취소하면, 숙박비 50%가 호스트에게 지급됩니다. 체크인까지 7일이 채 남지 않은 시점에 예약을 취소하면, 숙박비 전액이 호스트에게 지급됩니다.
엄격 환불 정책: 게스트는 예약 후 48시간 이내에 취소하고 체크인까지 14일 이상이 남은 경우에만 전액 환불을 받을 수 있습니다. 체크인까지 7~14일이 남은 시점에 예약을 취소하면, 숙박비 50%가 호스트에게 지급됩니다. 그 후에 취소하는 경우, 숙박 대금 전액이 호스트에게 지급됩니다.
장기 숙박 정책
장기 숙박 환불 정책은 연속 28박 이상의 예약에 적용되며, 표준 정책보다 우선합니다.

유연한 장기 숙박 환불 정책: 게스트는 체크인 30일 전까지 취소한 경우에만 전액 환불을 받을 수 있습니다. 그 후에 취소하는 경우, 이미 숙박한 날짜의 숙박비 전액과 30일만큼의 추가 숙박비가 호스트에게 지급됩니다. 게스트가 예약을 취소하는 시점에 남은 숙박 일수가 30일 미만이라면, 남은 숙박일 전체에 대한 숙박비가 호스트에게 지급됩니다.
엄격한 장기 숙박 환불 정책: 게스트는 예약 후 48시간 이내 및 체크인 28일 전까지 취소한 경우에만 전액 환불을 받을 수 있습니다. 그 이후에 예약을 취소하는 경우, 이미 숙박한 날짜의 숙박비와 더불어 취소일로부터 30일만큼의 추가 숙박비가 호스트에게 지급됩니다. 남은 숙박 일수가 30일 미만인 예약을 취소하면, 남은 숙박 일수에 대한 숙박비 100%가 호스트에게 지급됩니다.			
</textarea>
						</p>


						</div>
				</div>
			</fieldset>				
			</div>
			
			<li class="check6" ><input id="agreement3" type="checkbox" name="agreement3"  class="agree3"><span class="check7 closed" onclick="clickshow(this,'categories3');"><label for="agreement3">만 14세 이상 확인</label></span><span
				class="test5">(필수)</span><span id="successChk3" style="font-size : 13px; margin-left : 5px;"></span></li>
			
			<div>
			<fieldset id="categories3" style="display: none;">
				<div>
					<div class="content">
					<p>
<textarea style="font-size: 4px; width : 600px; height : 100px;">				
 사이트 운영자는 만 14세 미만의 아동으로부터 개인정보 수집·이용·제공 등의 동의를 받으려면 법정대리인의 동의를 받아야 하고, 다음의 어느 하나에 해당하는 방법으로 법정대리인이 동의하였는지를 확인해야 합니다(「개인정보 보호법」 제39조의3제4항 및 「개인정보 보호법 시행령」 제48조의3제1항).
 동의 내용을 게재한 인터넷 사이트에 법정대리인이 동의 여부를 표시하도록 하고 정보통신서비스 제공자등이 그 동의 표시를 확인했음을 법정대리인의 휴대전화 문자메시지로 알리는 방법
 동의 내용을 게재한 인터넷 사이트에 법정대리인이 동의 여부를 표시하도록 하고 법정대리인의 신용카드·직불카드 등의 카드정보를 제공받는 방법
 동의 내용을 게재한 인터넷 사이트에 법정대리인이 동의 여부를 표시하도록 하고 법정대리인의 휴대전화 본인인증 등을 통해 본인 여부를 확인하는 방법
 동의 내용이 적힌 서면을 법정대리인에게 직접 발급하거나, 우편 또는 팩스를 통하여 전달하고 법정대리인이 동의 내용에 대하여 서명날인 후 제출하도록 하는 방법
 동의 내용이 적힌 전자우편을 발송하여 법정대리인으로부터 동의의 의사표시가 적힌 전자우편을 전송받는 방법
 전화를 통하여 동의 내용을 법정대리인에게 알리고 동의를 얻거나 인터넷주소 등 동의 내용을 확인할 수 있는 방법을 안내하고 재차 전화 통화를 통하여 동의를 얻는 방법
 그 밖에 위의 규정에 따른 방법에 준하는 방법으로 법정대리인에게 동의 내용을 알리고 동의의 의사표시를 확인하는 방법
 사이트 운영자는 개인정보 수집 매체의 특성상 동의 내용을 전부 표시하기 어려운 경우 법정대리인에게 동의 내용을 확인할 수 있는 방법(인터넷주소·사업장 전화번호 등)을 안내할 수 있습니다(「개인정보 보호법 시행령」 제48조의3제2항).
 사이트 운영자는 만 14세 미만의 아동에게 개인정보 처리와 관련한 사항의 고지 등을 하는 때에는 이해하기 쉬운 양식과 명확하고 알기 쉬운 언어를 사용해야 합니다(「개인정보 보호법」 제39조의3제5항).
 만 14세 미만의 아동은 개인정보 처리에 따른 위험성과 그로인해 초래될 수 있는 결과 및 이용자의 권리 등을 명확하게 인지하지 못할 수 있으므로 개인정보 보호위원회에서 이들을 보호하기 위한 방안을 마련하도록 하고 있습니다(「개인정보 보호법」 제39조의3제6항).
※ “개인정보 보호위원회”는 개인정보 보호를 강화해야 할 필요성이 커짐에 따라 분산되어 있던 개인정보보호 감독기능을 통합하여 개인정보와 관련된 일을 종합적으로 수행하기 위해 2020년 8월 5일 국무총리 소속 중앙행정기관으로 출범한 기관입니다(개인정보보호위원회 홈페이지 참조).
 위반할 경우
 법정대리인의 동의를 받지 않거나, 법정대리인이 동의했는지 확인하지 않고 만 14세 미만인 아동의 개인정보를 수집한 경우 5년 이하의 징역 또는 5천만원 이하의 벌금형에 처해집니다(「개인정보 보호법」 제71조제4호의6).
※ 14세 미만 아동의 개인정보를 수집하려면 부모님의 허락이 있어야 해요~~
(질문) 부모님 허락을 받지 않고 온라인 게임 사이트에 가입해서 게임을 했는데, 한달 후 요금이 아주 많이 나왔습니다. 어떻게 해야 하나요?
(답변) 14세 미만의 아동이 자신의 이름, 주민등록번호, 주소 같은 개인정보를 입력하고 인터넷 웹사이트에 회원으로 가입하려면 부모님(법정대리인)의 동의가 필요합니다. 따라서 온라인 게임과 같은 사이트에 회원으로 가입하려면 반드시 부모님(법정대리인)의 허락을 받아야 합니다.
 만약 부모님의 동의 없이 온라인 게임에 가입해서 요금이 많이 나온 경우라면 일단 부모님께 이 사실을 알리고 게임사이트에 연락해서 요금을 낼 수 없다고 할 수 있습니다.
부모님의 동의없이 미성년자가 체결한 계약은 취소할 수 있고[「소비자분쟁해결기준」(공정거래위원회 고시 제2021-7호, 2021. 5. 25. 발령·시행) 별표 2. 44. 인터넷콘텐츠업], 「민법」상 “취소”는 계약이 처음부터 없었던 것으로 보기 때문입니다(「민법」 제141조 본문).
 그러나 부모님 모르게 부모님의 주민등록번호 등을 이용해 회원 가입을 했거나 부모님께서 자녀가 온라인 게임 사이트에 회원 가입을 했다는 사실을 알고 계신 경우 등에는 요금을 돌려받을 수 없으므로 유의해야 합니다.
</textarea>
						</p>
						</div>
				</div>
			</fieldset>
			</div>	
		</ul>
                  
            </div>
            
        </div>

    </div>
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
   
    </body>
     <script>
     function checkAll() {
    	 if($("#allCheck").is(':checked')) {
    			$("input[type=checkbox]").prop("checked", true);
    		} else {
    			$("input[type=checkbox]").prop("checked", false);
    		}
     }
     
     var codeBtn2 = "";     
     //바로 결제
//      $("#phoneDoubleChk").val() == "true"
     $("#button1").click(function(){
 	    if($("#agreement1").prop("checked") && $("#agreement2").prop("checked") && $("#agreement3").prop("checked") && $("#nameChk").val() != null){
 	    		var price1 = $("#price").text().replace(",", "");
 	    		var price2 = price1.replace("원", "");
 	    		//가맹점 식별코드
 	     		IMP.init('imp28778843');
 	     		IMP.request_pay({
 	     		    pg : 'kcp',
 	     		    pay_method : 'card',
 	     		    merchant_uid : 'merchant_' + new Date().getTime(),
 	     		    name : '한재민' ,
// 		    		amount : price1,
					amount : '501',
 	     		    buyer_email : 'iamport@siot.do',
 	     		    buyer_name : $("#nameChk").val(),
 	     		    buyer_tel : $("#phone").val()
// 	      		    buyer_addr : '서울 강남구 도곡동',
// 	      		    buyer_postcode : '123-456'
 	     		},function(rsp) {
 	     			console.log(rsp);
 	     		    if ( rsp.success ) {
 	     		        msg += '고유ID : ' + rsp.imp_uid;
 	     		        msg += '상점 거래ID : ' + rsp.merchant_uid;
 	     		        msg += '결제 금액 : ' + rsp.paid_amount;
 	     		        msg += '카드 승인번호 : ' + rsp.apply_num;  
 	     		        
 	     		        $.ajax({
 	     		        	url : "/pay/success",
 	     		        	data : {
 	     		        		"payId" : rsp.imp_uid,
 	     		        		"roomNo" : '${r.roomNo}',
 	     		        		"payPensionNo" : '${r.refPensionNo}',
 	     		        		"payPrice" : rsp.paid_amount        		
 	     		        	},
 	     		        	type : "post",
 	     		        	success : function(result) {
 	     		        		alert(result);
 	     		        		$.ajax({
 	     		        			url : "/reservation/success",
 	     		        			data : {
 	     		        				"reservationName" : $("#nameChk").val(),
 	     		        				"roomNo" : '${r.roomNo}',
 	     		        				"rePensionNo" : '${r.refPensionNo}',
 	     		        				"rePrice" : rsp.paid_amount,
 	     		        				"reStartDate" : '${startDate}',
 	     		        				"reEndDate" : '${endDate}',
 	     		        				"couponCode" : codeBtn2
 	     		        			},
 	     		        			type : "post",
 	     		        			success : function(result) {
 	     		        				if(codeBtn2 != "") {
 	     		        					$.ajax({
 	    	     		   						url : "/coupon/decreaseCoupon",
 	    	     		   						data : {
 	    	     		   							"couponCode" : codeBtn2
 	    	     		   						},
 	    	     		   						type : "post",
 	    	     		   						success : function(result) {
 	    	     		   							if(result != "성공") {
 	    	     		   							alert("쿠폰감소 실패!");
 	    	     		   							}
 	    	     		   						}
 	    	     		   					});
 	     		        				}
 	     		        				alert("예약이 완료되었습니다.");
 	     		        				location.href = "/pension/list";
 	     		        			},
 	     		        			error : function() {
 	    	     		        		alert("예약 등록 실패!");
 	    	     		        	}
 	     		        		});

 	     		        	},
 	     		        	error : function() {
 	     		        		alert("결제 등록 실패!");
 	     		        	}
 	     		        });
 	     		    } else {
 	     		    	 var msg = '결제에 실패하였습니다. 처음부터 다시 진행해주세요. ';
 	     		         msg += '에러내용 : ' + rsp.error_msg;
 	     		       alert(msg);
 	     		     location.href = "/pension/list";
 	     		    }	
//  	     		  location.href = "/pension/list";
 	     		});	
 	    }else{
 	    	alert("결제를 진행할 수 없습니다. 다시한번 확인해주세요.");
 	    	if(!$("#agreement1").prop("checked")){
 	    		$("#successChk1").text("동의 해주시기 바랍니다.");
 				$("#successChk1").css("color", "red");
 	    	}
 	    	if(!$("#agreement2").prop("checked")) {
 	    		$("#successChk2").text("동의 해주시기 바랍니다.");
 				$("#successChk2").css("color", "red");
 	    	}
 	    	if(!$("#agreement3").prop("checked")) {
 	    		$("#successChk3").text("동의 해주시기 바랍니다.");
 				$("#successChk3").css("color", "red");
	    	}
 	    	var nameChk = $("#nameChk").val();
 	    	if(nameChk == ""){
 	    		console.log($("#nameChk").val());
 	    		$("#successNameChk").text("예약자 이름을 입력해주세요");
 				$("#successNameChk").css("color", "red");
 	    	}
//  	    	if($("#phoneDoubleChk").val() != "true"){
//  	    		console.log($("#phoneDoubleChk").val());
//  	    		$(".successPhoneChk").text("휴대폰 인증을 완료해주세요.");
//  				$(".successPhoneChk").css("color", "red");	    		
//  	    	}
 	    	return false
 	    }    	    	
     });
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     //나중에 결제 
     $("#button2").click(function() {
    	 $.ajax({
    		url : "/reservation/checkSessionId",
    		type : "post",
    		success : function(result) {   
    			var sessionId = "";
    			if(result != "") {
    			 sessionId = result;
    			 $.ajax({
    				url : "/reservation/waitAvailability",
    				data : {
    					"memberId" : sessionId
    				},
    			 	type : "post",
    			 	success : function(result) {
    			 		if(result == "1") {
    			 			alert("이미 결제해야할 예약건이 있습니다! 결제 완료 후 다시 시도해주세요.");
    			 			location.href="/pension/list";
    			 		}else {
    			 			 if($(".agree1").prop("checked") && $(".agree2").prop("checked") && $(".agree3").prop("checked") && $("#nameChk").val() != null){
    		   	        		 $.ajax({
    		   	        			url : "/reservation/waiting",
    		   	        			type : "post",
    		   	        			data : {
    		   	        				"reservationName" : $("#nameChk").val(),
    		   	        				"roomNo" : '${r.roomNo}',
    		   	        				"rePensionNo" : '${r.refPensionNo}',
    		   	        				"rePrice" : '${price}',
    		   	        				"reStartDate" : '${startDate}',
    		   	        				"reEndDate" : '${endDate}',
    		   	        				"couponCode" : codeBtn2
    		   	        			},
    		   	        			success : function(result) {   		   	        				
    		   	     		    			var keyName = sessionId;	// 키이름은 time
    		   	   	        				var keyValue = 	$("#nameChk").val();// 저장할 값은 30분에서 0분까지 줄어드는 기능        		 	    		
    		   	   	        				console.log("keyName : " + keyName);
    		   	   	        				console.log("keyValue : " + keyValue);
//    		   	    	        				var tts = 1800000;	// 만료시간 30분
    		   								var tts = 10000;
//    		    	   	        			 	let min=30;			//분 
//    		    		        		 	    let sec=60;			//초
    		   	   	        				//local에 저장할 key, value와 만료시간을 입력받음
    		   									//local에 저장할 객체를 생성하여 value를 세팅하고 현재일자 + 만료기간을 지정하여 저장
    		   		        		 	    	const date = new Date();
    		   		        		 	    	
    		   									const obj = {
    		   											value : keyValue,	// obj객체에 value는 time
    		   											expire : Date.now() + tts,
    		   											time : tts,
    		   											name : keyName
    		   									}
    		   									console.log(obj);
    		   									
    		   									//local에는 객체를 저장할 수 없어서 JSON으로 문자열 변환							
    		   									const objString = JSON.stringify(obj);	// JSON으로 문자열 변환
    		   									//변환한 객체를 파라미터로 입력받은 name과 함께 localStorage에 저장
    		   									localStorage.setItem(keyName, objString);	//time과 JSON으로 변환된 문자열을 localStorage에 저장
    		   									////////////////////localStorage 1차 저장 끝/////////////////////// 
    		   									console.log("로컬 저장 완료! 로컬확인해봐");
    		   									if(codeBtn2 != "") {
    	 	     		        					$.ajax({
    	 	    	     		   						url : "/coupon/decreaseCoupon",
    	 	    	     		   						data : {
    	 	    	     		   							"couponCode" : codeBtn2
    	 	    	     		   						},
    	 	    	     		   						type : "post",
    	 	    	     		   						success : function(result) {
    	 	    	     		   							if(result != "성공") {
    	 	    	     		   							alert("쿠폰감소 실패!");
    	 	    	     		   							}
    	 	    	     		   						}
    	 	    	     		   					});
    	 	     		        				}
    		   	   	        				alert("예약되었습니다. 이용내역에서 30분 안에 결제해주세요.");	
    		   	   	        				location.href = "/pension/list";   	     		    				   	     		    				
    		   	        			}
    		   	        		 });
    		   	        	 }else {
    		   	        		alert("결제를 진행할 수 없습니다. 다시한번 확인해주세요.");
    		   	  	    	if(!$(".agree1").prop("checked")){
    		   	  	    		$("#successChk1").text("동의 해주시기 바랍니다.");
    		   	  				$("#successChk1").css("color", "red");
    		   	  	    	}
    		   	  	    	if(!$(".agree2").prop("checked")) {
    		   	  	    		$("#successChk2").text("동의 해주시기 바랍니다.");
    		   	  				$("#successChk2").css("color", "red");
    		   	  	    	}
    		   	  	    	if(!$(".agree3").prop("checked")) {
    		   	  	    		$("#successChk3").text("동의 해주시기 바랍니다.");
    		   	  				$("#successChk3").css("color", "red");
    		   	 	    	}
    		   	  	    	var nameChk = $("#nameChk").val();
    		   	  	    	if(nameChk == ""){
    		   	  	    		console.log($("#nameChk").val());
    		   	  	    		$("#successNameChk").text("예약자 이름을 입력해주세요");
    		   	  				$("#successNameChk").css("color", "red");
    		   	  	    	}
//    		   	   	    	if($("#phoneDoubleChk").val() != "true"){
//    		   	   	    		console.log($("#phoneDoubleChk").val());
//    		   	   	    		$(".successPhoneChk").text("휴대폰 인증을 완료해주세요.");
//    		   	   				$(".successPhoneChk").css("color", "red");	    		
//    		   	   	    	}
    		   	  	    	return false
    		   	        	 }
    			 		}
    			 	}
    			 });
    			}else {
    				alert("로그인 후 이용가능합니다.");
    			}
    		},
    		error : function() {
    			alert("왜안돼");
    		}
    	 });
     });
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////     
    
     //예약자명 적었냐 안적었냐 체크ajax
     $('#nameChk').focusout(function(){
    	 var nameChk = $("#nameChk").val();
 		$.ajax({
 			url : "/reservation/idNullCheck",
 			type : "post",
 			data : {"nameChk": nameChk},
 			success : function(result){
					if(nameChk == "") {
						$("#successNameChk").text("예약자 이름을 입력해주세요");
		 				$("#successNameChk").css("color", "red");
					}else {
						$("#successNameChk").text("");
		 				$("#successNameChk").css("color", "");
					}
					console.log(result);
 			},
 			error : function(){
 				alert("서버요청실패");
 			}
 		})
 		 
 	});
     
     //동의 체크했는지 안했는디 ajax
     $('.agree1').change(function(){
    	 var agree1 = $(".agree1").is(":checked");
 		$.ajax({
 			url : "/reservation/agreeCheck1",
 			type : "post",
 			data : {"agree1": agree1
 			},
 			success : function(result){
					if(agree1 == true) {
						$("#successChk1").text("");
		 				$("#successChk1").css("color", "");
					}
					console.log(result);
 			},
 			error : function(){
 				alert("서버요청실패");
 			}
 		}) 
 	});
     
   //동의 체크했는지 안했는디 ajax
     $('.agree2').change(function(){
    	 var agree2 = $(".agree2").is(":checked");
 		$.ajax({
 			url : "/reservation/agreeCheck2",
 			type : "post",
 			data : {"agree2": agree2
 			},
 			success : function(result){
					if(agree2 == true) {
						$("#successChk2").text("");
		 				$("#successChk2").css("color", "");
					}
					console.log(result);
 			},
 			error : function(){
 				alert("서버요청실패");
 			}
 		})
 		 
 	});
     
   //동의 체크했는지 안했는디 ajax
     $('.agree3').change(function(){
    	 var agree3 = $(".agree3").is(":checked");
 		$.ajax({
 			url : "/reservation/agreeCheck3",
 			type : "post",
 			data : {"agree3": agree3
 			},
 			success : function(result){
					if(agree3 == true) {
						$("#successChk3").text("");
		 				$("#successChk3").css("color", "");
					}
					console.log(result);
 			},
 			error : function(){
 				alert("서버요청실패");
 			}
 		})
 		 
 	});
	
     $('.follower').click(function(){
    	 $.ajax({
	    		url : "/reservation/checkSessionId",
	    		type : "post",
	    		success : function(result) {   
	    			var sessionId = "";
	    			if(result != "") {
    				  $('#followModal').modal();   //id가 "followModal"인 모달창을 열어준다.   
    			      $('.modal-title').text("적용");    //modal 의 header 부분에 "팔로우"라는 값을 넣어준다. 
	    			}else {
	    				alert("로그인 후 이용가능합니다.");
	    			}
	    		},
	    		error : function() {
	    			alert("서버요청 실패!");
	    		}
			});
     });

// 	    var code2 = "";
// 	    $("#phoneChk").click(function(){
// 	    	if($("#phone").val() != "") {
// 	    		alert("인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.");
// 		    	var phone = $("#phone").val();
// 		    	$.ajax({
// 		            type:"GET",
// 		            url:"/reservation/phoneCheck?memberPhone=" + phone,
// 		            cache : false,
// 		            success:function(data){
// 		            	if(data == "error"){
// 		            		alert("휴대폰 번호가 올바르지 않습니다.");
// 		    				$(".successPhoneChk").text("유효한 번호를 입력해주세요.");
// 		    				$(".successPhoneChk").css("color","red");
// 		    				$("#phone").attr("autofocus",true);
// 		            	}else{	        		
// 		            		$("#phone2").attr("disabled",false);
// 		            		$("#phoneChk2").css("display","inline-block");
// 		            		$(".successPhoneChk").text("인증번호를 입력한 뒤 본인인증을 눌러주십시오.");
// 		            		$(".successPhoneChk").css("color","green");
// 		            		$("#phone").attr("readonly",true);
// 		            		code2 = data;
// 		            	}
// 		            }
// 		        });
// 	    	}else {
// 	    		alert("휴대폰 번호를 입력해주세요.");
// 	    	}
// 	    });

	    
// 	    $("#phoneChk2").click(function(){
// 	    	if($("#phone2").val() == code2){
// 	    		$(".successPhoneChk").text("인증번호가 일치합니다.");
// 	    		$(".successPhoneChk").css("color","green");
// 	    		$("#phoneDoubleChk").val("true");
// 	    		$("#phone2").attr("disabled",true);
// 	    	}else{
// 	    		$(".successPhoneChk").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
// 	    		$(".successPhoneChk").css("color","red");
// 	    		$("#phoneDoubleChk").val("false");
// 	    		$(this).attr("autofocus",true);
// 	    	}
// 	    });

		//약관 내용 열고 닫기
	    function clickshow(elem,ID) {
	    	 var menu = document.getElementById(ID);
	    	 if (elem.className !='closed') {
	    	    elem.className = 'closed';
	    	    menu.style.display = "none";
	    	 } else {
	    	    elem.className ='opened';
	    	    menu.style.display ="block";
	    	}
	    }
		
		function applyCoupon(elem, code) {
 			if(codeBtn2 != code) {
				$.ajax({
					url : "/applyCoupon",
					data : {
						"salePrice" : elem.value,
						"rePrice" : '${price}'
					},
					type : "post",
					success : function(result) {
 						codeBtn2 = code;
	 					$("#price").text("");
	 					$("#price").text(result + "원");
	 					$("#price2").text("");
	 					$("#price2").text(elem.value + "원 할인");	
// 	 					$(".codeBtn").attr('disabled', true);
	 					alert("쿠폰이 적용되었습니다.");				
					}
				});
 			}else {
 				alert("이미 적용하셨습니다.");
 			}	
		}
		
		
		
    </script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>
