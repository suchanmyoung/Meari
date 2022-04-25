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
    <link rel="stylesheet" href="/resources/css/register.css?after">
</head>

<body>

   <form action="/signup" method="post">
      
        <div class="backgroundImageContainer">
           <img class="backgroundImage" src="resources/images/commerce/commerce_img/backgroundImage.jpeg">
       </div>
       
        <div class="wrap">
            <div class="register">
                <div class="logo">
                    <a href="" target="_blank" title="메아리"><img src="/resources/images/home/meari-logo.png" class="image"></a>
                </div>
                <div class="register_id">
                    <h4>아이디</h4>
                    <input type="text" name="id" placeholder="아이디 입력">
                </div>
                <div class="register_email">
                    <h4>이메일</h4>
                    <input type="text" name="email" placeholder="이메일 입력">
                </div>
                <div class="register_pw">
                    <h4>비밀번호</h4>
                    <input type="password" name="password" placeholder="비밀번호 입력">
                </div>

<%--                <div class="register_pw_confirm">--%>
<%--                    <h4>비밀번호 확인</h4>--%>
<%--                    <input type="password" name="member_pw_corr" placeholder="비밀번호 재입력">--%>
<%--                </div>--%>

                <div class="register_name">
                    <h4>이름</h4>
                    <input type="text" name="name" placeholder="이름 입력">
                </div>

                <div class="submit">
                    <input type="submit" onclick="alert('회원가입이 완료되었습니다.')" value="회원가입">
                </div>
            </div>
        </div>
    </form>
</body>

</html>