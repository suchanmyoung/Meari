<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- css  -->
    <link rel="stylesheet" href="/resources/css/map/map.css?after">
    
    <!-- 아이콘가지고오기 -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
    
    <!-- 슬라이드메뉴css -->
    <link rel="stylesheet" href="/resources/css/map/jsmobilemenu.css?after">
    
    <!-- jquery불러오기 -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>

     <!-- 구글 폰트 -->
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
 

</head>
<body>

     <!-- 지도를 표시할 div 입니다 -->
     <div id="map" style="width:100%;height:800px;margin:0px;"></div>
	
    
     <div class="topmenu-container">
	    	<button type="button" class="mobile-menu">
	    		<img class="menuImage" src="/resources/images/home/list.png" class="menu" alt="menu">
	    	</button>
    	<a onclick="location.href='/main'"><img src="/resources/images/home/meari-logo.png" class="meari-logo" alt="meari-logo"></a>
    	<a><img src="/resources/images/home/search.PNG" class="notice searchIcon" alt="notice"></a>
	</div>
  
	    <!-- 슬라이드메뉴 트리거버튼 
	    <button type="button" class="mobile-menu"><i class="fas fa-bars"></i></button>-->
    	
    	<div class ="keywordSearchBox">
    		<div style ="margin-left : 10px; margin-right : 5px;">
	    		<div>
	    			<p class = "thin" style = "font-size : 14px; margin-top :10px; word-spaicing : 1px; margin-bottom:4px; "> 원하시는 장소 혹은 산이름을 입력하세요.</p>
	    		</div>
	    		<div style ="margin-bottom : 10px;">
			        <form onsubmit="searchPlaces(); return false;">
			             <input type="text" value="" id="keyword" size="20" style="height: 20;"> 
			            <button  type="submit">검색</button> 
			        </form>
		        </div>
	        </div>
    	</div>
    
   
    
    

    <!-- 버튼누르면 나오는 div 입니다 -->
    <div class="menuwrap">
        <div>
            <div class="itmebox1">
                <div class = "item1" style="background-color:rgb(126, 126, 126);color : rgb(255, 255, 255);">
                    등산로
                </div>
                <div class = "item2" style="color : rgb(126, 126, 126);">
                    산
                </div>
            </div>
            <div class="itembox2">
                <div id="select-hiking" style="width:100%;height:100%;">
                    <div id="detailmap" style="width:100%;height:100%;"></div>
                    <div id="slected-mountainInfo" style="width:100%;height:100%;background-color: rgb(255, 255, 255);display:none;">                      
                        <div class = "mountainImageContainer">
                            <!-- 클릭한 산 사진 -->
                            <img id = "mountainimgfile" src="" >             
                        </div>
                        <div class = "mountainInfoContainer">
                        <!-- 산내용 -->
                            <div class="box1">
                                <div><p class="textMountainName bold"></p></div>
                                <div><p class="textMountainhigh thin"></p></div>
                            </div>
                            <p class="textMountainaddress thin"></p>
                            <hr>
                            <p class="textDetail thin"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- 카카오맵 API 호출 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=06467ba7c2b8f4c353e4eb3057d3b32f&libraries=services,clusterer,drawing"></script>
    <!-- 슬라이드메뉴js -->
    <script type="text/javascript" src="/resources/js/jsmobilemenu.js"></script>
    <!-- js -->
    <script type="text/javascript" src="/resources/js/map.js"></script>

    <script>
    
    
    </script>
</body> 
</html>