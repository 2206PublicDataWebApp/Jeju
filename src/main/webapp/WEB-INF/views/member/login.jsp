<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
 header{
                display:flex;
                justify-content: center;
            }
            form{
                padding:10px;
            }
            .input-box{
                position:relative;
                margin:10px 0;
            }
            .input-box > input{
                background:transparent;
                border:none;
                border-bottom: solid 1px #ccc;
                padding:20px 0px 5px 0px;
                font-size:14pt;
                width:100%;
            }
            input::placeholder{
                color:transparent;
            }
            input:placeholder-shown + label{
                color:#aaa;
                font-size:14pt;
                top:15px;

            }
            input:focus + label, label{
                color:#8aa1a1;
                font-size:10pt;
                pointer-events: none;
                position: absolute;
                left:0px;
                top:0px;
                transition: all 0.2s ease ;
                -webkit-transition: all 0.2s ease;
                -moz-transition: all 0.2s ease;
                -o-transition: all 0.2s ease;
            }

            input:focus, input:not(:placeholder-shown){
                border-bottom: solid 1px #8aa1a1;
                outline:none;
            }
            input[type=submit]{
                background-color: #8aa1a1;
                border:none;
                color:white;
                border-radius: 5px;
                width:100%;
                height:35px;
                font-size: 14pt;
                margin-top:100px;
            }
            #forgot{
                text-align: right;
                font-size:12pt;
                color:rgb(164, 164, 164);
                margin:10px 0px;
            }

</style>
<head>
        <meta name="viewport" content="width=device-width, height=device-height, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0">
    </head>
    <body>
        <header>
            <h2>Login</h2>
        </header>

<body>

   
   <div class="input-box">
         <form action="/member/login" method="get">
<!--             <table align="right"> -->
<!--                <tr> -->
<!--                   <td>아이디 : </td> -->
<!--                   <td><input type="text" name="memberId"></td> -->
<!--                   <td rowspan="2"> -->
<!--                      <input type="submit" value="로그인"> -->
<!--                   </td> -->
<!--                </tr> -->
<!--                <tr> -->
<!--                   <td>비밀번호 : </td> -->
<!--                   <td><input type="password" name="memberPwd"></td> -->
<!--    <!--                <td></td> --> 
<!--                </tr> -->
<!--                <tr> -->
            <div class="input-box">
                <input id="memberId" type="text" name="memberId" placeholder="아이디">
                <label for="memberId">아이디</label>
            </div>

            <div class="input-box">
                <input id="memberPwd" type="password" name="memberPwd" placeholder="비밀번호">
                <label for="memberPwd">비밀번호</label>       
               </div>
         아이디가 없으신가요?-><td colspan="3"><a href="/member/joinView.kh">회원가입</a></td><br>
         <td colspan="6"><a href="/member/findId"> ID 찾기</a></td>   
         <td colspan="6"><a href="/member/findPwd">Pwd 찾기</a></td>  
            <input type="submit" value="로그인">

        </form>


   
   </div>
   
   <script>

   </script>
</body>