package com.mySpring.myapp.sns.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.sns.vo.ReplyVO;


public interface SnsController {
	
	public ModelAndView comment(@ModelAttribute("reply") ReplyVO replyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;  
	
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView newImageList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popularImageList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;
	
	public ModelAndView viewArticle(@RequestParam("sns_articleNO") int sns_articleNO,
			                     HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String comment(MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;	
	
	public String addHeart(@RequestParam("sns_articleNO") int sns_articleNO,  
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateArticle(@RequestParam("sns_articleNO") int sns_articleNO,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;
	
	public ResponseEntity  removeArticle(@RequestParam("sns_articleNO") int sns_articleNO,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;

	
	
	//public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;
}
