package com.mySpring.myapp.mountain.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.myapp.mountain.service.MountainService;
import com.mySpring.myapp.mountain.vo.MountainVO;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MountainController {
   

   private final MountainService mountainService;

    @RequestMapping(value = "/mountain", method =  RequestMethod.GET)
      private ModelAndView mountain(HttpServletRequest request, HttpServletResponse response) throws Exception {
         String viewName = (String)request.getAttribute("viewName");
         ModelAndView mav = new ModelAndView();
         mav.setViewName(viewName);
         return mav;
      }
   
    
      @RequestMapping(value = "/mountain/club", method =  RequestMethod.POST)
      private ModelAndView form(@ModelAttribute("mountain") MountainVO mountain, HttpServletRequest request, HttpServletResponse response) throws Exception {
         request.setCharacterEncoding("utf-8");
         mountainService.insertMountain(mountain);
        ModelAndView mav = new ModelAndView("redirect:/main");
        return mav;
      }
      
      
   
}