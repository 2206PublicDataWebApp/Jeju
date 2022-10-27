<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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
                                                <img src="images/icon/avatar-06.jpg" alt="Michelle Moreno" />
                                            </div>
                                            <div class="content">
                                                <h6>Michelle Moreno</h6>
                                                <p>Have sent a photo</p>
                                                <span class="time">3 min ago</span>
                                            </div>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">
                                                <img src="images/icon/avatar-04.jpg" alt="Diane Myers" />
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
                                            <div class="image img-cir img-40">
                                                <img src="images/icon/avatar-06.jpg" alt="Cynthia Harvey" />
                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, 3 min ago</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="images/icon/avatar-05.jpg" alt="Cynthia Harvey" />
                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, Yesterday</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="images/icon/avatar-04.jpg" alt="Cynthia Harvey" />
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
                                        <img src="images/icon/avatar-01.jpg" alt="John Doe" />
                                    </div>
                                   <%-- <div class="content">
                                        <a class="js-acc-btn" href="#">john doe</a>
                                    </div>--%>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="images/icon/avatar-01.jpg" alt="John Doe" />
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

                                    <%--ajax 이용--%>
                                    <i class="zmdi zmdi-account-calendar"></i>회원관리</h3>
                                <table class="table table-borderless table-striped table-earning">
                                    <thead>
                                    <tr>
                                        <th>이름</th>
                                        <th>ID</th>
                                        <th>전화번호</th>
                                        <th>주소</th>
                                        <th>이메일</th>
                                        <th>최근예약일</th>
                                        <th>회원상태</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>user01</td>
                                        <td>010-1515-1414</td>
                                        <td>서울시 도봉구 쌍문동 59</td>
                                        <td>user01@gmail.com</td>
                                        <td>2022-10-22</td>
                                        <th>Y</th>
                                    </tr>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>user01</td>
                                        <td>010-1515-1414</td>
                                        <td>서울시 도봉구 쌍문동 59</td>
                                        <td>user01@gmail.com</td>
                                        <td>2022-10-22</td>
                                        <th>Y</th>
                                    </tr>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>user01</td>
                                        <td>010-1515-1414</td>
                                        <td>서울시 도봉구 쌍문동 59</td>
                                        <td>user01@gmail.com</td>
                                        <td>2022-10-22</td>
                                        <th>Y</th>
                                    </tr>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>user01</td>
                                        <td>010-1515-1414</td>
                                        <td>서울시 도봉구 쌍문동 59</td>
                                        <td>user01@gmail.com</td>
                                        <td>2022-10-22</td>
                                        <th>Y</th>
                                    </tr>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>user01</td>
                                        <td>010-1515-1414</td>
                                        <td>서울시 도봉구 쌍문동 59</td>
                                        <td>user01@gmail.com</td>
                                        <td>2022-10-22</td>
                                        <th>Y</th>
                                    </tr>
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
                                            <th>이름</th>
                                            <th>ID</th>
                                            <th>전화번호</th>
                                            <th>주소</th>
                                            <th>이메일</th>
                                            <th>최근예약일</th>
                                            <th>회원상태</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>user01</td>
                                            <td>010-1515-1414</td>
                                            <td>서울시 도봉구 쌍문동 59</td>
                                            <td>user01@gmail.com</td>
                                            <td>2022-10-22</td>
                                            <th>Y</th>
                                        </tr>
                                        </tbody>
                                    </table>

                                </div>
                                <div class="user-data__footer">
                                    <button class="au-btn au-btn-load">load more</button>
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
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr>
                                        <tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr><tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr><tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr><tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr><tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr>
                                        <tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr>
                                        <tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr>
                                        <tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr>
                                        <tr>
                                            <td>리뷰내용 리뷰내용 리뷰내용</td>
                                            <td>작성자</td>
                                            <td><a href="#">삭제</a></td>
                                        </tr>


                                        </tbody>
                                    </table>
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
                                <i class="zmdi zmdi-account-calendar"></i>예약관리</h3>
                            <!-- DATA TABLE-->
                            <div class="table-responsive m-b-40">
                                <table class="table table-borderless table-data3">
                                    <thead>
                                    <tr>
                                        <th>date</th>
                                        <th>type</th>
                                        <th>description</th>
                                        <th>status</th>
                                        <th>price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>2018-09-29 05:57</td>
                                        <td>Mobile</td>
                                        <td>iPhone X 64Gb Grey</td>
                                        <td class="process">Processed</td>
                                        <td>$999.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-28 01:22</td>
                                        <td>Mobile</td>
                                        <td>Samsung S8 Black</td>
                                        <td class="process">Processed</td>
                                        <td>$756.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-27 02:12</td>
                                        <td>Game</td>
                                        <td>Game Console Controller</td>
                                        <td class="denied">Denied</td>
                                        <td>$22.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-26 23:06</td>
                                        <td>Mobile</td>
                                        <td>iPhone X 256Gb Black</td>
                                        <td class="denied">Denied</td>
                                        <td>$1199.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-25 19:03</td>
                                        <td>Accessories</td>
                                        <td>USB 3.0 Cable</td>
                                        <td class="process">Processed</td>
                                        <td>$10.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-29 05:57</td>
                                        <td>Accesories</td>
                                        <td>Smartwatch 4.0 LTE Wifi</td>
                                        <td class="denied">Denied</td>
                                        <td>$199.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-24 19:10</td>
                                        <td>Camera</td>
                                        <td>Camera C430W 4k</td>
                                        <td class="process">Processed</td>
                                        <td>$699.00</td>
                                    </tr>
                                    <tr>
                                        <td>2018-09-22 00:43</td>
                                        <td>Computer</td>
                                        <td>Macbook Pro Retina 2017</td>
                                        <td class="process">Processed</td>
                                        <td>$10.00</td>
                                    </tr>
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

</html>
<!-- end document-->

