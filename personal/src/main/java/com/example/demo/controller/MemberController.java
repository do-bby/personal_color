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

}
