package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.entity.Color;
import com.example.demo.entity.Member;
import com.example.demo.entity.Personal;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PersonalRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberRepository memberRepository;
	private final PersonalRepository personalRepository;
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
		
		Member pmember = memberRepository.findByEmail(member.getEmail()).orElse(null);
		List<Color> colorlist = colorRepository.findByPnum(pmember.getPersonal().getPnum());		

		if(member != null) {
			model.addAttribute("pmember",pmember);
			model.addAttribute("colorlist",colorlist);
		}		

		return "mypage";
	}
	
	@GetMapping("/result")
	public String viewTone(Model model, @LoginUser SessionMember member) {
		//model로 부터 온 값을 decode
		int pn = 1;//임의의 pnum
		Personal p = personalRepository.findByPnum(pn); 

		Member pmember = memberRepository.findByEmail(member.getEmail()).orElse(null);		
		pmember.setPersonal(p);
		//로그인 된 멤버의 personal 저장
		List<Color> colorlist = colorRepository.findByPnum(pn);
		//결과 창에서 해당 pnum의 hexcode컬러값을 가져옴
		if(pmember != null) {
			model.addAttribute("pmember",pmember);
			model.addAttribute("colorlist",colorlist);
		}
		return "result";
	}
	
	
	//fast api로 요청 , 받은 이미지 or rgb값을 저장해서 결과 보여주는 html로 return

}
