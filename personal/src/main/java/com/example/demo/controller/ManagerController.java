package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.ColorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ManagerController {
	@Autowired
	ServletContext context; 
	//매니저 페이지로 이동
	@RequestMapping("/manager")
	public void formFile() {
	}
	
	//파일업로드 
	@RequestMapping("/uploadFile")
	public ModelAndView uploadFile(MultipartRequest mreq) {
		ModelAndView mav = new ModelAndView();
		List<MultipartFile> list = mreq.getFiles("mfile");
		System.out.println(list.size()+"개가 업로드 됨");
		String resultStr = "";
		mav.setViewName("manager"); //처리되고 보여줄 html
		for (MultipartFile mfile : list) {
			String fileName = mfile.getOriginalFilename();
			try {
				String uploadDirectory = System.getProperty("user.home") + "git/personal_color/personal/src/main/resources/static/assets/" + fileName;
				File f = new File(uploadDirectory);
				if (f.exists()) {
					resultStr += fileName + " : 파일이 이미 존재해요!!<br>";
				} else {
					mfile.transferTo(f);
					resultStr += fileName + " : 파일이 저장되었어요!!<br>";
				}
			} catch (IOException e) {
				e.printStackTrace();
				resultStr += fileName + " : 오류가 발생했어요!!<br>";				
			}
		}
		mav.addObject("msg", resultStr);	
		return mav;
	}
}
