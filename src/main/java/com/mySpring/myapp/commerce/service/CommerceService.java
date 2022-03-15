package com.mySpring.myapp.commerce.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.commerce.vo.ArticleVO;
import com.mySpring.myapp.commerce.vo.ImageVO;
import com.mySpring.myapp.commerce.vo.ReplyVO;

public interface CommerceService {
	public List<ArticleVO> listArticles() throws Exception;
	public List<ArticleVO> newArticleList() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
//  public ArticleVO viewArticle(int articleNO) throws Exception;
//*****scrolling*****
	public List<ArticleVO> selecNewArticleListPlus(Map articleMap) throws Exception;
	public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
    public List<ReplyVO> replyList(int articleNO) throws Exception;
	public int addHeart(int artcileNO) throws Exception;
	public int addReply(ReplyVO replyVO) throws DataAccessException;
	public int findHeart(int articleNO) throws Exception;
	public List<ImageVO> newImageList(String member_id) throws Exception;
	   
}