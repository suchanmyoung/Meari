package com.mySpring.myapp.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.member.vo.MemberVO;

public interface MemberDAO {
	 //public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 //public int deleteMember(String member_id) throws DataAccessException;
	 public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	 public List newImageList(String member_id) throws DataAccessException;
	 
	 public List userProfile(String member_id) throws DataAccessException;
     
	    public int userProfileUpdate(Map articleMap) throws DataAccessException;
     
}
