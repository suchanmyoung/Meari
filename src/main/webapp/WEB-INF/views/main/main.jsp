<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
 
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <script>
    var result = "${result}";
    if(result == "success"){
    	const Toast = Swal.mixin({
    		  toast: true,
    		  position: 'top-end',
    		  showConfirmButton: false,
    		  timer: 2000,
    		  background : 'rgb(f,f,f)',
    		  timerProgressBar: true,
    		  width: 300,
    		})

    		Toast.fire({
    		  icon: 'success',
    		  title: '로그인에 성공했습니다.'
    		  
    		})
    }
    
       $(document).ready( function() {
          $("#headers").load("/views/common/footer");  // 원하는 파일 경로를 삽입하면 된다
          $("#footers").load("common/footer.html");  // 추가 인클루드를 원할 경우 이런식으로 추가하면 된다
       });
    </script>
    
    <!-- css -->
    <link href="<c:url value="/resources/css/style.css?after" />" rel="stylesheet">

    <!-- swiper 사용 css -->
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>


    <!-- bxslider외부파일 불러오기 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

    <!-- 날씨 -->
    <link rel="stylesheet" href="index.css" />

    <!-- 지도 -->
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script src="./geoIndex.js"></script>
    
    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    
</head>
<body>
<!-- top nav -->
<div id="headers"></div>

<!-- 날씨 -->
<!-- weather_info 날씨 멘트  -->
<div class="weather-container">
    <div class="weather-coment">
      <p class="noto-sans5 thin">덥지 않고 등산하기 좋은 날씨에요 🌞</p>
    </div>
    
    <div class="weather-wrapper">
        <div class="itme1">
            <div class ="item2">
                <a href="#a"><img class="js-weatherIcon"/></a>
                <p class="js-description noto-sans5"> </p>
            </div>
            <!-- 날씨 종합정보 -->
            <div class = "item2">
                <p class = "js-tmpinfo noto-sans3B bold">00</p>
                <p class = "dustinfo noto-sans5 thin">미세먼지 : 좋음</p>
            </div>
        </div>

        <!-- GPS정보 -->
        <div class = "itme3">
            <p class ="js-currentlocation noto-sans5"> 위치 정보 불러오기 </p>
            <input id="submit" type="image" src="/resources/images/home/target.png" />
        </div>
    </div>
</div>

<!-- 슬라이더 -->
<div class="bxslider">
	<a href="#a"><img src="/resources/images/home/commercebanner.png" class="menu" onclick="location.href='/commerce'" alt="menu"></a>
	<a href="#a"><img src="/resources/images/home/snsbanner.png" class="menu" onclick="location.href='/sns/new'" alt="menu"></a>
    <a href="#a"><img src="/resources/images/home/banner1.png" class="menu"  alt="menu"></a>
    <a href="#a"><img src="/resources/images/home/banner2.png" class="menu"  alt="menu"></a>
    <a href="#a"><img src="/resources/images/home/banner3.png" class="menu"  alt="menu"></a>
    
    
</div>

<!-- 코스추천 -->
<div class="course-text">
    <div class="item1">
        <p class="noto-sans3B bold">👍코스추천</p>
        <p class="noto-sans5">운동량에 맞는 코스를 추천해드려요</p>
    </div>
    <div class="item2">
        <p class="noto-sans5">전체</p>
    </div>
</div>

<!-- 슬라이더 코스추천 -->
<div class="slider-container">

    <div class="swiper-container">
        <div class = "swiper-wrapper">
            <div class="swiper-slide">
                <div class="shade"></div>
               <img src="/resources/images/home/image1.jpg"  alt="image1" />
                <h5>한라산<br/> 등산코스1번</h5>
                <h6><img src="/resources/images/home/pin.png" onclick="location.href='/map'" alt="pin" />제주도</h6>
            </div>
            <div class="swiper-slide">
                <div class="shade"></div>
                <img src="/resources/images/home/image2.jpg" alt="image1" />
                <h5>속리산<br /> 등산코스3번</h5>
                <h6><img src="/resources/images/home/pin.png" onclick="location.href='/map'" alt="pin" />영동읍</h6>
            </div>
            <div class="swiper-slide">
                <div class="shade"></div>
                <img src="/resources/images/home/image3.jpg" alt="image1" />
                <h5>계족산<br /> 등산코스2번</h5>
                <h6><img src="/resources/images/home/pin.png" onclick="location.href='/map'" alt="pin" />대전시</h6>
            </div>
            <div class="swiper-slide">
                <div class="shade"></div>
                <img src="/resources/images/home/image4.jpg" alt="image1" />
                <h5>속리산<br /> 등산코스3번</h5>
                <h6><img src="/resources/images/home/pin.png" onclick="location.href='/map'" alt="pin" />몰라</h6>
            </div>
            <div class="swiper-slide">
                <div class="shade"></div>
                <img src="/resources/images/home/image5.jpg" alt="image1" />
                <h5>백두산<br /> 등산코스23번</h5>
                <h6><img src="/resources/images/home/pin.png" onclick="location.href='/map'" alt="pin" />북한</h6>
            </div>
            <div class="swiper-slide">
                <div class="shade"></div>
                <img src="/resources/images/home/image6.jpg" alt="image1" />
                <h5>구봉산<br /> 등산코스3번</h5>
                <h6><img src="/resources/images/home/pin.png" onclick="location.href='/map'" alt="pin" />대전시</h6>
            </div>
        </div>
    </div>
