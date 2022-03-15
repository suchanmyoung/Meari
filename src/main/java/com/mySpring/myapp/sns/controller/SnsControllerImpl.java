package com.mySpring.myapp.sns.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.sns.service.SnsService;
import com.mySpring.myapp.sns.vo.ArticleVO;
import com.mySpring.myapp.sns.vo.ImageVO;
import com.mySpring.myapp.sns.vo.ReplyVO;


@Controller("snsController")
public class SnsControllerImpl  implements SnsController{
   private static final String ARTICLE_IMAGE_REPO = "C:\\upload\\sns\\article_image";
   
   @Autowired
   private SnsService snsService;
   @Autowired
   private ArticleVO articleVO;
   @Autowired
   private ImageVO imageVO;


   @Override
   @RequestMapping(value="/comment" ,method =   RequestMethod.POST)
   public ModelAndView comment(@ModelAttribute("reply") ReplyVO reply, HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
         request.setCharacterEncoding("utf-8");
         int result = 0;
         result = snsService.addReply(reply);
         ModelAndView mav = new ModelAndView("redirect:/sns/feed?articleNO="+reply.getSns_articleNO());
         return mav;
      }
   
   @Override
   @RequestMapping(value="/sns/new" ,method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView newImageList(HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      List newImageList = snsService.newImageList();
      ModelAndView mav = new ModelAndView(viewName);
      mav.addObject("newImageList", newImageList);
      return mav;
   }
 
   
   @Override
   @RequestMapping(value="/sns/popular" ,method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView popularImageList(HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      List popularImageList = snsService.popularImageList();
      ModelAndView mav = new ModelAndView(viewName);
      mav.addObject("popularImageList", popularImageList);
      return mav;
   }
   
   @RequestMapping(value="/sns/feed" ,method = RequestMethod.GET)
   public  ModelAndView viewArticle(@RequestParam("articleNO") int articleNO,
           HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      Map articleMap=snsService.viewArticle(articleNO);
      ModelAndView mav = new ModelAndView();
      
      List<ReplyVO> replyList = snsService.replyList(articleNO);
      mav.addObject("replyList",replyList);
      mav.setViewName(viewName);
      mav.addObject("article", articleMap);
      return mav;
   }
   
   //여기하는중
   @RequestMapping(value="/sns/addHeart", method = RequestMethod.GET)
   @ResponseBody
   public String addHeart(@RequestParam("articleNO") int articleNO,  
		   HttpServletRequest request, HttpServletResponse response) throws Exception{
	   HttpSession session = request.getSession();
	   MemberVO memberVO = (MemberVO)session.getAttribute("member");
	   String id = memberVO.getMember_id();	   
	   Map articleMap = new HashMap();
	   articleMap.put("member_id",id);
	   articleMap.put("sns_articleNO", articleNO);
	   
	   boolean result = snsService.isNullHeart(articleMap);
	   System.out.println(result);
	   if(result == true) {
	   snsService.heartCnt(articleMap);
	   snsService.addHeart(articleNO);
	   }
	   else {
	         snsService.addHeart(articleNO);
	      }
	   
	   
	   int likecnt = snsService.findHeart(articleNO);
	   System.out.println(likecnt);
	   String likecnts = Integer.toString(likecnt);
	   return likecnts;
	  }
   
   
   
   
      

   //go to sns/write tiles
   @RequestMapping(value = "/sns/write", method =  RequestMethod.GET)
   private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String viewName = (String)request.getAttribute("viewName");
      System.out.println(viewName);
      ModelAndView mav = new ModelAndView();
      mav.setViewName(viewName);
      return mav;
   }
   
   //Multiple Image
   @Override
   @RequestMapping(value="/sns/writing" ,method = RequestMethod.POST)
   @ResponseBody
   public ResponseEntity  addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
    multipartRequest.setCharacterEncoding("utf-8");
    String sns_imageFileName=null;
    
    Map articleMap = new HashMap();
    Enumeration enu=multipartRequest.getParameterNames();
    while(enu.hasMoreElements()){
       String name=(String)enu.nextElement();
       String value=multipartRequest.getParameter(name);
       articleMap.put(name,value);
    }
    
    HttpSession session = multipartRequest.getSession();
    MemberVO memberVO = (MemberVO) session.getAttribute("member");
    String id = memberVO.getMember_id();
    articleMap.put("member_id",id);
    System.out.println(id);
    System.out.println(articleMap);
    
    List<String> fileList =upload(multipartRequest);
    List<ImageVO> imageFileList = new ArrayList<ImageVO>();
    if(fileList!= null && fileList.size()!=0) {
       for(String imageFileName : fileList) {
          ImageVO imageVO = new ImageVO();
          imageVO.setSns_imageFileName(imageFileName);
          imageFileList.add(imageVO);
       }
       articleMap.put("imageFileList", imageFileList);
    }
    String message;
    ResponseEntity resEnt=null;
    HttpHeaders responseHeaders = new HttpHeaders();
     responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    try {
    	System.out.println(id);
       int sns_articleNO = snsService.addNewArticle(articleMap);
       if(imageFileList!=null && imageFileList.size()!=0) {
          for(ImageVO  imageVO:imageFileList) {
             sns_imageFileName = imageVO.getSns_imageFileName();
             File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sns_imageFileName);
             File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+sns_articleNO);
             //destDir.mkdirs();
             FileUtils.moveFileToDirectory(srcFile, destDir,true);
          }
       }
           
