package com.mySpring.myapp.sns.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.myapp.sns.vo.ArticleVO;
import com.mySpring.myapp.sns.vo.HeartVO;
import com.mySpring.myapp.sns.vo.ImageVO;
import com.mySpring.myapp.sns.vo.ReplyVO;


@Repository("snsDAO")
public class SnsDAOImpl implements SnsDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> sns_articlesList = sqlSession.selectList("mapper.sns.selectAllArticlesList");
		return sns_articlesList;
	}

	   @Override
	   public List replyList(int sns_articleNO) throws DataAccessException{
	      List<ReplyVO> sns_replyList = sqlSession.selectList("mapper.sns.replyList", sns_articleNO);
	      return sns_replyList;
	   }
	   
	@Override
	public void heartCnt(Map articleMap) {
		sqlSession.insert("mapper.sns.heartCnt", articleMap);		
	}

	
	@Override
	public boolean isNullHeart(Map articleMap) throws DataAccessException{
		List <HeartVO> isNullHeart = sqlSession.selectList("mapper.sns.isNullHeart", articleMap);
		boolean nullCheck =	isNullHeart.isEmpty();
		return nullCheck;
	}
	
	   @Override
	   public int addReply(ReplyVO reply) throws DataAccessException {
	      int result = sqlSession.insert("mapper.sns.addReply", reply);
	      return result;
	   }
	
	
	public int findHeart(int sns_articleNO) throws DataAccessException{
		List<ArticleVO> sns_findHearts = sqlSession.selectList("mapper.sns.findHeart", sns_articleNO);
		int sns_findHeart = sns_findHearts.get(0).getSns_heart();
		return sns_findHeart;
	}
	
	
	//���⵵ ����
	@Override
	public int addHeart(int sns_articleNO) throws DataAccessException{
		System.out.println("���Գ�");
		System.out.println(sns_articleNO);
		int sns_addHeart = sqlSession.update("mapper.sns.addHeart", sns_articleNO);
		return sns_addHeart;
	}
	
	

	@Override
	public List newImageList() throws DataAccessException{
		List<ImageVO> sns_newImageList = sqlSession.selectList("mapper.sns.newImageList");
		return sns_newImageList;
	}
	
	@Override
	public List popularImageList() throws DataAccessException{
		List<ImageVO> sns_popularImageList = sqlSession.selectList("mapper.sns.popularImageList");
		return sns_popularImageList;
	}
	
	@Override
	public int insertNewArticle(Map sns_articleMap) throws DataAccessException {
		int sns_articleNO = selectNewArticleNO();
		sns_articleMap.put("sns_articleNO", sns_articleNO);
		sqlSession.insert("mapper.sns.insertNewArticle",sns_articleMap);
		return sns_articleNO;
	}
 
		@Override
		
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList){
			imageVO.setSns_imageFileNO(++imageFileNO);
			imageVO.setSns_articleNO(articleNO);
		}
		sqlSession.insert("mapper.sns.insertNewImage",imageFileList);
	}

	
	@Override
	public ArticleVO selectArticle(int sns_articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.sns.selectArticle", sns_articleNO);
	}

	@Override
	public void updateArticle(Map sns_articleMap) throws DataAccessException {
		sqlSession.update("mapper.sns.updateArticle",sns_articleMap);
	}

	@Override
	   public void deleteArticle(int sns_articleNO) throws DataAccessException {
	      sqlSession.delete("mapper.sns.deleteArticle", sns_articleNO);
	      
	   }
	   
	   @Override
	   public void deleteArticleImage(int sns_articleNO) throws DataAccessException {
	      sqlSession.delete("mapper.sns.deleteArticleImage", sns_articleNO);
	      
	   }
	
	@Override
	public List selectImageFileList(int sns_articleNO) throws DataAccessException {
		List<ImageVO> sns_imageFileList = null;
		sns_imageFileList = sqlSession.selectList("mapper.sns.selectImageFileList",sns_articleNO);
		return sns_imageFileList;
	}
	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.sns.selectNewArticleNO");
	}
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.sns.selectNewImageFileNO");
	}

}
