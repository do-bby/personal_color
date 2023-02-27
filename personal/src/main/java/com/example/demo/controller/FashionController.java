package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.entity.Color;
import com.example.demo.entity.Fashion;
import com.example.demo.entity.Member;
import com.example.demo.entity.Personal;
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
	
	@GetMapping("/clothes")
	public String selectstyle(Model model, @LoginUser SessionMember member) {
		//상황만 중복제거해서 가져옴
		List<Object[]> situations = fashionRepository.findDistinctSituationAndSitunum();
		model.addAttribute("situations", situations);
		model.addAttribute("memberName",member.getName());
		
		 for (Object[] situation : situations) { System.out.println("Situation: " +
		  situation[0] + ", Situnum: " + situation[1]); }
		
		return "selectstyle";
	}
	
	@PostMapping("/selectinfo")
	public String selectinfo(	Model model, @LoginUser SessionMember member, 
								@RequestParam("sex") int sex,
								@RequestParam("situnum") int situnum) {
		Member memberinfo = memberRepository.findByEmail(member.getEmail()).orElse(null);
		int pnum = memberinfo.getPersonal().getPnum();
		Fashion fashion = new Fashion();
		fashion.setSex(sex);
		fashion.setSitunum(situnum);
		Personal personal = new Personal();
	    personal = personalRepository.findByPnum(pnum);
	    fashion.setPersonal(personal);
	    List<Color> colorlist = colorRepository.findByPnum(pnum);
	    List<Fashion> fashionlist = fashionRepository.findDistinctByPersonalPnumAndSexAndSitunum(pnum, sex, situnum);
	    if(member != null) {
			model.addAttribute("memberName",member.getName());
			model.addAttribute("fashionlist", fashionlist);
			model.addAttribute("colorlist", colorlist);
			model.addAttribute("memberinfo", memberinfo);
		}
		return "clothes";
	}
	
//	//패션페이지 이동
//	@GetMapping("/clothes")
//	public String clothes(Model model, @LoginUser SessionMember member) {
//		//email로 member 객체 불러옴
//		Member memberinfo = memberRepository.findByEmail(member.getEmail()).orElse(null);
//		int pnum = memberinfo.getPersonal().getPnum();
//		//pnum에 해당하는 hexcode 가져옴
//		List<Color> colorlist = colorRepository.findByPnum(pnum);
//		//pnum에 해당하는 fashion 이미지들 가져옴
//		List<Fashion> fashionlist = fashionRepository.findByPersonalPnum(pnum);
//		//member 값여부체크
//		if(member != null) {
//			model.addAttribute("memberName",member.getName());
//			model.addAttribute("fashionlist", fashionlist);
//			model.addAttribute("colorlist", colorlist);
//			model.addAttribute("memberinfo", memberinfo);
//		}
//		return "clothes";
//	}

}
