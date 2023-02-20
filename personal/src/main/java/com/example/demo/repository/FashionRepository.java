package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Color;
import com.example.demo.entity.Fashion;
import com.example.demo.entity.Personal;


public interface FashionRepository extends JpaRepository<Fashion,Integer>{
	
	public List<Fashion> findByPersonalPnum(int pnum);
	
}
