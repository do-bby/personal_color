package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Fashion;
import com.example.demo.entity.Personal;

public interface FashionRepository extends JpaRepository<Fashion, Integer>{
	
	//personal 객체의 pnum으로 fashion 정보 가져오기
	public List<Fashion> findByPersonalPnum(int pnum);
	
}
