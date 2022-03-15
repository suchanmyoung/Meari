document.addEventListener('DOMContentLoaded', function(){

    
    /* 슬라이드메뉴 토글 이벤트 */
    $('.item1').click(function(){
        $(".item1").css("background-color","rgb(126, 126, 126)");
        $(".item1").css("color","rgb(255, 255, 255)");
        $(".item2").css("background-color","rgb(255, 255, 255)");
        $(".item2").css("color","rgb(126, 126, 126)");
        $('#slected-mountainInfo').hide();
        $('#detailmap').show();
    });
    $('.item2').click(function(){
        $(".item2").css("background-color","rgb(126, 126, 126)");
        $(".item2").css("color","rgb(255, 255, 255)");
        $(".item1").css("background-color","rgb(255, 255, 255)");
        $(".item1").css("color","rgb(126, 126, 126)");
        $('#detailmap').hide();
        $('#slected-mountainInfo').show();
    });




    document.querySelector(".mobile-menu").addEventListener("click", function(e){
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

	//searchbar
	 document.querySelector(".searchIcon").addEventListener("click", function(e){
		
		
		 if ( document.querySelector('.keywordSearchBox').classList.contains('on') ){
			document.querySelector('.keywordSearchBox').classList.remove('on');
			
		}else {
			document.querySelector('.keywordSearchBox').classList.add('on');
		}
	
	});










});

