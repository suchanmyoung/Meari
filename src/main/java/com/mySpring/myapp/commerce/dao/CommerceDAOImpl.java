package com.mySpring.myapp.commerce.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.myapp.commerce.vo.ArticleVO;
import com.mySpring.myapp.commerce.vo.ImageVO;
import com.mySpring.myapp.commerce.vo.ReplyVO;

@Repository("commerceDAO")
public class CommerceDAOImpl implements CommerceDAO{
	
	@Autowired
	private SqlSession sqlSession;

//*****scrolling*****
	@Override
	public List selecNewArticleListPlus(Map articleMap) throws DataAccessException {
		System.out.println("******articleMap****** : " + articleMap);
		List<ArticleVO> commerce_newArticleList = sqlSession.selectList("mapper.commerce.selecNewArticleListPlus",articleMap);
		System.out.println("******selecNewArticleListPlus****** : " + commerce_newArticleList);
		return commerce_newArticleList;
	}
	
	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> commerce_articlesList = sqlSession.selectList("mapper.commerce.selectAllArticlesList");
		return commerce_articlesList;
	}
	
	//connect to mappers.commerce.xml//
	@Override
	public List selectNewArticlesList() throws DataAccessException {
		System.out.println("***** DAO : selectNewArticlesList Excution *****");
		List<ArticleVO> commerce_newArticleList = sqlSession.selectList("mapper.commerce.selecNewArticlesList");
		System.out.println("***** Parameters Parsing Success*****");
		return commerce_newArticleList;
	}
	
	   @Override
	   public int addReply(ReplyVO reply) throws DataAccessException {
	      System.out.println(reply.getCommerce_articleNO());
	      int result = sqlSession.insert("mapper.commerce.addReply", reply);
	      return result;
	   }
	
	@Override
	   public List replyList(int commerce_articleNO) throws DataAccessException{
	      List<ReplyVO> commerce_replyList = sqlSession.selectList("mapper.commerce.replyList", commerce_articleNO);
	      return commerce_replyList;
	   }
	
	@Override
	public int insertNewArticle(Map commerce_articleMap) throws DataAccessException {
		
		System.out.println("insertNewArticle ����");
		System.out.println(commerce_articleMap);
		
		int commerce_articleNO = selectNewArticleNO();
		
		commerce_articleMap.put("commerce_articleNO", commerce_articleNO);
	
		System.out.println("articleNo put ����");
		System.out.println(commerce_articleMap);
		
		//int insert(String statement, Object parameter);
		sqlSession.insert("mapper.commerce.insertNewArticle",commerce_articleMap);
		System.out.println("insert ����");
		
		return commerce_articleNO;
	}
 
	
		@Override
		
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList){
			imageVO.setCommerce_imageFileNO(++imageFileNO);
			imageVO.setCommerce_articleNO(articleNO);
		}
		sqlSession.insert("mapper.commerce.insertNewImage",imageFileList);
	}

	
	@Override
	public ArticleVO selectArticle(int commerce_articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.commerce.selectArticle", commerce_articleNO);
	}

	@Override
	public void updateArticle(Map commerce_articleMap) throws DataAccessException {
		sqlSession.update("mapper.commerce.updateArticle",commerce_articleMap);
	}

	@Override
   public void deleteArticle(int commerce_articleNO) throws DataAccessException {
		System.out.println("article dao start");
      sqlSession.delete("mapper.commerce.deleteArticle", commerce_articleNO);
      System.out.println("article dao end");
      
   }
	   
   @Override
   public void deleteArticleImage(int commerce_articleNO) throws DataAccessException {
	   System.out.println("image dao start");
      sqlSession.delete("mapper.commerce.deleteArticleImage", commerce_articleNO);
      System.out.println("image dao start");
      
   }
	
	@Override
	public List selectImageFileList(int commerce_articleNO) throws DataAccessException {
		List<ImageVO> commerce_imageFileList = null;
		commerce_imageFileList = sqlSession.selectList("mapper.commerce.selectImageFileList",commerce_articleNO);
		return commerce_imageFileList;
	}
	
	
	private int selectNewArticleNO() throws DataAccessException {
		System.out.println("******selectNewArticleNO execution*****");
		return sqlSession.selectOne("mapper.commerce.selectNewArticleNO");
	}
	
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.commerce.selectNewImageFileNO");
	}	
	   public int findHeart(int commerce_articleNO) throws DataAccessException{
		      List<ArticleVO> commerce_findHearts = sqlSession.selectList("mapper.commerce.findHeart", commerce_articleNO);
		      int commerce_findHeart = commerce_findHearts.get(0).getCommerce_like();
		      return commerce_findHeart;
		   }
		   
		   @Override
		   public int addHeart(int commerce_articleNO) throws DataAccessException{
		      System.out.println(commerce_articleNO);
		      int commerce_addHeart = sqlSession.update("mapper.commerce.addHeart", commerce_articleNO);
		      return commerce_addHeart;
		   }
		   @Override
		   public List newImageList(String member_id) throws DataAccessException{
		      List<ImageVO> sns_newImageList = sqlSession.selectList("mapper.commerce.profileFileList", member_id);
		      return sns_newImageList;
		   }
}