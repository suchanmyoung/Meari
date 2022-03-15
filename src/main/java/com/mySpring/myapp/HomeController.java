package com.mySpring.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
//	@RequestMapping(value = "/home")
//	public String main(Locale locale, Model model) {
//		return "main/main";
//	}
	@RequestMapping(value = "main", method =  RequestMethod.GET)
	private ModelAndView main(@RequestParam(value= "result", required=false) String result,
								HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(viewName);
		mav.addObject("result", result);
		
		return mav;
	}
	@RequestMapping(value="map")
	private ModelAndView map(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;	
	}
	
	   @RequestMapping(value = "/chat/test", method =  RequestMethod.GET)
	   private ModelAndView chat(@RequestParam(value= "username", required=false) String username,
	                       @RequestParam(value= "roomNum", required=false) String roomNum,
	                         HttpServletRequest request, 
	                         HttpServletResponse response) throws Exception {

	      String viewName = (String)request.getAttribute("viewName");
	      System.out.println(viewName);
	      //HttpSession session = request.getSession();
	      //session.setAttribute("action", action);  
	      ModelAndView mav = new ModelAndView();
	      mav.addObject("username",username);
	      mav.addObject("roomNum",roomNum);
	      mav.setViewName(viewName);
	      return mav;
	   }
	
}