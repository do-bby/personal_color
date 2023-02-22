package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@SequenceGenerator(
		  name = "COLORINFO_SEQ_GENERATOR",	
		  sequenceName = "colorinfoseq", 
		  initialValue = 1,   			
		  allocationSize = 1  
)
public class Colorinfo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLORINFO_SEQ_GENERATOR")
	private int inum;
	private String info;
	private String good;
	private String bad;
	@ManyToOne
	@JoinColumn(name = "pnum")
	private Personal personal;
}
