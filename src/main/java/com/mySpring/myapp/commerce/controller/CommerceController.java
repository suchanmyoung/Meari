package com.mySpring.myapp.commerce.controller;

import com.mySpring.myapp.commerce.service.CommerceService;
import com.mySpring.myapp.commerce.vo.ArticleVO;
import com.mySpring.myapp.commerce.vo.ImageVO;
import com.mySpring.myapp.commerce.vo.ReplyVO;
import com.mySpring.myapp.member.service.MemberService;
import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.member.vo.UserProfileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommerceController {

	//파일 이미지 경로
	private static final String ARTICLE_IMAGE_REPO = "C:\\upload\\commerce\\article_image";

	private final CommerceService commerceService;
    private final MemberService memberService;

	  @RequestMapping(value="/commerce/addHeart", method = RequestMethod.GET)
      @ResponseBody
      public String addHeart(@RequestParam("articleNO") int articleNO,  
            HttpServletRequest request, HttpServletResponse response) throws Exception{
      
      
         commerceService.addHeart(articleNO);
         int likecnt = commerceService.findHeart(articleNO);
         String likecnts = Integer.toString(likecnt);
         return likecnts;
        }
	   
	   @RequestMapping(value="/commerce/comment" ,method =   RequestMethod.POST)
	   public ModelAndView comment(@ModelAttribute("reply") ReplyVO reply, HttpServletRequest request, HttpServletResponse response) throws Exception {
	      // TODO Auto-generated method stub
	         request.setCharacterEncoding("utf-8");
	         int result = 0;
	         result = commerceService.addReply(reply);
	         ModelAndView mav = new ModelAndView("redirect:/commerce/detail?articleNO="+reply.getCommerce_articleNO());
	         return mav;
	      }
	   
	   
		//*****scrolling*****
		//for infinite pagination
		@RequestMapping(value = "/test.action", method = { RequestMethod.POST })
		@ResponseBody
		public List<ArticleVO> test(@RequestParam Long lastArticleId, @RequestParam int size) throws Exception{ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
			System.out.println("****** ArticleId : " + lastArticleId +" / pageSize : "+size + "*****");
			Map articleMap = new HashMap();
			articleMap.put("commerce_articleNO",lastArticleId);
			List<ArticleVO> newArticleList = commerceService.selecNewArticleListPlus(articleMap);
			return newArticleList;
		}
	
	   
	
	@RequestMapping(value="/commerce" ,method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView newImageList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//보여줄 viewName가져오기.. /commerce/new
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("Controler-viewNmae : " + viewName); 
		//articleList를 보여줄거임.. 
		List newArticleList = commerceService.newArticleList();
		//modelandview 가져오기
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println("Controler-newArticleList : " + newArticleList);
		System.out.println(System.identityHashCode(newArticleList));
		//modelandview에 추가하기
		mav.addObject("newArticleList", newArticleList);
		return mav;
   }
	
	
	//commerce detail 
	@RequestMapping(value = "/commerce/detail")
	   public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO,
	              HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	         String viewName = (String)request.getAttribute("viewName");
	         
	         Map articleMap = commerceService.viewArticle(articleNO);
	         
	         ModelAndView mav = new ModelAndView();
	         
	         List<ReplyVO> replyList = commerceService.replyList(articleNO);
	            mav.addObject("replyList",replyList);
	            
	         mav.setViewName(viewName);
	         
	         mav.addObject("article", articleMap);
	         
	         return mav;
	   }
	
	@RequestMapping(value = "chat/main")
	private ModelAndView chat_main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = "chat/room")
	private ModelAndView chat_room(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = "commerce/write")
	private ModelAndView commerce_write(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	
	 //Multiple Image Upload
   @RequestMapping(value="/commercePost" ,method = RequestMethod.POST)
   @ResponseBody
   public ResponseEntity  addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
	    
	 System.out.println("commercePost 실행");
	   multipartRequest.setCharacterEncoding("utf-8");
    //이미지파일 초기화
    String commerce_imageFileName=null;
    
    //허쉬맵 변수를 하나 선언해준다
    Map articleMap = new HashMap();
    
    Enumeration enu=multipartRequest.getParameterNames();
    
    while(enu.hasMoreElements()){
       String name=(String)enu.nextElement();
       String value=multipartRequest.getParameter(name);
       articleMap.put(name,value);
    }
    
    // 현재 우리가 받아온 값은 articleMap에 있어~ 
    System.out.println("Enumeration 실행");
  
    //아티클맵 변수 들어오는지 확인
    System.out.println(articleMap);
    
    //세션받아
    HttpSession session = multipartRequest.getSession();
    
    //맴버VO 선언
    MemberVO memberVO = (MemberVO) session.getAttribute("member");
    
    //ID 변수 선언
    String id = memberVO.getMemberId();
    
    //ID를 추가해준다 
    articleMap.put("member_id",id);
    
    
    
    //추가된아티클맵 확인
    System.out.println(articleMap);
    
    //파일받아오기 
    List<String> fileList=upload(multipartRequest);
    System.out.println("썸네일 : "+fileList.get(0).toString());
    String thumbnail = fileList.get(0).toString();
    //articleMap에 좋아요 초깃값 0 추가
    articleMap.put("commerce_like",0);
    //articleMap에 썸네일 추가
    articleMap.put("commerce_thumbnailfilename",thumbnail);

    //List<String> fileList = null;
    List<ImageVO> imageFileList = new ArrayList<ImageVO>();
    
    if(fileList!= null && fileList.size()!=0) {
       for(String imageFileName : fileList) {
          ImageVO imageVO = new ImageVO();
          
          //이미지VO에다가 imageFileName을 넣어줌
          imageVO.setCommerce_imageFileName(imageFileName);
          
          System.out.println("이미지파일네임확인");
          System.out.println(imageFileName);
          
          imageFileList.add(imageVO);
       }
       articleMap.put("imageFileList", imageFileList);
    }
    
    //추가된아티클맵 확인
    System.out.println(articleMap);
    
    
    String message;
    ResponseEntity resEnt=null;
    
   //응답헤더를 정의해준다
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
     
    
    try {
    	
    // 아티클 넘버를 새로 가지고온다~
      int commerce_articleNO = commerceService.addNewArticle(articleMap);
       
       if(imageFileList!=null && imageFileList.size()!=0) {
          for(ImageVO  imageVO:imageFileList) {
             commerce_imageFileName = imageVO.getCommerce_imageFileName();
             File srcFile = new File(ARTICLE_IMAGE_REPO+"\\temp\\"+commerce_imageFileName);
             File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+commerce_articleNO);
             //destDir.mkdirs();
             FileUtils.moveFileToDirectory(srcFile, destDir,true);
          }
       }
       message ="<head> <script type=\"text/javascript\" src=\"/resources/js/sweetalert.js\"></script></head>";
       message += "<script> Swal.fire({position:'top-end',icon:'success',title:'업로드 성공',showConfirmButton:false,timer:1500}); "; 
       message +="location.href='"+multipartRequest.getContextPath()+"/commerce'; ";
       message +="</script>";
//            
//       message +="";
//       message += "<script>";
//       message += " Swal.fire({position:'top-end',icon:'success',title:'업로드 성공',showConfirmButton:false,timer:1500});";
//       message += " location.href='"+multipartRequest.getContextPath()+"/commerce'; ";
//       message +=" </script>";
       
        resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);     
    }catch(Exception e) {
       if(imageFileList!=null && imageFileList.size()!=0) {
         for(ImageVO  imageVO:imageFileList) {
            commerce_imageFileName = imageVO.getCommerce_imageFileName();
          File srcFile = new File(ARTICLE_IMAGE_REPO+"\\temp\\"+commerce_imageFileName);
           srcFile.delete();
         }
       } 
       message = " <script>";
       message +=" alert('upload실패');";
       message +=" location.href='"+multipartRequest.getContextPath()+"/main?'; ";
       message +=" </script>";
       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
       e.printStackTrace();
    }
    return resEnt;
   }
   
   
   private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception{
	  //애도 멀티파트리퀘스트를 받네?
	  
	   System.out.println("upload실행");
	   
	  //파일리스트 선언
      List<String> fileList= new ArrayList<String>();
      
      //파네임 가져와서 파일네임즈에 넣기
      Iterator<String> fileNames = multipartRequest.getFileNames();
      
      
      while(fileNames.hasNext()){
    	  	//파일네임을 하니씩 분리해서 저장하는 과정
	         String fileName = fileNames.next();
	         
	         //멀티파일이라는 변수에대가 저장해준다.
	         MultipartFile mFile = multipartRequest.getFile(fileName);
	         //오리진파일네임을 실행해서오리진파일네임에다가 저장해준다.
	         String originalFileName=mFile.getOriginalFilename();
	         System.out.println(originalFileName);
	        
	         if(originalFileName!="") {
	        	 //결국 중요한건 오리진 파일네임이네?
	        	 fileList.add(originalFileName);
	         }
	         
	         
	         File file = new File(ARTICLE_IMAGE_REPO +"\\"+ fileName);
	         if(mFile.getSize()!=0){ 
	            if(! file.exists()){ 
	               if(file.getParentFile().mkdirs()){ 
	                     file.createNewFile(); 
	               }
	            }
//	            mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\temp\\"+originalFileName));
	         }
      		}
	      
      
      return fileList;
   }
   
   @RequestMapping(value="/commerce/removeArticle" ,method =   RequestMethod.POST)
   @ResponseBody
   public ResponseEntity  removeArticle(@RequestParam("articleNO") int articleNO,
                               HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/html; charset=UTF-8");
    String message;
    ResponseEntity resEnt=null;
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    try {
       commerceService.removeArticle(articleNO);
       File destDir = new File(ARTICLE_IMAGE_REPO+"/"+articleNO);
       FileUtils.deleteDirectory(destDir);
       
       message = "<script>";
       message += " location.href='"+request.getContextPath()+"/commerce';";
       message +=" </script>";
        resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
           
    }catch(Exception e) {
       message = "<script>";
       message += " alert('dont remove this article.');";
       message += " location.href='"+request.getContextPath()+"/commerce';";
       message +=" </script>";
        resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
        e.printStackTrace();
    }
    return resEnt;
   }
   
   /* modArticle  */   
   @RequestMapping(value="/commerce/updating" ,method = RequestMethod.POST)
   @ResponseBody
   public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  
     HttpServletResponse response) throws Exception{
     multipartRequest.setCharacterEncoding("utf-8");
    Map<String,Object> articleMap = new HashMap<String, Object>();
    Enumeration enu=multipartRequest.getParameterNames();
    while(enu.hasMoreElements()){
       String name=(String)enu.nextElement();
       String value=multipartRequest.getParameter(name);
       articleMap.put(name,value);
    }
    
    
    List<String> imageFileName= upload(multipartRequest);
    HttpSession session = multipartRequest.getSession();
    MemberVO memberVO = (MemberVO) session.getAttribute("member");
    String id = memberVO.getMemberId();
    articleMap.put("member_id", id);
    articleMap.put("commerce_imageFileName", imageFileName);
    String articleNO= (String) articleMap.get("commerce_articleNO");
    String message;
    ResponseEntity resEnt=null;
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    commerceService.modArticle(articleMap);
    message = "<script>";
    message +="location.href='"+multipartRequest.getContextPath()+"/commerce/detail?articleNO="+articleNO+"';";
    message +="</script>";
    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
     return resEnt;
   }
   
   @RequestMapping(value="/commerce/update" ,method = RequestMethod.GET)
   public ModelAndView updateArticle(@RequestParam("articleNO") int articleNO,
           HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      Map articleMap=commerceService.viewArticle(articleNO);
      ModelAndView mav = new ModelAndView();
      mav.setViewName(viewName);
      mav.addObject("article", articleMap);
      return mav;
   }
   
   @RequestMapping(value = "/profile/commerce")
   private ModelAndView profile_commerce(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      MemberVO memberVO = (MemberVO)session.getAttribute("member");
      String viewName = (String)request.getAttribute("viewName");
      String member_id = memberVO.getMemberId();
      
      Map articleMap = new HashMap();
      List<UserProfileVO> userProfile = memberService.userProfile(member_id);
      
      
       List newImageList = commerceService.newImageList(member_id);
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("newImageList", newImageList);
        mav.addObject("userProfile", userProfile);
        return mav;
         }
   
}