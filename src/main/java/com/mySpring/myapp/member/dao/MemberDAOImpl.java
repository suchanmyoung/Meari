package com.mySpring.myapp.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.member.vo.UserProfileVO;
import com.mySpring.myapp.sns.vo.ImageVO;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

//	@Override
//	public List selectAllMemberList() throws DataAccessException {
//		List<MemberVO> membersList = null;
//		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
//		return membersList;
//	}

	
	  public int userProfileUpdate(Map articleMap) throws DataAccessException {
	      int articleNO = sqlSession.insert("mapper.member.userProfileUpdate", articleMap);
	      return articleNO;
	   }
	   
	   @Override
	   public List userProfile(String member_id) throws DataAccessException{
	      List<UserProfileVO> userProfile = sqlSession.selectList("mapper.member.userProfile", member_id);
	      return userProfile;
	   }
	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

//	@Override
//	public int deleteMember(String member_id) throws DataAccessException {
//		int result = sqlSession.delete("mapper.member.deleteMember", member_id);
//		return result;
//	}
	
	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException{
		  MemberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
		return vo;
	}

	   @Override
	   public List newImageList(String member_id) throws DataAccessException{
	      List<ImageVO> sns_newImageList = sqlSession.selectList("mapper.sns.profileFileList", member_id);
	      return sns_newImageList;
	   }
	
	
}
