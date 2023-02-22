package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PersonalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String webcam(Model model, @LoginUser SessionMember member) {
		if(member != null) {
			model.addAttribute("memberName",member.getName());
		}
		return "webcam";
	}
	
	//웹캠 연결
//	@PostMapping("/image")
//	public ResponseEntity<String> saveImage(@RequestBody Map<String, Object> data) {
//	    String imageData = (String) data.get("image");
//	    byte[] decodedImageData = Base64.getDecoder().decode(imageData.split(",")[1]);
//	    try {
//	        FileOutputStream outputStream = new FileOutputStream("saved-image.png");
//	        outputStream.write(decodedImageData);
//	        outputStream.close();
//	        System.out.println(decodedImageData);
//	        return ResponseEntity.ok("이미지 저장 완료");
//	    } catch (IOException e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미지 저장 실패");
//	    }
//	}

}
