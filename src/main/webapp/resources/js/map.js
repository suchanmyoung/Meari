// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

    
// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

function placesSearchCB(data, status) {
if (status === kakao.maps.services.Status.OK) {
    // 정상적으로 검색이 완료됐으면
    // 검색 목록과 마커를 표출합니다
    displayPlaces(data);
    // 페이지 번호를 표출합니다
} else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    alert('검색 결과가 존재하지 않습니다.');
    return;
} else if (status === kakao.maps.services.Status.ERROR) {
    alert('검색 결과 중 오류가 발생했습니다.');
    return;
    }
}
// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {
    var moveLatLon = new kakao.maps.LatLng(places[0].y, places[0].x);
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);      
}   


/* 테스트 텍스트상자 */
// const mountainimgfile = document.querySelector('mountainimgfile');
//사진파일 넣기
var src = jQuery('#mountainimgfile').attr("src");
// const testtext = document.querySelector(".testtext"); 

//산설명 넣기
const textMountainName = document.querySelector(".textMountainName"); //산이름
const textMountainhigh = document.querySelector(".textMountainhigh"); //산높이
const textMountainaddress = document.querySelector(".textMountainaddress"); //산주소
const textDetail = document.querySelector(".textDetail"); //산설명





/* 지도 호출 */
// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

    
var detailmapContainer = document.getElementById('detailmap'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

// 지도를 생성합니다.
var map = new kakao.maps.Map(mapContainer, mapOption); 
// 디테일맵 지도를 생성합니다.
var detailmap = new kakao.maps.Map(detailmapContainer, mapOption); 
//지형도 옵션을 추가합니다.
detailmap.addOverlayMapTypeId(kakao.maps.MapTypeId.TERRAIN);    
kakao.maps.event.addListener(map, 'tilesloaded', displayMarker);
/* 지도호출 끝 */


/* 현재위치 가지고오기 */


//현재 위치 마커 이미지 주소
var currentLocationSrc= '/resources/images/map/mylocation.png', // 마커이미지의 주소입니다   
    currentLocationSrcSize = new kakao.maps.Size(50, 80), // 마커이미지의 크기입니다
    currentLocationSrcOption = {offset: new kakao.maps.Point(20, 30)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var currentLocationIcon = new kakao.maps.MarkerImage(currentLocationSrc, currentLocationSrcSize, currentLocationSrcOption)

if (navigator.geolocation) {
// GeoLocation을 이용해서 접속 위치를 얻어옵니다
navigator.geolocation.getCurrentPosition(function(position) {
    var lat = position.coords.latitude, // 위도
        lon = position.coords.longitude; // 경도
    var locPosition = new kakao.maps.LatLng(lat, lon) // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
        // message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다 
    // 마커와 인포윈도우를 표시합니다
    CurrentLocationDisplayMarker(locPosition);
  });
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667)
        window.alert("현재 위치를 사용할 수 없어요, 브라우저 설정을 확인해 주세요");
    CurrentLocationDisplayMarker(locPosition);
}

function CurrentLocationDisplayMarker(locPosition) {
    /* 마커를 생성한다 */
    var marker = new kakao.maps.Marker({  
    map: map, 
    position: locPosition,
    /* 현재위치 마커를 생성한다 */
    image: currentLocationIcon
    }); 
    /* 마커 중심을 현재위치로 설정한다. */
    map.setCenter(locPosition);   
}
/* 현재위치 가지고 오기 끝 */



function displayMarker() {
    serchForMountain();
}
    
function serchForMountain(){
    // 장소 검색 객체를 생성합니다
    var ps = new kakao.maps.services.Places(); 
        var location = map.getCenter();
        var searchOption = {
            location,
            radius: 5000,
            size: 5,
            category_group_code : 'AT4',
        };

    // 키워드로 장소를 검색합니다
    ps.keywordSearch('mountain', placesSearchCB, searchOption); 

    // 키워드 검색 완료 시 호출되는 콜백함수 입니다
    function placesSearchCB (data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
            // LatLngBounds 객체에 좌표를 추가합니다
            for (var i=0; i<data.length; i++) {
                displayMarker(data[i]);    
            }       
            // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        } 
    }
    //마커 이미지 주소
    var imageSrc = '/resources/images/map/IconMountainMeariVersion.png', // 마커이미지의 주소입니다   
        imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
        imageOption = {offset: new kakao.maps.Point(20, 30)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)

    // // 마커를 생성합니다
    // var marker = new kakao.maps.Marker({
    //     position: markerPosition, 
    //     image: markerImage // 마커이미지 설정 
    // });
    

    // 지도에 마커를 표시하는 함수입니다
    function displayMarker(place) {

        // 마커를 생성하고 지도에 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x) ,
            image: markerImage//마커이미지설정
        });
        
        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'click', function() {
            
            

            setCenter(place.y,place.x);
            searchHikingTrail(place.y,place.x);
            // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
            infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
            infowindow.open(map, marker);
            // window.alert('이름 : ' + place.place_name + '\n좌표 : ' + place.y + ', ' + place.x);
            mountainInfo(place.place_name);

            // 밑에 화면열기
            if ( document.querySelector('.menuwrap').classList.contains('on') ){
                /* 메뉴닫힘 */
                document.querySelector('.menuwrap').classList.remove('on');
                /* 아이콘 바꾸기 */
                // document.querySelector('.mobile-menu i').classList.remove('fa-times')
                // document.querySelector('.mobile-menu i').classList.add('fa-bars');

                //페이지 스크롤 락 해제
                document.querySelector('#dimmed').remove();
            } else {
                /* 메뉴펼침 */
                document.querySelector('.menuwrap').classList.add('on');
                /* 아이콘 바꾸기 */
                // document.querySelector('.mobile-menu i').classList.remove('fa-bars');
                // document.querySelector('.mobile-menu i').classList.add('fa-times');

                //페이지 스크롤 락 레이어 추가
                let div = document.createElement('div');
                div.id = 'dimmed';
                document.body.append(div);

                //페이지 스크롤 락  모바일 이벤트 차단
                document.querySelector('#dimmed').addEventListener('scroll touchmove touchend mousewheel', function(e){
                    e.preventDefault();
                    e.stopPropagation();
                    return false;
                });

                //페이지 스크롤 락 레이어 클릭 메뉴 닫기
                document.querySelector('#dimmed').addEventListener('click', function(e){
                    document.querySelector(".mobile-menu").click();
                });             

            }
        });


    }
}

