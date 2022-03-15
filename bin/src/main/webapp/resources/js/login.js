document.addEventListener('DOMContentLoaded', function(){
    
   

    document.querySelector(".mobile-menu").addEventListener("click", function(e){
        
        /* 선택했을 때, on을 포함하고 있으면? */
        if ( document.querySelector('.menuwrap').classList.contains('on') ){
            // $('.menuwrap').fadeOut();

            //메뉴닫힘 - on속성을 제거한다
            document.querySelector('.menuwrap').classList.remove('on');
            document.querySelector('.bar').classList.remove('on');
            document.querySelector('.mobile-menu').classList.remove('on');
            document.querySelector('.backgroundImage').classList.remove('on');
            document.querySelector('.wellcomMention').classList.remove('on');

            // //페이지 스크롤 락 레이어 추가
            // let div = document.createElement('div');
            // div.id = 'dimmed';
            // document.body.append(div);
           

            
        } else {
            //메뉴펼침 - on속성을 추가한다.
            document.querySelector('.menuwrap').classList.add('on');
            document.querySelector('.bar').classList.add('on');
            document.querySelector('.mobile-menu').classList.add('on');
            document.querySelector('.backgroundImage').classList.add('on');
            document.querySelector('.wellcomMention').classList.add('on');

            //페이지 스크롤 락 레이어 클릭 메뉴 닫기
            document.querySelector('#dimmed').addEventListener('click', function(e){
                document.querySelector(".mobile-menu").click();
            });             

        }
    });
});