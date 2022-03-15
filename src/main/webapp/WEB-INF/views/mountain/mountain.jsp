<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
   <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/mountain/mountain.css?after">
     <link rel="stylesheet" href="/resources/css/style.css?after">
     <script type="text/javascript" src="resources/js/mountain.js"></script>
     
</head>

<body>

   <form action="/mountain/club" method="POST">

        <div class="backgroundImageContainer">
           <img class="backgroundImage" src="/resources/images/mountainclub.jpg">
       </div>
       
        <div class="wrap">
            <div class="register">
                <div class="register_name">
                    <h4>이름</h4>
                    <input type="text" name="mountain_name" id="" placeholder="아이디 입력">
                </div>
                <div class="register_activity">
                    <h4>활동명</h4>
                    <input type="text" name="mountain_activity" id="" placeholder="이메일 입력">
                </div>
                <div class="register_career">
                    <h4>등산 경력</h4>
                    <input type="text" name="mountain_career" id="" placeholder="비밀번호 입력">
                </div>

                <div class="register_purpose">
                    <h4>등산 목적</h4>
                    <input type="text" name="mountain_purpose" id="" placeholder="비밀번호 재입력">
                </div>

                <div class="register_recommend">
                    <h4>자주가는 산</h4>
                    <input type="text" name="mountain_recommend" id="" placeholder="이름 입력">
                </div>

                <div class="submit">
                    <input type="submit" value="산막걸리회 가입">
                </div>
                                    

            </div>
        </div>

    </form>
    
</body>

</html>