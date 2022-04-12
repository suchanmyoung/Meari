package com.mySpring.myapp.member.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.myapp.member.service.MemberService;
import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.member.vo.UserProfileVO;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberCotnroller {

	private final MemberService memberService;
	private static final String ARTICLE_IMAGE_REPO = "C:\\upload\\profile\\article_image";

	@RequestMapping(value = "/profile")
	   private ModelAndView profile(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      HttpSession session = request.getSession();
	      MemberVO memberVO = (MemberVO)session.getAttribute("member");
	      String viewName = (String)request.getAttribute("viewName");
	      String member_id = memberVO.getMemberId();
	      
	      Map articleMap = new HashMap();
	      List<UserProfileVO> userProfile = memberService.userProfile(member_id);
	      
	      List newImageList = memberService.newImageList(member_id);      
	      ModelAndView mav = new ModelAndView(viewName);
	        mav.addObject("newImageList", newImageList);
	        mav.addObject("userProfile", userProfile);
	        return mav;
	         }
	   
	      @RequestMapping(value = "/profile/update", method =  RequestMethod.GET)
	      private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
	         String viewName = (String)request.getAttribute("viewName");
	         System.out.println(viewName);
	         ModelAndView mav = new ModelAndView();
	         mav.setViewName(viewName);
	         return mav;
	      }
	   
	   
	   
	   //프로필 업데이트중
	      @RequestMapping(value="/profile/updating" ,method = RequestMethod.POST)
	      public ModelAndView  updateUserProfile(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception { {
	         multipartRequest.setCharacterEncoding("utf-8");
	         Map articleMap = new HashMap();
	          Enumeration enu=multipartRequest.getParameterNames();    
	          while(enu.hasMoreElements()){
	             String name=(String)enu.nextElement();
	             String value=multipartRequest.getParameter(name);
	             articleMap.put(name,value);
	          }          
	          
	          String user_imageFileName= upload(multipartRequest);
	         HttpSession session = multipartRequest.getSession();
	         MemberVO memberVO = (MemberVO)session.getAttribute("member");
	         String member_id = memberVO.getMemberId();
	         articleMap.put("member_id", member_id);
	         articleMap.put("user_imageFileName", user_imageFileName);
	         
	      memberService.userProfileUpdate(articleMap);
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("redirect:/profile");
	      return mav;   
	      }
	      }
	      
	      private String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
	         String imageFileName= null;
	         Iterator<String> fileNames = multipartRequest.getFileNames();
	         
	         while(fileNames.hasNext()){
	            String fileName = fileNames.next();
	            MultipartFile mFile = multipartRequest.getFile(fileName);
	            imageFileName=mFile.getOriginalFilename();
	            File file = new File(ARTICLE_IMAGE_REPO +"\\"+ fileName);
	            if(mFile.getSize()!=0){ 
	               if(! file.exists()){ 
	                  if(file.getParentFile().mkdirs()){ 
	                        file.createNewFile(); 
	                  }
	               }
	            }
	         }
	         return imageFileName;
	      }   
	   
	   
		  @RequestMapping(value="/signupForm" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/loginForm");
		return mav;
	}
	

	@RequestMapping(value = "/logout", method =  RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/loginForm");
		return mav;
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	member = memberService.login(member);
	if(member != null) {
	    HttpSession session = request.getSession();
	    session.setAttribute("member", member);
	    session.setAttribute("isLogOn", true);
	    //mav.setViewName("redirect:/member/listMembers.do");
	    String action = (String)session.getAttribute("action");
	    session.removeAttribute("action");
	    if(action!= null) {
	       mav.setViewName("redirect:"+action);
	    }else {
	       mav.setViewName("redirect:/main?result=success");	
	    }

	}else {
	   rAttr.addAttribute("result","loginFailed");
	   mav.setViewName("redirect:/loginForm");
	}
	return mav;
	}


	@RequestMapping(value = "/*Form", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}


}