function setCenter(x,y) {            
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(x, y);
    // 지도 중심을 이동 시킵니다
    detailmap.setCenter(moveLatLon);
    //레벨을 3으로 설정합니다.
    detailmap.setLevel(3);
}

function mountainInfo(place_name){

    var xhr = new XMLHttpRequest();
    var url = 'http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI'; /*URL*/
    var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'wsf7xD22zr%2FlqPjRLk0IxbaBlV0LxUbyDCUsVW3VcAGfg%2F7pcKZR0iEP6qXjJzxoedLRAPD4QqUb%2FqMJIPSQsw%3D%3D'; /*Service Key*/
    queryParams += '&' + encodeURIComponent('searchWrd') + '=' + encodeURIComponent(place_name); /**/
    xhr.open('GET', url + queryParams);
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            console.log("산정보 출력 성공!");
            parseData(this.responseXML)
        }
    };
    xhr.send('');
}

/* 이미지정보가져오기 */
function mountainImage(mntiListNo){

var xhr = new XMLHttpRequest();
var url = 'http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoImgOpenAPI'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'wsf7xD22zr%2FlqPjRLk0IxbaBlV0LxUbyDCUsVW3VcAGfg%2F7pcKZR0iEP6qXjJzxoedLRAPD4QqUb%2FqMJIPSQsw%3D%3D'; /*Service Key*/
queryParams += '&' + encodeURIComponent('mntiListNo') + '=' + encodeURIComponent(mntiListNo); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        console.log("산정보 출력 성공!");
        parseImageData(this.responseXML)
    }
};
xhr.send('');
}

