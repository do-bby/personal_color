package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@SequenceGenerator(
		  name = "PERSONAL_SEQ_GENERATOR",	
		  sequenceName = "personalseq", 
		  initialValue = 1,   			
		  allocationSize = 1  
)
public class Personal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAL_SEQ_GENERATOR")
	private int pnum;
	private String tonename;
	//패션-퍼스널 => ManytoOne, 퍼스널이미지-퍼스널 => OnetoOne, 회원-퍼스널=> OnetoOne
}
