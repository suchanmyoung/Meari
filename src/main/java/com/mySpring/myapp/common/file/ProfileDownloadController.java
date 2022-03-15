package com.mySpring.myapp.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProfileDownloadController {
   //image file root 
   private static final String ARTICLE_IMAGE_REPO = "C:\\upload\\commerce\\article_image";
   
   //commerce_download�� ��û�Ǹ� => ��ûȮ�ο�
   @RequestMapping("/profile_download")
   
   //mepper���� requestParam�Ѵ�.
   protected void download(@RequestParam("commerce_articleNO") String commerce_articleNO,
		   @RequestParam("commerce_imageFileName") String commerce_imageFileName,
                          HttpServletResponse response)throws Exception {
      
	  //what is OutputStream..?
	  OutputStream out = response.getOutputStream();
	  
	  System.out.println("*****thumbnai download lexcution*****");
      System.out.println("commerce_articleNO : "+commerce_articleNO);
      System.out.println("commerce_imageFileName : "+commerce_imageFileName);
      
      
      String downFile = ARTICLE_IMAGE_REPO + "\\" +commerce_articleNO+"\\"+ commerce_imageFileName;   
      File file = new File(downFile);

      response.setHeader("Cache-Control", "no-cache");
      response.addHeader("Content-disposition", "attachment; fileName=" + commerce_imageFileName);
      
      FileInputStream in = new FileInputStream(file);
      
      
      byte[] buffer = new byte[1024 * 8];
      while (true) {
         int count = in.read(buffer); 
         if (count == -1) 
            break;
         out.write(buffer, 0, count);
      }
      in.close();
      out.close();
   }

}