/* 산정보 받아온 데이터 처리하기 */
function parseData(respXML) {
    console.log(respXML);

    // console.log(respXML.getElementsByTagName("crtymd")[0]);
    // HTML의 DOM 처리와 같은 방식으로 첫 번째 child요소의 Entity 값을 가져온다.
    var mauntaincode = respXML.getElementsByTagName("mntilistno")[0].firstChild.nodeValue;
    // testtext.innerText = respXML.getElementsByTagName("mntiname")[0].firstChild.nodeValue
    //                     +"\n 주소 : "+respXML.getElementsByTagName("mntiadd")[0].firstChild.nodeValue
    //                     +"\n 산높이 : "+respXML.getElementsByTagName("mntihigh")[0].firstChild.nodeValue
    //                     +"\n 문의 : "+respXML.getElementsByTagName("mntiadminnum")[0].firstChild.nodeValue
    //                     +"\n"+respXML.getElementsByTagName("mntidetails")[0].firstChild.nodeValue;

    textMountainName.innerText = respXML.getElementsByTagName("mntiname")[0].firstChild.nodeValue;
    textMountainhigh.innerText = respXML.getElementsByTagName("mntihigh")[0].firstChild.nodeValue + "m";
    textMountainaddress.innerText = respXML.getElementsByTagName("mntiadd")[0].firstChild.nodeValue;
    textDetail.innerText = respXML.getElementsByTagName("mntidetails")[0].firstChild.nodeValue;

    mountainImage(mauntaincode);
}

function parseImageData(respXML) {
    console.log(respXML);
    // window.alert(respXML.getElementsByTagName("imgfilename")[0].firstChild.nodeValue);
    const imgNum = respXML.getElementsByTagName("imgfilename")[0].firstChild.nodeValue;
    console.log(respXML.getElementsByTagName("imgfilename")[0].firstChild.nodeValue);
    //이미지 객체를 생성한다. 속성은 다음과 같다
    //<img src="이미지파일" name="이름" width="가로너비" height="세로높이" alt="그림설명">
    // const image = new Image();
    // //image객체가 생성되어 속성들을 추가할수 있음
    // image.src = `https://www.forest.go.kr/images/data/down/mountain/${imgNum}`;
    // mountainimgfile = image; 

    jQuery('#mountainimgfile').attr("src",`https://www.forest.go.kr/images/data/down/mountain/${imgNum}`);

}


