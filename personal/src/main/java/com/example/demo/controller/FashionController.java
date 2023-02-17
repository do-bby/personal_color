package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.entity.Member;
import com.example.demo.entity.Personal;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FashionController {
	//패션페이지 이동
	@GetMapping("/clothes")
	public ModelAndView clothes(@LoginUser SessionMember member) {
		ModelAndView mav = new ModelAndView();
		if(member == null) {
			mav.setViewName("/oauth2/authorization/");
		}else {
			mav.setViewName("clothes");	
		}
		return mav;
	}

}
