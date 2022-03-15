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
public class FileDownloadController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\upload\\sns\\article_image";
	@RequestMapping("/download")
	protected void download(@RequestParam("sns_imageFileName") String sns_imageFileName,	//占쎌뵠沃섎챷占� 占쎈솁占쎌뵬占쎌뵠�뵳占� 占쎄퐬占쎌젟
							@RequestParam("sns_articleNO") String sns_articleNO,
			                 HttpServletResponse response)throws Exception {
		OutputStream out = response.getOutputStream();
		System.out.println(sns_articleNO);
		System.out.println(sns_imageFileName);
		String downFile = ARTICLE_IMAGE_REPO + "\\" +sns_articleNO+"\\"+ sns_imageFileName;	//占쎈솁占쎌뵬 野껋럥以� 占쎄퐬占쎌젟
		File file = new File(downFile);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + sns_imageFileName);
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