function searchHikingTrail(y,x){
    const mountainKey = "234C69E6-7090-3FC0-99A7-11A176FB4081";
    // const minx = 126.9612209730114;
    // const miny = 37.42364366720774;
    // const maxx = 126.96245634371084;
    // const maxy = 37.4311124148557;
    const minx = x - 0.001;
    const miny = y - 0.001; 
    const maxx = x*1 + 0.001; 
    const maxy = y*1 + 0.001; 
    console.log(minx,x,maxx);
    console.log(miny,y,maxy);

    var selectedMarker = null; // 디테일 맵 안에 클릭한 마커를 담을 변수

    fetch(`https://api.vworld.kr/req/data?service=data&request=GetFeature&size=20&data=LT_L_FRSTCLIMB&key=${mountainKey}&domain=http://127.0.0.1:5500&geomFilter=BOX(${minx},${miny},${maxx},${maxy})`)
    .then((response) => response.json())
    .then((data) =>  {          
        if (data.response.result.featureCollection.features[0]) {
        //주소 보여주기
        //features 전체 개수 
        const features = data.response.result.featureCollection.features;
        var polyline = [];
        // var customOverlay = [];
            for(var j = 0; j < features.length+1; j++){
                const arr = data.response.result.featureCollection.features[j].geometry.coordinates.flat();
                const currentFeacher = data.response.result.featureCollection.features[j].properties;
                console.log("번호 " + j);
                console.log("난이도 " + currentFeacher.cat_nam);
                console.log("구간거리 " + currentFeacher.sec_len);
                console.log("종점높이 " + currentFeacher.end_z);
                // var centerPoint = arr.lenght/2;
                var centerPoint = 0;
                if(arr.length >= 2){
                    //Math.floor : 소숫점 버림, 중간지점에 테그표시
                    centerPoint = Math.floor((arr.length)/2);
                    // console.log(centerPoint); 
                }else{
                    centerPoint=1;
                }
                // console.log(arr.length);

                //linePath초기화
                var linePath = [];
                // window.alert(Object.values(arr));
                // window.alert(arr[0][0]); //126
                // window.alert(arr[0][1]); //34.6    
            
                for(var i = 0; i < arr.length; i++){
                    linePath[i] = new kakao.maps.LatLng(arr[i][1]*1, arr[i][0]*1);
                }                                               
                
                var content = '<div class ="label"><span class="left"></span><span class="center">'+j+'</span><span class="right"></span></div>';
                var infoContents = '<div class ="infoContents" style="padding:8px" ><p style="margin:-3px 0px -3px 0px";>등산로 번호 : '+(j*1+1)+'<br>난이도 : '+ currentFeacher.cat_nam + '<br>구간거리 : '+ currentFeacher.sec_len +'m<br> 종점높이 : '+ currentFeacher.end_z+'m</p></div>';
                
                var position = new kakao.maps.LatLng(arr[centerPoint][1]*1, arr[centerPoint][0]*1);

                // 마커에 표시할 인포윈도우를 생성합니다 
                var infowindow = new kakao.maps.InfoWindow({
                    content: infoContents,
                    removable : true
                });
                
                //마커 인포 이미지 주소
                var infoimageSrc = '/resources/images/map/hikingInfoIcon.png', // 마커이미지의 주소입니다   
                    infoimageSize = new kakao.maps.Size(35, 45), // 마커이미지의 크기입니다
                    infoimageOption = {offset: new kakao.maps.Point(16, 36)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

                // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
                var markerInfoImage = new kakao.maps.MarkerImage(infoimageSrc, infoimageSize, infoimageOption)

                //detailmapmarker를 생성합니다
                var marker1 = new kakao.maps.Marker({
                    position: position, // 마커의 위치
                    map: detailmap, // 마커를 표시할 지도
                    image: markerInfoImage,//마커이미지설정          
                    clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다     
                    });

                // customOverlay를 생성합니다.
                var customOverlay = new kakao.maps.CustomOverlay({
                    position: position,
                    content: content   
                });

                // 클릭이벤트 설정하기
                // kakao.maps.event.addListener(marker1, 'click', makeOutListener(infowindow));
                kakao.maps.event.addListener(marker1, 'click', makeOverListener(detailmap, marker1, infowindow));
                
                //난이도에 따른 선색 보여주기
                color = colorset(j,currentFeacher.cat_nam);
                var a = 0;

                polyline[j] = [ new kakao.maps.Polyline({
                    path: linePath, // 선을 구성하는 좌표배열 입니다
                    strokeWeight: 10, // 선의 두께 입니다
                    strokeColor: color,//'#FFAE00', // 선의 색깔입니다
                    strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle: 'solid' // 선의 스타일입니다
                }), a ];                    
                // 지도에 선을 표시합니다. 
                polyline[j][0].setMap(detailmap);

               
               
            }
        } else {
            window.alert("No results found");
        }
    })
    .catch((error) => console.log("error:", error));            
}

var color;

//난이도별로 표시
function colorset(n){
    if(n==0){
        color = '#006400'
    }else if(n==1){
        color = '#228B22'
    }else if(n==2){
        color = '#6AC793'
    }else if(n==3){
        color = '#78EFAD'
    }else if(n==4){
        color = '#A5FA7D'
    }else if(n==5){
        color = '#C6FF70'
    }else if(n==6){
        color = '#BEF5BE'
    }else if(n==7){
        color = '#F6AE70'
    }else if(n==8){
        color = '#A8F552'
    }else{
        color = '#AAEBAA'
    } 
    return color;
}


// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(detailmap, marker, infowindow) {
    return function() {
        infowindow.open(detailmap, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}