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

import com.mySpring.myapp.member.vo.Member;
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

import com.mySpring.myapp.sns.service.SnsService;
import com.mySpring.myapp.sns.vo.ImageVO;
import com.mySpring.myapp.sns.vo.ReplyVO;

@Slf4j
@RequiredArgsConstructor
@Controller
public class SnsController{
   private static final String ARTICLE_IMAGE_REPO = "C:\\upload\\sns\\article_image";

   private final SnsService snsService;

   @PostMapping(value="/comment")
   public ModelAndView comment(@ModelAttribute("reply") ReplyVO reply, HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
         request.setCharacterEncoding("utf-8");
         int result = 0;
         result = snsService.addReply(reply);
         ModelAndView mav = new ModelAndView("redirect:/sns/feed?articleNO="+reply.getSns_articleNO());
         return mav;
      }
   
   @GetMapping(value="/sns/new")
   public ModelAndView newImageList(HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      List newImageList = snsService.newImageList();
      ModelAndView mav = new ModelAndView(viewName);
      mav.addObject("newImageList", newImageList);
      return mav;
   }
 

   @GetMapping(value="/sns/popular")
   public ModelAndView popularImageList(HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      List popularImageList = snsService.popularImageList();
      ModelAndView mav = new ModelAndView(viewName);
      mav.addObject("popularImageList", popularImageList);
      return mav;
   }
   
   @GetMapping(value="/sns/feed")
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
   
   //???????????????
   @GetMapping(value="/sns/addHeart")
   @ResponseBody
   public String addHeart(@RequestParam("articleNO") int articleNO,  
		   HttpServletRequest request) throws Exception{
	   HttpSession session = request.getSession();
	   Member member = (Member)session.getAttribute("member");
	   String id = member.getId();
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
   @GetMapping(value = "/sns/write")
   private ModelAndView form(HttpServletRequest request) throws Exception {
      String viewName = (String)request.getAttribute("viewName");
      System.out.println(viewName);
      ModelAndView mav = new ModelAndView();
      mav.setViewName(viewName);
      return mav;
   }
   
   //Multiple Image
   @PostMapping(value="/sns/writing")
   @ResponseBody
   public ResponseEntity  addNewArticle(MultipartHttpServletRequest multipartRequest) throws Exception {
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
    Member member = (Member) session.getAttribute("member");
    String id = member.getId();
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
       message += " alert('?????? ????????? ??????!');";
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
       message +=" alert(' ?????? ????????? ??????!');');";
       message +=" location.href='"+multipartRequest.getContextPath()+"/board/articleForm.do'; ";
       message +=" </script>";
       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
       e.printStackTrace();
    }
    return resEnt;
   }
   
   //Multiple ImageUpload
   private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception{
	   System.out.println("????????????????");
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
         }
      }
      return fileList;
   }
   
   @PostMapping(value="/sns/updating")
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
    Member member = (Member) session.getAttribute("member");
    String id = member.getId();
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
   
   @GetMapping(value="/sns/update")
   public ModelAndView updateArticle(@RequestParam("articleNO") int articleNO,
           HttpServletRequest request, HttpServletResponse response) throws Exception{
      String viewName = (String)request.getAttribute("viewName");
      Map articleMap=snsService.viewArticle(articleNO);
      ModelAndView mav = new ModelAndView();
      mav.setViewName(viewName);
      mav.addObject("article", articleMap);
      return mav;
   }
   
   @GetMapping(value= "/notUsed")
   public ModelAndView listArticles(HttpServletRequest request) throws Exception {
    String viewName = (String)request.getAttribute("viewName");
    List articlesList = snsService.listArticles();
    ModelAndView mav = new ModelAndView(viewName);
    mav.addObject("articlesList", articlesList);
    return mav;
   }
   

   @PostMapping(value="/board/removeArticle")
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
}