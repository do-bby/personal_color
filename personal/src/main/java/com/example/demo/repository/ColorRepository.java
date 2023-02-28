package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Color;
import com.example.demo.entity.Personal;

@Repository
public interface ColorRepository extends JpaRepository<Color,Integer>{
	

	@Query("select p from Color c join c.personal p where c.hexcode = :hx")
	public Personal findByHexcode(@Param("hx") String hexcode);
	@Query("select c from Color c join c.personal p where p.pnum = :pnum")
	public List<Color> findByPnum(@Param("pnum") int pnum);
	
}
