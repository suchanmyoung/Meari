<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>자바스크립트 모바일 메뉴</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/login.css">
    <script type="text/javascript" src="resources/js/login.js"></script>
    
    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">


    <!-- 제이쿼리 -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    
</head>
<body>
   <form action="/loginForm" class="form-signin" method="post">
    <div class="backgroundImageContainer">
        <img class="backgroundImage" src="resources/images/commerce/commerce_img/backgroundImage.jpeg">
    </div>

    <div class ="allContainer">
        
        <div class="contentsContainer">
            <div class ="wellcomMention">
                <p class = "mainMention bold">크게 불러보세요 <br> 서로에게 닿도록 <br> 메아리 </p>
                <p class = "subMention thin">메아리와 새로운 산생활을 시작하세요</p>
            </div>
        </div>
        <div class="bar"></div>
        <div class="barBackground"></div>
    </div>
        <div class="menuwrap"> 
            <div class="login">
                <div class="logo">
                    <a href="" target="_blank" title="메아리"><img src="resources/images/commerce/commerce_img/meari-logo.png" style="height: 50px; width: auto;"></a>
                </div>
                <p class = "loginMessege regular">들려주세요. 당신의 메아리</p> 
                <div class="login_id">
                    <input type="text" name="member_id" id=""  placeholder="아이디를 입력하세요.">
                </div>
                <div class="login_pw">
                    <input type="password" name="member_pw" id="" placeholder="비밀번호를 입력하세요.">
                </div>
                <div class="submit">
                    <input type="submit" value="로그인">
                </div>
                
                
                
                <div class="find-signup-wrap">
                    <span class="find-id">
                        <a href="" target="_blank">아이디 찾기</a>
                    </span>
        
                    <span class="find-pw">
                        <a href="" target="_blank">비밀번호 찾기</a>
                    </span>
        
                    <span class="sign-up">
                        <a onclick="location.href='/signupForm'" target="_blank">회원가입</a>
                        
                    </span>
                </div>
                <div class="login_sns">
                    <li><a href=""><i class="fab fa-google"></i></a></li>
                    <li><a href=""><i class="fab fa-facebook-f"></i></a></li>
                </div>    
            </div>
        </div>
        
        <button type="button" class="mobile-menu"> <img class="point" src="resources/images/commerce/commerce_img/point.png"> </button>
    </form>
</body>
</html>