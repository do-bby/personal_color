package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PersonalRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	//메인페이지 이동
	@GetMapping("/")
	public String login(Model model, @LoginUser SessionMember member) {
			
		if(member != null) {
			model.addAttribute("memberName",member.getName());
		}
		return "main";
	}
	
	//웹캠 연결
	@GetMapping("/camera")
	public String webcam() {
		return "webcam";
	}

}
