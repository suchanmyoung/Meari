package com.mySpring.myapp.member.service;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.myapp.member.dao.MemberDAO;
import com.mySpring.myapp.member.vo.Member;
import com.mySpring.myapp.member.vo.UserProfileVO;
import com.mySpring.myapp.sns.vo.ImageVO;


@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberDAO memberDAO;

	public void join(Member member){
		memberDAO.joinMember(member);
	}

    public Member login(Member member){
        return memberDAO.loginById(member);
    }



	public int userProfileUpdate(Map articleMap) throws Exception {
        int articleNO = memberDAO.userProfileUpdate(articleMap);
        return articleNO;
    }

    public List<UserProfileVO> userProfile(String member_id) throws Exception {
        List<UserProfileVO> userProfile = memberDAO.userProfile(member_id);
        return userProfile;
    }

    public List<ImageVO> newImageList(String member_id) throws Exception {
        List<ImageVO> sns_newImageList = memberDAO.newImageList(member_id);
        return sns_newImageList;
    }

}
