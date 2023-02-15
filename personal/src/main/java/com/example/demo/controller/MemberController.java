package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	@GetMapping("/")
	public String login(Model model, @LoginUser SessionMember member) {
		
		if(member != null) {
			model.addAttribute("memberName",member.getName());
		}
		return "main";
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model, @LoginUser SessionMember member) {
		if(member != null) {
			model.addAttribute("member",member);			
		}
		
		return "mypage";
	}
	
	
	//fast api로 요청 , 받은 이미지 or rgb값을 저장해서 결과 보여주는 html로 return
	//db에 저장되있는 rgb값에 분류된 퍼스널컬러와 비교하여 member.pnum에 저장 

}
