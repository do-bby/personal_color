package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.entity.Color;
import com.example.demo.entity.Fashion;
import com.example.demo.entity.Member;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.FashionRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PersonalRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FashionController {
	private final MemberRepository memberRepository;
	private final PersonalRepository personalRepository;
	private final ColorRepository colorRepository;
	private final FashionRepository fashionRepository;
	//패션페이지 이동
	@GetMapping("/clothes")
	public String clothes(Model model, @LoginUser SessionMember member) {
		//email로 member 객체 불러옴
		Member memberinfo = memberRepository.findByEmail(member.getEmail()).orElse(null);
		int pnum = memberinfo.getPersonal().getPnum();
		//pnum에 해당하는 hexcode 가져옴
		List<Color> colorlist = colorRepository.findByPnum(pnum);
		//pnum에 해당하는 fashion 이미지들 가져옴
		List<Fashion> fashionlist = fashionRepository.findByPersonalPnum(pnum);
		//member 값여부체크
		if(member != null) {
			model.addAttribute("memberName",member.getName());
			model.addAttribute("fashionlist", fashionlist);
			model.addAttribute("colorlist", colorlist);
			model.addAttribute("memberinfo", memberinfo);
		}
		return "clothes";
	}

}
