package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Color;
import com.example.demo.entity.Fashion;
import com.example.demo.entity.Personal;


public interface FashionRepository extends JpaRepository<Fashion,Integer>{
	
	//pnum 받아서 list형태로 fashion 리턴
	public List<Fashion> findByPersonalPnum(int pnum);
	//상황만 조회해옴
	@Query("SELECT DISTINCT f.situation, f.situnum FROM Fashion f")
	List<Object[]> findDistinctSituationAndSitunum();
	//중복제거
	public List<Fashion> findDistinctByPersonalPnumAndSexAndSitunum(int pnum, int sex, int situnum);
	
}
