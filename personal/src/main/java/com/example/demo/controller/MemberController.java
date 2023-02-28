package com.example.demo.controller;


import java.util.Base64;

import java.util.List;
import java.util.Map;


import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
   private final ColorRepository colorRepository;
   private final PersonalRepository personalRepository;

   private int output;
   
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
   @PostMapping("/output")
   public ResponseEntity<String> viewTone(@RequestBody Map<String,String> request) {
      
      String encodedData = request.get("encodedData");      
      byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
      String decodedResult = new String(decodedBytes);      
      JSONObject jsonObject = new JSONObject(decodedResult);      
      output= jsonObject.getInt("result");
      
      return ResponseEntity.ok("완료");

   }

      
   @GetMapping("/result")
   public String result(Model model, @LoginUser SessionMember member) {

      
      Personal p = personalRepository.findByPnum(output);
      System.out.println(p.getPnum());
      
      Member pmember = memberRepository.findByEmail(member.getEmail()).orElse(null);
      System.out.println(pmember.getEmail());
      pmember.setPersonal(p);
      List<Color> colorlist = colorRepository.findByPnum(pmember.getPersonal().getPnum());
      //결과 창에서 해당 pnum의 hexcode컬러값을 가져옴
      if(pmember != null) {
         model.addAttribute("pmember",pmember);
         model.addAttribute("colorlist",colorlist);
      }
      return "result";
   }
   
   //fast api로 요청 , 받은 이미지 or rgb값을 저장해서 결과 보여주는 html로 return

}