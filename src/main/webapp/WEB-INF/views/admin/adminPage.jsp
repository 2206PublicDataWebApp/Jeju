<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Tables</title>

    <!-- Fontfaces CSS-->
    <link href="/resources/assets/css/font-face.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="/resources/assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="/resources/assets/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="/resources/assets/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="/resources/assets/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="index.html">
                        <img src="#" alt="CoolAdmin" />
                    </a>
                    <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                    </button>
                </div>
            </div>
        </div>
        <nav class="navbar-mobile">
            <div class="container-fluid">
                <ul class="navbar-mobile__list list-unstyled">

                    <li>
                        <a href="table.html">
                            <i class="fas fa-table"></i>Tables</a>
                    </li>
                    <li>
                        <a href="form.html">
                            <i class="far fa-check-square"></i>Forms</a>
                    </li>
                    <li>
                        <a href="calendar.html">
                            <i class="fas fa-calendar-alt"></i>Calendar</a>
                    </li>
                    <li>
                        <a href="map.html">
                            <i class="fas fa-map-marker-alt"></i>Maps</a>
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-copy"></i>Pages</a>
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="login.html">Login</a>
                            </li>
                            <li>
                                <a href="register.html">Register</a>
                            </li>
                            <li>
                                <a href="forget-pass.html">Forget Password</a>
                            </li>
                        </ul>
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-desktop"></i>UI Elements</a>
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="button.html">Button</a>
                            </li>
                            <li>
                                <a href="badge.html">Badges</a>
                            </li>
                            <li>
                                <a href="tab.html">Tabs</a>
                            </li>
                            <li>
                                <a href="card.html">Cards</a>
                            </li>
                            <li>
                                <a href="alert.html">Alerts</a>
                            </li>
                            <li>
                                <a href="progress-bar.html">Progress Bars</a>
                            </li>
                            <li>
                                <a href="modal.html">Modals</a>
                            </li>
                            <li>
                                <a href="switch.html">Switchs</a>
                            </li>
                            <li>
                                <a href="grid.html">Grids</a>
                            </li>
                            <li>
                                <a href="fontawesome.html">Fontawesome Icon</a>
                            </li>
                            <li>
                                <a href="typo.html">Typography</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="#">
                <img src="로고이미지파일" alt="로고" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="active">
                        <a href="#">
                            <i class="fas fa-table"></i>Tables</a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="far fa-check-square"></i>Forms</a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-calendar-alt"></i>Calendar</a>
                    </li>

                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <form class="form-header" action="" method="POST">
                            <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                            <button class="au-btn--submit" type="submit">
                                <i class="zmdi zmdi-search"></i>
                            </button>
                        </form>
                        <div class="header-button">
                            <div class="noti-wrap">
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-comment-more"></i>
                                    <span class="quantity">1</span>
                                    <div class="mess-dropdown js-dropdown">
                                        <div class="mess__title">
                                            <p>You have 2 news message</p>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">

                                            </div>
                                            <div class="content">
                                                <h6>Michelle Moreno</h6>
                                                <p>Have sent a photo</p>
                                                <span class="time">3 min ago</span>
                                            </div>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">

                                            </div>
                                            <div class="content">
                                                <h6>Diane Myers</h6>
                                                <p>You are now connected on message</p>
                                                <span class="time">Yesterday</span>
                                            </div>
                                        </div>
                                        <div class="mess__footer">
                                            <a href="#">View all messages</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-email"></i>
                                    <span class="quantity">1</span>
                                    <div class="email-dropdown js-dropdown">
                                        <div class="email__title">
                                            <p>You have 3 New Emails</p>
                                        </div>
                                        <div class="email__item">

                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, 3 min ago</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">

                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, Yesterday</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">

                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, April 12,,2018</span>
                                            </div>
                                        </div>
                                        <div class="email__footer">
                                            <a href="#">See all emails</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-notifications"></i>
                                    <span class="quantity">3</span>
                                    <div class="notifi-dropdown js-dropdown">
                                        <div class="notifi__title">
                                            <p>You have 3 Notifications</p>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c1 img-cir img-40">
                                                <i class="zmdi zmdi-email-open"></i>
                                            </div>
                                            <div class="content">
                                                <p>You got a email notification</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c2 img-cir img-40">
                                                <i class="zmdi zmdi-account-box"></i>
                                            </div>
                                            <div class="content">
                                                <p>Your account has been blocked</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c3 img-cir img-40">
                                                <i class="zmdi zmdi-file-text"></i>
                                            </div>
                                            <div class="content">
                                                <p>You got a new file</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__footer">
                                            <a href="#">All notifications</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">

                                    </div>
                                   <%-- <div class="content">
                                        <a class="js-acc-btn" href="#">john doe</a>
                                    </div>--%>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                </a>

                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">john doe</a>
                                                </h5>
                                                <span class="email">johndoe@example.com</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-account"></i>Account</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-money-box"></i>Billing</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="#">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-9">
                            <div class="table-responsive table--no-card m-b-30">
                                <h3 class="title-3 m-b-30">

                                    <!--회원관리 -->
                                    <i class="zmdi zmdi-account-calendar"></i>회원관리</h3>
                                <table class="table table-borderless table-striped table-earning">
                                    <thead>
                                    <tbody>
                                    <tr>
                                        <td>회원번호</td>
                                        <td>아이디</td>
                                        <td>이메일</td>
                                        <td>이름</td>
                                        <td>전화번호</td>
                                        <td>주소</td>
                                        <td>가입날짜</td>
                                        <td>생년월일</td>
                                        <td>성별</td>
                                        <td>총결재금액</td>
                                        <td>예약횟수</td>
                                        <td>탈퇴</td>
                                    </tr>
                                    <c:forEach items="${memberList }" var="adminMember" varStatus="i">
                                    <tr>
                                        <td>${adminMember.memberNo}</td>
                                        <td>${adminMember.memberId}</td>
                                        <td>${adminMember.memberEmail}</td>
                                        <td>${adminMember.memberName}</td>
                                        <td>${adminMember.memberPhone}</td>
                                        <td>${fn:substring(adminMember.memberAddr, 0, 40)} </td>
                                        <td>${adminMember.enrollDate}</td>
                                        <td>${adminMember.birthDate}</td>
                                        <td>${adminMember.gender}</td>
                                        <td>0</td>
                                        <td>0</td>
                                        <td><a href="#" onclick="removeAdminMember(${adminMember.memberNo})">탈퇴</a></td>

                                    </tr>
                                    </c:forEach>
                                    </thead>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>문의관리</h3>
                            <div class="au-card au-card--bg-blue au-card-top-countries m-b-30">
                                <div class="au-card-inner">
                                    <div class="table-responsive">
                                        <table class="table table-top-countries">
                                            <tbody>
                                            <tr>
                                                <td>조혜원님의 질문</td>
                                                <td class="text-right">미답변</td>
                                            </tr>
                                            <tr>
                                                <td>한상일님의 질문</td>
                                                <td class="text-right">미답변</td>
                                            </tr>
                                            <tr>
                                                <td>이혁렬님의 질문</td>
                                                <td class="text-right">미답변</td>
                                            </tr>
                                            <tr>
                                                <td>한재민님의 질문</td>
                                                <td class="text-right">미답변</td>
                                            </tr>
                                            <tr>
                                                <td>민봉식님의 질문</td>
                                                <td class="text-right">답변</td>
                                            </tr>
                                            <tr>
                                                <td>회원1님의 질문</td>
                                                <td class="text-right">답변</td>
                                            </tr>
                                            <tr>
                                                <td>회원2님의 질문</td>
                                                <td class="text-right">답변</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-6">

                            <h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>숙소관리</h3>
                            <div class="user-data m-b-30">
                                <div class="table-responsive table-data">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>이름</th>
                                            <th>주소</th>
                                            <th>가격</th>
                                            <th>리뷰 개수</th>
                                            <th>기타</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${pensionList }" var="adminPension" varStatus="i">
                                            <input type="hidden" name="pensionNo" value="${adminPension.pensionNo}">
                                            <tr>
                                                <th>${i.count}</th>
                                                <th>${adminPension.pensionName}</th>

                                                <th>${adminPension.pensionAddr}</th>

                                                <th>${adminPension.pensionPrice}</th>
                                                <th>${adminPension.reviewCount}</th>
                                                <th><a href="#" onclick="removeAdminPension(${adminPension.pensionNo});">삭제</a></th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                                <div class="user-data__footer">

                                </div>
                            </div>

                        </div>
                        <div class="col-lg-6">

                            <h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>리뷰관리</h3>
                            <div class="top-campaign">
                                <div class="table-responsive">
                                    <table class="table table-top-campaign">
                                        <tbody>
                                        <tr>
                                            <td>아이디</td>
                                            <td>내용</td>
                                            <td>작성일</td>
                                            <td>기타</td>
                                        </tr>
                                            <c:forEach items="${reviewList }" var="adminReview" varStatus="i">
                                        <tr>
                                            <input type="hidden" name="reviewNo" value="${adminReview.reviewNo}">
                                            <td>${adminReview.memberId}</td>
                                            <td>${fn:substring(adminReview.reviewContents, 0, 40)} ... </td>
                                            <%--<td>${adminReview.reviewContents}</td>--%>
                                            <td>${adminReview.regDate}</td>
                                            <td><a href="#" onclick="removeAdminReview(${adminReview.reviewNo});">삭제</a></td>
                                        </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- 페이징 -->
                                <br><br>
                                <div>
                                <article id = "page-are">
                                    <c:if test="${pagination.startNavi != 1 && pagination.startNavi > 0}">
                                        <span class="prev">
                                            <a href="/admin/adminPage?page=${pagination.startNavi -1}"></a>
                                        </span>
                                    </c:if>
                                    <c:forEach var="page" begin="${pagination.startNavi}"
                                    									end="${pagination.endNavi}">
                                        <c:if test="${page == pagination.currentPage  }">
                                            <span class="pageNow">
                                                ${page }
                                            </span>
                                        </c:if>
                                        <c:if test="${page == 0  }">
                                            <span class="pageNow">
                                                ${page+1 }
                                            </span>
                                        </c:if>

                                        <c:if test="${page != pagination.currentPage && page !=0}">
                                            <span class="pages"> <a href="/admin/adminPage?page=${page }">${p }</a>
                                            </span>
                                        </c:if>

                                    </c:forEach>
                                    <!-- 다음 페이지 출력 -->
                                    <c:if test="${pagination.endNavi ne pagination.maxPage  }">
                                        <span class="next"> <a
                                            href="/admin/adminPage?page=${pagination.endNavi+1 }"> > </a>
                                        </span>
                                    </c:if>
                                </article>

                            </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                        </div>
                    </div>
                    <div class="row m-t-30">
                        <div class="col-md-12">
                            <h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>예약/결재관리</h3>
                            <!-- DATA TABLE-->
                            <div class="table-responsive m-b-40">
                                <table class="table table-borderless table-data3">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>숙소</th>
                                        <th>결재여부</th>
                                        <th>결재일</th>
                                        <th>아이디</th>
                                        <th>가격</th>
                                        <th>예약상태</th>
                                        <th>예약기간-시작</th>
                                        <th>예약기간-마감</th>
                                        <th>기타</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${reservationList }" var="adminReservation" varStatus="i">
                                        <tr>
                                            <th>${i.count}</th>
                                            <th>${adminReservation.roomNo}</th>
                                            <th>0</th>
                                            <th>0</th>
                                            <th>${adminReservation.memberId}</th>
                                            <th>${adminReservation.rePrice}</th>
                                            <th>${adminReservation.rStatus}</th>
                                            <th>0</th>
                                            <th>0</th>
                                            <th>0</th>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- END DATA TABLE -->
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="copyright">
                                <p>Copyright © 2022 Jeju. All rights reserved.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Jquery JS-->
