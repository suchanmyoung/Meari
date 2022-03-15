     function backToList(obj){
       obj.action="/sns/feed";
       obj.submit();
     }
 
    function fn_enable(obj){
       document.getElementById("i_title").disabled=false;
       document.getElementById("i_content").disabled=false;
       document.getElementById("i_imageFileName").disabled=false;
       document.getElementById("tr_btn_modify").style.display="block";
       document.getElementById("tr_file_upload").style.display="block";
       document.getElementById("tr_btn").style.display="none";
    }
    
/*     function fn_modify_article(obj){
       obj.action="${contextPath}/board/modArticle.do";
       obj.submit();
    }
    
    function fn_remove_article(url,articleNO){
       var form = document.createElement("form");
       form.setAttribute("method", "post");
       form.setAttribute("action", url);
        var articleNOInput = document.createElement("input");
        articleNOInput.setAttribute("type","hidden");
        articleNOInput.setAttribute("name","articleNO");
        articleNOInput.setAttribute("value", articleNO);
       
        form.appendChild(articleNOInput);
        document.body.appendChild(form);
        form.submit();
    
    } 
    */
    function fn_reply_form(url, parentNO){
       var form = document.createElement("form");
       form.setAttribute("method", "post");
       form.setAttribute("action", url);
        var parentNOInput = document.createElement("input");
        parentNOInput.setAttribute("type","hidden");
        parentNOInput.setAttribute("name","parentNO");
        parentNOInput.setAttribute("value", parentNO);
       
        form.appendChild(parentNOInput);
        document.body.appendChild(form);
       form.submit();
    }
    
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    } 