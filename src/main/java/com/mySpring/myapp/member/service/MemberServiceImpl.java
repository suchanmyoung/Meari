package com.mySpring.myapp.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.myapp.member.dao.MemberDAO;
import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.member.vo.UserProfileVO;
import com.mySpring.myapp.sns.vo.ImageVO;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

//	@Override
//	public List listMembers() throws DataAccessException {
//		List membersList = null;
//		membersList = memberDAO.selectAllMemberList();
//		return membersList;
//	}

	
	@Override
	   public int userProfileUpdate(Map articleMap) throws Exception{
	      int articleNO = memberDAO.userProfileUpdate(articleMap);
	      return articleNO;
	   }

	   public List<UserProfileVO> userProfile(String member_id) throws Exception{
	      List<UserProfileVO> userProfile = memberDAO.userProfile(member_id);
	      return userProfile;      
	   }
	   
	   
	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

//	@Override
//	public int removeMember(String member_id) throws DataAccessException {
//		return memberDAO.deleteMember(member_id);
//	}
	
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginById(memberVO);
	}

	   public List<ImageVO> newImageList(String member_id) throws Exception{
		      List<ImageVO> sns_newImageList = memberDAO.newImageList(member_id);
		      return sns_newImageList;      
		   }
		   
}