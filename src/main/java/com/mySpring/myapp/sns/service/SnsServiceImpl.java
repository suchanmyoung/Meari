package com.mySpring.myapp.sns.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.myapp.sns.dao.SnsDAO;
import com.mySpring.myapp.sns.vo.ArticleVO;
import com.mySpring.myapp.sns.vo.ImageVO;
import com.mySpring.myapp.sns.vo.ReplyVO;


@Service("snsService")
@Transactional(propagation = Propagation.REQUIRED)
public class SnsServiceImpl  implements SnsService{
	@Autowired
	SnsDAO snsDAO;
	
	public List<ArticleVO> listArticles() throws Exception{
		List<ArticleVO> sns_articlesList =  snsDAO.selectAllArticlesList();
        return sns_articlesList;
	}

	public List<ImageVO> newImageList() throws Exception{
		List<ImageVO> sns_newImageList = snsDAO.newImageList();
		return sns_newImageList;		
	}
	
	 
	 public List<ReplyVO> replyList(int articleNO) throws Exception{
	      List<ReplyVO> sns_replyList = snsDAO.replyList(articleNO);
	      return sns_replyList;      
	   }
	
	public void heartCnt(Map articleMap) throws Exception{
		snsDAO.heartCnt(articleMap);
	}
	
	
	public boolean isNullHeart(Map articleMap) throws Exception{
		boolean nullCheck = snsDAO.isNullHeart(articleMap);
		return nullCheck;
	}
	
	
	public int findHeart(int articleNO) throws Exception{
		int sns_findHeart = snsDAO.findHeart(articleNO);
		System.out.println("ServiceImpl : " + sns_findHeart);
		return sns_findHeart;
	}
	

	
	
	public int addHeart(int articleNO) throws Exception{
		int sns_addHeart = snsDAO.addHeart(articleNO);
		return sns_addHeart;
	}
	
	
	public List<ImageVO> popularImageList() throws Exception{
		List<ImageVO> sns_popularImageList = snsDAO.popularImageList();
		return sns_popularImageList;
	}
	
	 public int addReply(ReplyVO reply) throws DataAccessException {
		      System.out.println(reply.getSns_articleNO());
		      System.out.println(reply.getSns_reply());
		      return snsDAO.addReply(reply);
		   }
	
	//단일 업로드
	/*
	@Override
	public int addNewArticle(Map sns_articleMap) throws Exception{
		return snsDAO.insertNewArticle(sns_articleMap);
	}
	*/
	
	
	@Override
	public int addNewArticle(Map sns_articleMap) throws Exception{
		int articleNO = snsDAO.insertNewArticle(sns_articleMap);
		sns_articleMap.put("articleNO", articleNO);
		snsDAO.insertNewImage(sns_articleMap);
		return articleNO;
	}


	//Multiple Image Upload 
	
	
	@Override
	public Map viewArticle(int articleNO) throws Exception {
		Map sns_articleMap = new HashMap();
		ArticleVO articleVO = snsDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = snsDAO.selectImageFileList(articleNO);
		sns_articleMap.put("article", articleVO);
		sns_articleMap.put("imageFileList", imageFileList);
		return sns_articleMap;
	}
	
	
	
	/*
	@Override
	public ArticleVO viewArticle(int sns_articleNO) throws Exception {
		ArticleVO sns_articleVO = snsDAO.selectArticle(sns_articleNO);
		return sns_articleVO;
	}
	*/
	@Override
	public void modArticle(Map sns_articleMap) throws Exception {
		snsDAO.updateArticle(sns_articleMap);
	}
	
	
	@Override
	   public void removeArticle(int articleNO) throws Exception {
	      snsDAO.deleteArticleImage(articleNO);
	      snsDAO.deleteArticle(articleNO);
	   }
	
	

	
}
