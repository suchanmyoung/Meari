package com.mySpring.myapp.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.member.vo.MemberVO;
import com.mySpring.myapp.member.vo.UserProfileVO;
import com.mySpring.myapp.sns.vo.ImageVO;

public interface MemberService {
	 //public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 //public int removeMember(String member_id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
	 public List<ImageVO> newImageList(String member_id) throws Exception;
	 public int userProfileUpdate(Map articleMap) throws Exception;
     public List<UserProfileVO> userProfile(String member_id) throws Exception;
}
