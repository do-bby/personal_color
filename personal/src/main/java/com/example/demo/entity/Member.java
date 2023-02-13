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
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@SequenceGenerator(
		  name = "MEMBER_SEQ_GENERATOR",	
		  sequenceName = "memberseq", 
		  initialValue = 1,   			
		  allocationSize = 1  
)

public class Member {
	public Member() {};
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_SEQ_GENERATOR")
	private int mnum;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String email;
	
//	@Column(nullable = false)
//	private String nickname;
		
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@OneToOne
	@JoinColumn(name="pnum")
	private Personal personal;
	
	public Member update(String name) {		
		this.name = name;		
		//this.nickname = nickname;
	
		return this;
	}
	
	@Builder
	public Member(String name,String email,Role role) {
		
		this.name = name;
		this.email = email;
		//this.nickname = nickname;
		this.role = role;
	}
	
	public String getRoleKey() {
		System.out.println("aaaaa"+role.getKey());
		return this.role.getKey();
	}

}
