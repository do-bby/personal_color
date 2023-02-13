package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Perimg {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inum;
	private String img;
	
	@OneToOne
	@JoinColumn(name="pnum")
	private Personal personal;	

}
