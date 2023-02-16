package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@RequiredArgsConstructor
@Controller
public class ColorController {
	
}
