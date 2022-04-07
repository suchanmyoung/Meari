package com.mySpring.myapp.commerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.myapp.commerce.controller.CommerceController;
import com.mySpring.myapp.commerce.dao.CommerceDAO;
import com.mySpring.myapp.commerce.vo.ArticleVO;
import com.mySpring.myapp.commerce.vo.ImageVO;
import com.mySpring.myapp.commerce.vo.ReplyVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class CommerceServiceImpl implements CommerceService{
	
//*****scrolling*****
	@Override
		public List<ArticleVO> selecNewArticleListPlus(Map articleMap) throws Exception{
			 
		   List<ArticleVO> commerce_newArticleList = commerceDAO.selecNewArticleListPlus(articleMap);
		     
		    System.out.println("service-commerce_newArticleList : " + commerce_newArticleList);
		     
		     
		    return commerce_newArticleList;      
		}

	
	@Autowired
	CommerceDAO commerceDAO;
	
	@Override
	public List<ArticleVO> listArticles() throws Exception{
		List<ArticleVO> commerce_articlesList =  commerceDAO.selectAllArticlesList();
        return commerce_articlesList;
	}
	
	 public List<ReplyVO> replyList(int articleNO) throws Exception{
	         System.out.println(articleNO);
	         List<ReplyVO> commerce_replyList = commerceDAO.replyList(articleNO);
	         return commerce_replyList;      
	      }
	 
	   public int addReply(ReplyVO reply) throws DataAccessException {
		      return commerceDAO.addReply(reply);
		      }
	   
	//������//
	@Override
	 public List<ArticleVO> newArticleList() throws Exception{
		 //ArticleVO�� �޾ƿðž�.. thumbnail�̶� ��������..
		 System.out.println("*****service execution*****");
	     List<ArticleVO> commerce_newArticleList = commerceDAO.selectNewArticlesList();
	     System.out.println("service-commerce_newArticleList : " + commerce_newArticleList);
	     return commerce_newArticleList;      
	  }
	
	
	//���ο� ��ƼŬ �߰� map���·� ����
	@Override
	public int addNewArticle(Map commerce_articleMap) throws Exception{
		
		System.out.println("addNewArticle����");
		System.out.println(commerce_articleMap);
		
		
		int articleNO = commerceDAO.insertNewArticle(commerce_articleMap);
		
		
		commerce_articleMap.put("articleNO", articleNO);
		commerceDAO.insertNewImage(commerce_articleMap);
		return articleNO;
	}
	
    
   //Multiple Image Upload 
   @Override
   public Map viewArticle(int articleNO) throws Exception {
      Map commerce_articleMap = new HashMap();
      ArticleVO articleVO = commerceDAO.selectArticle(articleNO);
      List<ImageVO> imageFileList = commerceDAO.selectImageFileList(articleNO);
      commerce_articleMap.put("article", articleVO);
      commerce_articleMap.put("imageFileList", imageFileList);
      
      return commerce_articleMap;
   }
   public int findHeart(int articleNO) throws Exception{
	      int commerce_findHeart = commerceDAO.findHeart(articleNO);
	      return commerce_findHeart;
	   }
	   
	   public int addHeart(int articleNO) throws Exception{
	      int commerce_addHeart = commerceDAO.addHeart(articleNO);
	      return commerce_addHeart;
	   }
	 
	   @Override
		public void modArticle(Map commerce_articleMap) throws Exception {
			commerceDAO.updateArticle(commerce_articleMap);
		}
		
		
		@Override
		   public void removeArticle(int articleNO) throws Exception {
		      commerceDAO.deleteArticleImage(articleNO);
		      commerceDAO.deleteArticle(articleNO);
		   }
		public List<ImageVO> newImageList(String member_id) throws Exception{
		      List<ImageVO> sns_newImageList = commerceDAO.newImageList(member_id);
		      return sns_newImageList;      
		   }
}