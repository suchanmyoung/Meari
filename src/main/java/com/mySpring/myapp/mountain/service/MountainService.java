package com.mySpring.myapp.mountain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mySpring.myapp.mountain.dao.MountainDAO;
import com.mySpring.myapp.mountain.vo.MountainVO;


@Service("mountainService")
public class MountainService {
   @Autowired
   private MountainDAO mountainDAO;
   

   
   public int insertMountain(MountainVO mountain) throws DataAccessException {
      int mountains =  mountainDAO.insertMountain(mountain);
      return mountains;
   }

   
}