package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.ColorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ColorController {
	//db에 저장되있는 rgb값에 분류된 퍼스널컬러와 비교하여 member.pnum에 저장
	//조인된 hexcode, tonename을 결과창에 보여주기
	
	private ColorRepository colorRepository;
	@GetMapping("/result")
	public String viewTone(Model model,String hexcode) {
		
		String t = colorRepository.findByhexcode(hexcode);
		//임의의 hexcode값을 넣어 테스트
		if(model != null) {
			model.addAttribute("color",t);
		}
		return "result";
	}
}
