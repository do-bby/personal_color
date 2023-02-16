package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.entity.Member;
import com.example.demo.entity.Personal;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberRepository memberRepository;
	private final ColorRepository colorRepository;
	//메인페이지 이동
	@GetMapping("/")
	public String login(Model model, @LoginUser SessionMember member) {
		
		if(member != null) {
			model.addAttribute("memberName",member.getName());
		}
		return "main";
	}
	
	//마이페이지 이동
	@GetMapping("/mypage")
	public String mypage(Model model, @LoginUser SessionMember member) {
		
		Member pmember = memberRepository.findByName(member.getName());
		if(member != null) {
			model.addAttribute("pmember",pmember);			
		}		

		return "mypage";
	}
	
	@GetMapping("/result")
	public String viewTone(Model model, @LoginUser SessionMember member) {
		
		Personal p = colorRepository.findByHexcode("#F28C8E");
		Member pmember = memberRepository.findByName(member.getName());				
		pmember.setPersonal(p);

		if(pmember != null) {
			model.addAttribute("pmember",pmember);			
		}
		return "result";
	}
	
	//패션페이지 이동
	@GetMapping("/clothes")
	public String clothes(@LoginUser SessionMember member) {
	
		return "clothes";
	}
	
	//fast api로 요청 , 받은 이미지 or rgb값을 저장해서 결과 보여주는 html로 return

}
