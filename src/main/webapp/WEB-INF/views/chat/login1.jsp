<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
	<style>
	    
	    #login-form > div {
	        margin: 15px 0;
	    }
	
	</style>
	<title>Home</title>
</head>
<div class="container">
    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title">안녕하세요 예약관련문의 상담입니다.</div>
            </div>
            <div class="panel-body">
                <form id="login-form" method="post" action="/loginProcess1.do">                  
                    <div>
                        <button type="submit" class="form-control btn btn-primary">시작</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</html>