       message = "<script>";
       message += " alert('피드 업로드 완료!');";
       message += " location.href='"+multipartRequest.getContextPath()+"/sns/new'; ";
       message +=" </script>";
        resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
        
        
    }catch(Exception e) {
       if(imageFileList!=null && imageFileList.size()!=0) {
         for(ImageVO  imageVO:imageFileList) {
            sns_imageFileName = imageVO.getSns_imageFileName();
          File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sns_imageFileName);
           srcFile.delete();
         }
       }

       message = " <script>";
       message +=" alert(' 피드 업로드 실패!');');";
       message +=" location.href='"+multipartRequest.getContextPath()+"/board/articleForm.do'; ";
       message +=" </script>";
       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
       e.printStackTrace();
    }
    return resEnt;
   }
   
   //Multiple ImageUpload
   private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception{
	   System.out.println("여긴들오나?");
      List<String> fileList= new ArrayList<String>();
      Iterator<String> fileNames = multipartRequest.getFileNames();
      while(fileNames.hasNext()){
         String fileName = fileNames.next();
         MultipartFile mFile = multipartRequest.getFile(fileName);
         String originalFileName=mFile.getOriginalFilename();
         
         if(originalFileName!="") {
         	fileList.add(originalFileName);
         }
         
         
         File file = new File(ARTICLE_IMAGE_REPO +"\\"+ fileName);
         if(mFile.getSize()!=0){ 
            if(! file.exists()){ 
               if(file.getParentFile().mkdirs()){ 
                     file.createNewFile(); 
               }
            }
            mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+ "\\"+originalFileName)); // 엫 떆濡     옣 맂 multipartFile 쓣  떎 젣  뙆 씪濡   쟾 넚
         }
      }
      return fileList;
   }
   
   /* modArticle  */   
   @RequestMapping(value="/sns/updating" ,method = RequestMethod.POST)
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
    String id = memberVO.getMember_id();
    articleMap.put("member_id", id);
    articleMap.put("sns_imageFileName", imageFileName);
    String articleNO= (String) articleMap.get("sns_articleNO");
    String message;
    ResponseEntity resEnt=null;
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    snsService.modArticle(articleMap);
    message = "<script>";
    //message += " location.href='"+multipartRequest.getContextPath()+"/sns/new';";
    message += " location.href='"+multipartRequest.getContextPath()+"/sns/feed?articleNO="+articleNO+"';";
    message +=" </script>";
    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
     return resEnt;
   }
   
   @RequestMapping(value="/sns/update" ,method = RequestMethod.GET)
   public ModelAndView updateArticle(@RequestParam("articleNO") int articleNO,
           HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      Map articleMap=snsService.viewArticle(articleNO);
      ModelAndView mav = new ModelAndView();
      mav.setViewName(viewName);
      mav.addObject("article", articleMap);
      return mav;
   }
   
   

   @Override
   @RequestMapping(value= "/notUsed", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String viewName = (String)request.getAttribute("viewName");
    List articlesList = snsService.listArticles();
    ModelAndView mav = new ModelAndView(viewName);
    mav.addObject("articlesList", articlesList);
    return mav;
   }
   

   
   @Override
   @RequestMapping(value="/board/removeArticle" ,method =   RequestMethod.POST)
   @ResponseBody
   public ResponseEntity  removeArticle(@RequestParam("articleNO") int articleNO,
                               HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/html; charset=UTF-8");
    String message;
    ResponseEntity resEnt=null;
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    try {
       snsService.removeArticle(articleNO);
       File destDir = new File(ARTICLE_IMAGE_REPO+"/"+articleNO);
       FileUtils.deleteDirectory(destDir);
       
       message = "<script>";
       message += " location.href='"+request.getContextPath()+"/sns/new';";
       message +=" </script>";
        resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
           
    }catch(Exception e) {
       message = "<script>";
       message += " alert('dont remove this article.');";
       message += " location.href='"+request.getContextPath()+"/sns/new';";
       message +=" </script>";
        resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
        e.printStackTrace();
    }
    return resEnt;
   }


@Override
public String comment(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	return null;
}  
   
