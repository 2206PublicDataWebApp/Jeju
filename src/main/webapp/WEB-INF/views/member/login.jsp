<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>My Spring Web Page</title>
<!-- 	<link href="../../resources/css/menubar-style.css" rel="stylesheet"> -->
	<link href="/resources/css/menubar-style.css" rel="stylesheet">
</head>
<body>

	<h1 align="center">Welcome Our WebSite!!</h1>
	<div class="forms">
                <div class="form-content">
                  <div class="login-form">
                    <div class="title">Login</div>
                  <form action="/member/login.kh" method="post">
                    <div class="input-boxes">
                      <div class="input-box">
                        <i class="fas fa-envelope"></i>
                        <input type="text" name="memberEmail" placeholder="Enter your email" required>
                      </div>
                      <div class="input-box">
                        <i class="fas fa-lock"></i>
                        <input type="password" name="memberPwd" placeholder="Enter your password" required>
                      </div>
                      <div class="text"><a href="#">Forgot password?</a></div>
                      <div class="button input-box">
                        <input type="submit" value="Sumbit">
                      </div>
                      <div class="text sign-up-text">Don't have an account? <label for="flip">Sigup now</label></div>
                    </div>
                </form>
              </div>

</body>
</html>
