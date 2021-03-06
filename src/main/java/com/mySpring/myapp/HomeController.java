package com.mySpring.myapp;

import com.mySpring.myapp.sns.dao.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

	private final UserMapper userMapper;

	@GetMapping(value = "/")
	private String main(@RequestParam(value = "result", required = false) String result, Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("result", result);
		return "/";
	}

	@GetMapping(value = "map")
	private ModelAndView map(HttpServletRequest request) {

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@GetMapping(value = "/chat/test")
	private ModelAndView chat(@RequestParam(value = "username", required = false) String username,
							  @RequestParam(value = "roomNum", required = false) String roomNum,
							  HttpServletRequest request) throws Exception {

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