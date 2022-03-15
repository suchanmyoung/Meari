package com.mySpring.myapp.sns.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.sns.vo.ArticleVO;
import com.mySpring.myapp.sns.vo.ReplyVO;


public interface SnsDAO {
	public List selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	public void insertNewImage(Map articleMap) throws DataAccessException;
	public List newImageList() throws DataAccessException;
	public List popularImageList() throws DataAccessException;

	public int findHeart(int sns_articleNO) throws DataAccessException;
	
	public List replyList(int ArticleNO) throws DataAccessException;
	 
	public void updateArticle(Map sns_articleMap) throws DataAccessException;
	
	public int addHeart(int sns_artilceNO) throws DataAccessException;
	
	public boolean isNullHeart(Map articleMap) throws DataAccessException;
	
	public void heartCnt(Map articleMap);
	
	public ArticleVO selectArticle(int sns_articleNO) throws DataAccessException;

	
	public void deleteArticle(int sns_articleNO) throws DataAccessException;
	public void deleteArticleImage(int sns_articleNO) throws DataAccessException;
	
	public List selectImageFileList(int sns_articleNO) throws DataAccessException;
	
	public int addReply(ReplyVO reply) throws DataAccessException ;
	
}
