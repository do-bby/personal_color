package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Color;

//select a.hexcode 
//from color a,
//member b,
//personal c
//where b.pnum = a.pnum 
//and b.pnum = c.pnum
//and b.pnum = 1;

public interface ColorRepository extends JpaRepository<Color,Integer>{
	
	//@Query("select t.teamname from Member m join m.team t where m.username = :un")
	@Query("select p.tonename from Color c join c.personal p where c.hexcode = :hx")
	public String findByhexcode(@Param("hx") String hexcode);
	//넘어온 hexcode or rgb or 이미지 byte를 처리
}
