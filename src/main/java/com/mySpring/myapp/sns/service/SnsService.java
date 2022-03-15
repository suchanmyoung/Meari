package com.mySpring.myapp.sns.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.sns.vo.ArticleVO;
import com.mySpring.myapp.sns.vo.ImageVO;
import com.mySpring.myapp.sns.vo.ReplyVO;

public interface SnsService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	//public ArticleVO viewArticle(int articleNO) throws Exception;
	public Map viewArticle(int articleNO) throws Exception;
	
	 public List<ReplyVO> replyList(int articleNO) throws Exception;



	public int addHeart(int artcileNO) throws Exception;
	
	public void heartCnt(Map articleMap) throws Exception;
	
	
	public int findHeart(int articleNO) throws Exception;
	
	public void modArticle(Map articleMap) throws Exception;
	
	public boolean isNullHeart(Map articleMap) throws Exception;
	
	 public int addReply(ReplyVO replyVO) throws DataAccessException;
	
	public List<ImageVO> newImageList() throws Exception;
	public List<ImageVO> popularImageList() throws Exception;
	public void removeArticle(int articleNO) throws Exception;
}
