package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Colorinfo;

public interface ColorinfoRepository extends JpaRepository<Colorinfo, Integer>{

	public Colorinfo findByPersonalPnum(int pnum);
	
}
