package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mnum;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String email;
	
	@Column(nullable = false)
	private String nickname;
		
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne
	@JoinColumn(name="pnum")
	private Personal personal;
	
	public Member update(String name,String nickname) {		
		this.name = name;		
		this.nickname = nickname;
	
		return this;
	}
	
	@Builder
	public Member(String name,String email,String nickname,Role role) {
		
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.role = role;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}

}
