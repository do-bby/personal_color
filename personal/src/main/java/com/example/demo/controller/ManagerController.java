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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.entity.Fashion;
import com.example.demo.entity.Member;
import com.example.demo.entity.Personal;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.FashionRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PersonalRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ManagerController {
	private final MemberRepository memberRepository;
	private final FashionRepository fashionRepository;
	private final PersonalRepository personalRepository;
	@Autowired
	ServletContext context; 
	//매니저 페이지로 이동
	@RequestMapping("/manager")
	public String formFile(Model model, @LoginUser SessionMember member) {
		String page = null;
		if(member != null) {
			model.addAttribute("memberName",member.getName());
			page = "manager";
		}else {
			page = "main";
		}
		return page;
	}
	
	@RequestMapping("/uploadFile")
	public ModelAndView uploadFile(@RequestParam("mfile") MultipartFile mfile, 
	                               @RequestParam("situation") String situation,
	                               @RequestParam("situationnum") int situationnum,
	                               @RequestParam(value="clotheinfo", required=false) String clotheinfo,
	                               @RequestParam(value="tone", required=false) int tone,
	                               @RequestParam(value="sex", required=false) int sex) {
	    ModelAndView mav = new ModelAndView();
	    System.out.println("1개가 업로드 됨");
	    String resultStr = "";
	    mav.setViewName("manager"); //처리되고 보여줄 html
	    String fileName = mfile.getOriginalFilename();
	    
	    Fashion fashion = new Fashion();
	    fashion.setSituation(situation);
	    fashion.setSitunum(situationnum);
	    fashion.setClotheimg(fileName);
	    fashion.setClotheinfo(clotheinfo);
	    fashion.setSex(sex);
	    Personal personal = new Personal();
	    personal = personalRepository.findByPnum(tone);
	    fashion.setPersonal(personal);
	    fashionRepository.save(fashion);
	    try {
	        String uploadDirectory = System.getProperty("user.home") + "/git/personal_color/personal/src/main/resources/static/assets/img/clothesimg/" + fileName;
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
	    mav.addObject("msg", resultStr);
	    mav.addObject("link", "/manager");
	    return mav;
	}
}
