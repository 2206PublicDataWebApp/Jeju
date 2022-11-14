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

<!-- 사이드바 -->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="/">
                <img src="/resources/images/logo.png" alt="로고" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li>
                        <a href="/admin/adminPage">
                            <i class="fas fa-table"></i>일반</a>
                    </li>
                    <li>
                        <a href="/admin/member">
                            <i class="fas fa-table"></i>회원관리</a>
                    </li>
                    <li>
                        <a href="/admin/pension">
                            <i class="far fa-check-square"></i>숙소관리</a>
                    </li>
                    <li>
                        <a href="/admin/review">
                            <i class="fas fa-calendar-alt"></i>리뷰관리</a>
                    </li>
                    <li>
                        <a href="/admin/reservation">
                            <i class="fas fa-calendar-alt"></i>예약/결재관리</a>
                    </li>
                    <li>
                        <a href="/admin/chart">
                            <i class="fas fa-calendar-alt"></i>통계</a>
                    </li>

                </ul>
            </nav>
        </div>
    </aside>
    <!-- 사이드바 끝 -->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <form class="form-header" action="" method="POST">

                        </form>
                        <div class="header-button">
                            <div class="noti-wrap">
                                <div class="noti__item js-item-menu">

                                    <div class="mess-dropdown js-dropdown">
                                    </div>
                                </div>
                                <div class="noti__item js-item-menu">

                                    <div class="email-dropdown js-dropdown">

                                        <div class="email__item">

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

                                    <div class="notifi-dropdown js-dropdown">

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
                    </div></div>
                <div class="row m-t-30">
                    <div class="col-md-12">

                        <div class="table-responsive m-b-40">
                            <h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>예약/결재관리</h3>
                            <div class="table-responsive m-b-40">
                                <table class="table table-borderless table-data3">
                                    <thead>
                                    <tr>
                                        <th>예약번호</th>
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
                                            <td>${adminReservation.reservationNo}</td>
                                            <td>${adminReservation.rePensionName}</td>
                                            <td>${adminReservation.rStatus}</td>
                                            <td>${adminReservation.rePayDate}</td>
                                            <td>${adminReservation.memberId}</td>
                                            <td>${adminReservation.rePrice}</td>
                                            <td>${adminReservation.rStatus}</td>
                                            <td>${adminReservation.reStartDate}</td>
                                            <td>${adminReservation.reEndDate}</td>
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div></div>

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

</html>


