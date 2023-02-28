package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionMember;

import lombok.RequiredArgsConstructor;

@Controller
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
