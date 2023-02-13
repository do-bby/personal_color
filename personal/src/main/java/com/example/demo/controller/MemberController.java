package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.SessionMember;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String main(Model model) {
		SessionMember member = (SessionMember) httpSession.getAttribute("member");
		if(member != null) {
			model.addAttribute("memberName",member.getName());
		}
		return "main";
	}

}
