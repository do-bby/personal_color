package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Personal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pnum;
	private String tonename;
	//패션-퍼스널 => ManytoOne, 퍼스널이미지-퍼스널 => OnetoOne, 회원-퍼스널=> OnetoOne
}
