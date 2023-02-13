package com.example.demo.config.auth;

import java.io.Serializable;

import com.example.demo.entity.Member;

import lombok.Getter;

@Getter
public class SessionMember implements Serializable{
	
	private String name;
	private String email;
	private String nickname;
	
	public SessionMember(Member member) {
		this.name = member.getName();
		this.email = member.getEmail();
		this.nickname = member.getNickname();
	}

}
