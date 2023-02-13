package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Fashion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fnum;
	private String situation;
	private int situnum;
	private String clotheimg;
	@ManyToOne
	@JoinColumn(name = "pnum")
	private Personal personal;
}
