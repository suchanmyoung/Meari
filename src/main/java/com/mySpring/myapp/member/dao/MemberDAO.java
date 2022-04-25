package com.mySpring.myapp.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.myapp.member.vo.Member;
import com.mySpring.myapp.member.vo.UserProfileVO;
import com.mySpring.myapp.sns.vo.ImageVO;

import javax.persistence.*;


@Repository
public class MemberDAO {
    @Autowired
    private SqlSession sqlSession;

    @PersistenceContext
    EntityManager em;

    public void joinMember(Member member){
            em.persist(member);
    }


    public Member loginById(Member member){
        return em.find(Member.class, member.getId());
    }

    public int userProfileUpdate(Map articleMap) throws DataAccessException {
        int articleNO = sqlSession.insert("mapper.member.userProfileUpdate", articleMap);
        return articleNO;
    }

    public List userProfile(String member_id) throws DataAccessException {
        List<UserProfileVO> userProfile = sqlSession.selectList("mapper.member.userProfile", member_id);
        return userProfile;
    }

    public List newImageList(String member_id) throws DataAccessException {
        List<ImageVO> sns_newImageList = sqlSession.selectList("mapper.sns.profileFileList", member_id);
        return sns_newImageList;
    }


}
