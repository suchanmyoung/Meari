package com.mySpring.myapp;

import com.mySpring.myapp.sns.dao.SnsDAO;
import com.mySpring.myapp.sns.dao.SnsDAOImpl;
import com.mySpring.myapp.sns.dao.UserMapper;
import com.mySpring.myapp.sns.service.SnsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserMapper userMapper;

	@GetMapping(value = "/main")
	private String main(@RequestParam(value = "result", required = false) String result, Model model) throws Exception {
		userMapper.save("testzzz", "testggg");
		model.addAttribute("result", result);
		return "/main";
	}

	@RequestMapping(value = "map")
	private ModelAndView map(HttpServletRequest request, HttpServletResponse response) {

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/chat/test", method = RequestMethod.GET)
	private ModelAndView chat(@RequestParam(value = "username", required = false) String username,
							  @RequestParam(value = "roomNum", required = false) String roomNum,
							  HttpServletRequest request,
							  HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		//HttpSession session = request.getSession();
		//session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", username);
		mav.addObject("roomNum", roomNum);
		mav.setViewName(viewName);
		return mav;
	}

	
}