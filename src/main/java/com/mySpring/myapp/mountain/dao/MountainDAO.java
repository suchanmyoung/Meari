package com.mySpring.myapp.mountain.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.myapp.mountain.vo.MountainVO;

   @Repository("mountainDAO")
   public class MountainDAO {
   @Autowired
   private SqlSession sqlSession;
   
   
   public int insertMountain(MountainVO mountain) throws DataAccessException {
      int result = sqlSession.insert("mapper.mountain.insertMountain", mountain);
      return result;
   }

   
   
}