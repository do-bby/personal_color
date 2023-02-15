package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Color {
	
	@Column
	private String hexcode;
	
	@ManyToOne
	@JoinColumn(name = "pnum")
	private Personal personal;

}
