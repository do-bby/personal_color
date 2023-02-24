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
		  name = "FASHION_SEQ_GENERATOR",	
		  sequenceName = "fashionseq", 
		  initialValue = 1,   			
		  allocationSize = 1  
)
public class Fashion {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FASHION_SEQ_GENERATOR")
	private int fnum;
	private String situation;
	private int situnum;
	private String clotheimg;
	private String clotheinfo;
	private int sex;
	@ManyToOne
	@JoinColumn(name = "pnum")
	private Personal personal;
}