/* One ImageUpload
   @Override
   @RequestMapping(value="/board/addNewArticle" ,method = RequestMethod.POST)
   @ResponseBody
   public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, 
   HttpServletResponse response) throws Exception {
      multipartRequest.setCharacterEncoding("utf-8");
      Map<String,Object> sns_articleMap = new HashMap<String, Object>();
      Enumeration enu=multipartRequest.getParameterNames();
      while(enu.hasMoreElements()){
         String name=(String)enu.nextElement();
         String value=multipartRequest.getParameter(name);
         sns_articleMap.put(name,value);
      }
      String sns_imageFileName= upload(multipartRequest);
      HttpSession session = multipartRequest.getSession();
      MemberVO memberVO = (MemberVO) session.getAttribute("member");
      String member_id = memberVO.getMember_id();
      sns_articleMap.put("member_id", member_id);
      sns_articleMap.put("sns_imageFileName", sns_imageFileName);
      String message;
      ResponseEntity resEnt=null;
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.add("Content-Type", "text/html; charset=utf-8");
      try {
         int sns_articleNO = snsService.addNewArticle(sns_articleMap);
         if(sns_imageFileName!=null && sns_imageFileName.length()!=0) {
            File srcFile = new 
            File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sns_imageFileName);
            File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+sns_articleNO);
            FileUtils.moveFileToDirectory(srcFile, destDir,true);
         }
         message = "<script>";
         message += " alert('upload success');";
         message += " location.href='"+multipartRequest.getContextPath()+"/main'; ";
         message +=" </script>";
          resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
          System.out.println("catch문이 시작되는가?");
      }
      catch(Exception e) {
         System.out.println("catch문이 시작되었는가?");
         File srcFile = new File(ARTICLE_IMAGE_REPO+sns_imageFileName);
         srcFile.delete();
         
         message = " <script>";
         message +=" alert('upload');');";
         message +=" location.href='"+multipartRequest.getContextPath()+"/main'; ";
         message +=" </script>";
         resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
         e.printStackTrace();
      }
      
      return resEnt;
   }
  */
   
   /*
   @RequestMapping(value="/board/viewArticle.do" ,method = RequestMethod.GET)
   public ModelAndView viewArticle(@RequestParam("sns_articleNO") int sns_articleNO,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      articleVO=snsService.viewArticle(sns_articleNO);
      ModelAndView mav = new ModelAndView();
      mav.setViewName(viewName);
      mav.addObject("sns_article", articleVO);
      return mav;
   }
   */
   


   

/* modArticle   
  @RequestMapping(value="/board/modArticle.do" ,method = RequestMethod.POST)
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
   
   
   String imageFileName= upload(multipartRequest);
   HttpSession session = multipartRequest.getSession();
   MemberVO memberVO = (MemberVO) session.getAttribute("member");
   String id = memberVO.getMember_id();
   articleMap.put("id", id);
   articleMap.put("imageFileName", imageFileName);
   
   String articleNO=(String)articleMap.get("articleNO");
   String message;
   ResponseEntity resEnt=null;
   HttpHeaders responseHeaders = new HttpHeaders();
   responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    try {
       snsService.modArticle(articleMap);
       if(imageFileName!=null && imageFileName.length()!=0) {
         File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
         File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
         FileUtils.moveFileToDirectory(srcFile, destDir, true);
         
         String originalFileName = (String)articleMap.get("originalFileName");
         File oldFile = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originalFileName);
         oldFile.delete();
       }   
       message = "<script>";
      message += " alert('update success');";
      message += " location.href='"+multipartRequest.getContextPath()+"/board/viewArticle.do?articleNO="+articleNO+"';";
      message +=" </script>";
       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
    }catch(Exception e) {
      File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
      srcFile.delete();
      message = "<script>";
     message += " alert('update fail');";
     message += " location.href='"+multipartRequest.getContextPath()+"/board/viewArticle.do?articleNO="+articleNO+"';";
     message +=" </script>";
      resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
    }
    return resEnt;
  }
 
  */

  

   /*One Image Upload
   private String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
      String imageFileName= null;
      Iterator<String> fileNames = multipartRequest.getFileNames();
      
      while(fileNames.hasNext()){
         String fileName = fileNames.next();
         MultipartFile mFile = multipartRequest.getFile(fileName);
         imageFileName=mFile.getOriginalFilename();
         File file = new File(ARTICLE_IMAGE_REPO +"\\"+ fileName);
         if(mFile.getSize()!=0){ //File Null Check
            if(! file.exists()){ //寃쎈줈 긽 뿉  뙆 씪 씠 議댁옱 븯吏   븡 쓣 寃쎌슦
               if(file.getParentFile().mkdirs()){ //寃쎈줈 뿉  빐 떦 븯 뒗  뵒 젆 넗由щ뱾 쓣  깮 꽦
                     file.createNewFile(); // 씠 썑  뙆 씪  깮 꽦
               }
            }
            mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+ "\\"+imageFileName)); // 엫 떆濡     옣 맂 multipartFile 쓣  떎 젣  뙆 씪濡   쟾 넚
         }
      }
      return imageFileName;
   }
   */
   
  
}