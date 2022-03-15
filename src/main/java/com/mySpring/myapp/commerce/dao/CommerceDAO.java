package com.mySpring.myapp.commerce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.commerce.vo.ArticleVO;
import com.mySpring.myapp.commerce.vo.ReplyVO;

public interface CommerceDAO {
//*****scrolling*****
	public List selecNewArticleListPlus(Map articleMap) throws DataAccessException;
	public List selectAllArticlesList() throws DataAccessException;
	public List selectNewArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	public void insertNewImage(Map articleMap) throws DataAccessException;
	public ArticleVO selectArticle(int commerce_articleNO) throws DataAccessException;
	public void updateArticle(Map commerce_articleMap) throws DataAccessException;
	public List replyList(int ArticleNO) throws DataAccessException;
	public int addReply(ReplyVO reply) throws DataAccessException ;

	
	public void deleteArticle(int sns_articleNO) throws DataAccessException;
	public void deleteArticleImage(int sns_articleNO) throws DataAccessException;
	public List selectImageFileList(int commerce_articleNO) throws DataAccessException;
	
	public int findHeart(int commerce_articleNO) throws DataAccessException;
	   public int addHeart(int commerce_artilceNO) throws DataAccessException;
	   public List newImageList(String member_id) throws DataAccessException;
}