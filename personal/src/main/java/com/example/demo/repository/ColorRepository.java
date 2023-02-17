package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Color;
import com.example.demo.entity.Personal;


public interface ColorRepository extends JpaRepository<Color,Integer>{
	

	@Query("select p from Color c join c.personal p where c.hexcode = :hx")
	public Personal findByHexcode(@Param("hx") String hexcode);

	
}