</div>

<!-- 당당산악회 -->
<div>
    <!-- 당당산악회 header -->
    <div class="crew-text">
        <div class="item1">
            <p class="noto-sans3B bold">⛰️당당산악회 </p>
            <p class="noto-sans5 thin">함께할수록 즐거운 산생활</p>
        </div>
        <div class="item2">
            <p class="noto-sans5">전체</p>
        </div>
    </div>
    <!-- 당당산악회 contents -->
    <div class="crew">
        <!-- 당당산악회 mainbanner -->
        <div class="contents" style="border-radius:10px; overflow:hidden;">
         <img src="resources/images/home/등산배너.png" style="border-radius:10px;" ></img>
        </div><br>
        <!-- 당당산악회 렝킹 -->
        <div class="rank-container">
            <div class="rank">
                <img src="/resources/images/home/rank2.png" class="rank-image" alt="rank-image"></img>
                <div class="circle2"><img class="logo" src="/resources/images/home/산악회로고2.PNG"></div>
                <p class="rank1 thin2" style="font-size:10px; margin-top:2px;">나무산악회</p>
            </div>
            <div class="rank">
                <img src="/resources/images/home/rank1.png" class="rank-image" alt="rank-image"></img>
             <div class="circle1" onClick="location.href='/mountain'"/><img class="logo" src="/resources/images/home/산악회로고1.PNG"></div>
                <p class="rank2 medium2" style="font-size:12px; margin-top:2px;">산막걸리회</p>
            </div>
            <div class="rank">
                <img src="/resources/images/home/rank3.png" class="rank-image" alt="rank-image"></img>
                <div class="circle2"><img class="logo" src="/resources/images/home/산악회로고3.PNG"></div>
                <p class="rank3 thin2" style="font-size:10px; margin-top:2px;">당당산악회</p>
            </div>
        </div>
    </div>
</div>

<div class="bottom-banner">
    <img src="/resources/images/home/배너.PNG" class="battombannerimage"/>
</div>
<div class="bottom-info">
    <div class="bottom-info-contents">
        <p class="bold">co.Meari</p><hr style="margin:4px auto; font-size:20x">
        <p class="noto-sans5">회사소개  이용약관  개인정보처리방침  회원탈퇴  고객센터 </br> Meari | 대표이사 : 선도우 | 소재지: 서울특별시 서초구 효령로 176  </br> 사업자등록번호 111-11-11111 | 고객센터 1588-0000  </p>
    </div>
</div>
<!-- 바텀네비게이션바를 위한 빈박스 -->
<div style="display: flex; background-color: rgb(255, 255, 255); height: 90px;"></div>

<!-- bottom nav -->
<div th:replace="common/common :: footer" id="footer"></div>

<!-- bxslider사용 -->
<script type="text/javascript">
        $(document).ready(function(){ 
            $('.bxslider').bxSlider({
                auto : true, // 자동회전
                speed : 500, // 500ms
                pause : 4000, // 멈춰있는 시간 4000ms
                mode : 'horizontal', //수평으로 이동
                pager : false, //페이징
                controls : false, //좌우 화살표
                shrinkItem : true,
                adaptiveHeight : true, //각슬라이드 높이 자동조절
                touchEnabled : true,
                wrapperClass : 'bx-wrapper'
            }); 
        }); 
</script>
<!-- swiper 사용 js -->
<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<!-- js -->
<script src="/resources/js/main.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyxon6eceolfT0xKcj2DZeGyVK85W6WIM&callback=initMap&v=weekly" async></script>
<script src="/resources/js/weather.js"></script>

</body>
</html>