<script src="/resources/assets/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="/resources/assets/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="/resources/assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="/resources/assets/vendor/slick/slick.min.js">
</script>
<script src="/resources/assets/vendor/wow/wow.min.js"></script>
<script src="/resources/assets/vendor/animsition/animsition.min.js"></script>
<script src="/resources/assets/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="/resources/assets/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="/resources/assets/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="/resources/assets/vendor/circle-progress/circle-progress.min.js"></script>
<script src="/resources/assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="/resources/assets/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="/resources/assets/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="/resources/assets/js/main.js"></script>

</body>

<script>
        function removeAdminMember(memberNo){
            if(confirm("회원을 탈퇴시키겠습니까?")) {
                location.href="/admin/member/remove?memberNo="+memberNo;
            }
        }

    	function removeAdminPension(pensionNo){
    		if(confirm("숙소를 삭제하시겠습니까?")) {
                location.href="/admin/pension/remove?pensionNo="+pensionNo;
            }
    	}

        function removeAdminReview(reviewNo){
            if(confirm("리뷰를 삭제하시겠습니까?")){
                location.href="/admin/review/remove?reviewNo="+reviewNo;
            }
        }

    function setReviewContentsBySize(reviewContents) {
        var str = "${reviewContents}"
        var result = str.substring(0, 10) + "...";
        return result;
    }
   </script>

</html>


