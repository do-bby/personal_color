package com.example.demo.entity;

import javax.persistence.Column;
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
		  name = "COLOR_SEQ_GENERATOR",	
		  sequenceName = "colorseq", 
		  initialValue = 1,   			
		  allocationSize = 1  
)
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLOR_SEQ_GENERATOR")
	private int cnum;
	@Column
	private String hexcode;
	@Column
	private String pccs;
	
	@ManyToOne
	@JoinColumn(name = "pnum")
	private Personal personal;

}


